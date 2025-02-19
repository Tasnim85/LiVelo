module Livelo {
    requires com.nimbusds.jose.jwt;
    requires java.sql;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires jbcrypt;
    requires json.smart;

    // 🔹 Permet à JavaFX de charger les fichiers FXML dans ce package
    opens tn.esprit.test to javafx.fxml;

    // 🔹 Exporte le package principal
    exports tn.esprit.test;
}
