package test;

import main.tn.esprit.models.User;
import services.CrudUser;
import models.Commande;
import models.statutlCommande;
import services.CrudCommande;

import java.sql.Timestamp;

public class mainCommande {
    public static void main(String[] args) {
        Timestamp Currenttime=new Timestamp(System.currentTimeMillis());
        Commande commande = new Commande(
           "marsa",
           "ariana",
           "E-Bike",
           Currenttime,
            statutlCommande.Shipping,
                17
        );
        CrudCommande crudCommande = new CrudCommande();
        crudCommande.add(commande);
        System.out.println(crudCommande.getAll());
        crudCommande.delete(13);
        System.out.println(crudCommande.getAll());

        commande.setAdresse_arr("kelibia");
        commande.setCreated_by(19);
        crudCommande.update(commande);
        System.out.println(crudCommande.getAll());
    }
    }
