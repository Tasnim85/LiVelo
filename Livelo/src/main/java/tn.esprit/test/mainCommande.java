package tn.esprit.test;

import tn.esprit.models.User;
import tn.esprit.services.CrudUser;
import tn.esprit.models.Commande;
import tn.esprit.models.statutlCommande;
import tn.esprit.services.CrudCommande;

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
                50
        );
        CrudCommande crudCommande = new CrudCommande();
       crudCommande.add(commande);
        /*System.out.println(crudCommande.getAll());
        crudCommande.delete(13);
        System.out.println(crudCommande.getAll());

        commande.setAdresse_arr("kelibia");
        commande.setCreated_by(19);
        crudCommande.update(commande);*/
        //crudCommande.getById(5);
        //crudCommande.search("E-Bile");
        System.out.println(crudCommande.getAll());
    }
    }
