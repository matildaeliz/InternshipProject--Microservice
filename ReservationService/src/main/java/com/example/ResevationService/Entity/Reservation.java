package com.example.ResevationService.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "reservationinfo")
public class Reservation {
    public Reservation(String pnr, String departureport, String arrivalport, String departuredate, int adultcount, int childcount, int infantcount, String flighttype, String price, String name, String surname, String mail, String telephone) {

        this.pnr = pnr;
        this.departureport = departureport;
        this.arrivalport = arrivalport;
        this.departuredate = departuredate;
        this.adultcount = adultcount;
        this.childcount = childcount;
        this.infantcount = infantcount;
        this.flighttype = flighttype;
        this.price = price;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.telephone = telephone;
    }

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


    public Reservation(String generatePNR, String departure, String arrival, int adultcount, int childcount, int infantcount, String triptype, String departuredate) {
        this.pnr=generatePNR;
        this.departureport=departure;
        this.arrivalport=arrival;
        this.adultcount=adultcount;
        this.childcount=childcount;
        this.infantcount=infantcount;
        this.flighttype=triptype;
        this.departuredate= departuredate;
    }
}