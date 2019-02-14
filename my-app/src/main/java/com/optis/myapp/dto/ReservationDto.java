package com.optis.myapp.dto;

public class ReservationDto {
    //Properties
    private long reservationNumber;
    private String dateOfReservation;
    private String timeOfReservation;
    private int amountOfPeople;

    //Getters & Setters
    public long getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(long reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(String dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public String getTimeOfReservation() {
        return timeOfReservation;
    }

    public void setTimeOfReservation(String timeOfReservation) {
        this.timeOfReservation = timeOfReservation;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    //Default constructor
    public ReservationDto() {
    }

    //Regular constructor
    public ReservationDto(long reservationNumber, String dateOfReservation, String timeOfReservation, int amountOfPeople) {
        this.reservationNumber = reservationNumber;
        this.dateOfReservation = dateOfReservation;
        this.timeOfReservation = timeOfReservation;
        this.amountOfPeople = amountOfPeople;
    }
}
