package com.example.pnrsearchservice.Repository;

import com.example.pnrsearchservice.Entity.Reservation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

    @Query("SELECT reservation.name,reservation.surname,reservation.telephone, reservation.mail FROM Reservation reservation WHERE reservation.pnr=:pnr")
    String getPassengerInfo(@Param("pnr") String pnr);
@Query("SELECT res.arrivalport FROM Reservation res WHERE res.pnr=:pnr")
String getArrivalPort(@Param("pnr") String pnr);
    @Query("SELECT reservation.departuredate FROM Reservation  reservation WHERE reservation.pnr=:pnr")
    String getDate(@Param("pnr") String pnr);

    @Query("SELECT res.pnr FROM Reservation res WHERE res.pnr =:pnr ")
    String isExistPNR(@Param("pnr") String pnr);







}
