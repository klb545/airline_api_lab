package com.example.airline_api_lab.controllers;

import com.example.airline_api_lab.models.Flight;
import com.example.airline_api_lab.models.Passenger;
import com.example.airline_api_lab.models.PassengerDTO;
import com.example.airline_api_lab.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightService flightService;



//    1) add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> postFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

//      2) display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

//      3) display details of a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> displayDetailsOfSpecificFlight(@PathVariable Long id){
        return new ResponseEntity<>(flightService.findFlight(id), HttpStatus.OK);
    }



//      7) book a passenger onto a flight
    @PatchMapping(value="/{id}")
    public ResponseEntity<Passenger> bookPassengerOntoFlight(@PathVariable Long id, @RequestBody Passenger passenger){
        flightService.addPassengerToFlight(id, passenger);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

//      8) cancel a flight
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.removeFlightFromPassengers(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
