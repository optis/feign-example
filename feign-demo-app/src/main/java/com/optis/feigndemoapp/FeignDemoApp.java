package com.optis.feigndemoapp;

import com.google.gson.JsonParser;
import com.optis.feigndemoapp.client.ReservationClient;
import com.optis.feigndemoapp.dto.ResourceTransformer;
import com.optis.feigndemoapp.model.Reservation;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Hello world!
 *
 */
public class FeignDemoApp
{
    public static void main( String[] args )
    {
        ReservationClient client = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ReservationClient.class, "http://localhost:8080/api/reservations");

        List<Reservation> test = ResourceTransformer.transformDtosToReservations(client.findAll());


        System.out.println("\u001B[32mGet all reservations\u001B[0m");
        for(Reservation r : test){
            System.out.println(r);
        }

        System.out.println( "\u001B[32mGet reservation by reservation number: 12345\u001B[0m");
        Reservation test2 =  ResourceTransformer.transformDtoToReservation(client.findByReservationNumber(12345));
        System.out.println(test2);


        LocalDate date = LocalDate.of(2019, 2, 16);
        System.out.println("\u001B[32mGet all reservations on "+ date.toString()+"\u001B[0m");
        List<Reservation> test3 = ResourceTransformer.transformDtosToReservations(client.findAllByDateOfReservation(date));
        if(test3.size() > 0) {
            for (Reservation r : test3) {
                System.out.println(r);
            }
        }
        else{
            System.out.println("No reservations found for " + date.toString());
        }

        LocalTime time = LocalTime.of(20, 30);
        System.out.println("\u001B[32mGet all reservations on "+ date.toString()+" at "+ time +"\u001B[0m");
        List<Reservation> test4 = ResourceTransformer.transformDtosToReservations(client.findAllByDateAndTime(date, time));
        if(test4.size() > 0) {
            for (Reservation r : test4) {
                System.out.println(r);
            }
        }
        else{
            System.out.println("No reservations found for " + date.toString() + " at " + time.toString());
        }


        System.out.println("\u001B[32mAdd a reservation and fetching it afterwards if successful\u001B[0m");
        Reservation reservation = new Reservation(12348, LocalDate.of(2019, 3, 10), LocalTime.of(20,0), 5);
        try{
            client.addReservation(reservation);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            //Reservation test5 =  ResourceTransformer.transformDtoToReservation(client.findByReservationNumber(12348));
            //System.out.println(test5);

        }




    }
}
