package services;

import interfaces.IServiceCrud;
import models.Article;
import models.User;
import models.statut_article;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudArticle implements IServiceCrud<Article> {
    Connection conn = MyDatabase.getInstance().getConnection();

    @Override
    public void add(Article article) {
        String qry = "INSERT INTO `article` (`url_image`, `id_categorie`, `nom`, `prix`, `description`, `created_by`, `quantite`, `statut`, `createdAt`, `nbViews`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, article.getUrlImage());
            statement.setInt(2, article.getIdCategorie());
            statement.setString(3, article.getNom());
            statement.setFloat(4, article.getPrix());
            statement.setString(5, article.getDescription());
            statement.setInt(6, article.getCreatedBy());
            statement.setInt(7, article.getQuantite());
            statement.setString(8, article.getStatut().toString());
            statement.setDate(9, new java.sql.Date(article.getCreatedAt().getTime()));
            statement.setInt(10, article.getNbViews());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        article.setIdArticle(generatedId);
                        System.out.println("Article added successfully with ID: " + generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT * FROM article"; // Remplace par ta propre requête SQL pour récupérer les articles

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Executing query: " + query);

            while (resultSet.next()) {
                int idArticle = resultSet.getInt("id_article");
                String urlImage = resultSet.getString("url_image");
                int idCategorie = resultSet.getInt("id_categorie");
                String nom = resultSet.getString("nom");
                float prix = resultSet.getFloat("prix");
                String description = resultSet.getString("description");
                int createdBy = resultSet.getInt("created_by");
                int quantite = resultSet.getInt("quantite");
                int nbViews = resultSet.getInt("nbViews");
                Date createdAt = resultSet.getDate("createdAt");

                // Récupérer le statut de l'article depuis la base de données
                String statutString = resultSet.getString("statut");
                System.out.println("Statut: " + statutString); // Affichage pour déboguer

                // Conversion de la chaîne récupérée en valeur de l'énumération
                statut_article statut;
                try {
                    statut = statut_article.valueOf(statutString.toUpperCase()); // Conversion en respectant la casse
                } catch (IllegalArgumentException e) {
                    statut = statut_article.on_stock; // Statut par défaut si la valeur n'est pas valide
                }

                // Créer un objet Article avec les données récupérées
                Article article = new Article(idArticle, urlImage, idCategorie, nom, prix, description, createdBy, quantite, statut, createdAt, nbViews);
                articles.add(article);
            }

            System.out.println("Nombre d'articles récupérés: " + articles.size());
            for (Article a : articles) {
                System.out.println(a); // Affiche les détails de chaque article
            }

        } catch (SQLException e) {
            System.out.println("Erreur SQL: " + e.getMessage());
        }

        // Retourner la liste des articles récupérés
        return articles;
    }


    @Override
    public void update(Article article) {
        String qry = "UPDATE `article` SET `url_image` = ?, `id_categorie` = ?, `nom` = ?, `prix` = ?, `description` = ?, `created_by` = ?, `quantite` = ?, `statut` = ?, `createdAt` = ?, `nbViews` = ? WHERE `id_article` = " + article.getIdArticle();

        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            statement.setString(1, article.getUrlImage());
            statement.setInt(2, article.getIdCategorie());
            statement.setString(3, article.getNom());
            statement.setFloat(4, article.getPrix());
            statement.setString(5, article.getDescription());
            statement.setInt(6, article.getCreatedBy());
            statement.setInt(7, article.getQuantite());
            statement.setString(8, article.getStatut().toString());
            statement.setDate(9, new java.sql.Date(article.getCreatedAt().getTime()));
            statement.setInt(10, article.getNbViews());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Article updated successfully.");
            } else {
                System.out.println("No article found with ID " + article.getIdArticle());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String qry = "DELETE FROM `article` WHERE `id_article` = " + id;
        try (PreparedStatement statement = conn.prepareStatement(qry)) {
            statement.executeUpdate();
            System.out.println("Article deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
