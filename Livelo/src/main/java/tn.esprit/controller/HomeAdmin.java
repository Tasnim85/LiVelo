package tn.esprit.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeAdmin {

    @FXML
    private AnchorPane anDeliveryPMain;

    @FXML
    private AnchorPane anListUsersMain;

    @FXML
    private AnchorPane anLogout;

    @FXML
    private AnchorPane anOrder;

    @FXML
    private AnchorPane anOrdersMain;

    @FXML
    private AnchorPane anPendingUsers;

    @FXML
    private AnchorPane anRiders;

    @FXML
    private AnchorPane anUsers;
    @FXML
    private AnchorPane anCategories;

    @FXML
    private AnchorPane anVerifyUserMain;

    @FXML
    private ImageView imLogo;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private void navigateToHome() {
        try {
            // Load the SignUp.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/homeAdmin.fxml"));
            Scene signUpScene = new Scene(loader.load());

            // Get the current stage and set the new scene
            Stage stage = (Stage) imLogo.getScene().getWindow();
            stage.setScene(signUpScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading SignUp.fxml.");
        }
    }
    @FXML
    private void openGestionCategorie() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestioncategorie.fxml"));
            AnchorPane gestionCategoriePane = loader.load();

            // Remplacer le contenu actuel par la gestion des catégories
            mainPane.getChildren().setAll(gestionCategoriePane);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de gestioncategorie.fxml");
        }
    }
    @FXML
    public void initialize() {
        // Ajouter un événement de clic sur anCategories
        anCategories.setOnMouseClicked(event -> openGestionCategorie());
    }
}
