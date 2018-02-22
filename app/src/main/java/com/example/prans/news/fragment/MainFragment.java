package com.example.prans.news.fragment;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prans.news.NewsDetailsActivity;
import com.example.prans.news.R;
import com.example.prans.news.adapter.NewsAdapter;
import com.example.prans.news.data.News;
import com.example.prans.news.loader.NewsLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final int NEWS_LOADER_ID = 1;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsAdapter mAdapter;

    public MainFragment() {
        // Required empty public constructor
    }


    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             final String QueryUrl) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new NewsLoader(getContext(), QueryUrl);
            }
        });


        // Find a reference to the {@link ListView} in the layout
        ListView listView = view.findViewById(R.id.list_view);
        mAdapter = new NewsAdapter(getActivity(), new ArrayList<News>());

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                News news = mAdapter.getItem(i);
                //   Uri headlinesUri = Uri.parse(news.getUrl());
                Intent headlines_intent = new Intent(getActivity(), NewsDetailsActivity.class);
                if (news != null) {
                    headlines_intent.putExtra("url", news.getUrl());
                }
                startActivity(headlines_intent);
            }
        });

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {

            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).

            loaderManager.initLoader(NEWS_LOADER_ID, null, new LoaderManager.LoaderCallbacks<List<News>>() {
                @Override
                public Loader<List<News>> onCreateLoader(int id, Bundle args) {
                    return new NewsLoader(getContext(), QueryUrl);
                }

                @Override
                public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
                    // Clear the adapter of previous earthquake data
                    mAdapter.clear();

                    // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
                    // data set. This will trigger the ListView to update.
                    if (data != null && !data.isEmpty()) {
                        mAdapter.addAll(data);
                        mAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }

                @Override
                public void onLoaderReset(Loader<List<News>> loader) {

                    // Loader reset, so we can clear out our existing data.
                    mAdapter.clear();
                }
            });
        } else {

            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(getActivity(), "No internet Connection...", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
