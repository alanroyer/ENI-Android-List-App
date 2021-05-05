package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.listapp.model.Article;

public class InfoUrlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);

        Bundle b = getIntent().getExtras();
        Article article = (Article) b.getSerializable("article");

        TextView textViewUrl = findViewById(R.id.item_url);

        textViewUrl.setText(article.getUrl());
    }
}