package com.example.ResevationService.Controller;


import com.example.ResevationService.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class ReservationController {



@Autowired
    ReservationService reservationService;

    @GetMapping("/reservation")
    public void GenerateReservation(@RequestParam("triptype")  String triptype, @RequestParam("departure") String departure, @RequestParam("arrival") String arrival,@RequestParam("adultcount") String adulcount,@RequestParam("childcount") String childcount, @RequestParam("infantcount") String infantcount, @RequestParam("date")String date){
      reservationService.GenerateReservation(triptype,departure, arrival,adulcount,childcount,infantcount,date);
    }
    @GetMapping("/adultinfo")
    public void addInfo(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("telephone")String telephone, @RequestParam("mail")String mail){
    reservationService.addInfo(name,surname,telephone,mail);
    }

    @GetMapping("/getbusinessprice")
    public String getBusinessPrice(){
        return String.valueOf(2354+ reservationService.calculateprice()) ;
    }

    @GetMapping("/geteconomyprice")
    public String getEconomyPrice(){
        return String.valueOf(945+ reservationService.calculateprice()) ;
    }

    @GetMapping("/setprice")
    public void setPrice(@RequestParam("price") String price){

        reservationService.setPrice(price);
    }
    @GetMapping("/getflightinfo")
    public String getFlightinformation(){
        return reservationService.getFlightInfo();
    }
    @GetMapping("/getpassengerinfo")
    public String getPassengerInfo(){
        return reservationService.getPassengerInfo();
    }
    @GetMapping("/setstatus")
    public void setStatus(){
       reservationService.setStatus("TICKETED");
    }
    @GetMapping("/deletereservation")
    public void deleteReservation(){
        reservationService.deleteReservation();
    }

    @GetMapping("/getpnr")
    public String getpnr(){
        return reservationService.getPNR();
    }
}
