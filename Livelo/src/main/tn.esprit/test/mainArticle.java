package test;
import models.statut_article;

import models.Article;
import services.CrudArticle;

import java.util.Date;



public class mainArticle {
    public static void main(String[] args) {

        Article article = new Article(
                "https://example.com/image.jpg",
                6,
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
        crudArticle.delete(22);
        crudArticle.add(article);
        crudArticle.getAll();


        article.setPrix(99.99f);
        article.setQuantite(15);
        article.setStatut(statut_article.out_of_stock);
        crudArticle.update(article);
        crudArticle.getAll();
    }
}
