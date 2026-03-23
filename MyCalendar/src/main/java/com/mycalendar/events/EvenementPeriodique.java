package com.mycalendar.events;

import com.mycalendar.*;

public class EvenementPeriodique implements Evenement {
    private final EventId id;
    private final TitreEvenement titre;
    private final Proprietaire proprietaire;
    private final DateEvenement dateDebut;
    private final FrequenceEvenement frequence;

    public EvenementPeriodique(EventId id, TitreEvenement titre, Proprietaire proprietaire,
                               DateEvenement dateDebut, FrequenceEvenement frequence) {
        this.id = id;
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.frequence = frequence;
    }

    @Override public EventId id() { return id; }
    @Override public TitreEvenement titre() { return titre; }
    @Override public DateEvenement dateDebut() { return dateDebut; }

    @Override
    public String description() {
        return "Événement périodique : " + titre.valeur() + " tous les " + frequence.jours() + " jours";
    }

    @Override
    public boolean estDansPeriode(DateEvenement debut, DateEvenement fin) {
        DateEvenement temp = dateDebut;
        while (temp.estAvant(fin)) {
            if (!temp.estAvant(debut)) return true;
            temp = temp.plusJours(frequence);
        }
        return false;
    }

    @Override
    public boolean estEnConflit(Evenement autre) {
        return false; // périodique sans durée fixe = pas de conflit calculable
    }
}