package firat.gurgur.task;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentOne extends Fragment {
    TaskListPojo storesListProjo;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    public FragmentOne() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.stores_list);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        storesListProjo = new Gson().fromJson(parseJSONData(), TaskListPojo.class);
        adapter = new TasksListAdapter(storesListProjo.getDetailList(), getActivity());
        recyclerView.setAdapter(adapter);

        int[] ATTRS = new int[]{android.R.attr.listDivider};

        TypedArray a = getActivity().obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        int inset = 40;
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 5, 0, 5);
        a.recycle();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(insetDivider);
        recyclerView.addItemDecoration(itemDecoration);

        return view;
    }




    public String parseJSONData() {
        String JSONString = null;
        JSONObject JSONObject = null;
        try {

            InputStream inputStream = getResources().getAssets().open("task.json");

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