package services;

import interfaces.IServiceCrud;
import models.Commande;
import models.Facture;
import models.statutlCommande;
import models.type_paiement;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudFacture  implements IServiceCrud<Facture> {
    Connection conn= MyDatabase.getInstance().getConnection();
    @Override
    public void add(Facture facture) {
        //create Qry SQL
        //execute Qry
        String qry ="INSERT INTO `facture`(`montant`, `date`, `type_payement`,`userId`,`commandeId`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setFloat(1,facture.getMontant());
            pstm.setDate(2, new java.sql.Date(facture.getDatef().getTime()));
            pstm.setString(3,facture.getTypePaiement().toString());
            pstm.setInt(4,facture.getUserId());
            pstm.setInt(5, facture.getCommandeId());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Facture> getAll() {
        //create Qry sql
        //execution
        //Mapping data


        List<Facture> factures = new ArrayList<>();
        String qry ="SELECT * FROM `facture`";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()){
                Facture f = new Facture();
                f.setIdFacture(rs.getInt("idFacture"));
                f.setMontant(rs.getFloat(2));
                f.setDatef(rs.getDate("date"));
                f.setTypePaiement(type_paiement.valueOf(rs.getString(4).toUpperCase()));
                f.setUserId(rs.getInt(5));
                f.setCommandeId(rs.getInt(6));

                factures.add(f);
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return factures;
    }

    @Override
    public void update(Facture facture) {
        // Créer la requête SQL avec des paramètres
        String qry = "UPDATE `facture` SET `montant` = ?, `date` = ?, `type_payement` = ?, `userId` = ?, " +
                "`commandeId` = ? WHERE `idFacture` ="+2;

        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            // Remplacer les points d'interrogation par les valeurs
            statement.setFloat(1, facture.getMontant());
            statement.setDate(2, new java.sql.Date(facture.getDatef().getTime()));            statement.setString(3, facture.getTypePaiement().toString());
            statement.setInt(4, facture.getUserId());
            statement.setInt(5, facture.getCommandeId());

            // Exécuter la requête
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Facture updated successfully.");
            } else {
                System.out.println("No facture found with ID " + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String qry = "DELETE FROM `facture` WHERE `idFacture` = " + id;
        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            // Exécuter la requête
            statement.executeUpdate();
            System.out.println("Facture deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Facture getById(int id) {
        return null;
    }

    @Override
    public List<Facture> search(String criteria) {
        return List.of();
    }
}
