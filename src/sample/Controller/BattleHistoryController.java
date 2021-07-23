package sample.Controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import sample.Model.DataBase;
import sample.Model.Player;
import sample.Model.SharedData;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Battle history controller.
 */
public class BattleHistoryController implements Initializable {
    private final SharedData sharedData = SharedData.getInstance();
    private final DataBase dataBase = new DataBase();
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
     * Back hover.
     *
     * @param event the event
     */
    @FXML
    void backHover(MouseEvent event) {
        fadeIn(goBackLabel);
    }

    /**
     * Back un hover.
     *
     * @param event the event
     */
    @FXML
    void backUnHover(MouseEvent event) {
        fadeOut(goBackLabel);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       setLabels();
       addHistory();
    }

    /**
     * Fade in.
     *
     * @param label the label
     */
    void fadeIn(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.65),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(1);
        ft.play();
    }

    /**
     * Fade out.
     *
     * @param label the label
     */
    void fadeOut(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.65),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(0);
        ft.play();
    }

    /**
     * Sets labels.
     */
    void setLabels()
    {
        historyUserName.setText(player.getUserName());
        goBackLabel.setText("go back");
    }

    /**
     * Add history.
     */
    void addHistory()
    {
        for (int i =0; i<player.getHistory().size();i++)
        {
            Label label = new Label();
            label.setText("match #"+(i+1)+" "+player.getHistory().get(i).toString());
            label.setStyle(" -fx-border-color:transparent transparent linear-gradient(to right, rgba(35,67,222,1) 0%, rgba(3,17,69,1) 100%) transparent;" +
                    "-fx-text-fill: #21075c;" +
                    "-fx-font-size: 14px;" +
                    "-fx-border-width: 3px" );
            label.setPadding(new Insets(10,0,10,0));
            historyList.getChildren().add(label);
        }
    }
}
