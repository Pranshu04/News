package com.example.prans.news.data;

/**
 * Created by prans on 08-01-2018.
 */

public class News {

    private String title;
    private String url;
    private String urlToImage;

    public News(String title, String urlToImage, String url) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.url = url;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
