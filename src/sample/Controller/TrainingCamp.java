package sample.Controller;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * The type Training camp.
 */
public class TrainingCamp implements Initializable {

    private final SceneLoader sceneLoader = new SceneLoader();
    @FXML
    private AnchorPane TrainingCampPane;

    @FXML
    private Button DummyBotButton;

    @FXML
    private Button smartBotButton;

    @FXML
    private Label dummyLabel;

    @FXML
    private Label smartLabel;

    /**
     * Go to menu.
     *
     * @param event the event
     */
    @FXML
    void goToMenu(MouseEvent event) {
        sceneLoader.goToMainMenu(event);
    }


    /**
     * Dummy exit.
     *
     * @param event the event
     */
    @FXML
    void dummyExit(MouseEvent event) {
        labelFadeOut(dummyLabel);
        DummyBotButton.setEffect(new DropShadow());
    }

    /**
     * Dummy hover.
     *
     * @param event the event
     */
    @FXML
    void dummyHover(MouseEvent event) {
        labelFadeIn(dummyLabel);
        DummyBotButton.setEffect(new GaussianBlur(5.5));
    }

    /**
     * Go to dummy bot.
     *
     * @param event the event
     */
    @FXML
    void goToDummyBot(ActionEvent event) {
        sceneLoader.goToDummy(event);
    }

    /**
     * Go to smart bot.
     *
     * @param event the event
     */
    @FXML
    void goToSmartBot(ActionEvent event) {

    }

    /**
     * Smart bot exit.
     *
     * @param event the event
     */
    @FXML
    void smartBotExit(MouseEvent event) {
        labelFadeOut(smartLabel);
        smartBotButton.setEffect(new DropShadow());
    }

    /**
     * Smart bot hover.
     *
     * @param event the event
     */
    @FXML
    void smartBotHover(MouseEvent event) {
        labelFadeIn(smartLabel);
        smartBotButton.setEffect(new GaussianBlur(5.5));
    }

    /**
     * Label fade in.
     *
     * @param label the label
     */
    void labelFadeIn(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(1);
        ft.play();

    }

    /**
     * Label fade out.
     *
     * @param label the label
     */
    void labelFadeOut(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(0);
        ft.play();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLabels();
    }

    /**
     * Sets labels.
     */
    void setLabels()
    {
        dummyLabel.setText("Dummy Bot");
        smartLabel.setText("Smart Bot");
    }
}
