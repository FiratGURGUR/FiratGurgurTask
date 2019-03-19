package firat.gurgur.task;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView txt_title,ist;
    ImageView ayarmenu,bildirimmenu;
    TextView tasksayiQ,favsayiQ,commentsayiQ;


    private ViewPager viewPager;
    private TabLayout tabLayout;


    ComListPojo storesListProjo3;
    FavListPojo storesListProjo2;
    TaskListPojo storesListProjo1;

    private static RecyclerView.Adapter adapter1,adapter2,adapter3;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksayiQ= findViewById(R.id.tasksayiQ);
        favsayiQ= findViewById(R.id.favsayiQ);
        commentsayiQ= findViewById(R.id.commentsayiQ);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0,0);

        ayarmenu = view.findViewById(R.id.ayarmenu);
        bildirimmenu = view.findViewById(R.id.bildirimmenu);
        txt_title = view.findViewById(R.id.name);
        ist = findViewById(R.id.ist);
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/EncodeSansSemiCondensed-Regular.ttf");
        tasksayiQ.setTypeface(face);
        commentsayiQ.setTypeface(face);
        favsayiQ.setTypeface(face);
        txt_title.setTypeface(face);
        ist.setTypeface(face);

        ayarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsopen = new Intent(MainActivity.this,Settings.class);
                startActivity(settingsopen);

            }
        });
        bildirimmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Bildirimler", Toast.LENGTH_SHORT).show();
            }
        });


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        ViewGroup.LayoutParams params = tabLayout.getLayoutParams();
        //Change the height in 'Pixels'
        params.height = 90;
        tabLayout.setLayoutParams(params);


        setCustomFont();

        Veriler();
    }


    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(),"Görevlerim");
        adapter.addFragment(new FragmentTwo(), "Favorilerim");
        adapter.addFragment(new FragmentThree(), "Yorumlarım");
        viewPager.setAdapter(adapter);
    }

    public void setCustomFont() {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();

        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);

            int tabChildsCount = vgTab.getChildCount();

            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    //Put your font in assests folder
                    //assign name of the font here (Must be case sensitive)
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/EncodeSansSemiCondensed-Light.ttf"));
                }
            }
        }
    }


    public void Veriler(){
        storesListProjo1 = new Gson().fromJson(parseJSONData("task"), TaskListPojo.class);
        storesListProjo2 = new Gson().fromJson(parseJSONData("favorites"), FavListPojo.class);
        storesListProjo3 = new Gson().fromJson(parseJSONData("comment"), ComListPojo.class);


        adapter1 = new TasksListAdapter(storesListProjo1.getDetailList(), this);
        adapter2 = new FavsListAdapter(storesListProjo2.getDetailList(), this);
        adapter3 = new ComsListAdapter(storesListProjo3.getDetailList(), this);

        int GorevSayim =  adapter1.getItemCount();
        int FavoriSayim =  adapter2.getItemCount();
        int YorumSayim =  adapter3.getItemCount();

        tasksayiQ.setText(String.valueOf(GorevSayim));
        favsayiQ.setText(String.valueOf(FavoriSayim));
        commentsayiQ.setText(String.valueOf(YorumSayim));
    }



    public String parseJSONData(String bolum) {
        String JSONString = null;
        JSONObject JSONObject = null;
        try {
            InputStream inputStream = getResources().getAssets().open(bolum+".json");
            int sizeOfJSONFile = inputStream.available();
            byte[] bytes = new byte[sizeOfJSONFile];
            inputStream.read(bytes);
            inputStream.close();
            JSONString = new String(bytes, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return JSONString;
    }




}