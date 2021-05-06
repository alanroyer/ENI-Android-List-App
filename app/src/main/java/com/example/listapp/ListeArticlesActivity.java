package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.listapp.adapters.ArticlesAdapter;
import com.example.listapp.model.Article;

import java.util.ArrayList;

public class ListeArticlesActivity extends AppCompatActivity {

    private ArrayList<Article> listeArticles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_articles);

        initArticle();

        RecyclerView recyclerViewArticles = (RecyclerView) findViewById(R.id.reclycerviewarticles);
        recyclerViewArticles.setLayoutManager(new LinearLayoutManager(this));
        ArticlesAdapter msgAdapter = new ArticlesAdapter(this, listeArticles);
        recyclerViewArticles.setAdapter(msgAdapter);
    }

    private void initArticle(){
        Article article = new Article(1,"Meuble",15d,"Simple meuble",3f,"http://www.meuble.fr",false);
        Article article2 = new Article(2,"Coussin",5d,"Simple coussin",4f,"http://www.coussin.fr",false);
        Article article3 = new Article(3,"Tableau",250d,"Simple tableau",2f,"http://www.tableau.fr",false);
        Article article4 = new Article(4,"Luminaire",34d,"Simple luminaire",5f,"http://www.luminaire.fr",false);
        Article article5 = new Article(5,"Brosse",5d,"Simple tableau",5f,"http://www.brosse.fr",false);
        Article article6 = new Article(6,"Chaise",22d,"Simple luminaire",5f,"http://www.chaise.fr",false);
        Article article7 = new Article(7,"Table",26d,"Simple tableau",4f,"http://www.table.fr",false);
        Article article8 = new Article(8,"TV",64d,"Simple luminaire",1f,"http://www.tv.fr",false);
        listeArticles.add(article);
        listeArticles.add(article2);
        listeArticles.add(article3);
        listeArticles.add(article4);
        listeArticles.add(article5);
        listeArticles.add(article6);
        listeArticles.add(article7);
        listeArticles.add(article8);
    }
}