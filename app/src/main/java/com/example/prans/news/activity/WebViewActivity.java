package com.example.prans.news.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.prans.news.R;

public class WebViewActivity extends AppCompatActivity {


    WebView webView;
    SwipeRefreshLayout refreshLayout;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        url = getIntent().getStringExtra("url");

        refreshLayout = findViewById(R.id.swipe_refresh);

        refreshLayout.setRefreshing(true);

        refreshLayout.setColorSchemeResources(
                R.color.colorAccent,
                R.color.colorGreen,
                R.color.colorBlue,
                R.color.colorOrange);

        webView = findViewById(R.id.webView);
        //  webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.loadUrl(url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    refreshLayout.setRefreshing(false);
                } else {
                    refreshLayout.setRefreshing(true);
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        getCacheDir().deleteOnExit();
        webView.clearCache(true);
    }
}
