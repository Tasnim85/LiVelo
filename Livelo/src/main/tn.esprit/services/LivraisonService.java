package main.tn.esprit.services;

import main.tn.esprit.models.Livraison;

import java.util.ArrayList;
import java.util.List;

public class LivraisonService {

    private List<Livraison> livraisons = new ArrayList<>();


    public void ajouterLivraison(Livraison livraison) {
        livraisons.add(livraison);
    }


    public Livraison getLivraisonById(int id) {
        for (Livraison livraison : livraisons) {
            if (livraison.getId() == id) {
                return livraison;
            }
        }
        return null;
    }


    public List<Livraison> getAllLivraisons() {
        return livraisons;
    }


    public void updateLivraison(int id, Livraison updatedLivraison) {
        Livraison livraison = getLivraisonById(id);
        if (livraison != null) {
            livraisons.set(livraisons.indexOf(livraison), updatedLivraison);
        }
    }


    public void deleteLivraison(int id) {
        Livraison livraison = getLivraisonById(id);
        if (livraison != null) {
            livraisons.remove(livraison);
        }
    }
}
