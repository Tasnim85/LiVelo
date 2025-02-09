package main.tn.esprit.test;

import main.tn.esprit.models.Livraison;
import main.tn.esprit.models.User;
import main.tn.esprit.models.role_user;
import main.tn.esprit.models.type_vehicule;
import main.tn.esprit.services.LivraisonService;
import java.util.Date;

//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;

public class MainLivraison {

    public void testAjouterLivraison() {
        LivraisonService service = new LivraisonService();

        // Créer un utilisateur pour la livraison
        User utilisateur = new User("John", "Doe", role_user.client, true, "1234 rue test", type_vehicule.bike, "johndoe@email.com", "password123", "123456789", "12345678");

        // Créer une livraison de test
        Livraison livraison = new Livraison(1, utilisateur, type_vehicule.bike, "4567 rue livraison", new Date(), new Date(), "en cours");

        // Ajouter la livraison
        service.ajouterLivraison(livraison);

        // Vérifier que la livraison a bien été ajoutée
        Livraison result = service.getLivraisonById(1);
       // assertNotNull(result);
        //assertEquals(1, result.getId());
    }
}
