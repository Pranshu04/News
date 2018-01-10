package com.example.prans.news.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechnologyFragment extends MainFragment {


    public TechnologyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String QueryUrl = "https://newsapi.org/v2/top-headlines?sources=techcrunch,techradar,the-verge,recode,crypto-coins-news,wired,hacker-news,the-next-web&apiKey=35c1bde1d45d4cc192403695ee31a59f";
        return super.onCreateView(inflater, container, savedInstanceState, QueryUrl);
    }

}
