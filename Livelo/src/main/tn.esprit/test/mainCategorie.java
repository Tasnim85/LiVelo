package test;

import models.Categorie;
import services.CrudCategorie;

public class mainCategorie {
    public static void main(String[] args) {

        // **Ajouter une catégorie**
        Categorie nouvelleCategorie = new Categorie(
                "nom",  // Nom ✅
                "description y",  // Description ✅
                "img1.jpg",  // URL de l'image ✅
                17  // Created_by ✅
        );

        // CRUD pour gérer les catégories
        CrudCategorie crudCategorie = new CrudCategorie();
        crudCategorie.delete(17);  // Supprimer la catégorie ayant l'ID 4
        crudCategorie.add(nouvelleCategorie);  // Ajouter la nouvelle catégorie
        crudCategorie.getAll();  // Récupérer toutes les catégories

        // Mise à jour de la catégorie
        nouvelleCategorie.setNom("07");
        nouvelleCategorie.setDescription("06");
        crudCategorie.update(nouvelleCategorie);  // Mettre à jour la catégorie
        crudCategorie.getAll();  // Récupérer toutes les catégories
    }
}
