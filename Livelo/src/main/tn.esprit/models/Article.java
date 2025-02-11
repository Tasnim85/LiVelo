package models;
import java.util.Date;

public class Article {
    private int idArticle,idCategorie,createdBy,quantite,nbViews;
    private String urlImage,nom,description;
    private float prix;
    statut_article statut;// ENUM ('on_stock', 'out_of_stock')
    private Date createdAt;


    public Article() {}

    public Article(int idArticle, String urlImage, int idCategorie, String nom, float prix,
                   String description, int createdBy, int quantite, statut_article statut, Date createdAt, int nbViews) {
        this.idArticle = idArticle;
        this.urlImage = urlImage;
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.createdBy = createdBy;
        this.quantite = quantite;
        this.statut = statut; // Corrected here
        this.createdAt = createdAt;
        this.nbViews = nbViews;
    }

    public Article(String urlImage, int idCategorie, String nom, float prix,
                   String description, int createdBy, int quantite, statut_article statut, Date createdAt, int nbViews) {
        this.urlImage = urlImage;
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.createdBy = createdBy;
        this.quantite = quantite;
        this.statut = statut; // Corrected here
        this.createdAt = createdAt;
        this.nbViews = nbViews;
    }


    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public statut_article getStatut() {
        return statut;
    }

    public void setStatut(statut_article statut) {
        this.statut = statut;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getNbViews() {
        return nbViews;
    }

    public void setNbViews(int nbViews) {
        this.nbViews = nbViews;
    }

    @Override
    public String toString() {
        return "Article{" +
                "idArticle=" + idArticle +
                ", urlImage='" + urlImage + '\'' +
                ", idCategorie=" + idCategorie +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", quantite=" + quantite +
                ", statut=" + statut +
                ", createdAt=" + createdAt +
                ", nbViews=" + nbViews +
                '}';
    }
}
