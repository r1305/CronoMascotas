package com.solution.tecno.cronomascotas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder>{
    List<String> l =new ArrayList<>();
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context=parent.getContext();
        return new TimeLineAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info,parent,false));
    }

    public TimeLineAdapter(List<String> l) {
        this.l = l;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final String info_array = l.get(i);
        String[] info = info_array.split(",");
        Log.d("*****",info[0] + " - " + info[1]);
        holder.title.setText(info[0]);
        holder.description.setText(info[1]);
    }



    @Override
    public int getItemCount() {
        if(l==null){
            return 0;
        }else {
            return l.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView title,description;

        private ViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title_event);
            description=itemView.findViewById(R.id.desc_event);
        }
    }
}
