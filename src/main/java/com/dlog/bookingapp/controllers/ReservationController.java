package com.dlog.bookingapp.controllers;

import com.dlog.bookingapp.models.Reservation;
import com.dlog.bookingapp.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PostMapping
    public ResponseEntity<String> saveReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.saveReservation(reservation);
        if (newReservation == null) {
            return ResponseEntity.ok("Vehicle already in-use");
        } else {
            return ResponseEntity.ok("New reservation saved successfully");
        }
    }
}
