package test;

import models.Avis;
import services.CrudAvis;

import java.util.Date;


public class MainAvis {

    public static void main(String[] args) {
        CrudAvis serviceAvis = new CrudAvis();

        serviceAvis.add(new Avis( 20, 5, new Date(), new Date(), "Test 1"));

        System.out.println(serviceAvis.getAll());

        System.out.println("Test get by ID : "+ serviceAvis.getById(22));

        serviceAvis.delete(41);

        serviceAvis.update(new Avis( 21, 6, new Date(), new Date(), "Test 999"));


    }
}
