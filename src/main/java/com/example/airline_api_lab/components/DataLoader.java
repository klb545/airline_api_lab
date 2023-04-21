package com.example.airline_api_lab.components;

import com.example.airline_api_lab.models.Flight;
import com.example.airline_api_lab.models.Passenger;
import com.example.airline_api_lab.models.PassengerDTO;
import com.example.airline_api_lab.repositories.FlightRepository;
import com.example.airline_api_lab.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        FLIGHTS

        // FLIGHT TO NEW YORK
        Flight flightNewYork = new Flight("New York", 250, LocalDate.of(2023, 05, 4), LocalTime.of(16, 30));
        flightRepository.save(flightNewYork);

        // FLIGHT TO TOKYO
        Flight flightTokyo = new Flight("Tokyo", 300, LocalDate.of(2023, 05, 5), LocalTime.of(8, 15));
        flightRepository.save(flightTokyo);

        // FLIGHT TO LOS ANGELES
        Flight flightLosAngeles = new Flight("Los Angeles", 280, LocalDate.of(2023, 05, 5), LocalTime.of(10, 20));
        flightRepository.save(flightLosAngeles);


//        PASSENGERS

        // PASSENGERS TO BE PUT ON FLIGHT TO NEW YORK
        Passenger passengerKatie = new Passenger("Katie", "katiesemail@gmail.com");
        passengerRepository.save(passengerKatie);

        Passenger passengerLaura = new Passenger("Laura", "laurasemail@hotmail.com");
        passengerRepository.save(passengerLaura);

        // PASSENGER ON FLIGHT TO TOKYO
        Passenger passengerJames = new Passenger("James", "jamessemail@btinternet.com");
        passengerRepository.save(passengerJames);

        Passenger passengerRuth = new Passenger("Ruth", "ruthsemail@gmail.com");
        passengerRepository.save(passengerRuth);

        // PASSENGER ON FLIGHT TO LOS ANGELES

        Passenger passengerStephen = new Passenger("Stephen", "stephensemail@hotmail.com");
        passengerRepository.save(passengerStephen);

        Passenger passengerHelen = new Passenger("Helen", "helensemail@btinternet.com");
        passengerRepository.save(passengerHelen);


//        ADDING FLIGHTS TO PASSENGERS
        passengerKatie.addFlight(flightNewYork);
        passengerLaura.addFlight(flightNewYork);

        passengerJames.addFlight(flightTokyo);
        passengerRuth.addFlight(flightTokyo);

        passengerStephen.addFlight(flightLosAngeles);
        passengerHelen.addFlight(flightLosAngeles);

        passengerRepository.save(passengerKatie);
        passengerRepository.save(passengerLaura);
        passengerRepository.save(passengerJames);
        passengerRepository.save(passengerRuth);
        passengerRepository.save(passengerStephen);
        passengerRepository.save(passengerHelen);

    }



}
