package com.optis.feigndemoapi.persistence;

import com.optis.feigndemoapi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

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
