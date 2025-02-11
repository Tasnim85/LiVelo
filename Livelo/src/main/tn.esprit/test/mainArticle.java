package test;
import models.statut_article;

import models.Article;
import services.CrudArticle;

import java.util.Date;



public class mainArticle {
    public static void main(String[] args) {
        // Création d'un nouvel article
        Article article = new Article(
                "https://example.com/image.jpg",
                18, // ID de la catégorie
                "Casque Bluetooth",
                120.99f,
                "Casque sans fil avec réduction de bruit",
                25, // Créé par (ex: ID de l'utilisateur)
                10, // Quantité
                statut_article.on_stock,
                new Date(),
                50 // Nombre de vues
        );
       CrudArticle crudArticle = new CrudArticle();
        //crudArticle.delete(22); // Suppression d'un article par ID
        //crudArticle.add(article); // Ajout de l'article
        crudArticle.getAll(); // Affichage de tous les articles

        // Mise à jour des informations de l'article
        /*article.setPrix(99.99f);
        article.setQuantite(15);
        article.setStatut(statut_article.out_of_stock);
        crudArticle.update(article);
        crudArticle.getAll(); // Affichage après mise à jour*/
    }
}
