package com.example.knuplate.model.dto;

public class Menu {
    private String like;
    private String date_create;
    private String dislike;
    private String mall_id;
    private String menu_name;
    private String menu_id;

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getDislike() {
        return dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public String getMall_id() {
        return mall_id;
    }

    public void setMall_id(String mall_id) {
        this.mall_id = mall_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "like='" + like + '\'' +
                ", date_create='" + date_create + '\'' +
                ", dislike='" + dislike + '\'' +
                ", mall_id='" + mall_id + '\'' +
                ", menu_name='" + menu_name + '\'' +
                ", menu_id='" + menu_id + '\'' +
                '}';
    }
}
