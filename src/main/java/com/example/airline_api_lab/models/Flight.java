package com.example.airline_api_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String destination;

    @Column
    private int capacity;

    @Column
    private LocalDate departureDate;

    @Column
    private LocalTime departureTime;

    @ManyToMany(mappedBy = "flights")
    @JsonIgnoreProperties({"flights"})
    private List<Passenger> passengers;

//    CONSTRUCTOR
    public Flight(String destination, int capacity, LocalDate departureDate, LocalTime departureTime) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
    }

//    DEFAULT CONSTRUCTOR
    public Flight() {
    }


//        GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }


//    CUSTOM METHODS - ADD AND REMOVE PASSENGER FROM FLIGHT
    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
    }
    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

}
