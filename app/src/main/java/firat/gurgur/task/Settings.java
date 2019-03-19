package firat.gurgur.task;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.style.BackgroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Settings extends AppCompatActivity   implements View.OnClickListener {
    ImageView settings_back_button;
    SeekBar seekBar1;
    TextView mesafe,account_delete;


    Settings_DestekPojo storesListProjo;
    Settings_HesapPojo storesListProjo2;
    Settings_CikisPojo storesListProjo3;
    private static RecyclerView.Adapter adapter,adapter2,adapter3;
    private RecyclerView.LayoutManager layoutManager,layoutManager2,layoutManager3;
    private static RecyclerView recyclerView,recyclerView2,recyclerView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_settings);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0,0);


        settings_back_button = view.findViewById(R.id.ayar_geri);
        settings_back_button.setOnClickListener(this);


        mesafe = findViewById(R.id.mesafe);
        account_delete = findViewById(R.id.account_delete);
        account_delete.setOnClickListener(this);
       seekBar1 = findViewById(R.id.seekBar1);
       seekBar1.setMax(1000);
       seekBar1.setProgress(600);
       mesafe.setText(String.valueOf(seekBar1.getProgress())+"m");
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                mesafe.setText(String.valueOf(progress)+"m");
                // SeekBar'ın değeri değiştiğinde yakalamak için burayı kullanabilirsiniz.
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.destek_list);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        storesListProjo = new Gson().fromJson(parseJSONData(), Settings_DestekPojo.class);
        adapter = new Settings_DestekListAdapter(storesListProjo.getDetailList(),this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        recyclerView2 = (RecyclerView) findViewById(R.id.hesap_list);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        storesListProjo2 = new Gson().fromJson(parseJSONData(), Settings_HesapPojo.class);
        adapter2 = new Settings_HesapListAdapter(storesListProjo2.getDetailList(),this);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.addItemDecoration(itemDecoration);

        recyclerView3 = (RecyclerView) findViewById(R.id.cikis_list);
        recyclerView3.setHasFixedSize(true);
        layoutManager3 = new LinearLayoutManager(this);
        recyclerView3.setLayoutManager(layoutManager3);
        recyclerView3.setItemAnimator(new DefaultItemAnimator());
        storesListProjo3 = new Gson().fromJson(parseJSONData(), Settings_CikisPojo.class);
        adapter3 = new Settings_CikisListAdapter(storesListProjo3.getDetailList(),this);
        recyclerView3.setAdapter(adapter3);
        recyclerView3.addItemDecoration(itemDecoration);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ayar_geri:
            finish();
            break;
            case R.id.account_delete:
                Toast.makeText(this, "Hesabını Sil", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public String parseJSONData() {
        String JSONString = null;
        JSONObject JSONObject = null;
        try {

            InputStream inputStream = getResources().getAssets().open("ayarlar_menu.json");

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
