package com.example.pnrsearchservice.Repository;

import com.example.pnrsearchservice.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight,String> {

    @Query("SELECT flight.aircraft,flight.departureport,flight.arrivalport FROM Flight flight  WHERE flight.arrivalport=:arrivalport")
    public String getFlightInformation(@Param("arrivalport") String arrivalport);
}
