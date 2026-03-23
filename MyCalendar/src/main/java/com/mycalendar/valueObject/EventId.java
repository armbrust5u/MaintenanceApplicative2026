package com.mycalendar;

import java.util.UUID;

public record EventId(String valeur) {
    public static EventId nouveau() {
        return new EventId(UUID.randomUUID().toString());
    }
}