package tn.esprit.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.MyDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionCategorie {

    @FXML
    private VBox vboxCategories; // Conteneur des catégories

    @FXML
    private ImageView imLogo;

    @FXML
    private void navigateToHome() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/homeAdmin.fxml"));
            Scene homeScene = new Scene(loader.load());

            Stage stage = (Stage) imLogo.getScene().getWindow();
            stage.setScene(homeScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de homeAdmin.fxml.");
        }
    }

    @FXML
    public void initialize() {
        afficherCategories(); // Charge les catégories dès l’ouverture de la page
    }

    private void afficherCategories() {
        vboxCategories.getChildren().clear(); // Nettoyer avant d'ajouter

        try {
            // Connexion à la base de données
            Connection conn = MyDatabase.getInstance().getConnection();
            String query = "SELECT nom, description, image_url FROM categorie";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                String imageUrl = rs.getString("image_url");

                // Création d'un HBox pour contenir les éléments
                HBox hbox = new HBox(10);
                hbox.setStyle("-fx-padding: 10px; -fx-border-color: #ccc; -fx-border-radius: 5px;");

                // Image de la catégorie
                ImageView imageView = new ImageView(new Image(imageUrl));
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);

                // Labels pour le nom et la description
                Label lblNom = new Label(nom);
                lblNom.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

                Label lblDescription = new Label(description);
                lblDescription.setStyle("-fx-text-fill: gray;");

                hbox.getChildren().addAll(imageView, lblNom, lblDescription);
                vboxCategories.getChildren().add(hbox);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement des catégories.");
        }
    }
}
