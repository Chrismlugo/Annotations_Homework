package models;

import models.File;

import java.util.Set;

public class Folder {
    private int id;
    private String title;
    private Set<File> files;

    public Folder() {
    }

    public Folder(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }
}
