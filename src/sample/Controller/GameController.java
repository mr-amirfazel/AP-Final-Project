package sample.Controller;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import sample.Model.*;
import sample.Model.Cards.BuildingCards.Buildings;
import sample.Model.Cards.Card;
import sample.Model.Cards.SpellCards.Arrows;
import sample.Model.Cards.SpellCards.Fireball;
import sample.Model.Cards.SpellCards.Rage;
import sample.Model.Cards.SpellCards.Spells;

import java.net.URL;
import java.util.*;

public class GameController implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView slot1;
    @FXML
    private ImageView slot2;
    @FXML
    private ImageView slot3;
    @FXML
    private ImageView slot4;
    @FXML
    private ProgressBar elixirBar;
    @FXML
    private HBox gameDeck;
    @FXML
    private ImageView upComingPhoto;
    @FXML
    private Label blueScore;

    @FXML
    private Label redScore;
    @FXML
    private Label timerLabel;


    private boolean slot1Selected = false;
    private boolean slot2Selected = false;
    private boolean slot3Selected = false;
    private boolean slot4Selected = false;

    private Random randomGenerator;
    private ArrayList<Card> cards;
    private ArrayList<ImageView> slots;
    private final SharedData sharedData = SharedData.getInstance();
    private final Player player = sharedData.player;
    private GraphicsContext gc;
    private final ArrayList<Spawn> spawnCharacters = new ArrayList<>();
    private final GameModel gameModel = new GameModel();

    //    public Card anyCard() {
