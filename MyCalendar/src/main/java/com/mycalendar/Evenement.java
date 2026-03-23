package com.mycalendar;

public interface Evenement {
    EventId id();
    TitreEvenement titre();
    DateEvenement dateDebut();
    String description();
    boolean estDansPeriode(DateEvenement debut, DateEvenement fin);
    boolean estEnConflit(Evenement autre);
}