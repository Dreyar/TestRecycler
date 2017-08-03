package com.example.arxdev30.testrecycler.Data;

/**
 * Created by nikos on 3/8/2017.
 */

public class ListItem {
    private String dateAndTime;
    private String message;
    private int colorResource;

    public ListItem() {
    }

    public ListItem(String dateAndTime, String message, int colorResource) {
        this.dateAndTime = dateAndTime;
        this.message = message;
        this.colorResource = colorResource;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getMessage() {
        return message;
    }

    public int getColorResource() {
        return colorResource;
    }
}
