package com.example.codingassignment2;

public class AvailableSlotDetails {

    private String date;
    private String time;

    public AvailableSlotDetails(){

    }

    public AvailableSlotDetails(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }


}
