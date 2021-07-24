package com.example.knuplate.model;

import android.graphics.Bitmap;

public class MallData {
    String mall_id;
    String mall_name;
    String category_name;
    String rating;
    String address;
    String thumbnail;

    @Override
    public String toString() {
        return "MallData{" +
                "mall_id='" + mall_id + '\'' +
                ", mall_name='" + mall_name + '\'' +
                ", category_name='" + category_name + '\'' +
                ", rating='" + rating + '\'' +
                ", address='" + address + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }

    public String getMall_id() {
        return mall_id;
    }

    public void setMall_id(String mall_id) {
        this.mall_id = mall_id;
    }

    public String getMall_name() {
        return mall_name;
    }

    public void setMall_name(String mall_name) {
        this.mall_name = mall_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
