package com.example.knuplate.model;

import com.google.gson.annotations.SerializedName;

public class NoticeData {

    @SerializedName("title")
    private String title;

    @SerializedName("contents")
    private String contents;

    @SerializedName("date_create")
    private String date_create;

    @SerializedName("notice_id")
    private int notice_id;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("is_active")
    private String is_active;

    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "SignUpData{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", date_create='" + date_create + '\'' + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }
}


