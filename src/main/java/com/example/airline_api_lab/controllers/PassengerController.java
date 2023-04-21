package com.example.airline_api_lab.controllers;

import com.example.airline_api_lab.models.Flight;
import com.example.airline_api_lab.models.Passenger;
import com.example.airline_api_lab.models.PassengerDTO;
import com.example.airline_api_lab.services.FlightService;
import com.example.airline_api_lab.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

//     4) add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> postPassenger(@RequestBody PassengerDTO passengerDTO){
        Passenger passenger = passengerService.savePassenger(passengerDTO);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

//      5) display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }

//      6) display details of a specific passenger
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getSpecificPassenger(@PathVariable Long id){
        return new ResponseEntity<>(passengerService.findSpecificPassenger(id), HttpStatus.OK);
    }


}
