package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.listapp.model.Article;

public class MainActivity extends AppCompatActivity {

    private Article article;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        article = new Article(
                1
                ,"Pain au Chocolat"
                ,10d
                ,"Une viennoiserie au beurre et au chocolat"
                ,3f
                ,"http://article.com/"
                ,false
        );

        TextView textViewTitle = findViewById(R.id.item_title);
        TextView textViewPrice = findViewById(R.id.item_price);
        TextView textViewDescription = findViewById(R.id.item_description);
        RatingBar ratingBarRating = findViewById(R.id.item_rating);
        ToggleButton toggle = findViewById(R.id.toggle_buy);

        textViewTitle.setText(article.getLabel());
        textViewPrice.setText(article.getPrice().toString() + "€");
        textViewDescription.setText(article.getDescription());
        ratingBarRating.setRating(article.getRating());
        toggle.setChecked(article.isAchete());
    }

    public void onClickBtnUrl(View view){
        Intent intent = new Intent(this, InfoUrlActivity.class);
        startActivity(intent);
    }

    public void onClickBtnBuy(View view)
    {
        article.setAchete(!article.isAchete());
        if(article.isAchete()){
            Toast.makeText(this, "Article acheté",Toast.LENGTH_SHORT).show();
            Log.i("INFO","Article acheté");
        }
        else{
            Toast.makeText(this, "Article non acheté",Toast.LENGTH_SHORT).show();
            Log.i("INFO","Article non acheté");

        }
    }
}