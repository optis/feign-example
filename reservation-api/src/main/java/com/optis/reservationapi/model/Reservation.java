package com.optis.reservationapi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "RESERVATION_NUMBER")
    private long reservationNumber;

    @Column(nullable = false, name="DATE_OF_RESERVATION")
    private LocalDate dateOfReservation;

    @Column(nullable = false, name="TIME_OF_RESERVATION")
    private LocalTime timeOfReservation;

    @Column(nullable = false, name="AMOUNT_OF_PEOPLE")
    private int amountOfPeople;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Reservation() {
    }

    public Reservation(long reservationNumber, LocalDate dateOfReservation, LocalTime timeOfReservation, int amountOfPeople) {
        this.reservationNumber = reservationNumber;
        this.dateOfReservation = dateOfReservation;
        this.timeOfReservation = timeOfReservation;
        this.amountOfPeople = amountOfPeople;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getId() == that.getId() &&
                getReservationNumber() == that.getReservationNumber() &&
                getAmountOfPeople() == that.getAmountOfPeople() &&
                Objects.equals(getDateOfReservation(), that.getDateOfReservation()) &&
                Objects.equals(getTimeOfReservation(), that.getTimeOfReservation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReservationNumber(), getDateOfReservation(), getTimeOfReservation(), getAmountOfPeople());
    }
}
