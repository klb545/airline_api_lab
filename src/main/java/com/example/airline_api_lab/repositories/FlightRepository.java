package com.example.airline_api_lab.repositories;

import com.example.airline_api_lab.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
