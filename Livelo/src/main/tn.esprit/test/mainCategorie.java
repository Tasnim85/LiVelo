package main.tn.esprit.tn.esprit.test;

import main.tn.esprit.tn.esprit.models.Categorie;
import main.tn.esprit.tn.esprit.services.CrudCategorie;

public class mainCategorie {
    public static void main(String[] args) {

        // **Ajouter une catégorie**
        Categorie nouvelleCategorie = new Categorie(
                1, "Électronique", "Tout sur l'électronique", "image1.jpg", 17);

        // CRUD pour gérer les catégories
        CrudCategorie crudCategorie = new CrudCategorie();
        crudCategorie.delete(3);  // Supprimer la catégorie ayant l'ID 1
        crudCategorie.add(nouvelleCategorie);  // Ajouter la nouvelle catégorie
        crudCategorie.getAll();  // Récupérer toutes les catégories

        // Mise à jour de la catégorie
        nouvelleCategorie.setDescription("tout sur le mecanique");
        nouvelleCategorie.setNom("mecanique");
        crudCategorie.update(nouvelleCategorie);  // Mettre à jour la catégorie
        crudCategorie.getAll();  // Récupérer toutes les catégories

    }
}
