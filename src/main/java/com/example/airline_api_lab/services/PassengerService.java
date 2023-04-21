package com.example.airline_api_lab.services;

import com.example.airline_api_lab.models.Flight;
import com.example.airline_api_lab.models.Passenger;
import com.example.airline_api_lab.models.PassengerDTO;
import com.example.airline_api_lab.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightService flightService;

//     4) add a new passenger
    public Passenger savePassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmailAddress());
        return passengerRepository.save(passenger);
    }

//      5) display details of all passengers
    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

//      6) display details of a specific passenger
    public Optional<Passenger> findSpecificPassenger(Long id) {
        return passengerRepository.findById(id);
    }



}
