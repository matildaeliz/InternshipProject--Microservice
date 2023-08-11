package com.example.ResevationService.Repository;

import com.example.ResevationService.Entity.Reservation;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PATCH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    @Modifying
    @Transactional
    @Query("UPDATE Reservation res SET res.name=:name, res.surname=:surname, res.telephone=:telephone, res.mail=:mail WHERE res.pnr=:pnr")
    void addInfo(@Param("pnr") String pnr, @Param("name") String name, @Param("surname") String surname, @Param("telephone") String telephone, @Param("mail") String mail);

    @Modifying
    @Transactional
    @Query("UPDATE Reservation res SET res.price =:price")
    void updatePrice(@Param("price") String price);

    @Query("SELECT reservation.name,reservation.surname,reservation.telephone, reservation.mail FROM Reservation reservation WHERE reservation.pnr=:pnr")
    String getPassengerInfo(@Param("pnr") String pnr);


    @Query("SELECT reservation.departuredate FROM Reservation  reservation WHERE reservation.pnr=:pnr")
    String getDate(@Param("pnr") String pnr);

    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation reservation WHERE reservation.pnr =:pnr ")
    void deleteReservation(@Param("pnr") String pnr);

    @Modifying
    @Transactional
    @Query("UPDATE Reservation res SET res.Status =:Status WHERE res.pnr =:pnr")
    void setStatus( @Param("Status")String Status,@Param("pnr") String pnr);



}