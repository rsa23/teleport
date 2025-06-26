package com.teleport.tracking_number_api.service;

import com.teleport.tracking_number_api.util.TrackingNumGenerator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TrackingService {

    private final Set<String> generatedNumbers = ConcurrentHashMap.newKeySet();

    public String generateTrackingNumber(String origin, String destination,
                                         BigDecimal weight, ZonedDateTime createdAt,
                                         UUID customerId, String customerName, String slug) {
        String base = origin + destination + customerId.toString().substring(0, 4);
        String trackingNumber;
        int attempt = 0;

        do {
            trackingNumber = TrackingNumGenerator.generate(base + attempt);
            attempt++;
        } while (!generatedNumbers.add(trackingNumber)); // ensure uniqueness

        return trackingNumber;
    }
}
