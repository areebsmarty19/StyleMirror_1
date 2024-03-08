package com.example.stylemirror_1_1.domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private int id;
    private String title;
    private String picUrl1;
    private String picUrl2;
    private String picUrl3;
    private double review;
    private double rating;
    private int numberInCart;
    private double price;
    private String description;
    private String url;

    //Constructor of All Products.
    public PopularDomain(int id , String title, String picUrl1, String picUrl2, String picUrl3, double review, double rating, double price, String description, String url) {
        this.id = id;
        this.title = title;
        this.picUrl1 = picUrl1;
        this.picUrl2= picUrl2;
        this.picUrl3= picUrl3;
        this.review = review;
        this.rating = rating;
        this.price = price;
        this.description=description;
        this.url=url;
    }

    //Constructor of Favorite Items.
    public PopularDomain(int id, String title, String picUrl1, String picUrl2, String picUrl3, Double price, String description) {
        this.id=id;
        this.title = title;
        this.picUrl1 = picUrl1;
        this.picUrl2 = picUrl2;
        this.picUrl3 = picUrl3;
        this.price = price;
        this.description=description;
    }

    //Constructor of SearchAdapter
    public PopularDomain(int id, String title, int picUrl1, int picUrl2, int picUrl3, int review, int rating, int price, String description, String Url) {
        this.id=id;
        this.title = title;
        this.picUrl1 = String.valueOf(picUrl1);
        this.picUrl2 = String.valueOf(picUrl2);
        this.picUrl3 = String.valueOf(picUrl3);
        this.review = review;
        this.rating = rating;
        this.price = price;
        this.description = description;
        this.url = Url;
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

    public String getPicUrl1() {
        return picUrl1;
    }

    public void setPicUrl1(String picUrl1) {
        this.picUrl1 = picUrl1;
    }
    public String getPicUrl2() {
        return picUrl2;
    }

    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }
    public String getPicUrl3() {
        return picUrl3;
    }

    public void setPicUrl3(String picUrl3) {
        this.picUrl3 = picUrl3;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
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

    public String getUrl(){ return url;}

    public void setUrl(String url) {this.url=url;}
}
