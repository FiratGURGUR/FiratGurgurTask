package firat.gurgur.task;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class FavsListAdapter extends RecyclerView.Adapter<FavsListAdapter.MyViewHolder> {
    private List<Fav> dataSet;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView meter;
        RatingBar rate;
        TextView lasttime;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = (TextView) itemView.findViewById(R.id.favname);
            this.meter = (TextView) itemView.findViewById(R.id.favmeter);
            this.rate = (RatingBar) itemView.findViewById(R.id.favrate);
            this.lasttime = (TextView) itemView.findViewById(R.id.favlasttime);
        }
    }

    public FavsListAdapter(List<Fav> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public FavsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favori_list, parent, false);


        FavsListAdapter.MyViewHolder myViewHolder = new FavsListAdapter.MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(final FavsListAdapter.MyViewHolder holder, final int listPosition) {


        holder.name.setText(dataSet.get(listPosition).getName());
        holder.meter.setText(dataSet.get(listPosition).getMeter());
        holder.rate.setRating(Float.parseFloat(dataSet.get(listPosition).getRate()));
        holder.lasttime.setText(dataSet.get(listPosition).getLastTime());

        Typeface face=Typeface.createFromAsset(context.getResources().getAssets(),"fonts/EncodeSansSemiCondensed-Bold.ttf");
        holder.name.setTypeface(face);
    }


    @Override
    public int getItemCount() {
        return  dataSet.size();
    }
}
