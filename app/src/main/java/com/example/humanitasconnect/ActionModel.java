package com.example.humanitasconnect;

public class ActionModel {
    private String title;
    private String description;
    private String target;

    public ActionModel() {
    }

    public ActionModel(String title, String description, String target) {
        this.title = title;
        this.description = description;
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}