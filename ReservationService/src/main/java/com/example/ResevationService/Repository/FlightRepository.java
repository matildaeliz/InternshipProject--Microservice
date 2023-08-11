package com.example.ResevationService.Repository;

import com.example.ResevationService.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {
    @Query("SELECT flight.distance FROM Flight flight WHERE flight.arrivalport=:arrivalport")
    public String getDistance(@Param("arrivalport") String arrivalport);

    @Query("SELECT flight.aircraft,flight.departureport,flight.arrivalport FROM Flight flight  WHERE flight.arrivalport=:arrivalport")
    public String getFlightInformation(@Param("arrivalport") String arrivalport);
}
