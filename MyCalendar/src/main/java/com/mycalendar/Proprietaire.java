package com.mycalendar;

public record Proprietaire(String valeur) {
    public Proprietaire {
        if (valeur == null || valeur.isBlank())
            throw new IllegalArgumentException("Le propriétaire ne peut pas être vide");
    }
}