package com.ravisharma.topnews;

/**
 * Created by Pi Last LAB on 4/20/2018.
 */

public class NewsModel {

    String Title, Description, Authur, Time, Url;
    String image;

    public NewsModel() {
    }

    public String getTitle() {
        return Title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuthur() {
        return Authur;
    }

    public void setAuthur(String authur) {
        Authur = authur;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
