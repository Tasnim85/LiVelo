package models;

public class Categorie {

    private int id_categorie;
    private String nom,description,url_image;
    private int createdBy; // Clé étrangère ya nouha rodbelek

    public Categorie() {}

    public Categorie(int id_categorie, String description, String url_image, String nom, int createdBy) {
        this.id_categorie = id_categorie;
        this.description = description;
        this.url_image = url_image;
        this.nom = nom;
        this.createdBy = createdBy;
    }

    public Categorie(String description, String url_image, String nom, int createdBy) {
        this.description = description;
        this.url_image = url_image;
        this.nom = nom;
        this.createdBy = createdBy;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id_categorie=" + id_categorie +
                ", description='" + description + '\'' +
                ", url_image='" + url_image + '\'' +
                ", nom='" + nom + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}

