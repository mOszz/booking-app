package com.dlog.bookingapp.repository;

import com.dlog.bookingapp.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationInterface extends JpaRepository<Reservation, Integer> {}
