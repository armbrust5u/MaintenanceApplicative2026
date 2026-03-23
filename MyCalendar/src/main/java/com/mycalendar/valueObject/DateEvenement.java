package com.mycalendar.valueObject;

import java.time.LocalDateTime;

public record DateEvenement(LocalDateTime valeur) {
    public DateEvenement {
        if (valeur == null)
            throw new IllegalArgumentException("La date ne peut pas être nulle");
    }

    public boolean estAvant(DateEvenement autre) {
        return this.valeur.isBefore(autre.valeur);
    }

    public boolean estApres(DateEvenement autre) {
        return this.valeur.isAfter(autre.valeur);
    }

    public DateEvenement plusMinutes(DureeEvenement duree) {
        return new DateEvenement(this.valeur.plusMinutes(duree.minutes()));
    }

    public DateEvenement plusJours(FrequenceEvenement frequence) {
        return new DateEvenement(this.valeur.plusDays(frequence.jours()));
    }
}