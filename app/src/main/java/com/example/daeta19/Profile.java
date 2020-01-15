package com.example.daeta19;

public class Profile {
    private String profile;
    private String name;
    private int age;
    private int count;
    private String star;
    private String score;
    private String sex;
    private String career;
    private String location;
    private String time;

    public Profile(String star, String score, String sex, String career, String location, String time , String name, int age, int count) {
        this.star = star;
        this.score = score;
        this.sex = sex;
        this.career = career;
        this.location = location;
        this.time = time;
        this.name = name;
        this.age = age;
        this.count = count;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
