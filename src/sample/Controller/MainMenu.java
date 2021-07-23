package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Main menu.
 */
public class MainMenu {
    private final SceneLoader sceneLoader = new SceneLoader();
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

    /**
     * Go to 1 v 1.
     *
     * @param event the event
     */
    @FXML
    void goTo1v1(ActionEvent event) {

    }

    /**
     * Go to 2 v 2.
     *
     * @param event the event
     */
    @FXML
    void goTo2v2(ActionEvent event) {

    }

    /**
     * Go to battle deck.
     *
     * @param event the event
     */
    @FXML
    void goToBattleDeck(ActionEvent event) {
        sceneLoader.goToBattleDeck(event);
    }

    /**
     * Go to battle history.
     *
     * @param event the event
     */
    @FXML
    void goToBattleHistory(ActionEvent event) {
        sceneLoader.goToBattleHistory(event);
    }

    /**
     * Go to profile.
     *
     * @param event the event
     */
    @FXML
    void goToProfile(ActionEvent event) {
        sceneLoader.goToProfile(event);
    }

    /**
     * Go to training camp.
     *
     * @param event the event
     */
    @FXML
    void goToTrainingCamp(ActionEvent event) {
        sceneLoader.goToTrainingCamp(event);
    }

    /**
     * Menu back.
     *
     * @param event the event
     */
    @FXML
    void menuBack(ActionEvent event) {
        sceneLoader.goToLogin(event);
    }
}

