package services;

import interfaces.IServiceCrud;
import models.User;
import models.role_user;
import models.type_vehicule;
import utils.MyDatabase;
import org.mindrot.jbcrypt.BCrypt;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudUser implements IServiceCrud<User> {
    Connection conn= MyDatabase.getInstance().getConnection();

    @Override
    public void add(User user) {
        String qry = "INSERT INTO `user` (`nom`, `prenom`, `role`, `verified`, `adresse`, `type_vehicule`, `email`, `password`, `num_tel`, `cin`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS)) {
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

            System.out.println("Mot de passe original : " + user.getPassword());
            System.out.println("Mot de passe hashé : " + hashedPassword);

            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getRole().toString());
            statement.setInt(4, user.isVerified() ? 1 : 0);
            statement.setString(5, user.getAdresse());
            statement.setString(6, user.getType_vehicule().toString());
            statement.setString(7, user.getEmail());
            statement.setString(8, hashedPassword);
            statement.setString(9, user.getNum_tel());
            statement.setString(10, user.getCin());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        user.setId(generatedId);
                        System.out.println("User ajouté avec ID: " + generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM `user`";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Récupérer les données de l'utilisateur
                int id = rs.getInt("idUser");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String roleString = rs.getString("role");
                String typeVehiculeString = rs.getString("type_vehicule");
                type_vehicule typeVehicule = type_vehicule.valueOf(typeVehiculeString);
                role_user role = role_user.valueOf(roleString);

                boolean verified = rs.getBoolean("verified");
                String adresse = rs.getString("adresse");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String num_tel = rs.getString("num_tel");
                String cin = rs.getString("cin");

                User user = new User(id,nom, prenom, role, verified, adresse,
                        typeVehicule, email, password, num_tel, cin);

                users.add(user);
            }

            System.out.println("Nombre d'utilisateurs récupérés : " + users.size());
            for (User u : users) {
                System.out.println(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


    @Override
    public void update(User user) {
        String qry = "UPDATE `user` SET `nom` = ?, `prenom` = ?, `role` = ?, `verified` = ?, " +
                "`adresse` = ?, `type_vehicule` = ?, `email` = ?, `password` = ?, " +
                "`num_tel` = ?, `cin` = ? WHERE `idUser` = ?";

        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            // Si le mot de passe est non vide, on le hash. Sinon, on garde l'ancien.
            String hashedPassword;
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            } else {
                // Si tu veux juste garder l'ancien mot de passe, il faut le récupérer depuis la base
                // Sinon tu peux laisser null ou une chaîne vide selon ton cas
                System.out.println("Mot de passe vide, mise à jour de l'utilisateur sans changer le mot de passe.");
                hashedPassword = user.getPassword(); // Optionnel, si tu veux éviter le hash
            }

            // Remplacer les valeurs dans la requête
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getRole().toString());
            statement.setInt(4, user.isVerified() ? 1 : 0);
            statement.setString(5, user.getAdresse());
            statement.setString(6, user.getType_vehicule().toString());
            statement.setString(7, user.getEmail());
            statement.setString(8, hashedPassword);
            statement.setString(9, user.getNum_tel());
            statement.setString(10, user.getCin());
            statement.setInt(11, user.getId()); // WHERE idUser = ?

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with ID " + user.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void delete(int id) {
        String qry = "DELETE FROM `user` WHERE `idUser` = " + id;
        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            // Exécuter la requête
            statement.executeUpdate();
            System.out.println("User deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
