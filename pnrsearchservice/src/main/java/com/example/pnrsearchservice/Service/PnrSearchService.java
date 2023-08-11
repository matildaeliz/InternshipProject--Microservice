package com.example.pnrsearchservice.Service;

import com.example.pnrsearchservice.Repository.FlightRepository;
import com.example.pnrsearchservice.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PnrSearchService {
   String pnr;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    ReservationRepository reservationRepository;
    public String getPassengerInfo(){
        return reservationRepository.getPassengerInfo(pnr);
    }
    public String getFlightInfo(){
        return flightRepository.getFlightInformation(reservationRepository.getArrivalPort(pnr)) + "-" + reservationRepository.getDate(pnr);   }
    public String isExistPNR(String pnr){
         this.pnr=pnr;
        return reservationRepository.isExistPNR(pnr);
    }

}
