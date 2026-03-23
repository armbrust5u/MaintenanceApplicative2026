package com.mycalendar;

public class RendezVousPersonnel implements Evenement {
    private final EventId id;
    private final TitreEvenement titre;
    private final Proprietaire proprietaire;
    private final DateEvenement dateDebut;
    private final DureeEvenement duree;

    public RendezVousPersonnel(EventId id, TitreEvenement titre, Proprietaire proprietaire,
                               DateEvenement dateDebut, DureeEvenement duree) {
        this.id = id;
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    @Override public EventId id() { return id; }
    @Override public TitreEvenement titre() { return titre; }
    @Override public DateEvenement dateDebut() { return dateDebut; }

    @Override
    public String description() {
        return "RDV : " + titre.valeur() + " à " + dateDebut.valeur();
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

    // helper pour récupérer la durée de l'autre événement via l'interface
    private DureeEvenement getDuree(Evenement autre) {
        if (autre instanceof RendezVousPersonnel r) return r.duree;
        if (autre instanceof Reunion r) return r.getDuree();
        return new DureeEvenement(1);
    }
}