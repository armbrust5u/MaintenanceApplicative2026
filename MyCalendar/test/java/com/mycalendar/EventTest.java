package com.mycalendar;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private final LocalDateTime date = LocalDateTime.of(2025, 6, 10, 14, 0);

    // --- description() RDV_PERSONNEL ---

    @Test
    void description_rdv_personnel_contient_le_titre() {
        Event e = new Event("RDV_PERSONNEL", "Dentiste", "Loup", date, 30, "", "", 0);
        assertTrue(e.description().contains("Dentiste"));
    }

    @Test
    void description_rdv_personnel_commence_par_RDV() {
        Event e = new Event("RDV_PERSONNEL", "Dentiste", "Loup", date, 30, "", "", 0);
        assertTrue(e.description().startsWith("RDV :"));
    }

    // --- description() REUNION ---

    @Test
    void description_reunion_contient_le_titre() {
        Event e = new Event("REUNION", "Standup", "Noah", date, 15, "107", "Noah, Loup", 0);
        assertTrue(e.description().contains("Standup"));
    }

    @Test
    void description_reunion_contient_le_lieu() {
        Event e = new Event("REUNION", "Standup", "Noah", date, 15, "107", "Noah, Loup", 0);
        assertTrue(e.description().contains("107"));
    }

    @Test
    void description_reunion_contient_les_participants() {
        Event e = new Event("REUNION", "Standup", "Noah", date, 15, "107", "Noah, Loup", 0);
        assertTrue(e.description().contains("Noah, Loup"));
    }

    // --- description() PERIODIQUE ---

    @Test
    void description_periodique_contient_le_titre() {
        Event e = new Event("PERIODIQUE", "Sport", "Loup", date, 0, "", "", 7);
        assertTrue(e.description().contains("Sport"));
    }

    @Test
    void description_periodique_contient_la_frequence() {
        Event e = new Event("PERIODIQUE", "Sport", "Loup", date, 0, "", "", 7);
        assertTrue(e.description().contains("7"));
    }

    // --- description() type inconnu ---

    @Test
    void description_type_inconnu_retourne_chaine_vide() {
        Event e = new Event("INCONNU", "Titre", "Loup", date, 0, "", "", 0);
        assertEquals("", e.description());
    }
}