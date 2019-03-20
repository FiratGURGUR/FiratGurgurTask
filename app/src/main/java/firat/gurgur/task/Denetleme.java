package firat.gurgur.task;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Denetleme extends AppCompatActivity implements View.OnClickListener {
    ImageView denetleme_back_button;

    Denetleme_SoruListPojo storesListProjo;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_denetleme);


        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_denetleme);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();

        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0,0);


        denetleme_back_button = view.findViewById(R.id.denetleme_geri);
        denetleme_back_button.setOnClickListener(this);



        recyclerView = (RecyclerView) findViewById(R.id.dent_list);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        storesListProjo = new Gson().fromJson(parseJSONData(), Denetleme_SoruListPojo.class);
        adapter = new Denetleme_SoruListAdapter(storesListProjo.getDetailList(),this);
        recyclerView.setAdapter(adapter);





    }
    public String parseJSONData() {
        String JSONString = null;
        JSONObject JSONObject = null;
        try {

            InputStream inputStream = getResources().getAssets().open("denetleme.json");

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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.denetleme_geri:
                finish();
                break;
        }
    }
}
