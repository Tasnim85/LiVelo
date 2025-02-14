package services;

import models.Commande;
import models.statutlCommande;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudCommande implements interfaces.IServiceCrud<Commande> {
    Connection conn= MyDatabase.getInstance().getConnection();

    @Override
    public void add(Commande commande) {
        //create Qry SQL
        //execute Qry
        String qry ="INSERT INTO `commande`(`adresse_dep`, `adresse_arr`, `type_livraison`,`horaire`,`statut`,`created_by`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setString(1,commande.getAdresse_dep());
            pstm.setString(2, commande.getAdresse_arr());
            pstm.setString(3,commande.getType_livraison());
            pstm.setTimestamp(4,commande.getHoraire());
            pstm.setString(5, commande.getStatut().toString());
            pstm.setInt(6,commande.getCreated_by());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Commande> getAll() {
        //create Qry sql
        //execution
        //Mapping data


        List<Commande> commandes = new ArrayList<>();
        String qry ="SELECT * FROM `commande`";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()){
                Commande c = new Commande();
                c.setId_Commande(rs.getInt("id_commande"));
                c.setAdresse_dep(rs.getString(2));
                c.setAdresse_arr(rs.getString("adresse_arr"));
                c.setType_livraison(rs.getString(4));
                c.setHoraire(rs.getTimestamp(5));
                c.setStatut(statutlCommande.valueOf(rs.getString(6)));
                c.setCreated_by(rs.getInt(7));

                commandes.add(c);
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return commandes;
    }

    @Override
    public void update(Commande commande) {
        // Créer la requête SQL avec des paramètres
        String qry = "UPDATE `commande` SET `adresse_dep` = ?, `adresse_arr` = ?, `type_livraison` = ?, `horaire` = ?, " +
                "`statut` = ?, `created_by` = ? WHERE `id_commande` ="+1;

        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            // Remplacer les points d'interrogation par les valeurs
            statement.setString(1, commande.getAdresse_dep());
            statement.setString(2, commande.getAdresse_arr());
            statement.setString(3, commande.getType_livraison());
            statement.setTimestamp(4, commande.getHoraire());
            statement.setString(5, commande.getStatut().toString());
            statement.setInt(6, commande.getCreated_by());
            // Exécuter la requête
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Command updated successfully.");
            } else {
                System.out.println("No command found with ID " + 10);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String qry = "DELETE FROM `commande` WHERE `id_commande` = " + id;
        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            // Exécuter la requête
            statement.executeUpdate();
            System.out.println("Command deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Commande getById(int id) {
        return null;
    }

    @Override
    public List<Commande> search(String criteria) {
        return List.of();
    }
}
