package com.solution.tecno.cronomascotas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NextEventsFragment extends Fragment {

    public NextEventsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NextEventsFragment newInstance() {
        NextEventsFragment fragment = new NextEventsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_events, container, false);
    }

}
