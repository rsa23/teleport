package com.teleport.tracking_number_api.controller;

import com.teleport.tracking_number_api.model.TrackingResponse;
import com.teleport.tracking_number_api.service.TrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/next-tracking-number")
public class TrackingController {

    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping
    public ResponseEntity<TrackingResponse> getTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam BigDecimal weight,
            @RequestParam ZonedDateTime created_at,
            @RequestParam UUID customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug
    ) {
        String trackingNumber = trackingService.generateTrackingNumber(
                origin_country_id, destination_country_id, weight,
                created_at, customer_id, customer_name, customer_slug);

        return ResponseEntity.ok(new TrackingResponse(trackingNumber, ZonedDateTime.now()));
    }
}