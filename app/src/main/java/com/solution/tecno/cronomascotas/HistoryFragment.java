package com.solution.tecno.cronomascotas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    Context ctx;
    RecyclerView activity;
    TimeLineAdapter adapter;
    List<String> l=new ArrayList<>();

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx=this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_history, container, false);
        activity=v.findViewById(R.id.recycler_timeline);
        activity.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new TimeLineAdapter(l);
        for(int i=0;i<4;i++){
            String text ="Hola,Posición "+i;
            l.add(text);
        }
        activity.setAdapter(adapter);
        return v;
    }

}
