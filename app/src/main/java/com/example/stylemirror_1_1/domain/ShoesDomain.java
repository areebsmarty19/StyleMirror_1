package com.example.stylemirror_1_1.domain;

import java.io.Serializable;

public class ShoesDomain implements Serializable {
    private String shoesTitle;
    private String shoesPicUrl;
    private int shoesReview;
    private double shoesScore;
    private int numberInCart;
    private double shoesPrice;
    private String shoesDescription;

    public ShoesDomain(String shoesTitle, String shoesPicUrl,int shoesReview, double shoesScore, double shoesPrice,String shoesDescription) {
        this.shoesTitle = shoesTitle;
        this.shoesPicUrl = shoesPicUrl;
        this.shoesReview = shoesReview;
        this.shoesScore = shoesScore;
        this.shoesPrice = shoesPrice;
        this.shoesDescription=shoesDescription;
    }

    public String getShoesDescription() {
        return shoesDescription;
    }

    public void setShoesDescription(String shoesDescription) {
        this.shoesDescription = shoesDescription;
    }

    public String getShoesTitle() {
        return shoesTitle;
    }

    public void setShoesTitle(String shoesTitle) {
        this.shoesTitle = shoesTitle;
    }

    public String getShoesPicUrl() {
        return shoesPicUrl;
    }

    public void setShoesPicUrl(String shoesPicUrl) {
        this.shoesPrice = shoesPrice;
    }

    public int getShoesReview() {
        return shoesReview;
    }

    public void setShoesReview(int shoesReview) {
        this.shoesReview = shoesReview;
    }

    public double getShoesScore() {
        return shoesScore;
    }

    public void setShoesScore(double shoesScore) {
    this.shoesScore = shoesScore;
    }

    public int getShoesNumberInCart() {
        return numberInCart;
    }

    public void setShoesNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public double getShoesPrice() {
    return shoesPrice;
    }

public void setSHoesPrice(double shoesPrice) {
        this.shoesPrice = shoesPrice;
    }
}
