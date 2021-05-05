package com.example.listapp.model;

public class Article {

    private int id;
    private String label;
    private Double price;
    private String description;
    private Float rating;

    private String url;
    private boolean isAchete;

    public Article() {
    }

    public Article(int id, String label, Double price, String description, Float rating, String url, boolean isAchete) {
        super();
        this.id = id;
        this.label = label;
        this.price = price;
        this.description = description;
        this.rating = rating;
        this.url = url;
        this.isAchete = isAchete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public boolean isAchete() { return isAchete; }

    public void setAchete(boolean achete) { isAchete = achete; }
}
