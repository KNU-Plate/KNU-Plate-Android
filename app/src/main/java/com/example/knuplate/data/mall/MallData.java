package com.example.knuplate.data.mall;

public class MallData {
    int mall_id;
    String mall_name;
    String category_name;
    Double evaluate_average;
    String address;
    String thumbnail;
    FileFolder file_folder;

    @Override
    public String toString() {
        return "MallData{" +
                "mall_id=" + mall_id +
                ", mall_name='" + mall_name + '\'' +
                ", category_name='" + category_name + '\'' +
                ", evaluate_average=" + evaluate_average +
                ", address='" + address + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", file_folder=" + file_folder +
                '}';
    }

    public int getMall_id() {
        return mall_id;
    }

    public void setMall_id(int mall_id) {
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

    public Double getEvaluate_average() {
        return evaluate_average;
    }

    public void setEvaluate_average(Double evaluate_average) {
        this.evaluate_average = evaluate_average;
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

    public FileFolder getFile_folder() {
        return file_folder;
    }

    public void setFile_folder(FileFolder file_folder) {
        this.file_folder = file_folder;
    }
}
