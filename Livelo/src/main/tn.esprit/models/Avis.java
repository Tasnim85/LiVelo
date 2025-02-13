package models;

import java.util.Date;

public class Avis {
    private int id_avis;
    private int id_utilisateur;
    private int id_livraison;
    private String commentaire;
    private int note;
    private Date date_avis;

    public Avis() {}

    public Avis(int id_utilisateur, int id_livraison, String commentaire, int note, Date date_avis) {
        this.id_utilisateur = id_utilisateur;
        this.id_livraison = id_livraison;
        this.commentaire = commentaire;
        this.note = note;
        this.date_avis = date_avis;
    }

    public int getId_avis() { return id_avis; }
    public void setId_avis(int id_avis) { this.id_avis = id_avis; }
    public int getId_utilisateur() { return id_utilisateur; }
    public void setId_utilisateur(int id_utilisateur) { this.id_utilisateur = id_utilisateur; }
    public int getId_livraison() { return id_livraison; }
    public void setId_livraison(int id_livraison) { this.id_livraison = id_livraison; }
    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }
    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }
    public Date getDate_avis() { return date_avis; }
    public void setDate_avis(Date date_avis) { this.date_avis = date_avis; }

    @Override
    public String toString() {
        return "Avis{" + "id_avis=" + id_avis + ", id_utilisateur=" + id_utilisateur + ", id_livraison=" + id_livraison + ", commentaire='" + commentaire + "', note=" + note + ", date_avis=" + date_avis + '}';
    }
}

