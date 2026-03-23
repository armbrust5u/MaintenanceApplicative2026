package com.mycalendar.events;

import com.mycalendar.DateEvenement;
import com.mycalendar.EventId;
import com.mycalendar.TitreEvenement;

public interface Evenement {
    EventId id();
    TitreEvenement titre();
    DateEvenement dateDebut();
    String description();
    boolean estDansPeriode(DateEvenement debut, DateEvenement fin);
    boolean estEnConflit(Evenement autre);
}