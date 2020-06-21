package com.example.codingassignment2;

public class AvailableSlotDetails {

    private String Date;
    private String Time;

    public AvailableSlotDetails(){

    }

    @Override
    public String toString() {
        return "AvailableSlotDetails{" +
                "Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
