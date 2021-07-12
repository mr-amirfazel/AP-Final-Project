package sample.Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Model.DataBase;
import sample.Model.Player;

import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private VBox LogDisplay;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Label WelcomeID;
    @FXML
    private Label gobackLabel;

    @FXML
    void Submit(ActionEvent event) {
        DataBase dataBase = new DataBase();
        if (dataBase.playerExist(userNameField.getText()))
        {
            Player player = dataBase.getPlayer(userNameField.getText());
            if (player.getPassWord().equals(passwordField.getText()))
                  WelcomeID.setText("hi Dear  " + userNameField.getText());
            else
                WelcomeID.setText("PassWord is INACCURATE");
        }
        else
            WelcomeID.setText("this account does not exist");

    }

    @FXML
    void goToEntrance(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../View/Entrance.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void gobackShow(MouseEvent event) {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(1.5),gobackLabel);
        tt.setCycleCount(1);
        tt.setToY(23);
        tt.play();
       tt.setAutoReverse(false);
    }
    @FXML
    void justAFunc(MouseEvent event) {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(1.5),gobackLabel);
        tt.setCycleCount(1);
        tt.setToY(-10);
        tt.play();

    }

}
