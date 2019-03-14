package firat.gurgur.task;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TasksListAdapter extends RecyclerView.Adapter<TasksListAdapter.MyViewHolder> {

    private List<Task> dataSet;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView start;
        TextView finish;
        TextView lasttime;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = (TextView) itemView.findViewById(R.id.taskname);
            this.start = (TextView) itemView.findViewById(R.id.taskstart);
            this.finish = (TextView) itemView.findViewById(R.id.taskfinish);
            this.lasttime = (TextView) itemView.findViewById(R.id.tasklasttime);
        }
    }

    public TasksListAdapter(List<Task> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        holder.name.setText(dataSet.get(listPosition).getName());
        holder.start.setText(dataSet.get(listPosition).getStart());
        holder.finish.setText(dataSet.get(listPosition).getFinish());
        holder.lasttime.setText(dataSet.get(listPosition).getLastTime());

        Typeface face=Typeface.createFromAsset(context.getResources().getAssets(),"fonts/EncodeSansSemiCondensed-Medium.ttf");
        holder.name.setTypeface(face);
    }


    @Override
    public int getItemCount() {
        return  dataSet.size();
    }
}
