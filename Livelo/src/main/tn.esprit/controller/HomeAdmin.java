package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
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
    private AnchorPane anVerifyUserMain;

    @FXML
    private ImageView imLogo;

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
    private void logout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignIn.fxml"));
            Scene SignInScene = new Scene(loader.load());

            Stage stage = (Stage) anLogout.getScene().getWindow();
            stage.setScene(SignInScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading SignUp.fxml.");
        }
    }
    @FXML
    private void NavigateToGestionUsers() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GestionUtilisateurs.fxml"));
            Scene GestionUtilisateursScene = new Scene(loader.load());

            Stage stage = (Stage) anLogout.getScene().getWindow();
            stage.setScene(GestionUtilisateursScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading SignUp.fxml.");
        }
    }

    public void normalEffect(javafx.scene.input.MouseEvent event) {
        ((AnchorPane) event.getSource()).setStyle("-fx-background-color: transparent; -fx-cursor: hand;");

    }

    public void hoverEffect(javafx.scene.input.MouseEvent event) {
        ((AnchorPane) event.getSource()).setStyle("-fx-background-color: lightgrey; -fx-cursor: hand;");

    }
}
