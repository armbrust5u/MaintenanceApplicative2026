package com.mycalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalendarManagerTest {

    private CalendarManager manager;

    @BeforeEach
    void setUp() {
        manager = new CalendarManager();
    }

    @Test
    void testAjouterEvent() {
        manager.ajouterEvent(
                "SIMPLE",
                "Réunion",
                "Alice",
                LocalDateTime.now(),
                60,
                "Salle 1",
                "Bob",
                0
        );

        assertEquals(1, manager.events.size());
    }

    @Test
    void testEventsDansPeriode_eventSimpleDansIntervalle() {
        LocalDateTime debut = LocalDateTime.of(2024, 1, 1, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2024, 1, 1, 12, 0);

        manager.ajouterEvent("SIMPLE", "Meeting", "Alice", debut.plusHours(1), 60, "Salle", "Bob", 0);

        List<Event> result = manager.eventsDansPeriode(debut, fin);

        assertEquals(1, result.size());
    }

    @Test
    void testEventsDansPeriode_eventSimpleHorsIntervalle() {
        LocalDateTime debut = LocalDateTime.of(2024, 1, 1, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2024, 1, 1, 12, 0);

        manager.ajouterEvent("SIMPLE", "Meeting", "Alice", debut.minusHours(2), 60, "Salle", "Bob", 0);

        List<Event> result = manager.eventsDansPeriode(debut, fin);

        assertEquals(0, result.size());
    }

    @Test
    void testEventsDansPeriode_eventPeriodiqueDansIntervalle() {
        LocalDateTime debut = LocalDateTime.of(2024, 1, 10, 0, 0);
        LocalDateTime fin = LocalDateTime.of(2024, 1, 20, 0, 0);

        manager.ajouterEvent("PERIODIQUE", "Sport", "Alice",
                LocalDateTime.of(2024, 1, 1, 0, 0),
                60,
                "Gym",
                "Bob",
                5 // tous les 5 jours
        );

        List<Event> result = manager.eventsDansPeriode(debut, fin);

        assertEquals(1, result.size());
    }

    @Test
    void testEventsDansPeriode_eventPeriodiqueHorsIntervalle() {
        LocalDateTime debut = LocalDateTime.of(2024, 2, 1, 0, 0);
        LocalDateTime fin = LocalDateTime.of(2024, 2, 5, 0, 0);

        manager.ajouterEvent("PERIODIQUE", "Sport", "Alice",
                LocalDateTime.of(2024, 1, 1, 0, 0),
                60,
                "Gym",
                "Bob",
                40 // trop espacé
        );

        List<Event> result = manager.eventsDansPeriode(debut, fin);

        assertEquals(0, result.size());
    }

    @Test
    void testConflit_true() {
        Event e1 = new Event("SIMPLE", "A", "Alice",
                LocalDateTime.of(2024, 1, 1, 10, 0),
                60, "", "", 0);

        Event e2 = new Event("SIMPLE", "B", "Bob",
                LocalDateTime.of(2024, 1, 1, 10, 30),
                60, "", "", 0);

        assertTrue(manager.conflit(e1, e2));
    }

    @Test
    void testConflit_false_pasDeChevauchement() {
        Event e1 = new Event("SIMPLE", "A", "Alice",
                LocalDateTime.of(2024, 1, 1, 10, 0),
                60, "", "", 0);

        Event e2 = new Event("SIMPLE", "B", "Bob",
                LocalDateTime.of(2024, 1, 1, 12, 0),
                60, "", "", 0);

        assertFalse(manager.conflit(e1, e2));
    }

    @Test
    void testConflit_periodiqueToujoursFalse() {
        Event e1 = new Event("PERIODIQUE", "A", "Alice",
                LocalDateTime.now(), 60, "", "", 1);

        Event e2 = new Event("SIMPLE", "B", "Bob",
                LocalDateTime.now(), 60, "", "", 0);

        assertFalse(manager.conflit(e1, e2));
    }

    @Test
    void testAfficherEvenements() {
        manager.ajouterEvent(
                "SIMPLE",
                "Test",
                "Alice",
                LocalDateTime.now(),
                30,
                "Salle",
                "Bob",
                0
        );

        // On vérifie juste que ça ne plante pas
        assertDoesNotThrow(() -> manager.afficherEvenements());
    }
}
