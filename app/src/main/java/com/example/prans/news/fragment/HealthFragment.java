package com.example.prans.news.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prans.news.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthFragment extends MainFragment {


    public HealthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String QueryUrl = "https://newsapi.org/v2/top-headlines?sources=medical-news-today&apiKey=35c1bde1d45d4cc192403695ee31a59f";
        return super.onCreateView(inflater, container, savedInstanceState, QueryUrl);
    }


}
