package firat.gurgur.task;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

public class Denetleme_SoruListAdapter extends RecyclerView.Adapter<Denetleme_SoruListAdapter.MyViewHolder> {
    private List<Denetleme_Soru> dataSet;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView soru;
        SeekBar puan;
        Button btn_kapsam_ici,btn_kapsam_disi;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.soru = (TextView) itemView.findViewById(R.id.denetleme_soru);
            this.puan = (SeekBar) itemView.findViewById(R.id.denetleme_seekbar);
            puan.setPadding(0, 0, 0, 0);
            this.btn_kapsam_ici = itemView.findViewById(R.id.btn_kapsam_ici);
            this.btn_kapsam_disi = itemView.findViewById(R.id.btn_kapsam_disi);


        }
    }

    public Denetleme_SoruListAdapter(List<Denetleme_Soru> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public Denetleme_SoruListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.denetleme_list, parent, false);


        Denetleme_SoruListAdapter.MyViewHolder myViewHolder = new Denetleme_SoruListAdapter.MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(final Denetleme_SoruListAdapter.MyViewHolder holder, final int listPosition) {


        holder.soru.setText(dataSet.get(listPosition).getSoru());
        holder.puan.setProgress(Integer.parseInt(dataSet.get(listPosition).getPuan()));

        holder.btn_kapsam_ici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btn_kapsam_ici.setVisibility(View.GONE);
                holder.btn_kapsam_disi.setVisibility(View.VISIBLE);
                holder.puan.setEnabled(false);
            }
        });
        holder.btn_kapsam_disi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btn_kapsam_disi.setVisibility(View.GONE);
                holder.btn_kapsam_ici.setVisibility(View.VISIBLE);
                holder.puan.setEnabled(true);
            }
        });

        Typeface face=Typeface.createFromAsset(context.getResources().getAssets(),"fonts/EncodeSansSemiCondensed-Medium.ttf");
        holder.soru.setTypeface(face);
    }


    @Override
    public int getItemCount() {
        return  dataSet.size();
    }
}
