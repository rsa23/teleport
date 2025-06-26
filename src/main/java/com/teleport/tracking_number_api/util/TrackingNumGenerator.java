package com.teleport.tracking_number_api.util;

public class TrackingNumGenerator {
    public static String generate(String input) {
        int hash = Math.abs(input.hashCode());
        String alphanumeric = Integer.toHexString(hash).toUpperCase();
        return alphanumeric.substring(0, Math.min(16, alphanumeric.length()));
    }
}
