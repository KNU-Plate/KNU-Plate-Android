package com.example.knuplate.data.mall;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuData implements Parcelable {
    private int like;
    private String date_create;
    private int dislike;
    private int mall_id;
    private String menu_name;
    private int menu_id;


    protected MenuData(Parcel in) {
        like = in.readInt();
        date_create = in.readString();
        dislike = in.readInt();
        mall_id = in.readInt();
        menu_name = in.readString();
        menu_id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(like);
        dest.writeString(date_create);
        dest.writeInt(dislike);
        dest.writeInt(mall_id);
        dest.writeString(menu_name);
        dest.writeInt(menu_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MenuData> CREATOR = new Creator<MenuData>() {
        @Override
        public MenuData createFromParcel(Parcel in) {
            return new MenuData(in);
        }

        @Override
        public MenuData[] newArray(int size) {
            return new MenuData[size];
        }
    };

    @Override
    public String toString() {
        return "MenuData{" +
                "like=" + like +
                ", date_create='" + date_create + '\'' +
                ", dislike=" + dislike +
                ", mall_id=" + mall_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_id=" + menu_id +
                '}';
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getMall_id() {
        return mall_id;
    }

    public void setMall_id(int mall_id) {
        this.mall_id = mall_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }
}
