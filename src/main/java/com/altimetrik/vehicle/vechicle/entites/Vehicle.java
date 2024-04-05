package com.altimetrik.vehicle.vechicle.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehicle_t")
public class Vehicle {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String make;

    private String model;

    private int year;

    @Column(name = "vin", nullable = false, unique = true)
    private String vin;

    public Vehicle() {

    }
    public Vehicle(String make, String model, int year, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }

}
