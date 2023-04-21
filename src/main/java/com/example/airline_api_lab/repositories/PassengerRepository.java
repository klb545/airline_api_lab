package com.example.airline_api_lab.repositories;

import com.example.airline_api_lab.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
