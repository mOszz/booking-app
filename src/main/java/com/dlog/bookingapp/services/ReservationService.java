package com.dlog.bookingapp.services;

import com.dlog.bookingapp.models.Reservation;
import com.dlog.bookingapp.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        List<Reservation> reservations = getAllReservations();
        for (Reservation r : reservations) {
            if (reservation.getVehicule().getId() == r.getVehicule().getId()) {
                Calendar newStartDate = reservation.getStartDate();
                Calendar newEndDate = reservation.getEndDate();
                if (newStartDate.before(r.getEndDate()) && newEndDate.after(r.getStartDate())) {
                    return null;
                }
            }
        }
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> deleteReservation(int id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        reservationRepository.deleteById(id);
        return reservation;
    }

    public Reservation reservationUpdate(int id, Reservation reservation) {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);
        if (existingReservation.isPresent()) {
            Reservation oldReservation = existingReservation.get();
            oldReservation.setVehicule(reservation.getVehicule());
            oldReservation.setCustomer(reservation.getCustomer());
            oldReservation.setStartDate(reservation.getStartDate());
            oldReservation.setEndDate(reservation.getEndDate());
            oldReservation.setKmCount(reservation.getKmCount());
            reservationRepository.save(reservation);
            return  reservation;
        } else {
            return null;
        }
    }

}