package com.example.knuplate.model.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuData implements Parcelable {
    private Integer like;
    private String date_create;
    private Integer dislike;
    private Integer mall_id;
    private String menu_name;
    private Integer menu_id;

    protected MenuData(Parcel in) {
        if (in.readByte() == 0) {
            like = null;
        } else {
            like = in.readInt();
        }
        date_create = in.readString();
        if (in.readByte() == 0) {
            dislike = null;
        } else {
            dislike = in.readInt();
        }
        if (in.readByte() == 0) {
            mall_id = null;
        } else {
            mall_id = in.readInt();
        }
        menu_name = in.readString();
        if (in.readByte() == 0) {
            menu_id = null;
        } else {
            menu_id = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (like == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(like);
        }
        dest.writeString(date_create);
        if (dislike == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dislike);
        }
        if (mall_id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(mall_id);
        }
        dest.writeString(menu_name);
        if (menu_id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(menu_id);
        }
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

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public Integer getMall_id() {
        return mall_id;
    }

    public void setMall_id(Integer mall_id) {
        this.mall_id = mall_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }
}
