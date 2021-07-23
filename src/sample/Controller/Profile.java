package sample.Controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import sample.Model.Cards.BuildingCards.Cannon;
import sample.Model.Cards.BuildingCards.InfernoTower;
import sample.Model.Cards.Card;
import sample.Model.Cards.SpellCards.Arrows;
import sample.Model.Cards.SpellCards.Fireball;
import sample.Model.Cards.SpellCards.Rage;
import sample.Model.Cards.TroopCards.*;
import sample.Model.DataBase;
import sample.Model.Player;
import sample.Model.SharedData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * The type Profile.
 */
public class Profile implements Initializable {
    private final SharedData sharedData = SharedData.getInstance();
    /**
     * The Data base.
     */
    DataBase dataBase = new DataBase();
    private final Player player = sharedData.player;
    private final SceneLoader sceneLoader = new SceneLoader();

    @FXML
    private ImageView slot1;

    @FXML
    private ImageView slot2;

    @FXML
    private ImageView slot3;

    @FXML
    private ImageView slot4;

    @FXML
    private ImageView slot5;

    @FXML
    private ImageView slot6;

    @FXML
    private ImageView slot7;

    @FXML
    private ImageView slot8;

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
    private Pane holderPane;
    @FXML
    private ImageView leaguePhoto;

    private final ArrayList<ImageView> slots = new ArrayList<>() ;

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
     * Go to setting.
     *
     * @param event the event
     */
    @FXML
    void goToSetting(MouseEvent event) {

    }

    /**
     * Level exit.
     *
     * @param event the event
     */
    @FXML
    void levelExit(MouseEvent event) {
       fadeOut(levelLabel);
    }

    /**
     * Profile hover.
     *
     * @param event the event
     */
    @FXML
    void profileHover(MouseEvent event) {
        holderPane.setStyle("-fx-border-color: #0004ff;");
        ProfileHolder.setRadius(ProfileHolder.getRadius()+1);
    }

    /**
     * Profile exit.
     *
     * @param event the event
     */
    @FXML
    void profileExit(MouseEvent event) {
        holderPane.setStyle(holderPane.getStyle()+"-fx-border-color: #f711ab;");
        ProfileHolder.setRadius(ProfileHolder.getRadius()-1);

    }

    /**
     * Level hover.
     *
     * @param event the event
     */
    @FXML
    void levelHover(MouseEvent event) {
       fadeIn(levelLabel);
    }

    /**
     * Progress exit.
     *
     * @param event the event
     */
    @FXML
    void progressExit(MouseEvent event) {
       fadeOut(xpLabel);
    }

    /**
     * Progress hover.
     *
     * @param event the event
     */
    @FXML
    void progressHover(MouseEvent event) {
       fadeIn(xpLabel);
    }

    /**
     * Sets exit.
     *
     * @param event the event
     */
    @FXML
    void settingExit(MouseEvent event) {
     fadeOut(settingLabel);
    }

    /**
     * Sets hover.
     *
     * @param event the event
     */
    @FXML
    void settingHover(MouseEvent event) {
        fadeIn(settingLabel);
    }

    /**
     * Go back exit.
     *
     * @param event the event
     */
    @FXML
    void goBackExit(MouseEvent event) {
     fadeOut(goBackLabel);
    }

    /**
     * Go back hover.
     *
     * @param event the event
     */
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
       setProfile();
       setDeck();
       setLeague();
    }

    /**
     * Max xp double.
     *
     * @param level the level
     * @return the double
     */
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

    /**
     * Sets profile.
     */
    public void setProfile()
    {

        File imageFile = new File("out/defultpfp.jpg");
        try {
          Image  image = new Image(new FileInputStream(imageFile));
            ProfileHolder.setFill(new ImagePattern(image));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets labels.
     */
    void setLabels()
    {
        levelLabel.setText("LEVEL");
        xpLabel.setText("XP : "+player.getXp()+"/"+maxXP(player.getLevel()));
        settingLabel.setText("Setting");
        goBackLabel.setText("GO BACK!!!");
    }

    /**
     * Sets league.
     */
    public void setLeague()
    {
        switch (player.getLevel())
        {
            case 1:
                leaguePhoto.setImage(new Image("Liga1.png"));
                break;
                case 2:
                leaguePhoto.setImage(new Image("Liga2.png"));
                break;
                case 3:
                leaguePhoto.setImage(new Image("Liga3.png"));
                break;
                case 4:
                leaguePhoto.setImage(new Image("Liga4.png"));
                break;
                case 5:
                leaguePhoto.setImage(new Image("Liga5.png"));
                break;

        }
    }

    /**
     * Sets deck.
     */
    void setDeck()
    {
        addSlots();
        if(player.getBattleDeck().getCards().size()==8){
            int i =0;
        for(Card card:player.getBattleDeck().getCards())
        {
            if (card instanceof Archer){
                slots.get(i).setImage(new Image("archer_00000.png"));
            }
            else if (card instanceof BabyDragon){
                slots.get(i).setImage((new Image("babyDragon_00000.png")));
            }
            else if (card instanceof Barbarian){
                slots.get(i).setImage(new Image("barbarian_00000.png"));
            }
            else if (card instanceof Giant){
                slots.get(i).setImage(new Image("giant_00000.png"));
            }
             else if (card instanceof MiniPekka){
                slots.get(i).setImage(new Image("miniPekka_00000.png"));
             }
            else if (card instanceof Valkyrie){
                slots.get(i).setImage(new Image("valkyrie_00000.png"));
            }
            else if (card instanceof Wizard){
                slots.get(i).setImage(new Image("wizard_00000.png"));
            }
            else if (card instanceof Arrows){
                slots.get(i).setImage(new Image("arrows_00000.png"));
            }
            else if (card instanceof Fireball){
                slots.get(i).setImage(new Image("fireball_00000.png"));
            }
            else if (card instanceof Rage){
                slots.get(i).setImage(new Image("rage_00000.png"));
            }
            else if (card instanceof Cannon){
                slots.get(i).setImage(new Image("canon_00000.png"));
            }
            else if (card instanceof InfernoTower){
                slots.get(i).setImage(new Image("inferno_00000.png"));
            }
           i++;
        }
        }
        else
        {
           for(ImageView slot:slots)
               slot.setImage(new Image("kart.png"));
        }
    }

    /**
     * Add slots.
     */
    void addSlots()
    {
        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);
        slots.add(slot5);
        slots.add(slot6);
        slots.add(slot7);
        slots.add(slot8);
    }

    /**
     * Fade in.
     *
     * @param label the label
     */
    void fadeIn(Label label)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),label);
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
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),label);
        ft.setFromValue(label.getOpacity());
        ft.setToValue(0.0);
        ft.play();
    }
}
