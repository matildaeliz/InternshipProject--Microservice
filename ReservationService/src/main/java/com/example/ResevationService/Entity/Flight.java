package com.example.ResevationService.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flightinfo")
public class Flight {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    int id;

    @Column
    String aircraft;
    @Column
    String arrivalport;
    @Column
    String departureport;
    @Column
    String distance;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArrivalport() {
        return arrivalport;
    }

    public void setArrivalport(String arrivalport) {
        this.arrivalport = arrivalport;
    }

    public String getDepartureport() {
        return departureport;
    }

    public void setDepartureport(String departureport) {
        this.departureport = departureport;
    }

    public String  getDistance() {
        return distance;
    }
}
