package com.example.knuplate.model;

public class ReviewData {
    private Integer review_id;
    private String user_id;
<<<<<<< HEAD
    private Integer mail_id;
=======
    private int mail_id;
>>>>>>> ba5ddfcdb1fca974621ab6c9f33bbf6a313c4ca1
    private String date_create;
    private String contents;
    private Integer evaluate;
    private String review_image;
    private String is_active;

<<<<<<< HEAD
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
=======
    public ReviewData(int review_id, String user_id, int mail_id, String date_create, String contents, int evaluate, String review_image, String is_active) {
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
>>>>>>> ba5ddfcdb1fca974621ab6c9f33bbf6a313c4ca1
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
