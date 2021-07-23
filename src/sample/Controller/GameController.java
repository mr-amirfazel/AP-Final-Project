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
import sample.Model.Cards.SpellCards.Spells;
import sample.Model.Cards.Towers.ArcherTower;
import sample.Model.Cards.Towers.KingTower;
import sample.Model.Cards.TroopCards.Troops;

import java.net.URL;
import java.util.*;

/**
 * The type Game controller.
 */
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
    @FXML
    private Label elixirLabel;


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
    private long prevTime = 0;
    private int minutes = 0;
    private int seconds = 0;
    private int elixirCount = 0;
    private Bot bot;
    private KingTower kingTower = new KingTower();
    private KingTower kingTowerB = new KingTower();

    private ArcherTower archerTowerRight = new ArcherTower();
    private ArcherTower archerTowerRightB = new ArcherTower();
    private ArcherTower archerTowerLeft = new ArcherTower();
    private ArcherTower archerTowerLeftB = new ArcherTower();



    //    public Card anyCard() {
//        int index = randomGenerator.nextInt(cards.size());
//        return cards.get(index);
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGameDeck();
        gc = canvas.getGraphicsContext2D();
        determineBot();
//        initTowers();
        startTimer();
    }

    /**
     * Determine bot.
     */
    void determineBot() {
        DummyBot dummyBot = new DummyBot();
        AverageBot averageBot = new AverageBot();
        int r = new Random().nextInt(2);
        if (r == 0) {
            bot = dummyBot;
            System.out.println("bot is dummy");
        } else {
            bot = averageBot;
            System.out.println("bot is average");
        }
    }

    /**
     * Init towers.
     */
    void initTowers() {
        kingTower = new KingTower();
        kingTowerB = new KingTower();
        archerTowerRight = new ArcherTower();
        archerTowerRightB = new ArcherTower();
        archerTowerLeft = new ArcherTower();
        archerTowerLeftB = new ArcherTower();
    }

    /**
     * Ground click.
     *
     * @param mouseEvent the mouse event
     */
    @FXML
    public void groundClick(MouseEvent mouseEvent) {


        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        System.out.println("x :" + x);
        System.out.println("y :" + y);
    }

    /**
     * Init game deck.
     */
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

    /**
     * Sets next photo.
     */
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

    /**
     * Go back.
     *
     * @param event the event
     */
    @FXML
    void goBack(MouseEvent event) {
        new SceneLoader().goToTrainingCamp(event);
    }

    /**
     * Slot 1 click.
     *
     * @param event the event
     */
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

    /**
     * Slot 2 click.
     *
     * @param event the event
     */
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

    /**
     * Slot 3 click.
     *
     * @param event the event
     */
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

    /**
     * Slot 4 click.
     *
     * @param event the event
     */
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

    /**
     * Slot 1 exit.
     *
     * @param event the event
     */
    @FXML
    void slot1Exit(MouseEvent event) {
        if (!(slot1.getEffect() instanceof DropShadow))
            slot1.setEffect(null);
    }

    /**
     * Slot 1 hover.
     *
     * @param event the event
     */
    @FXML
    void slot1Hover(MouseEvent event) {
        addGlow(slot1);
    }

    /**
     * Slot 2 exit.
     *
     * @param event the event
     */
    @FXML
    void slot2Exit(MouseEvent event) {
        if (!(slot2.getEffect() instanceof DropShadow))
            slot2.setEffect(null);
    }

    /**
     * Slot 2 hover.
     *
     * @param event the event
     */
    @FXML
    void slot2Hover(MouseEvent event) {
        addGlow(slot2);
    }

    /**
     * Slot 3 exit.
     *
     * @param event the event
     */
    @FXML
    void slot3Exit(MouseEvent event) {
        if (!(slot3.getEffect() instanceof DropShadow))
            slot3.setEffect(null);
    }

    /**
     * Slot 3 hover.
     *
     * @param event the event
     */
    @FXML
    void slot3Hover(MouseEvent event) {
        addGlow(slot3);
    }

    /**
     * Slot 4 exit.
     *
     * @param event the event
     */
    @FXML
    void slot4Exit(MouseEvent event) {
        if (!(slot4.getEffect() instanceof DropShadow))
            slot4.setEffect(null);
    }

    /**
     * Slot 4 hover.
     *
     * @param event the event
     */
    @FXML
    void slot4Hover(MouseEvent event) {
        addGlow(slot4);
    }

    /**
     * Add drop shadow.
     *
     * @param slot the slot
     */
    void addDropShadow(ImageView slot) {
        slot.setEffect(new DropShadow(0.0, -3, 3, Color.RED));
        for (ImageView imageSlot : slots
        ) {
            if (!slot.equals(imageSlot)) {
                imageSlot.setEffect(null);
            }
        }
    }

    /**
     * Add glow.
     *
     * @param slot the slot
     */
    void addGlow(ImageView slot) {
        if (slot.getEffect() == null)
            slot.setEffect(new Glow(0.3));

    }

    /**
     * Alter elixir.
     *
     * @param slot the slot
     */
    void alterElixir(ImageView slot) {
        if (gameModel.getCardByDirectory(slot.getImage()).getCost() <= elixirCount) {
            elixirCount -= gameModel.getCardByDirectory(slot.getImage()).getCost();
            elixirBar.setProgress(elixirBar.getProgress() - gameModel.getCardByDirectory(slot.getImage()).getCost() * 0.07);
        }
    }


    /**
     * Spawn character.
     *
     * @param event the event
     */
    @FXML
    void spawnCharacter(MouseEvent event) {
        if (event.getY() > 228) {
            Point2D point2D = new Point2D(event.getX(), event.getY());
            boolean photoChange = false;
            if (slot1Selected) {
                alterElixir(slot1);
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot1.getImage()), gameModel.getUrl(slot1.getImage()), point2D, 1));
                slot1.setImage(upComingPhoto.getImage());
                photoChange = true;
                slot1Selected = false;
                slot1.setEffect(null);
                botMove(point2D);

            }
            if (slot2Selected) {
                alterElixir(slot2);
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot2.getImage()), gameModel.getUrl(slot2.getImage()), point2D, 1));
                slot2Selected = false;
                slot2.setEffect(null);
                slot2.setImage(upComingPhoto.getImage());
                photoChange = true;
                botMove(point2D);
            }
            if (slot3Selected) {
                alterElixir(slot3);
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot3.getImage()), gameModel.getUrl(slot3.getImage()), point2D, 1));
                slot3Selected = false;
                slot3.setEffect(null);
                slot3.setImage(upComingPhoto.getImage());
                photoChange = true;
                botMove(point2D);
            }
            if (slot4Selected) {
                alterElixir(slot4);
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot4.getImage()), gameModel.getUrl(slot4.getImage()), point2D, 1));
                slot4Selected = false;
                slot4.setEffect(null);
                slot4.setImage(upComingPhoto.getImage());
                photoChange = true;
                botMove(point2D);
            }

            if (photoChange)
                setNextPhoto();
            System.out.println(spawnCharacters.size());
        }
    }

    /**
     * Start timer.
     */
    void startTimer() {
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                String opponent ="";
                if(bot instanceof DummyBot)
                    opponent = "DummyBot";
                else
                    opponent ="AverageBot";
                if (timerLabel.getText().equals("03:00")){
                    this.stop();
                    System.out.println("timer is stopped");
                    if(Integer.parseInt(redScore.getText())<Integer.parseInt(blueScore.getText()))
                    {
                        player.getHistory().add(new BattleHistory(opponent,"win"));
                        player.increaseXP(200);
                    }
                    else{
                        player.getHistory().add(new BattleHistory(opponent,"lost"));
                        player.increaseXP(70);

                    }
                }
                if(redScore.getText().equals("3"))
                {
                    player.getHistory().add(new BattleHistory(opponent,"lost"));
                    player.increaseXP(70);
                    new DataBase().savePlayer(player);
                }
                else if(blueScore.getText().equals("3"))
                {
                    player.getHistory().add(new BattleHistory(opponent,"win"));
                    player.increaseXP(200);
                    new DataBase().savePlayer(player);
                }
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                manageGameTimer(currentNanoTime);


                Image ground = new Image("ground.png", 400, 500, false, false);

                Image archerB = new Image("Buildings/archerTowerB.png", 60, 75, false, false);
                Image archerR = new Image("Buildings/archerR.png", 60, 75, false, false);

                Image kingR = new Image("Buildings/kingR.png", 70, 85, false, false);
                Image kingB = new Image("Buildings/kingTowerB.png", 70, 85, false, false);

                Image destroyed = new Image("Buildings/Destroy.png", 60, 75, false, false);

                    int blueCrown =0;
                    int redCrown =0;

                gc.drawImage(ground, 0, 0);
                if (kingTower.getHP() >= 0)
                    gc.drawImage(kingB, 165, 330);
                else{
                    gc.drawImage(destroyed, 165, 330);
                    redCrown++;
                }
                if (kingTowerB.getHP() >= 0)
                    gc.drawImage(kingR, 165, 16);
                else{
                    gc.drawImage(destroyed, 165, 16);
                    blueCrown++;
                }

                if (archerTowerLeftB.getHP() >= 0)
                    gc.drawImage(archerR, 83, 75);
                else{
                    gc.drawImage(destroyed, 83, 75);
                    blueCrown++;
                }
                if (archerTowerRightB.getHP() >= 0)
                    gc.drawImage(archerR, 255, 75);
                else{
                    gc.drawImage(destroyed, 225, 75);
                    blueCrown++;
                }
                if (archerTowerLeft.getHP() >= 0)
                    gc.drawImage(archerB, 80, 290);
                else{
                    gc.drawImage(destroyed, 80, 290);
                    redCrown++;
                }
                if (archerTowerRight.getHP() >= 0)
                    gc.drawImage(archerB, 250, 290);
                else{
                    gc.drawImage(destroyed, 250, 290);
                    redCrown++;
                }
                blueScore.setText(blueCrown+"");
                redScore.setText(redCrown+"");

                Iterator<Spawn> it = spawnCharacters.iterator();


                while (it.hasNext()) {
                    Spawn spawn = it.next();

                    int i = spawn.getVelocity() * 5;
                    if (!(spawn.getCard() instanceof Spells)) {
                        Image image = new Image(spawn.getImageURL(), 60, 75, false, false);
                        if (spawn.getCard() instanceof Buildings)
                            gc.drawImage(image, spawn.getPoint2D().getX(), spawn.getPoint2D().getY());

                        else {
                            checkPlayerDistance(spawn);
                            if (((Troops) spawn.getCard()).getHP() <= 0){
                                it.remove();
                            }
                            if (!attackOnArcherTower(spawn, image)) {
                                gc.drawImage(image, spawn.getPoint2D().getX(), spawn.getPoint2D().getY());
//                                if (archerTowerRight.getHP() < 0 && spawn.getPoint2D().getX() > 196) {
//                                    spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX() - Math.abs(i), spawn.getPoint2D().getY()));
//                                    attackOnKingTower(spawn, image);
//                                } else if (archerTowerLeft.getHP() < 0 && spawn.getPoint2D().getX() < 196) {
//                                    spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX() + Math.abs(i), spawn.getPoint2D().getY()));
//                                    attackOnKingTower(spawn, image);
//                                } else if (archerTowerRightB.getHP() < 0 && spawn.getPoint2D().getX() > 196) {
//                                    spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX() - Math.abs(i), spawn.getPoint2D().getY()));
//                                    attackOnKingTower(spawn, image);
//                                } else if (archerTowerLeftB.getHP() < 0 && spawn.getPoint2D().getX() < 196) {
//                                    spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX() + Math.abs(i), spawn.getPoint2D().getY()));
//                                    attackOnKingTower(spawn, image);
//                                } else {
                                    if (spawn.getPoint2D().getY() > 288) {

                                        spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX(), spawn.getPoint2D().getY() - i));
                                    } else if ((spawn.getPoint2D().getY() <= 288) || (spawn.getPoint2D().getY() >= 232)) {
                                        if (!(((spawn.getPoint2D().getX() >= 99) && (spawn.getPoint2D().getX() <= 126)) || ((spawn.getPoint2D().getX() >= 270) && (spawn.getPoint2D().getX() <= 298)))) {
                                            if (spawn.getPoint2D().getX() < 99)
                                                spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX() + Math.abs(i), spawn.getPoint2D().getY()));
                                            else if (spawn.getPoint2D().getX() > 298)
                                                spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX() - Math.abs(i), spawn.getPoint2D().getY()));
                                            else if ((spawn.getPoint2D().getX() - 126) < (spawn.getPoint2D().getX() - 270))
                                                spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX() - Math.abs(i), spawn.getPoint2D().getY()));
                                            else
                                                spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX() + Math.abs(i), spawn.getPoint2D().getY()));

                                        } else
                                            spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX(), spawn.getPoint2D().getY() - i));
                                    } else
                                        //testComment
                                        spawn.setPoint2D(new Point2D(spawn.getPoint2D().getX(), spawn.getPoint2D().getY() - i));

                                }
