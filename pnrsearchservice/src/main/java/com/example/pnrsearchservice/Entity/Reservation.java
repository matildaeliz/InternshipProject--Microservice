package com.example.pnrsearchservice.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "reservationinfo")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int reservationid;
    @Column
    private String pnr;
    @Column
    private String departureport;
    @Column
    private String arrivalport;
    @Column
    private String departuredate;
    @Column
    private int adultcount;
    @Column
    private int childcount;
    @Column
    private int infantcount;
    @Column
    private String flighttype;
    @Column
    private String price;
    @Column
    private String Status = "UNTICKETED";
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String mail;
    @Column
    private String telephone;

    public Reservation(){}



}