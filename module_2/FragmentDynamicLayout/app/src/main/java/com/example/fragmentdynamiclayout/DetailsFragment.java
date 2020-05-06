package com.example.fragmentdynamiclayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(int index) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);

        return fragment;
    }

    public int  getShownIndex(){
        return getArguments().getInt("index", 0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4,
                getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);
        scroller.addView(text);
        text.setText(Shakespeare.DIALOGUE[getShownIndex()]);
        // Inflate the layout for this fragment
        return scroller;
    }
}
