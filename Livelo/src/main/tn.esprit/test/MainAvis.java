package test;


import models.Avis;
import services.CrudAvis;
import java.sql.Timestamp;

public class MainAvis {

    public static void main(String[] args) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        Avis avis = new Avis(1, 2, "Bon service", 5, currentTime);
        CrudAvis crudAvis = new CrudAvis();

        crudAvis.add(avis);
        System.out.println("Avis ajouté:");
        System.out.println(avis);

        System.out.println("Tous les avis:");
        System.out.println(crudAvis.getAll());

        crudAvis.delete(1); // Remplace 1 par un ID existant
        System.out.println("Après suppression:");
        System.out.println(crudAvis.getAll());
    }
}
