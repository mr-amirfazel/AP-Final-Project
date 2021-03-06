package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Scene loader.
 */
public class SceneLoader {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Instantiates a new Scene loader.
     */
    public SceneLoader() {}

    /**
     * Go to entrance.
     *
     * @param event the event
     */
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

    /**
     * Go to entrance.
     *
     * @param event the event
     */
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

    /**
     * Go to login.
     *
     * @param event the event
     */
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

    /**
     * Go to sign up.
     *
     * @param event the event
     */
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

    /**
     * Go to main menu.
     *
     * @param event the event
     */
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

    /**
     * Go to profile.
     *
     * @param event the event
     */
    public void goToProfile(ActionEvent event)
    {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/Profile.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/Profile.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Player Profile");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Go to main menu.
     *
     * @param event the event
     */
    public void goToMainMenu(MouseEvent event) {
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

    /**
     * Go to battle history.
     *
     * @param event the event
     */
    public void goToBattleHistory(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/BattleHistory.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/BattleHistory.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Battle History");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Go to battle deck.
     *
     * @param event the event
     */
    public void goToBattleDeck(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/BattleDeck.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/Bg-deck.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Battle Deck");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Go to training camp.
     *
     * @param event the event
     */
    public void goToTrainingCamp(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/TrainingCamp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/TrainingCamp.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("TrainingCamp");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Go to dummy.
     *
     * @param event the event
     */
    public void goToDummy(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/dummyGame.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/DummyGame.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Dummy BOT");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Go to training camp.
     *
     * @param event the event
     */
    public void goToTrainingCamp(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/TrainingCamp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/TrainingCamp.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("TrainingCamp");
        stage.setScene(scene);
        stage.show();
    }
}
