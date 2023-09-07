package com.dlog.bookingapp.services;

import com.dlog.bookingapp.models.Reservation;
import com.dlog.bookingapp.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return  reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }
}
