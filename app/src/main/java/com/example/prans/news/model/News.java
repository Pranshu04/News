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

    public static final int NEWS_IMAGE_TYPE = 0;
    public static final int NEWS_WITHOUT_IMAGE_TYPE = 1;
    private int type;

    public News(String mTitle, String mUrl, String mUrlToImage, int type) {
        this.mTitle = mTitle;
        this.mUrl = mUrl;
        this.mUrlToImage = mUrlToImage;
        this.type = type;
    }

    public int getType() {
        if (mUrlToImage == null) {
            return NEWS_WITHOUT_IMAGE_TYPE;
        } else {
            return NEWS_IMAGE_TYPE;
        }
    }

    public String getTitle() {
        return mTitle.replace("/<(.*?)\\>", "");
    }

    public String getUrl() {
        return mUrl;
    }

    public String getUrlToImage() {
        if (mUrlToImage.equals("")) {
            return mUrlToImage = null;
        } else {
            return mUrlToImage;
        }
    }
}
