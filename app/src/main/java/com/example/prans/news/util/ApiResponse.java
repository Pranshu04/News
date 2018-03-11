package com.example.prans.news.util;

import com.example.prans.news.model.NewsResource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by prans on 11-03-2018.
 */

public interface ApiResponse {


    @GET("top-headlines")
    Call<NewsResource> getTopHeadlines(@Query("country") String country,
                                       @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<NewsResource> getWorldHeadlines(@Query("sources") String sources,
                                         @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<NewsResource> getCategoryOfHeadlines(@Query("country") String country,
                                              @Query("category") String category,
                                              @Query("apiKey") String apiKey);
}
