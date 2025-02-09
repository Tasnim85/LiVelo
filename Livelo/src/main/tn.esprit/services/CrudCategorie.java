package main.tn.esprit.services;



import interfaces.IServiceCrud;
import main.tn.esprit.models.Categorie;
import main.tn.esprit.models.User;
import main.tn.esprit.utils.MyDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CrudCategorie implements IServiceCrud<Categorie> {
    Connection conn = MyDatabase.getInstance().getConnection();

    @Override
    public void add(Categorie cat) {
        String qry = "INSERT INTO `categorie` (`nom`, `description`, `url_image`, `created_by`) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cat.getNom());
            statement.setString(2, cat.getDescription());
            statement.setString(3, cat.getUrl_image());
            statement.setInt(4, cat.getCreatedBy());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        cat.setId_categorie(generatedId);
                        System.out.println("Catégorie ajoutée avec succès avec l'ID : " + generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Categorie> getAll() {
        List<Categorie> categories = new ArrayList<>();
        String query = "SELECT * FROM `categorie`";

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_categorie");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                String urlImage = rs.getString("url_image");
                int createdBy = rs.getInt("created_by");

                Categorie categorie = new Categorie(id, nom, description, urlImage, createdBy);
                categories.add(categorie);
            }

            System.out.println("Nombre de catégories récupérées : " + categories.size());
            for (Categorie c : categories) {
                System.out.println(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public void update(Categorie cat) {
        String qry = "UPDATE `categorie` SET `nom` = ?, `description` = ?, `url_image` = ?, `created_by` = ? WHERE `id_categorie` = ?";

        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            statement.setString(1, cat.getNom());
            statement.setString(2, cat.getDescription());
            statement.setString(3, cat.getUrl_image());
            statement.setInt(4, cat.getCreatedBy());
            statement.setInt(5, cat.getId_categorie());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Catégorie mise à jour avec succès.");
            } else {
                System.out.println("Aucune catégorie trouvée avec l'ID " + cat.getId_categorie());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id_categorie) {
        String qry = "DELETE FROM `categorie` WHERE `id_categorie` = ?";

        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            statement.setInt(1, id_categorie);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Catégorie supprimée avec succès.");
            } else {
                System.out.println("Aucune catégorie trouvée avec l'ID " + id_categorie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
