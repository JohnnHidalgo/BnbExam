package com.example.johnnhidalgo.model;

public class Element {
    private String Title;
    private String description;
    private String LongDescription;

    public Element() {
    }

    public Element(String title, String description, String longDescription) {
        Title = title;
        this.description = description;
        LongDescription = longDescription;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return LongDescription;
    }

    public void setLongDescription(String longDescription) {
        LongDescription = longDescription;
    }


    @Override
    public String toString() {
        return "Element{" +
                "Title='" + Title + '\'' +
                ", description='" + description + '\'' +
                ", LongDescription='" + LongDescription + '\'' +
                '}';
    }
}
