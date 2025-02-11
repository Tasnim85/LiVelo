package models;

public class Categorie {
    private int id_categorie;
    private String nom;
    private String description;
    private String url_image;
    private int createdBy;

    // **Constructeur pour l'affichage avec ID**
    public Categorie(int id_categorie, String nom, String description, String url_image, int createdBy) {
        this.id_categorie = id_categorie;
        this.nom = nom;
        this.description = description;
        this.url_image = url_image;
        this.createdBy = createdBy;
    }

    // **Constructeur pour l'ajout sans ID**
    public Categorie(String nom, String description, String url_image, int createdBy) {
        this.nom = nom;
        this.description = description;
        this.url_image = url_image;
        this.createdBy = createdBy;
    }

    // **Getters et Setters**
    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    // **Redéfinition de toString pour affichage**
    @Override
    public String toString() {
        return "Categorie{" +
                "id_categorie=" + id_categorie +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", url_image='" + url_image + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}
