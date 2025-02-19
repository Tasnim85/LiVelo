package tn.esprit.test;

import tn.esprit.services.CrudFacture;
import tn.esprit.services.CrudUser;
import tn.esprit.services.CrudCommande;
import tn.esprit.models.Facture;
import tn.esprit.models.type_paiement;

import java.sql.Timestamp;

public class mainFacture {
    public static void main(String[] args) {
        Timestamp Currenttime=new Timestamp(System.currentTimeMillis());
        Facture facture = new Facture(
                25.30f,
                new java.util.Date("01/01/2009"),
                type_paiement.CASH,
                50,
                5
        );
        CrudFacture crudFacture = new CrudFacture();
        crudFacture.add(facture);
        /*System.out.println(crudFacture.getAll());
        crudFacture.delete(1);
        System.out.println(crudFacture.getAll());

        facture.setMontant(320.25f);
        facture.setUserId(19);
        crudFacture.update(facture);*/
        //crudFacture.getById(5);
        //crudFacture.search("0");
        System.out.println(crudFacture.getAll());
    }
}