package com.example.knuplate.model;

public class ReviewData {
    private int review_id;
    private String user_id;
    private int mail_id;
    private int date_create;
    private String contents;
    private int evaluate;
    private String review_image;
    private String is_active;

    public ReviewData(int review_id, String user_id, int mail_id, int date_create, String contents, int evaluate, String review_image, String is_active) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.mail_id = mail_id;
        this.date_create = date_create;
        this.contents = contents;
        this.evaluate = evaluate;
        this.review_image = review_image;
        this.is_active = is_active;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getMail_id() {
        return mail_id;
    }

    public void setMail_id(int mail_id) {
        this.mail_id = mail_id;
    }

    public int getDate_create() {
        return date_create;
    }

    public void setDate_create(int date_create) {
        this.date_create = date_create;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }

    public String getReview_image() {
        return review_image;
    }

    public void setReview_image(String review_image) {
        this.review_image = review_image;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }
}
