package com.optis.feigndemoapi.web.service;

import com.optis.feigndemoapi.model.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationService {
     List<Reservation> getAllReservations();
     Reservation getReservationByReservationNumber(long reservationNumber);
     List<Reservation> getReservationsByDateAndOrTime(LocalDate date, LocalTime time);

     Reservation addReservation(Reservation reservation);
}
