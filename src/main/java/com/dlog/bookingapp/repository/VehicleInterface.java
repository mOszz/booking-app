package com.dlog.bookingapp.repository;

import com.dlog.bookingapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleInterface extends JpaRepository<Vehicle,Integer> {

}
