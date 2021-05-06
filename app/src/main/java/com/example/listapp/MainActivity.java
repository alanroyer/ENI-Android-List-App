package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.listapp.model.Article;

public class MainActivity extends AppCompatActivity {

    private Article article;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.action_bar_details,menu);
        return true;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        article = (Article) b.getSerializable("article");

        TextView textViewTitle = findViewById(R.id.item_title);
        TextView textViewPrice = findViewById(R.id.item_price);
        TextView textViewDescription = findViewById(R.id.item_description);
        RatingBar ratingBarRating = findViewById(R.id.item_rating);
        ToggleButton toggle = findViewById(R.id.toggle_buy);

        textViewTitle.setText(article.getLabel());
        textViewPrice.setText(article.getPrice().toString() + "€");
        textViewDescription.setText(article.getDescription());
        ratingBarRating.setRating(article.getRating());
        toggle.setChecked(article.isBuy());
    }

    public void onClickBtnUrl(View view){
        Intent intent = new Intent(this, InfoUrlActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("article", article);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void onClickBtnBuy(View view)
    {
        article.setBuy(!article.isBuy());
        if(article.isBuy()){
            Toast.makeText(this, "Article acheté",Toast.LENGTH_SHORT).show();
            Log.i("INFO","Article acheté");
        }
        else{
            Toast.makeText(this, "Article non acheté",Toast.LENGTH_SHORT).show();
            Log.i("INFO","Article non acheté");

        }
    }
}