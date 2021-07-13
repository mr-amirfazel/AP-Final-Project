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

public class SignUp {
    private DataBase dataBase;
    private Stage stage;
    private Scene scene;
    private Parent root;
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
    @FXML
    void backToMain(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/Entrance.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("JavaFX is my nigga");
        stage.setScene(scene);
        stage.show();
    }

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
