package com.example.evey.ibox.bean;

import android.graphics.Bitmap;

/**
 * Created by Evey on 2018/3/11.
 */

public class Delivery {
    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private Bitmap image;
    private Long time;

    public Delivery(Bitmap image, Long time, String place, String number) {
        this.image = image;
        this.time = time;
        this.place = place;
        this.number = number;
    }
    private String place;
    private String number;
}