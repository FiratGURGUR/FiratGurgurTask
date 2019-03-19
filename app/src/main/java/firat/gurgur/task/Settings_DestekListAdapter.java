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

public class Settings_DestekListAdapter extends RecyclerView.Adapter<Settings_DestekListAdapter.MyViewHolder> {

    private List<Settings_Destek> dataSet;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = (TextView) itemView.findViewById(R.id.destek_ad);

        }
    }

    public Settings_DestekListAdapter(List<Settings_Destek> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public Settings_DestekListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.settings_list, parent, false);


        Settings_DestekListAdapter.MyViewHolder myViewHolder = new Settings_DestekListAdapter.MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(final Settings_DestekListAdapter.MyViewHolder holder, final int listPosition) {


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
