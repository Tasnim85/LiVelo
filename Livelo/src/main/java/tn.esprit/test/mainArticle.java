package tn.esprit.test;

import tn.esprit.models.Article;
import tn.esprit.models.Categorie;
import tn.esprit.models.statut_article;
import tn.esprit.services.CrudArticle;
import tn.esprit.services.CrudCategorie;
import java.util.Date;

public class mainArticle {
    public static void main(String[] args) {


        CrudCategorie crudCategorie = new CrudCategorie();


        Categorie categorie = crudCategorie.getById(7);

        if (categorie == null) {
            System.out.println("Aucune catégorie trouvée avec cet ID.");
            return;
        }


        Article article = new Article(
                0,
                "https://example.com/image.jpg",
                categorie,
                "Casque Bluetooth",
                120.99f,
                "Casque sans fil avec réduction de bruit",
                50,
                10,
                statut_article.on_stock,
                new Date(),
                50
        );


        CrudArticle crudArticle = new CrudArticle();




         crudArticle.add(article);
         crudArticle.delete(8);

        // Mise à jour de l'article
         article.setPrix(99.99f);
         article.setQuantite(15);
        article.setStatut(statut_article.out_of_stock);
         crudArticle.update(article);

        // Récupération de tous les articles
        System.out.println("Récupération de tous les articles :");
        crudArticle.getAll();

        // Récupération d'un article spécifique par ID
        crudArticle.getById(18);

        // Recherche d'articles par nom
        System.out.println("Recherche d'articles avec le critère 'Casque Bluetooth' :");
        crudArticle.search("Casque Bluetooth");
    }
}
