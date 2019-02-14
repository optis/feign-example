package com.optis.myapp.model;


import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    //Properties
    private long reservationNumber;
    private LocalDate dateOfReservation;
    private LocalTime timeOfReservation;
    private int amountOfPeople;

    //Getters & Setters
    public long getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(long reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public LocalDate getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(LocalDate dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public LocalTime getTimeOfReservation() {
        return timeOfReservation;
    }

    public void setTimeOfReservation(LocalTime timeOfReservation) {
        this.timeOfReservation = timeOfReservation;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    //Default constructor
    public Reservation() {
    }

    //Regular constructor
    public Reservation(long reservationNumber, LocalDate dateOfReservation, LocalTime timeOfReservation, int amountOfPeople) {
        this.reservationNumber = reservationNumber;
        this.dateOfReservation = dateOfReservation;
        this.timeOfReservation = timeOfReservation;
        this.amountOfPeople = amountOfPeople;
    }

    @Override
    public String toString() {
        String result = "------Reservation------------------------------------";
        result += "\nReservation number: " + getReservationNumber();
        result += "\nDate and time of reservation: " + getDateOfReservation() + " at " + getTimeOfReservation();
        result += "\nFor " + getAmountOfPeople() + " people";
        result += "\n-----------------------------------------------------\n";

        return result;
    }
}
