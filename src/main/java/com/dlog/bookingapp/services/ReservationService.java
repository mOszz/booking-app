package com.dlog.bookingapp.services;

import com.dlog.bookingapp.models.Reservation;
import com.dlog.bookingapp.models.Vehicle;
import com.dlog.bookingapp.repository.ReservationRepository;
import com.dlog.bookingapp.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final VehicleRepository vehicleRepository;

    public ReservationService(ReservationRepository reservationRepository, VehicleRepository vehicleRepository) {
        this.reservationRepository = reservationRepository;
        this.vehicleRepository = vehicleRepository;
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
            return reservation;
        } else {
            return null;
        }
    }

    public float definePrice(Reservation reservation) {
        int vehicleId = Math.toIntExact(reservation.getVehicule().getId());
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent()) {
            float kmPrice = vehicle.get().getPriceKm();
            float dayPrice = vehicle.get().getPriceDay();
            int kmNb = reservation.getKmCount();
            long millisecondsDiff = reservation.getEndDate().getTimeInMillis() - reservation.getStartDate().getTimeInMillis();
            long daysDiff = millisecondsDiff / (24 * 60 * 60 * 1000);
            return (dayPrice * daysDiff) + (kmPrice * kmNb);
        }

//        long millisecondsDiff = reservation.getEndDate().getTimeInMillis() - reservation.getStartDate().getTimeInMillis();
//        long daysDiff = millisecondsDiff / (24 * 60 * 60 * 1000);

        //return (dayPrice * daysDiff) + (kmPrice * kmNb);+
        return 00.00F;
    }

}