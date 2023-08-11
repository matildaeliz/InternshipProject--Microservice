package com.example.pnrsearchservice.Controller;

import com.example.pnrsearchservice.Service.PnrSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class PnrSearchController {
    @Autowired
    PnrSearchService pnrSearchService;


    @GetMapping("/getpassengerinfos")
   public String getpassengerinfo(){
       return pnrSearchService.getPassengerInfo();
   }

    @GetMapping("/getflightinfos")
    public String getflightinfo(){
        return pnrSearchService.getFlightInfo();
    }

    @GetMapping("/checkrezervationinfo")
    public ResponseEntity isExistPNR(@RequestParam("pnr") String pnr){
      if(pnrSearchService.isExistPNR(pnr) == null){
          return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }else {
          return  ResponseEntity.status(HttpStatus.OK).build();
      }
    }
}
