package main.tn.esprit.models;

import java.util.Date;

public class Livraison {
    private int id;
    private User utilisateur;
    private type_vehicule vehicule;
    private String adresseLivraison;
    private Date dateDebut;
    private Date dateFin;
    private String statut;


    public Livraison(int id, User utilisateur, type_vehicule vehicule, String adresseLivraison, Date dateDebut, Date dateFin, String statut) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.vehicule = vehicule;
        this.adresseLivraison = adresseLivraison;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public type_vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(type_vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Livraison{" +
                "id=" + id +
                ", utilisateur=" + utilisateur.getNom() +
                ", vehicule=" + vehicule +
                ", adresseLivraison='" + adresseLivraison + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", statut='" + statut + '\'' +
                '}';
    }
}