//        int index = randomGenerator.nextInt(cards.size());
//        return cards.get(index);
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGameDeck();
        gc = canvas.getGraphicsContext2D();
        Image ground = new Image("ground.png", 400, 500, false, false);
        Image archerB = new Image("Buildings/archerTowerB.png", 60, 75, false, false);
        Image archerR = new Image("Buildings/archerR.png", 60, 75, false, false);
        Image kingR = new Image("Buildings/kingR.png", 70, 85, false, false);
        Image kingB = new Image("Buildings/kingTowerB.png", 70, 85, false, false);
        gc.drawImage(ground, 0, 0);
        gc.drawImage(kingB, 165, 330);
        gc.drawImage(kingR, 165, 16);
        gc.drawImage(archerR, 83, 75);
        gc.drawImage(archerR, 255, 75);
        gc.drawImage(archerB, 80, 290);
        gc.drawImage(archerB, 250, 290);
        gc.drawImage(ground, 0, 0);
        startTimer();
    }


    @FXML
    public void groundClick(MouseEvent mouseEvent) {


        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        System.out.println("x :" + x);
        System.out.println("y :" + y);
    }

    void initGameDeck() {
        cards = player.getBattleDeck().getCards();
        slots = new ArrayList<>();
        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);
        Collections.shuffle(cards);
        for (int i = 0; i < 4; i++) {
            slots.get(i).setImage(cards.get(i).getImage());
        }
        setNextPhoto();
    }

    void setNextPhoto() {
        Image image;
        ImageView imageView;
        while (true) {
            Collections.shuffle(cards);
            image = cards.get(0).getImage();
            imageView = new ImageView(image);
            if (!isInSlots(image)) {
                upComingPhoto.setImage(image);
                break;
            }
        }


    }

    private boolean isInSlots(Image image) {
        boolean exists = false;
        for (ImageView imageView : slots) {
            if (imageView.getImage().getUrl().equals(image.getUrl())) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    @FXML
    void goBack(MouseEvent event) {
        new SceneLoader().goToTrainingCamp(event);
    }

    @FXML
    public void slot1Click(MouseEvent event) {
        if (!(slot1.getEffect() instanceof DropShadow)) {
            addDropShadow(slot1);
            slot1Selected = true;
            slot2Selected = slot3Selected = slot4Selected = false;
        } else if (slot1.getEffect() instanceof DropShadow) {
            slot1.setEffect(null);
            slot1Selected = slot2Selected = slot3Selected = slot4Selected = false;
        }

    }

    @FXML
    public void slot2Click(MouseEvent event) {
        if (!(slot2.getEffect() instanceof DropShadow)) {
            addDropShadow(slot2);
            slot2Selected = true;
            slot1Selected = slot3Selected = slot4Selected = false;
        } else if (slot2.getEffect() instanceof DropShadow) {
            slot2.setEffect(null);
            slot1Selected = slot2Selected = slot3Selected = slot4Selected = false;
        }
    }

    @FXML
    public void slot3Click(MouseEvent event) {
        if (!(slot3.getEffect() instanceof DropShadow)) {
            addDropShadow(slot3);
            slot3Selected = true;
            slot2Selected = slot1Selected = slot4Selected = false;
        } else if (slot3.getEffect() instanceof DropShadow) {
            slot3.setEffect(null);
            slot1Selected = slot2Selected = slot3Selected = slot4Selected = false;
        }
    }

    @FXML
    public void slot4Click(MouseEvent event) {
        if (!(slot4.getEffect() instanceof DropShadow)) {
            addDropShadow(slot4);
            slot4Selected = true;
            slot2Selected = slot3Selected = slot1Selected = false;
        } else if (slot4.getEffect() instanceof DropShadow) {
            slot4.setEffect(null);
            slot1Selected = slot2Selected = slot3Selected = slot4Selected = false;
        }
    }

    @FXML
    void slot1Exit(MouseEvent event) {
        if (!(slot1.getEffect() instanceof DropShadow))
            slot1.setEffect(null);
    }

    @FXML
    void slot1Hover(MouseEvent event) {
        addGlow(slot1);
    }

    @FXML
    void slot2Exit(MouseEvent event) {
        if (!(slot2.getEffect() instanceof DropShadow))
            slot2.setEffect(null);
    }

    @FXML
    void slot2Hover(MouseEvent event) {
        addGlow(slot2);
    }

    @FXML
    void slot3Exit(MouseEvent event) {
        if (!(slot3.getEffect() instanceof DropShadow))
            slot3.setEffect(null);
    }

    @FXML
    void slot3Hover(MouseEvent event) {
        addGlow(slot3);
    }

    @FXML
    void slot4Exit(MouseEvent event) {
        if (!(slot4.getEffect() instanceof DropShadow))
            slot4.setEffect(null);
    }

    @FXML
    void slot4Hover(MouseEvent event) {
        addGlow(slot4);
    }

    void addDropShadow(ImageView slot) {
        slot.setEffect(new DropShadow(0.0, -3, 3, Color.RED));
        for (ImageView imageSlot : slots
        ) {
            if (!slot.equals(imageSlot)) {
                imageSlot.setEffect(null);
            }
        }
    }

    void addGlow(ImageView slot) {
        if (slot.getEffect() == null)
            slot.setEffect(new Glow(0.3));

    }

    @FXML
    void spawnCharacter(MouseEvent event) {
        if (event.getY() > 228) {
            Point2D point2D = new Point2D(event.getX(), event.getY());
            boolean photoChange = false;
            if (slot1Selected) {
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot1.getImage()),gameModel.getUrl(slot1.getImage()), point2D));
                slot1Selected = false;
                slot1.setEffect(null);
                slot1.setImage(upComingPhoto.getImage());
                photoChange = true;
            }
            if (slot2Selected) {
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot2.getImage()),gameModel.getUrl(slot2.getImage()), point2D));
                slot2Selected = false;
                slot2.setEffect(null);
                slot2.setImage(upComingPhoto.getImage());
                photoChange = true;
            }
            if (slot3Selected) {
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot3.getImage()),gameModel.getUrl(slot3.getImage()), point2D));
                slot3Selected = false;
                slot3.setEffect(null);
                slot3.setImage(upComingPhoto.getImage());
                photoChange = true;
            }
            if (slot4Selected) {
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot4.getImage()),gameModel.getUrl(slot4.getImage()), point2D));
                slot4Selected = false;
                slot4.setEffect(null);
                slot4.setImage(upComingPhoto.getImage());
                photoChange = true;
            }

            if (photoChange)
                setNextPhoto();
            System.out.println(spawnCharacters.size());
        }
    }

    void startTimer() {
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                Image ground = new Image("ground.png", 400, 500, false, false);

                Image archerB = new Image("Buildings/archerTowerB.png", 60, 75, false, false);
                Image archerR = new Image("Buildings/archerR.png", 60, 75, false, false);
                Image kingR = new Image("Buildings/kingR.png", 70, 85, false, false);
                Image kingB = new Image("Buildings/kingTowerB.png", 70, 85, false, false);

                Image val = new Image("valkyrie.png", 60, 75, false, false);
                Image val2 = new Image("chr_valkyrie_sprite_071.png", 60, 75, false, false);

                gc.drawImage(ground, 0, 0);

                gc.drawImage(kingB, 165, 330);
                gc.drawImage(kingR, 165, 16);

                gc.drawImage(archerR, 83, 75);
                gc.drawImage(archerR, 255, 75);

                gc.drawImage(archerB, 80, 290);
                gc.drawImage(archerB, 250, 290);

                for (Spawn spawn : spawnCharacters) {
                    if (!(spawn.getCard() instanceof Spells))
                    {
                        Image image = new Image(spawn.getImageURL(), 60, 75, false, false);

                        if(spawn.getCard() instanceof Buildings)
                                gc.drawImage(image, spawn.getPoint2D().getX(),spawn.getPoint2D().getY());
                        else
                        {

                            gc.drawImage(image, spawn.getPoint2D().getX(),spawn.getPoint2D().getY());
                            if(spawn.getPoint2D().getY()>232)
                            spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX(),spawn.getPoint2D().getY()-1));
                            else if(spawn.getPoint2D().getY()==232) {
                                if (!(((spawn.getPoint2D().getX() >= 99) && (spawn.getPoint2D().getX() <= 126)) || ((spawn.getPoint2D().getX() >= 270) && (spawn.getPoint2D().getX() <= 298))))
                                {
                                    if(spawn.getPoint2D().getX()<99)
                                        spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX()+1,spawn.getPoint2D().getY()));
                                    else if(spawn.getPoint2D().getX()>298)
                                        spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX()-1,spawn.getPoint2D().getY()));
                                    else if((spawn.getPoint2D().getX()-126)<(spawn.getPoint2D().getX()-270))
                                        spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX()-1,spawn.getPoint2D().getY()));
                                    else
                                        spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX()+1,spawn.getPoint2D().getY()));

                                }
                                else
                                    spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX(),spawn.getPoint2D().getY()-1));
                            }
                            else
                                spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX(),spawn.getPoint2D().getY()-1));

                        }
                    }
                }


            }
        }.start();
    }
}
