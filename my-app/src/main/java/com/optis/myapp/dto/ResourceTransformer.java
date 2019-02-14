package com.optis.myapp.dto;

import com.optis.myapp.model.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ResourceTransformer {

    public static Reservation transformDtoToReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setReservationNumber(reservationDto.getReservationNumber());
        reservation.setAmountOfPeople(reservationDto.getAmountOfPeople());
        reservation.setDateOfReservation(LocalDate.parse(reservationDto.getDateOfReservation()));
        reservation.setTimeOfReservation(LocalTime.parse(reservationDto.getTimeOfReservation()));

        return reservation;
    }

    public static List<Reservation> transformDtosToReservations(List<ReservationDto> reservationDtos) {
        List<Reservation> result = new ArrayList<>();

        for (ReservationDto reservationDto : reservationDtos) {
            result.add(transformDtoToReservation(reservationDto));
        }
        return result;
    }
}
