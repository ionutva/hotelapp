package com.hotels.roomoccupancyapplication.controllers;

import com.hotels.roomoccupancyapplication.model.OptimizationResult;
import com.hotels.roomoccupancyapplication.model.RoomRequest;
import com.hotels.roomoccupancyapplication.services.RoomOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RoomOptimizationController {

    private final RoomOptimizationService service;

     public RoomOptimizationController(RoomOptimizationService service) {
        this.service = service;
    }


    @PostMapping("/optimize")
    public ResponseEntity<OptimizationResult> optimizeRooms(@RequestBody RoomRequest request) {
        OptimizationResult result = service.optimizeRooms(request.getPremiumRooms(), request.getEconomyRooms(), request.getGuests());
        return ResponseEntity.ok(result);
    }
}
