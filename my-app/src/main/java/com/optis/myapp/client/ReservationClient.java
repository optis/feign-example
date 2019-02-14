package com.optis.myapp.client;

import com.optis.myapp.dto.ReservationDto;
import com.optis.myapp.model.Reservation;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationClient {
    @RequestLine("GET")
    List<ReservationDto> findAll();

    @RequestLine("GET /{reservationNumber}")
    ReservationDto findByReservationNumber(@Param("reservationNumber") long reservationNumber);

    @RequestLine("GET /filter?date={date}")
    List<ReservationDto> findAllByDateOfReservation(@Param("date") LocalDate date);

    @RequestLine("GET /filter?date={date}&time={time}")
    List<ReservationDto> findAllByDateAndTime(@Param("date") LocalDate date, @Param("time") LocalTime time);

    @RequestLine("GET")
    @Headers("Content-Type: application/json")
    void addReservation(Reservation reservation) throws Exception;

}




