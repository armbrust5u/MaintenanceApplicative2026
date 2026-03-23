package com.mycalendar;

import com.mycalendar.events.Evenement;
import com.mycalendar.valueObject.DateEvenement;
import com.mycalendar.valueObject.EventId;

import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    private final List<Evenement> events = new ArrayList<>();

    public void ajouterEvent(Evenement evenement) {
        events.add(evenement);
    }

    public void supprimerEvent(EventId id) {
        events.removeIf(e -> e.id().equals(id));
    }

    public List<Evenement> eventsDansPeriode(DateEvenement debut, DateEvenement fin) {
        return events.stream()
                .filter(e -> e.estDansPeriode(debut, fin))
                .toList();
    }

    public boolean conflit(Evenement e1, Evenement e2) {
        return e1.estEnConflit(e2) || e2.estEnConflit(e1);
    }

    public void afficherEvenements() {
        events.forEach(e -> System.out.println(e.description()));
    }
}