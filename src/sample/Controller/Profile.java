package sample.Controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import sample.Model.Player;
import sample.Model.SharedData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    private final SharedData sharedData = SharedData.getInstance();
    private final Player player = sharedData.player;
    private final SceneLoader sceneLoader = new SceneLoader();
    @FXML
    private Label levelLabel;
    @FXML
    private Label xpLabel;
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
    private Label goBackLabel;
    @FXML
    private Label settingLabel;
    @FXML
    private FlowPane DeckFlowPane;

    @FXML
    private Circle ProfileHolder;

    @FXML
    void goToMenu(MouseEvent event) {
        sceneLoader.goToMainMenu(event);
    }

    @FXML
    void goToSetting(MouseEvent event) {

    }
    @FXML
    void levelExit(MouseEvent event) {
       fadeOut(levelLabel);
    }

    @FXML
    void levelHover(MouseEvent event) {
       fadeIn(levelLabel);
    }

    @FXML
    void progressExit(MouseEvent event) {
       fadeOut(xpLabel);
    }

    @FXML
    void progressHover(MouseEvent event) {
       fadeIn(xpLabel);
    }
    @FXML
    void settingExit(MouseEvent event) {
     fadeOut(settingLabel);
    }

    @FXML
    void settingHover(MouseEvent event) {
        fadeIn(settingLabel);
    }
    @FXML
    void goBackExit(MouseEvent event) {
     fadeOut(goBackLabel);
    }

    @FXML
    void goBackHover(MouseEvent event) {
        fadeIn(goBackLabel);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameField.setText(player.getUserName());
       levelID.setText(player.getLevel()+"");
       progressBar.setProgress((player.getXp())/(maxXP(player.getLevel())));
       setLabels();
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

    public void setProfile()
    {

        File imageFile = new File(player.getProfilePicDirectory());
        try {
          Image  image = new Image(new FileInputStream(imageFile));
            ProfileHolder.setFill(new ImagePattern(image));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void setLabels()
    {
        levelLabel.setText("LEVEL");
        xpLabel.setText("XP : "+player.getXp()+"/"+maxXP(player.getLevel()));
        settingLabel.setText("Setting");
        goBackLabel.setText("GO BACK!!!");
    }
    void fadeIn(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(1);
        ft.play();
    }
    void fadeOut(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(0.0);
        ft.play();
    }
}
