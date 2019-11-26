package com.example.daeta19;

import android.media.Image;

public class Profile {
    private Image profile;
    private String star;
    private String score;
    private String sex;
    private String career;
    private String location;
    private String time;

    public Profile(String star, String score, String sex, String career, String location, String time) {
        this.star = star;
        this.score = score;
        this.sex = sex;
        this.career = career;
        this.location = location;
        this.time = time;
    }

    public Image getProfile() {
        return profile;
    }

    public void setProfile(Image profile) {
        this.profile = profile;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
