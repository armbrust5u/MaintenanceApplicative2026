package com.mycalendar.events;

import com.mycalendar.*;

import java.util.List;
import java.util.stream.Collectors;

public class Reunion implements Evenement {
    private final EventId id;
    private final TitreEvenement titre;
    private final Proprietaire proprietaire;
    private final DateEvenement dateDebut;
    private final DureeEvenement duree;
    private final LieuReunion lieu;
    private final List<Proprietaire> participants;

    public Reunion(EventId id, TitreEvenement titre, Proprietaire proprietaire,
                   DateEvenement dateDebut, DureeEvenement duree,
                   LieuReunion lieu, List<Proprietaire> participants) {
        this.id = id;
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.lieu = lieu;
        this.participants = participants;
    }

    public DureeEvenement getDuree() { return duree; }

    @Override public EventId id() { return id; }
    @Override public TitreEvenement titre() { return titre; }
    @Override public DateEvenement dateDebut() { return dateDebut; }

    @Override
    public String description() {
        String noms = participants.stream()
                .map(Proprietaire::valeur)
                .collect(Collectors.joining(", "));
        return "Réunion : " + titre.valeur() + " à " + lieu.valeur() + " avec " + noms;
    }

    @Override
    public boolean estDansPeriode(DateEvenement debut, DateEvenement fin) {
        return !dateDebut.estAvant(debut) && !dateDebut.estApres(fin);
    }

    @Override
    public boolean estEnConflit(Evenement autre) {
        DateEvenement maFin = dateDebut.plusMinutes(duree);
        return dateDebut.estAvant(autre.dateDebut().plusMinutes(getDuree(autre)))
                && maFin.estApres(autre.dateDebut());
    }

    private DureeEvenement getDuree(Evenement autre) {
        if (autre instanceof RendezVousPersonnel r) return r.duree;
        if (autre instanceof Reunion r) return r.duree;
        return new DureeEvenement(1);
    }
}