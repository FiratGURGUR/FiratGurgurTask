package firat.gurgur.task;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt_title,ist;
    ImageView ayarmenu,bildirimmenu;



    private ViewPager viewPager;
    private TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        txt_title.setTypeface(face);
        ist.setTypeface(face);

        ayarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Ayarlar", Toast.LENGTH_SHORT).show();
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


        setCustomFont();


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
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/EncodeSansSemiCondensed-Regular.ttf"));
                }
            }
        }
    }
}