package com.optis.feigndemoapi.web.service;

import com.optis.feigndemoapi.model.Reservation;
import com.optis.feigndemoapi.persistence.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

@Service("reservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationByReservationNumber(long reservationNumber) {
        return reservationRepository.findByReservationNumber(reservationNumber);
    }

    @Override
    public List<Reservation> getReservationsByDateAndOrTime(LocalDate date, LocalTime time) {
        List<Reservation> reservations;
        if(time == null){
            reservations = reservationRepository.findByDateOfReservation(date);
        }
        else{
            reservations = reservationRepository.findByDateOfReservationAndTimeOfReservation(date, time);
        }
        return reservations;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        System.out.println(reservation);
        reservation.setId(100);
        return reservationRepository.save(reservation);
    }
}
