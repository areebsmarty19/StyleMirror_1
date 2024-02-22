package com.example.stylemirror_1_1.domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private int id;
    private String title;
    private String picUrl;
    private int review;
    private double rating;
    private int numberInCart;
    private double price;
    private String description;

    public PopularDomain(int id , String title, String picUrl, int review, double rating, double price,String description) {
        this.id = id;
        this.title = title;
        this.picUrl = picUrl;
        this.review = review;
        this.rating = rating;
        this.price = price;
        this.description=description;
    }

    public PopularDomain(int id, String title, String picUrl, double price ,String description) {
        this.id=id;
        this.title=title;
        this.picUrl=picUrl;
        this.price=price;
        this.description=description;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getScore() {
        return rating;
    }

    public void setScore(double rating) {
        this.rating = rating;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
