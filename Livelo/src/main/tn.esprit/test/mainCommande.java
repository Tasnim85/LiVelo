package test;

import models.*;
import services.CrudArticle;
import services.CrudUser;
import services.CrudCommande;

import java.sql.Timestamp;
import java.util.Date;

public class mainCommande {
    public static void main(String[] args) {
        Timestamp Currenttime=new Timestamp(System.currentTimeMillis());
        /*Commande commande = new Commande(
           "marsa",
           "ariana",
           "E-Bike",
           Currenttime,
            statutlCommande.Shipping,
                51
        );*/
        CrudCommande crudCommande = new CrudCommande();
       /* crudCommande.delete(13);
        System.out.println(crudCommande.getAll());

        commande.setAdresse_arr("kelibia");
        commande.setCreated_by(19);
        crudCommande.update(commande);*/
        //crudCommande.getById(5);
        //crudCommande.search("E-Bile");
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
        crudArticle.add(article);
        /*CrudArticle crudArticle = new CrudArticle();
        Article article = new Article();
        article=crudArticle.getById(5);*/
        commande.getArticles().add(article);
        crudCommande.add(commande);

        System.out.println("Commande: " + commande);
        for (Article a : commande.getArticles()) {
            System.out.println("Associated Article: " + a);
        }
        System.out.println(crudCommande.getAll());
    }
    }
