package com.optis.reservationapi.persistence;

import com.optis.reservationapi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    //Methods

    List<Reservation> findAll();

    List<Reservation> findByDateOfReservation(LocalDate date);
    List<Reservation> findByDateOfReservationAndTimeOfReservation(LocalDate date, LocalTime time);

    Reservation findByReservationNumber(long reservationNumber);
}
