package firat.gurgur.task;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Settings_HesapListAdapter extends RecyclerView.Adapter<Settings_HesapListAdapter.MyViewHolder> {

    private List<Settings_Hesap> dataSet;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = (TextView) itemView.findViewById(R.id.destek_ad);

        }
    }

    public Settings_HesapListAdapter(List<Settings_Hesap> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public Settings_HesapListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.settings_list, parent, false);


        Settings_HesapListAdapter.MyViewHolder myViewHolder = new Settings_HesapListAdapter.MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(final Settings_HesapListAdapter.MyViewHolder holder, final int listPosition) {


        holder.name.setText(dataSet.get(listPosition).getName());


        Typeface face=Typeface.createFromAsset(context.getResources().getAssets(),"fonts/EncodeSansSemiCondensed-Medium.ttf");
        holder.name.setTypeface(face);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, dataSet.get(listPosition).getName() , Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return  dataSet.size();
    }
}
