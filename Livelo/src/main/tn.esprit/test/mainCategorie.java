package test;

import models.Categorie;
import services.CrudCategorie;

public class mainCategorie {
    public static void main(String[] args) {

        Categorie nouvelleCategorie = new Categorie(
                "nom",
                "description y",
                "img1.jpg",
                50
        );

        CrudCategorie crudCategorie = new CrudCategorie();
        crudCategorie.delete(3);
        crudCategorie.add(nouvelleCategorie);
        crudCategorie.getAll();


        nouvelleCategorie.setNom("07");
        nouvelleCategorie.setDescription("06");
        crudCategorie.update(nouvelleCategorie);
        crudCategorie.getAll();

    }
}
