package com.example.prans.news.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by prans on 05-03-2018.
 */

public class News {

    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("url")
    @Expose
    private String mUrl;
    @SerializedName("urlToImage")
    @Expose
    private String mUrlToImage;


    public News(String mTitle, String mUrl, String mUrlToImage) {
        this.mTitle = mTitle;
        this.mUrl = mUrl;
        this.mUrlToImage = mUrlToImage;
    }

    public String getTitle() {
        String title = mTitle.replace("/<(.*?)\\>", "");
        return title;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getUrlToImage() {
        return mUrlToImage;
    }

    public void setUrlToImage(String mUrlToImage) {
        this.mUrlToImage = mUrlToImage;
    }
}
