package com.example.knuplate.data.mall;

import java.util.ArrayList;

public class FileFolder {
    private String file_folder_id;
    private String date_create;
    private ArrayList<File> files;
    private String type;

    @Override
    public String toString() {
        return "FileFolder{" +
                "file_folder_id='" + file_folder_id + '\'' +
                ", date_create='" + date_create + '\'' +
                ", files=" + files +
                ", type='" + type + '\'' +
                '}';
    }

    public String getFile_folder_id() {
        return file_folder_id;
    }

    public void setFile_folder_id(String file_folder_id) {
        this.file_folder_id = file_folder_id;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
