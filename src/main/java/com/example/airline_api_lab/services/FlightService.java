package com.example.airline_api_lab.services;

import com.example.airline_api_lab.models.Flight;
import com.example.airline_api_lab.models.Passenger;
import com.example.airline_api_lab.models.PassengerDTO;
import com.example.airline_api_lab.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;



//    1) add details of a new flight
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }
//    2) display all available flights
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }
//    3) display details of a specific flight
    public Optional<Flight> findFlight(Long id) {
        return flightRepository.findById(id);
    }



//    7) book a passenger onto a flight
    public void addPassengerToFlight(Long id, Passenger passenger){
        Flight foundFlight = flightRepository.getById(id);
        foundFlight.addPassenger(passenger);
    }

//    8) cancel a flight
    public void removeFlightFromPassengers(Long id){
        Flight foundFlight = flightRepository.getById(id);
        for (Passenger passenger : foundFlight.getPassengers()) {
            foundFlight.removePassenger(passenger);
        }
    }


}
