package com.optis.feigndemoapp;

import com.optis.feigndemoapp.client.ReservationClient;
import com.optis.feigndemoapp.dto.ResourceTransformer;
import com.optis.feigndemoapp.model.Reservation;
import feign.Feign;
import feign.gson.GsonDecoder;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Unit test for simple FeignDemoApp.
 */
public class FeignDemoAppTest
    extends TestCase
{
    /**
     * Create the client
     */
    public ReservationClient getClient(){
        return  Feign.builder()
                .decoder(new GsonDecoder())
                .target(ReservationClient.class, "http://localhost:8080/api/reservations");
    }


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FeignDemoAppTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FeignDemoAppTest.class );
    }

/*
    public void testFindAll(){
        ReservationClient client = getClient();
        List<Reservation> reservations = ResourceTransformer.transformDtosToReservations(client.findAll());

        assertEquals(3, reservations.size());
    }


    public void testfindByReservationNumber(){
        ReservationClient client = getClient();
        Reservation reservation =  ResourceTransformer.transformDtoToReservation(client.findByReservationNumber(12345));

        assertEquals(12345, reservation.getReservationNumber());
    }

    public void testFindByDateOfReservation(){
        ReservationClient client = getClient();
        LocalDate date = LocalDate.of(2019, 2, 16);

        List<Reservation> reservations = ResourceTransformer.transformDtosToReservations(client.findAllByDateOfReservation(date));
        for(Reservation reservation : reservations){
            assertEquals(2019, reservation.getDateOfReservation().getYear());
            assertEquals(2, reservation.getDateOfReservation().getMonthValue());
            assertEquals(16, reservation.getDateOfReservation().getDayOfMonth());
        }
        assertEquals(2, reservations.size());
    }

    public void testFindByDateAndTIme(){
        ReservationClient client = getClient();
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



*/




}
