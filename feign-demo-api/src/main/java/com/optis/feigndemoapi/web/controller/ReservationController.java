package com.optis.feigndemoapi.web.controller;


import com.optis.feigndemoapi.model.Reservation;
import com.optis.feigndemoapi.web.service.ReservationServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/reservations" )
public class ReservationController {
    private ReservationServiceImpl reservationService;

    public ReservationController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return this.reservationService.getAllReservations();
    }

    @GetMapping("/{reservationNumber}")
    public Reservation getReservationByReservationNumber(@PathVariable long reservationNumber){
        return this.reservationService.getReservationByReservationNumber(reservationNumber);
    }

    @GetMapping("/filter")
    public List<Reservation> getReservationsByDateAndOrTime(@RequestParam(name="date")@DateTimeFormat( iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam(required = false, name="time") @DateTimeFormat( iso = DateTimeFormat.ISO.TIME) LocalTime time){
        return this.reservationService.getReservationsByDateAndOrTime(date, time);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation){
        return this.reservationService.addReservation(reservation);
    }
}
