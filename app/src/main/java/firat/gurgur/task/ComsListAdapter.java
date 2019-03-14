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

public class ComsListAdapter extends RecyclerView.Adapter<ComsListAdapter.MyViewHolder> {
    private List<Comment> dataSet;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView comment_com;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = (TextView) itemView.findViewById(R.id.commentname);
            this.comment_com = (TextView) itemView.findViewById(R.id.comment_com);

        }
    }

    public ComsListAdapter(List<Comment> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public ComsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_list, parent, false);


        ComsListAdapter.MyViewHolder myViewHolder = new ComsListAdapter.MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(final ComsListAdapter.MyViewHolder holder, final int listPosition) {


        holder.name.setText(dataSet.get(listPosition).getName());
        holder.comment_com.setText(dataSet.get(listPosition).getComment());


        Typeface face=Typeface.createFromAsset(context.getResources().getAssets(),"fonts/EncodeSansSemiCondensed-Medium.ttf");
        holder.name.setTypeface(face);
    }


    @Override
    public int getItemCount() {
        return  dataSet.size();
    }
}
