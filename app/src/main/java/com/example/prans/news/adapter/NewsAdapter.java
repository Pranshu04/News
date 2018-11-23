package com.example.prans.news.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prans.news.R;
import com.example.prans.news.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.prans.news.model.News.NEWS_IMAGE_TYPE;
import static com.example.prans.news.model.News.NEWS_WITHOUT_IMAGE_TYPE;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case NEWS_IMAGE_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
                return new NewsWithImageViewHolder(view);
            case NEWS_WITHOUT_IMAGE_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item_without_image, viewGroup, false);
                return new NewsWithOutImageViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        News news = newsList.get(i);
        switch (news.getType()) {
            case NEWS_IMAGE_TYPE:
                ((NewsWithImageViewHolder) viewHolder).tv_news_with_image_item.setText(news.getTitle());
                Picasso.get()
                        .load(news.getUrlToImage())
                        .resize(200, 200)
                        .centerCrop()
                        .into(((NewsWithImageViewHolder) viewHolder).iv_news);
                break;
            case NEWS_WITHOUT_IMAGE_TYPE:
                ((NewsWithOutImageViewHolder) viewHolder).tv_news_item.setText(news.getTitle());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {

        News news = newsList.get(position);

        if (news != null) {
            return news.getType();
        }

        return 0;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsWithImageViewHolder extends RecyclerView.ViewHolder {

        TextView tv_news_with_image_item;
        ImageView iv_news;

        public NewsWithImageViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_news_with_image_item = itemView.findViewById(R.id.title);
            iv_news = itemView.findViewById(R.id.urlToImage);

        }
    }

    public class NewsWithOutImageViewHolder extends RecyclerView.ViewHolder {

        TextView tv_news_item;

        public NewsWithOutImageViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_news_item = itemView.findViewById(R.id.tv_news_title);
        }
    }
}
