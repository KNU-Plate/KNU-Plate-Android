package com.example.knuplate.model;

public class ReviewData {
    private Integer review_id;
    private String user_id;
    private Integer mail_id;
    private String date_create;
    private String contents;
    private Integer evaluate;
    private String review_image;
    private String is_active;

    @Override
    public String toString() {
        return "ReviewData{" +
                "review_id=" + review_id +
                ", user_id='" + user_id + '\'' +
                ", mail_id=" + mail_id +
                ", date_create='" + date_create + '\'' +
                ", contents='" + contents + '\'' +
                ", evaluate=" + evaluate +
                ", review_image='" + review_image + '\'' +
                ", is_active='" + is_active + '\'' +
                '}';
    }

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getMail_id() {
        return mail_id;
    }

    public void setMail_id(Integer mail_id) {
        this.mail_id = mail_id;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
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
