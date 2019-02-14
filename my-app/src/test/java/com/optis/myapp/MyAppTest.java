package com.optis.myapp;

import com.optis.myapp.client.ReservationClient;
import com.optis.myapp.dto.ResourceTransformer;
import com.optis.myapp.model.Reservation;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple MyApp.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class MyAppTest

{

    private ReservationClient client;
    /**
     * Create the client
     */
    @BeforeAll
    public void setUp(){
        this.client = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ReservationClient.class, "http://localhost:8080/api/reservations");
    }


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    /**
     * @return the suite of tests being tested
     */

    @Test
    public void testFindAll(){
        List<Reservation> reservations = ResourceTransformer.transformDtosToReservations(client.findAll());
        assertEquals(3, reservations.size());
    }


    @Test
    public void testfindByReservationNumber(){
        Reservation reservation =  ResourceTransformer.transformDtoToReservation(client.findByReservationNumber(12345));

        assertEquals(12345, reservation.getReservationNumber());
    }

    @Test
    public void testFindByDateOfReservation(){
        LocalDate date = LocalDate.of(2019, 2, 16);

        List<Reservation> reservations = ResourceTransformer.transformDtosToReservations(client.findAllByDateOfReservation(date));
        for(Reservation reservation : reservations){
            assertEquals(2019, reservation.getDateOfReservation().getYear());
            assertEquals(2, reservation.getDateOfReservation().getMonthValue());
            assertEquals(16, reservation.getDateOfReservation().getDayOfMonth());
        }
        assertEquals(2, reservations.size());
    }

    @Test
    public void testFindByDateAndTIme(){
        LocalDate date = LocalDate.of(2019, 2, 16);
        LocalTime time = LocalTime.of(20,30);

        List<Reservation> reservations = ResourceTransformer.transformDtosToReservations(client.findAllByDateAndTime(date, time));

        for(Reservation reservation : reservations){
            assertEquals(2019, reservation.getDateOfReservation().getYear());
            assertEquals(2, reservation.getDateOfReservation().getMonthValue());
            assertEquals(16, reservation.getDateOfReservation().getDayOfMonth());

            assertEquals(20, reservation.getTimeOfReservation().getHour());
            assertEquals(30, reservation.getTimeOfReservation().getMinute());
        }
        assertEquals(1, reservations.size());
    }








}
