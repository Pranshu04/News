package com.example.prans.news.data;

/**
 * Created by prans on 08-01-2018.
 */

public class News {

    private String title;
    private String url;
    private String urlToImage;
    private String source;

    public News(String title, String urlToImage, String url, String source) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.url = url;
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
