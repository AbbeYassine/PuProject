package com.example.abbes.calendarviewtest.entity;

/**
 * Created by Abbes on 19/04/2016.
 */
public class Task {
    String name;
    String time;
    String duration;
    String address;
    Integer image;

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Task(String name, String time, String duration, int image, String address) {
        this.name = name;
        this.time = time;
        this.duration = duration;
        this.address = address;
        this.image = image;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
