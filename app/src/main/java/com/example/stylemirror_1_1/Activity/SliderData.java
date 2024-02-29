package com.example.stylemirror_1_1.Activity;

import android.media.Image;

public class SliderData {

    // image url is used to
    // store the url of image
    private Integer imgUrl;

    // Constructor method.
    public SliderData(Integer imgUrl) {
        this.imgUrl = imgUrl;
    }

    // Getter method
    public Integer getImgUrl() {
        return imgUrl;
    }

    // Setter method
    public void setImgUrl(Integer imgUrl) {
        this.imgUrl = imgUrl;
    }
}

