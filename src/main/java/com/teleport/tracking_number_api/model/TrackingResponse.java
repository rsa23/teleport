package com.teleport.tracking_number_api.model;

import java.time.ZonedDateTime;

public record TrackingResponse(String tracking_number, ZonedDateTime created_at) {
}
