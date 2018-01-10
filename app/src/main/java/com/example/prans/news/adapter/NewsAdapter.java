package com.example.prans.news.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prans.news.R;
import com.example.prans.news.data.News;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by prans on 08-01-2018.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
        }

        News news = getItem(position);

        TextView tv_title = view.findViewById(R.id.title);
        tv_title.setText(news.getTitle());


        ImageView urlToImage = view.findViewById(R.id.urlToImage);
        Picasso.with(getContext()).load(news.getUrlToImage()).into(urlToImage);

        return view;
    }
}
