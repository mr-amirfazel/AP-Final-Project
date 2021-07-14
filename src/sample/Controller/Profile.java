package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sample.Model.Player;
import sample.Model.SharedData;

import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    private final SharedData sharedData = SharedData.getInstance();
    private final Player player = sharedData.player;
    private final SceneLoader sceneLoader = new SceneLoader();
    @FXML
    private Pane profilePane;

    @FXML
    private VBox sideVBox;


    @FXML
    private Pane leftPane;

    @FXML
    private Label usernameField;

    @FXML
    private Label levelID;

    @FXML
    private ProgressBar progressBar;
    @FXML
    private VBox profileVBox;

    @FXML
    private Label cupsLabel;

    @FXML
    private FlowPane cupsFlowPane;

    @FXML
    private Label leagueLabel;

    @FXML
    private ImageView LeageImage;

    @FXML
    private Label DeckLabel;

    @FXML
    private FlowPane DeckFlowPane;
    @FXML
    private ImageView profilePicture;
    @FXML
    private Pane imageContainer;
    @FXML
    void goToMenu(MouseEvent event) {
        sceneLoader.goToMainMenu(event);
    }

    @FXML
    void goToSetting(MouseEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameField.setText(player.getUserName());
       levelID.setText(player.getLevel()+"");
       progressBar.setProgress((player.getXp())/(maxXP(player.getLevel())));
    }

    public double maxXP(int level){
        double maxXP;
        maxXP =1;
        switch (level)
        {
            case 1:
                maxXP = sharedData.LVL2_MAX;
                break;
            case 2:
                maxXP = sharedData.LVL3_MAX;
                break;
            case 3:
                maxXP = sharedData.LVL4_MAX;
                break;
            case 4:
                maxXP = sharedData.LVL5_MAX;
                break;

        }
        return maxXP;
    }

}
