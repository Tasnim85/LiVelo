package test;

import models.Livraison;
import services.CrudLivraison;

import java.util.Date;

public class MainLivraison {

    public static void main(String[] args) {
        CrudLivraison serviceLivraison = new CrudLivraison();


        // Test d'ajout d'une nouvelle livraison
        serviceLivraison.add(new Livraison(1, 2, 1, new Date(), 1));

        // Test de suppression d'une livraison
        serviceLivraison.delete(4);

        // Test de mise à jour d'une livraison existante
        serviceLivraison.update(new Livraison(1, 4, 5, new Date(), 5));


        // Test de récupération d'une livraison par ID
        Livraison livraison = serviceLivraison.getById(5);
        if (livraison != null) {
            System.out.println("Test get by ID : " + livraison);
        } else {
            System.out.println("Aucune livraison trouvée avec cet ID.");
        }

        System.out.println(serviceLivraison.getAll());
    }

}
