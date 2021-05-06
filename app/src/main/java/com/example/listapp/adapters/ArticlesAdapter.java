package com.example.listapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listapp.MainActivity;
import com.example.listapp.R;
import com.example.listapp.model.Article;

import java.util.ArrayList;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {
    public Context mContext;
    LayoutInflater inflater;
    private ArrayList<Article> articles;

    public ArticlesAdapter(Context mContext, ArrayList<Article> articles) {
        this.mContext = mContext;
        this.articles = articles;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemArticle = inflater.inflate(R.layout.article_card, parent, false);
        ArticlesViewHolder articlesViewHolder = new ArticlesViewHolder(itemArticle,articles);
        articlesViewHolder.view = itemArticle;
        articlesViewHolder.label = (TextView) itemArticle.findViewById(R.id.article_label);
        articlesViewHolder.rating = (RatingBar) itemArticle.findViewById(R.id.article_rating);
        return articlesViewHolder;
    }

    @Override
    public void onBindViewHolder(ArticlesViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.label.setText(article.getLabel());
        holder.rating.setRating(article.getRating());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticlesViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView label;
        RatingBar rating;
        public ArticlesViewHolder(View itemView, ArrayList<Article> articles) {
            super(itemView);
            this.view = itemView;
            itemView.setOnClickListener(view -> {
                Article a = articles.get(getAdapterPosition());
                Context context = view.getContext();
                Intent intent = new Intent(context, MainActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("article", a);
                intent.putExtras(b);
                context.startActivity(intent);
            });
        }
    }
}