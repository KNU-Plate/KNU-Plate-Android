package com.example.knuplate.data.mall;

import java.util.ArrayList;

public class MallDetailData {
    String kakao_mall_id;
    String thumbnail;
    String category_name;
    String address;
    String is_active;
    double latitude;
    double longitude;
    String recommend_count;
    FileFolder file_folder;
    String user_id;
    String date_create;
    String reviewCount;
    Integer mall_id;
    String contact;
    String mall_name;
    ArrayList<MenuData> menus;
    String my_recommend;
    String evaluate_average;

    String gate_location;

    @Override
    public String toString() {
        return "MallDetailData{" +
                "kakao_mall_id='" + kakao_mall_id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", category_name='" + category_name + '\'' +
                ", address='" + address + '\'' +
                ", is_active='" + is_active + '\'' +
                ", latitude='" + latitude + '\'' +
                ", recommend_count='" + recommend_count + '\'' +
                ", file_folder=" + file_folder +
                ", user_id='" + user_id + '\'' +
                ", date_create='" + date_create + '\'' +
                ", reviewCount='" + reviewCount + '\'' +
                ", mall_id=" + mall_id +
                ", contact='" + contact + '\'' +
                ", mall_name='" + mall_name + '\'' +
                ", menus=" + menus +
                ", my_recommend='" + my_recommend + '\'' +
                ", evaluate_average='" + evaluate_average + '\'' +
                ", longitude='" + longitude + '\'' +
                ", gate_location='" + gate_location + '\'' +
                '}';
    }

    public String getKakao_mall_id() {
        return kakao_mall_id;
    }

    public void setKakao_mall_id(String kakao_mall_id) {
        this.kakao_mall_id = kakao_mall_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getRecommend_count() {
        return recommend_count;
    }

    public void setRecommend_count(String recommend_count) {
        this.recommend_count = recommend_count;
    }

    public FileFolder getFile_folder() {
        return file_folder;
    }

    public void setFile_folder(FileFolder file_folder) {
        this.file_folder = file_folder;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getMall_id() {
        return mall_id;
    }

    public void setMall_id(Integer mall_id) {
        this.mall_id = mall_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMall_name() {
        return mall_name;
    }

    public void setMall_name(String mall_name) {
        this.mall_name = mall_name;
    }

    public ArrayList<MenuData> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<MenuData> menus) {
        this.menus = menus;
    }

    public String getMy_recommend() {
        return my_recommend;
    }

    public void setMy_recommend(String my_recommend) {
        this.my_recommend = my_recommend;
    }

    public String getEvaluate_average() {
        return evaluate_average;
    }

    public void setEvaluate_average(String evaluate_average) {
        this.evaluate_average = evaluate_average;
    }

    public String getGate_location() {
        return gate_location;
    }

    public void setGate_location(String gate_location) {
        this.gate_location = gate_location;
    }

}
