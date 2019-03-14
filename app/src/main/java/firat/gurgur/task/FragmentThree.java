package firat.gurgur.task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class FragmentThree extends Fragment {
    ComListPojo storesListProjo;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    public FragmentThree() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_three, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.com_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        storesListProjo = new Gson().fromJson(parseJSONData(), ComListPojo.class);
        adapter = new ComsListAdapter(storesListProjo.getDetailList(), getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }
    public String parseJSONData() {
        String JSONString = null;
        JSONObject JSONObject = null;
        try {

            InputStream inputStream = getResources().getAssets().open("comment.json");

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
