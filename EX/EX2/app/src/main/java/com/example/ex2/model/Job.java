package com.example.ex2.model;

public class Job {
    private String name, time, gender;

    public Job(String name, String time, String gender) {
        this.name = name;
        this.time = time;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
