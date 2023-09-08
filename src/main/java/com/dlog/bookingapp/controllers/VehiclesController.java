package com.dlog.bookingapp.controllers;

import com.dlog.bookingapp.models.Vehicle;
import com.dlog.bookingapp.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>>getAllVehicules(){
        return ResponseEntity.ok(vehicleService.getAllVehicules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> fillById(@PathVariable int id){
        return ResponseEntity.ok(vehicleService.vehicleById(id));
    }









}
