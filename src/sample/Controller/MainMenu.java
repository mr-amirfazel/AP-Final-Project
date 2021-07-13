package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {
        private Stage stage;
        private Scene scene;
        private Parent root;



        @FXML
        private Pane mainMenuPane;

        @FXML
        private Button profileButton;

        @FXML
        private Button battleDeckButton;

        @FXML
        private Button battleHistoryButton;

        @FXML
        private Button trainingCampButton;

        @FXML
        private Button onevoneButton;

        @FXML
        private Button twovtwoButton;
        @FXML
        private Button menuBackButton;

        @FXML
        void goTo1v1(ActionEvent event) {

        }

        @FXML
        void goTo2v2(ActionEvent event) {

        }

        @FXML
        void goToBattleDeck(ActionEvent event) {

        }

        @FXML
        void goToBattleHistory(ActionEvent event) {

        }

        @FXML
        void goToProfile(ActionEvent event) {

        }

        @FXML
        void goToTrainingCamp(ActionEvent event) {

        }
        @FXML
        void menuBack(ActionEvent event) {
                try {
                        root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
                } catch (IOException e) {
                        e.printStackTrace();
                }
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                String css = this.getClass().getResource("../View/StyleSheets/Phase1.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.setResizable(true);
                stage.setTitle("Log In");
                stage.show();
        }

    }

