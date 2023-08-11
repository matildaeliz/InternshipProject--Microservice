package com.example.ResevationService.Service;

import com.example.ResevationService.Entity.Reservation;
import com.example.ResevationService.Repository.FlightRepository;
import com.example.ResevationService.Repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Random;
@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    FlightRepository flightRepository;



    public String PNR = generatePNR();
    int adultcount,childcount,infantcount;
    String arrivalport;

    public void GenerateReservation(String triptype, String departure, String arrival,String adultcount, String childcount,  String infantcount,String date){
        reservationRepository.save(new Reservation(PNR,departure,arrival,Integer.parseInt(adultcount),Integer.parseInt(adultcount),Integer.parseInt(adultcount),triptype,date));this.adultcount= Integer.parseInt(adultcount);
        this.childcount= Integer.parseInt(childcount);
        this.infantcount = Integer.parseInt(infantcount);
        this.arrivalport=arrival;


    }
    public String getPassengerInfo(){
        return reservationRepository.getPassengerInfo(PNR);
    }
   public String getFlightInfo(){
      return flightRepository.getFlightInformation(this.arrivalport) + "-" + reservationRepository.getDate(PNR);   }
    public void addInfo( String name, String surname,String telephone, String mail){
        reservationRepository.addInfo(PNR,name,surname,telephone,mail);
    }

    public void setPrice(String Price){
        reservationRepository.updatePrice(Price);
    }
public void deleteReservation(){
        reservationRepository.deleteReservation(PNR);
}
    public void setStatus(String status){
        reservationRepository.setStatus(status,PNR);
    }
    public int calculateprice(){
        int price = 0;

        int totalPassengers = adultcount + childcount + infantcount;
        price += totalPassengers * Integer.parseInt(flightRepository.getDistance(arrivalport));

        price -= childcount * Integer.parseInt(flightRepository.getDistance(arrivalport)) * 0.3;
        price -= infantcount * Integer.parseInt(flightRepository.getDistance(arrivalport)) * 0.6;

        return price;

    }
    public static String generatePNR(){
        final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String NUMBERS = "0123456789";

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {

                int randomIndex = random.nextInt(LETTERS.length());
                sb.append(LETTERS.charAt(randomIndex));
            } else {

                int randomIndex = random.nextInt(NUMBERS.length());
                sb.append(NUMBERS.charAt(randomIndex));
            }
        }

        return sb.toString();
    }


}
