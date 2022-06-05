package com.example.basicinterface.datamodel;

import java.time.LocalDate;

public class Lift {
    //private String day;
    private String bodyPart;
    private String details;
    private LocalDate dateTime;

    public Lift( String bodyPart, String details, LocalDate dateTime) {
        //this.day = day;
        this.bodyPart = bodyPart;
        this.details = details;
        this.dateTime = dateTime;
    }




    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }



    @Override
    public String toString() {
        return dateTime.getDayOfWeek() + "\n" + bodyPart;
    }
}
