package services;

import models.Livraison;
import utils.MyDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudLivraison implements interfaces.IServiceCrud<Livraison> {
    Connection conn = MyDatabase.getInstance().getConnection();

    @Override
    public void add(Livraison livraison) {
        String qry = "INSERT INTO `livraison`(`id_commande`, `id_livreur`, `date_livraison`) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setInt(1, livraison.getId_commande());
            pstm.setInt(2, livraison.getId_livreur());
            pstm.setDate(3, new java.sql.Date(livraison.getDate_livraison().getTime()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Livraison> getAll() {
        List<Livraison> livraisons = new ArrayList<>();
        String qry = "SELECT * FROM `livraison`";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Livraison l = new Livraison();
                l.setId_livraison(rs.getInt("id_livraison"));
                l.setId_commande(rs.getInt("id_commande"));
                l.setId_livreur(rs.getInt("id_livreur"));
                l.setDate_livraison(rs.getDate("date_livraison"));
                livraisons.add(l);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return livraisons;
    }

    @Override
    public void update(Livraison livraison) {
        String qry = "UPDATE `livraison` SET `id_commande` = ?, `id_livreur` = ?, `date_livraison` = ? WHERE `id_livraison` = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setInt(1, livraison.getId_commande());
            pstm.setInt(2, livraison.getId_livreur());
            pstm.setDate(3, new java.sql.Date(livraison.getDate_livraison().getTime()));
            pstm.setInt(4, livraison.getId_livraison());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String qry = "DELETE FROM `livraison` WHERE `id_livraison` = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
