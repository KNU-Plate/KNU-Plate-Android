package com.example.knuplate.model;

public class MallData {
    String mall_id;
    String mall_name;
    String category_name;
    String evaluate_average;
    String address;

    @Override
    public String toString() {
        return "MallData{" +
                "mall_id='" + mall_id + '\'' +
                ", mall_name='" + mall_name + '\'' +
                ", category_name='" + category_name + '\'' +
                ", evaluate_average='" + evaluate_average + '\'' +
                ", address='" + address + '\'' +
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

    public String getEvaluate_average() {
        return evaluate_average;
    }

    public void setEvaluate_average(String evaluate_average) {
        this.evaluate_average = evaluate_average;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
