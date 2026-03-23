package com.mycalendar;

import com.mycalendar.events.EvenementPeriodique;
import com.mycalendar.events.RendezVousPersonnel;
import com.mycalendar.events.Reunion;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

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

    // DateEvenement

    @Test
    void dataNulleInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new DateEvenement(null));
    }

    @Test
    void dateAvantVrai() {
        DateEvenement date1 = new DateEvenement(LocalDateTime.of(2026, 6, 10, 9, 0));
        DateEvenement date2 = new DateEvenement(LocalDateTime.of(2026, 6, 10, 14, 0));
        assertTrue(date1.estAvant(date2));
    }

    @Test
    void dateAvantFaux() {
        DateEvenement date1 = new DateEvenement(LocalDateTime.of(2026, 6, 10, 14, 0));
        DateEvenement date2 = new DateEvenement(LocalDateTime.of(2026, 6, 10, 9, 0));
        assertFalse(date1.estAvant(date2));
    }

    @Test
    void dateApresVrai() {
        DateEvenement date1 = new DateEvenement(LocalDateTime.of(2026, 6, 10, 14, 0));
        DateEvenement date2 = new DateEvenement(LocalDateTime.of(2026, 6, 10, 9, 0));
        assertTrue(date1.estApres(date2));
    }

    @Test
    void dateApresFaux() {
        DateEvenement date1 = new DateEvenement(LocalDateTime.of(2026, 6, 10, 9, 0));
        DateEvenement date2 = new DateEvenement(LocalDateTime.of(2026, 6, 10, 14, 0));
        assertFalse(date1.estApres(date2));
    }

    @Test
    void plusMinutesTest() {
        DateEvenement date = new DateEvenement(LocalDateTime.of(2026, 6, 10, 9, 0));
        DateEvenement resultat = date.plusMinutes(new DureeEvenement(30));
        assertEquals(new DateEvenement(LocalDateTime.of(2026, 6, 10, 9, 30)), resultat);
    }

    @Test
    void plusJoursTest() {
        DateEvenement date = new DateEvenement(LocalDateTime.of(2026, 6, 10, 9, 0));
        DateEvenement resultat = date.plusJours(new FrequenceEvenement(7));
        assertEquals(new DateEvenement(LocalDateTime.of(2026, 6, 17, 9, 0)), resultat);
    }

    // LieuReunion

    @Test
    void lieuVideEstInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new LieuReunion(""));
    }

    @Test
    void lieuNullEstInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new LieuReunion(null));
    }

    @Test
    void lieuValideEstAccepte() {
        LieuReunion lieu = new LieuReunion("Salle A");
        assertEquals("Salle A", lieu.valeur());
    }

    // Proprietaire

    @Test
    void proprietaireVideEstInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new Proprietaire(""));
    }

    @Test
    void proprietaireNullEstInvalide() {
        assertThrows(IllegalArgumentException.class,
                () -> new Proprietaire(null));
    }

    @Test
    void proprietaireValideEstAccepte() {
        Proprietaire p = new Proprietaire("Noah");
        assertEquals("Noah", p.valeur());
    }

    // Evenement

    @Test
    void rdvPersonnelGenereUneDescriptionCorrecte() {
        RendezVousPersonnel rdv = new RendezVousPersonnel(
                EventId.nouveau(),
                new TitreEvenement("Dentiste"),
                new Proprietaire("Noah"),
                new DateEvenement(LocalDateTime.of(2026, 6, 10, 14, 0)),
                new DureeEvenement(30)
        );
        assertTrue(rdv.description().contains("Dentiste"));
    }

    @Test
    void reunionGenereUneDescriptionAvecLieu() {
        Reunion reunion = new Reunion(
                EventId.nouveau(),
                new TitreEvenement("Standup"),
                new Proprietaire("Loup"),
                new DateEvenement(LocalDateTime.of(2026, 6, 10, 9, 0)),
                new DureeEvenement(15),
                new LieuReunion("107"),
                List.of(new Proprietaire("Loup"), new Proprietaire("Noah"))
        );
        assertTrue(reunion.description().contains("107"));
    }

    @Test
    void evenementPeriodiqueGenereUneDescriptionAvecFrequence() {
        EvenementPeriodique ep = new EvenementPeriodique(
                EventId.nouveau(),
                new TitreEvenement("Sport"),
                new Proprietaire("Noah"),
                new DateEvenement(LocalDateTime.of(2026, 6, 10, 7, 0)),
                new FrequenceEvenement(7)
        );
        assertTrue(ep.description().contains("7"));
    }
}