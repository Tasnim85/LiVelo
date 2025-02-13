package services;

import models.Avis;
import utils.MyDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudAvis {
    Connection conn = MyDatabase.getInstance().getConnection();

    public void add(Avis avis) {
        String qry = "INSERT INTO `avis`(`id_user`, `id_livraison`, `commentaire`, `note`, `date_avis`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setInt(1, avis.getId_utilisateur());
            pstm.setInt(2, avis.getId_livraison());
            pstm.setString(3, avis.getCommentaire());
            pstm.setInt(4, avis.getNote());
            pstm.setDate(5, new java.sql.Date(avis.getDate_avis().getTime()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Avis> getAll() {
        List<Avis> avisList = new ArrayList<>();
        String qry = "SELECT * FROM `avis`";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Avis avis = new Avis();
                avis.setId_avis(rs.getInt("id_avis"));
                avis.setId_utilisateur(rs.getInt("id_user"));
                avis.setId_livraison(rs.getInt("id_livraison"));
                avis.setCommentaire(rs.getString("commentaire"));
                avis.setNote(rs.getInt("note"));
                avis.setDate_avis(rs.getDate("date_avis"));
                avisList.add(avis);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return avisList;
    }

    public void update(Avis avis) {
        String qry = "UPDATE `avis` SET `id_user` = ?, `id_livraison` = ?, `commentaire` = ?, `note` = ?, `date_avis` = ? WHERE `id_avis` = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setInt(1, avis.getId_utilisateur());
            pstm.setInt(2, avis.getId_livraison());
            pstm.setString(3, avis.getCommentaire());
            pstm.setInt(4, avis.getNote());
            pstm.setDate(5, new java.sql.Date(avis.getDate_avis().getTime()));
            pstm.setInt(6, avis.getId_avis());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String qry = "DELETE FROM `avis` WHERE `id_avis` = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
