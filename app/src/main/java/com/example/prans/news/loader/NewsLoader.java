package com.example.prans.news.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.prans.news.data.News;
import com.example.prans.news.util.QueryUtils;

import java.util.List;

/**
 * Created by prans on 08-01-2018.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private final String mUrl;
    private String LOG_TAG = NewsLoader.class.getName();

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        // Perform the network request, parse the response, and extract a list of news.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
