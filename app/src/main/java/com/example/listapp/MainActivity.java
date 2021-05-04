package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listapp.model.Article;

public class MainActivity extends AppCompatActivity {

    protected TextView textViewTitle;
    protected TextView textViewPrice;
    protected TextView textViewDescription;
    protected RatingBar ratingBarRating;

    private Article article;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitle = (TextView)findViewById(R.id.item_title);
        textViewPrice = (TextView)findViewById(R.id.item_price);
        textViewDescription = (TextView)findViewById(R.id.item_description);
        ratingBarRating = (RatingBar)findViewById(R.id.item_rating);

        article = new Article(
                1
                ,"Pain au Chocolat"
                ,10d
                ,"Une viennoiserie au beurre et au chocolat"
                ,3f
        );

        textViewTitle.setText(article.getLabel());
        textViewPrice.setText(article.getPrice().toString() + "€");
        textViewDescription.setText(article.getDescription());
        ratingBarRating.setRating(article.getRating());
    }

    public void onClickBtnInternet(View view){
        Toast.makeText(this, "http://article.com/" + article.getId(),Toast.LENGTH_SHORT).show();
    }
}