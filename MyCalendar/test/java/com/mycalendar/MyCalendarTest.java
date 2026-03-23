package com.mycalendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarTest {

    @Test
    void invalideTitreVide() {
        assertThrows(IllegalArgumentException.class,
                () -> new TitreEvenement(""));
    }

    @Test
    void dureeNegativeInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new DureeEvenement(-1));
    }

    @Test
    void dureeZeroInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new DureeEvenement(0));
    }

    @Test
    void frequenceNegativeInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new FrequenceEvenement(-1));
    }

    @Test
    void eventIdUnique() {
        EventId id1 = EventId.nouveau();
        EventId id2 = EventId.nouveau();
        assertNotEquals(id1, id2);
    }
}