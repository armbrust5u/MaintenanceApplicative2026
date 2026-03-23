package com.mycalendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarTest {

    @Test
    void invalideTitreVide() {
        assertThrows(IllegalArgumentException.class,
                () -> new TitreEvenement(""));
    }
}