//                            }
                        }
                    }
                }


            }
        }.start();
    }

    private boolean attackOnArcherTower(Spawn spawn, Image image) {
        boolean doesAttack = false;
//        Image destroyed = new Image("Buildings/Destroy.png", 60, 75, false, false);

        if ((sharedData.archerTowerLeft.distance(spawn.getPoint2D()) <= 7.5) || (sharedData.archerTowerRight.distance(spawn.getPoint2D()) <= 7.5)) {
            if (spawn.getVelocity() < 0) {
                if (sharedData.archerTowerLeft.distance(spawn.getPoint2D()) <= 7.5) {
                    if (archerTowerLeft.getHP() > 0) {
                        gc.drawImage(image, spawn.getPoint2D().getX(), spawn.getPoint2D().getY());
                        if (spawn.getCard() instanceof Troops) {
                            archerTowerLeft.setHP(archerTowerLeft.getHP() - ((Troops) spawn.getCard()).getDamage());
                            ((Troops) spawn.getCard()).setHP(((Troops) spawn.getCard()).getHP() - archerTowerLeft.getDamage());
                            System.out.println("archerLeft" + archerTowerLeft.getHP());
                            doesAttack = true;

                        }
                    }

                } else if (sharedData.archerTowerRight.distance(spawn.getPoint2D()) <= 7.5) {
                    if (archerTowerRight.getHP() > 0) {
                        gc.drawImage(image, spawn.getPoint2D().getX(), spawn.getPoint2D().getY());
                        if (spawn.getCard() instanceof Troops) {
                            archerTowerRight.setHP(archerTowerRight.getHP() - ((Troops) spawn.getCard()).getDamage());
                            ((Troops) spawn.getCard()).setHP(((Troops) spawn.getCard()).getHP() - archerTowerRight.getDamage());
                            System.out.println("archerRight" + archerTowerRight.getHP());
                            doesAttack = true;
                        }
                    }

//            System.out.println("salam");
                }
            }
        }
            if ((sharedData.archerTowerLeftB.distance(spawn.getPoint2D()) <= 7.5) || (sharedData.archerTowerRightB.distance(spawn.getPoint2D()) <= 7.5)) {
                if (spawn.getVelocity() > 0) {
                    if (sharedData.archerTowerLeftB.distance(spawn.getPoint2D()) <= 7.5) {
                        if (archerTowerLeftB.getHP() > 0) {
                            gc.drawImage(image, spawn.getPoint2D().getX(), spawn.getPoint2D().getY());
                            if (spawn.getCard() instanceof Troops) {
                                archerTowerLeftB.setHP(archerTowerLeftB.getHP() - ((Troops) spawn.getCard()).getDamage());
                                ((Troops) spawn.getCard()).setHP(((Troops) spawn.getCard()).getHP() - archerTowerLeftB.getDamage());
                                System.out.println("archerLeftB"+archerTowerLeftB.getHP());
                                doesAttack = true;
                            }
                        }

                    } else if (sharedData.archerTowerRightB.distance(spawn.getPoint2D()) <= 7.5) {
                        if (archerTowerRightB.getHP() > 0) {
                            gc.drawImage(image, spawn.getPoint2D().getX(), spawn.getPoint2D().getY());
                            if (spawn.getCard() instanceof Troops) {
                                archerTowerRightB.setHP(archerTowerRightB.getHP() - ((Troops) spawn.getCard()).getDamage());
                                ((Troops) spawn.getCard()).setHP(((Troops) spawn.getCard()).getHP() - archerTowerRightB.getDamage());
                                System.out.println("archerRightb"+archerTowerRightB.getHP());
                                doesAttack = true;
                            }
                        }
                    }
//            System.out.println("salam");

                }
            }
        return doesAttack;
        }

    /**
     * Attack on king tower.
     *
     * @param spawn the spawn
     * @param image the image
     */
    void attackOnKingTower(Spawn spawn , Image image){
        if(sharedData.KingTowerB.distance(spawn.getPoint2D())<=7)
        {
                if (spawn.getVelocity()>0)
                {
                    gc.drawImage(image,spawn.getPoint2D().getX()+(-1*Math.abs(spawn.getVelocity())),spawn.getPoint2D().getY());
                    if (spawn.getCard() instanceof Troops) {
                        kingTowerB.setHP(kingTowerB.getHP() - ((Troops) spawn.getCard()).getDamage());
                        ((Troops) spawn.getCard()).setHP(((Troops) spawn.getCard()).getHP() - kingTowerB.getDamage());
                    }
                }
        }
         if(sharedData.KingTower.distance(spawn.getPoint2D())<=7)
        {
                if (spawn.getVelocity()<0)
                {
                    gc.drawImage(image,spawn.getPoint2D().getX()+(-1*Math.abs(spawn.getVelocity())),spawn.getPoint2D().getY());
                    if (spawn.getCard() instanceof Troops) {
                        kingTower.setHP(kingTower.getHP() - ((Troops) spawn.getCard()).getDamage());
                        ((Troops) spawn.getCard()).setHP(((Troops) spawn.getCard()).getHP() - kingTower.getDamage());

                    }
                }
        }

    }

    /**
     * Bot move.
     *
     * @param point2D the point 2 d
     */
    void botMove(Point2D point2D) {
        Image image;
        Point2D point = null;
        String imageUrl = bot.getElement();
        image = new Image(imageUrl, 60, 70, false, false);
        if (bot instanceof DummyBot) {
            point = ((DummyBot) bot).getBotCoordinate();
        } else if (bot instanceof AverageBot) {
            point = ((AverageBot) bot).getBotCoordinate(point2D);
        }
        spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(image), imageUrl, point, -1));
    }

    /**
     * Manage game timer.
     *
     * @param currentNanoTime the current nano time
     */
    void manageGameTimer(long currentNanoTime) {
        long dt = currentNanoTime - prevTime;
        dt = dt / 1000000000;
        if (dt >= 1) {
            prevTime = currentNanoTime;
            timeTick();
            timerLabel.setText(displayTime());
        }

    }

    /**
     * Time tick.
     */
    void timeTick() {
        incrementSeconds();
        if (elixirBar.getProgress() < 1) {
            elixirBar.setProgress(elixirBar.getProgress() + 0.07);
            elixirCount++;
            if (elixirCount <= 10)
                elixirLabel.setText(elixirCount + "");
        }

        if (seconds == 0) {
            incrementMinutes();
        }
    }

    /**
     * Check player distance.
     *
     * @param spawn the spawn
     */
    void checkPlayerDistance(Spawn spawn) {
        Iterator<Spawn> chr = spawnCharacters.iterator();
        while (chr.hasNext()) {
            if(spawn.getCard() instanceof  Troops){
            Spawn player = chr.next();
            if (!player.equals(spawn)) {
                double distance = player.getPoint2D().distance(spawn.getPoint2D());
                if (distance < 4.00) {
                    Image img = new Image("bloodSplash.png", 40, 40, false, false);
                    if (spawn.getVelocity() != player.getVelocity()) {
                        System.out.println("folani said : salam");
                        gc.drawImage(img, spawn.getPoint2D().getX(), spawn.getPoint2D().getY());
                        ((Troops) spawn.getCard()).setHP(((Troops) spawn.getCard()).getHP() - ((Troops) player.getCard()).getDamage());
                        ((Troops) player.getCard()).setHP(((Troops) player.getCard()).getHP() - ((Troops) spawn.getCard()).getDamage());
                        }
                    }
                }
            }
        }
    }

    /**
     * Increment seconds.
     */
    void incrementSeconds() {
        seconds = (seconds + 1) % 60;
    }

    /**
     * Increment minutes.
     */
    void incrementMinutes() {
        minutes = (minutes + 1) % 60;
    }

    /**
     * Display time string.
     *
     * @return the string
     */
    String displayTime() {
        String min, sec;
        if (seconds < 10)
            sec = "0" + seconds;
        else
            sec = seconds + "";
        if (minutes < 10)
            min = "0" + minutes;
        else
            min = minutes + "";

        return min + ":" + sec;
    }
}