package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Player;

import java.io.IOException;

/**
 * The type Sign up.
 */
public class SignUp {

    private DataBase dataBase;
    private final SceneLoader sceneLoader = new SceneLoader();

    @FXML
    private Pane SignupPage;

    @FXML
    private VBox SignUpMenu;

    @FXML
    private Label signUpLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passField;

    @FXML
    private TextField secPassField;


    @FXML
    private Button signUpSubmitButton;

    @FXML
    private Button backToMain;

    @FXML
    private Label passLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label secpassLabel;

    /**
     * Back to main.
     *
     * @param event the event
     */
    @FXML
    void backToMain(ActionEvent event) {
        sceneLoader.goToEntrance(event);
    }

    /**
     * Sign up submit.
     *
     * @param event the event
     */
    @FXML
    void signUpSubmit(ActionEvent event) {
        dataBase = new DataBase();
        if (!dataBase.playerExist(usernameField.getText())) {
            if (passField.getText().equals(secPassField.getText())) {
                dataBase.savePlayer(new Player(usernameField.getText(), passField.getText()));
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("successfully created account __" + usernameField.getText() + "__");
                alert.show();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("this username already Exists");
            alert.show();
        }


    }

}
