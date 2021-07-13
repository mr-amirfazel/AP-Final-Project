package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public SceneLoader() {}

    public void goToEntrance(ActionEvent event)
    {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/Entrance.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Welcome Page");
        stage.setScene(scene);
        stage.show();
    }
    public void goToEntrance(MouseEvent event)
    {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/Entrance.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Welcome Page");
        stage.setScene(scene);
        stage.show();
    }
    public void goToLogin(ActionEvent event)
    {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    public void goToSignUp(ActionEvent event)
    {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/SignUp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Sign Up!");
        stage.setScene(scene);
        stage.show();
    }
    public void goToMainMenu(ActionEvent event)
    {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/MainMenu.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Clash Royale");
        stage.setScene(scene);
        stage.show();
    }
}
