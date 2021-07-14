package sample.Controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import sample.Model.Player;
import sample.Model.SharedData;

import java.net.URL;
import java.util.ResourceBundle;

public class BattleHistoryController implements Initializable {
    private final SharedData sharedData = SharedData.getInstance();
    private final Player player = sharedData.player;
    private final SceneLoader sceneLoader = new SceneLoader();
    @FXML
    private Label historyUserName;
    @FXML
    private Label goBackLabel;

    @FXML
    private AnchorPane historyPane;

    @FXML
    private VBox historyList;

    @FXML
    void goToMenu(MouseEvent event) {
    sceneLoader.goToMainMenu(event);
    }
    @FXML
    void backHover(MouseEvent event) {
        fadeIn(goBackLabel);
    }

    @FXML
    void backUnHover(MouseEvent event) {
        fadeOut(goBackLabel);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        historyUserName.setText(player.getUserName());
        goBackLabel.setText("go back");
    }
    void fadeIn(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.65),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(1);
        ft.play();
    }
    void fadeOut(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.65),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(0);
        ft.play();
    }
}
