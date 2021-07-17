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

    @FXML
    void goToMenu(MouseEvent event) {
        sceneLoader.goToMainMenu(event);
    }


    @FXML
    void dummyExit(MouseEvent event) {
        labelFadeOut(dummyLabel);
        DummyBotButton.setEffect(new DropShadow());
    }

    @FXML
    void dummyHover(MouseEvent event) {
        labelFadeIn(dummyLabel);
        DummyBotButton.setEffect(new GaussianBlur(5.5));
    }

    @FXML
    void goToDummyBot(ActionEvent event) {

    }

    @FXML
    void goToSmartBot(ActionEvent event) {

    }

    @FXML
    void smartBotExit(MouseEvent event) {
        labelFadeOut(smartLabel);
        smartBotButton.setEffect(new DropShadow());
    }

    @FXML
    void smartBotHover(MouseEvent event) {
        labelFadeIn(smartLabel);
        smartBotButton.setEffect(new GaussianBlur(5.5));
    }
    void labelFadeIn(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(1);
        ft.play();

    }
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
    void setLabels()
    {
        dummyLabel.setText("Dummy Bot");
        smartLabel.setText("Smart Bot");
    }
}
