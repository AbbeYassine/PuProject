package com.example.abbes.calendarviewtest.entity;

/**
 * Created by Abbes on 19/04/2016.
 */
public class Task {
    String name;
    String time;
    String duration;
    String address;


    public Task(String name, String time, String duration, String address) {
        this.name = name;
        this.time = time;
        this.duration = duration;
        this.address = address;
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
