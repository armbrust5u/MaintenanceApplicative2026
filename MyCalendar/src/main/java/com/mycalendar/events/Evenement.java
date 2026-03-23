package com.mycalendar.events;

import com.mycalendar.valueObject.DateEvenement;
import com.mycalendar.valueObject.EventId;
import com.mycalendar.valueObject.TitreEvenement;

public interface Evenement {
    EventId id();
    TitreEvenement titre();
    DateEvenement dateDebut();
    String description();
    boolean estDansPeriode(DateEvenement debut, DateEvenement fin);
    boolean estEnConflit(Evenement autre);
}