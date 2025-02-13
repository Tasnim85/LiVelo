package models;

import java.util.Date;


    public class Livraison {
        private int id_livraison;
        private int id_commande;
        private int id_livreur;
        private Date date_livraison;

        public Livraison() {}

        public Livraison(int id_livraison, int id_commande, int id_livreur, Date date_livraison) {
            this.id_livraison = id_livraison;
            this.id_commande = id_commande;
            this.id_livreur = id_livreur;
            this.date_livraison = date_livraison;
        }


        public Livraison(int id_commande, int id_livreur, Date date_livraison) {
            this.id_commande = id_commande;
            this.id_livreur = id_livreur;
            this.date_livraison = date_livraison;
        }

        public int getId_livraison() {
            return id_livraison;
        }

        public void setId_livraison(int id_livraison) {
            this.id_livraison = id_livraison;
        }

        public int getId_commande() {
            return id_commande;
        }

        public void setId_commande(int id_commande) {
            this.id_commande = id_commande;
        }

        public int getId_livreur() {
            return id_livreur;
        }

        public void setId_livreur(int id_livreur) {
            this.id_livreur = id_livreur;
        }

        public Date getDate_livraison() {
            return date_livraison;
        }

        public void setDate_livraison(Date date_livraison) {
            this.date_livraison = date_livraison;
        }

        @Override
        public String toString() {
            return "Livraison{" +
                    "id_livraison=" + id_livraison +
                    ", id_commande=" + id_commande +
                    ", id_livreur=" + id_livreur +
                    ", date_livraison=" + date_livraison +
                    '}';
        }
    }