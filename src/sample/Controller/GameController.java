package sample.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
import sample.Model.Cards.Card;
import sample.Model.Cards.TroopCards.Archer;

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


    private boolean slot1Selected = false;
    private boolean slot2Selected = false;
    private boolean slot3Selected = false;
    private boolean slot4Selected = false;

    private Random randomGenerator;
//    private ArrayList<Card>cards;
    private ArrayList<ImageView>slots;
//    private final SharedData sharedData = SharedData.getInstance();
//    private final Player player = sharedData.player;
    private GraphicsContext gc;
    private final ArrayList<Spawn> spawnCharacters = new ArrayList<>();
    private final GameModel gameModel = new GameModel();

//    public Card anyCard() {
//        int index = randomGenerator.nextInt(cards.size());
//        return cards.get(index);
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slots = new ArrayList<>();
        slots.add(slot1);slots.add(slot2);slots.add(slot3);slots.add(slot4);
//        cards = player.getBattleDeck().getCards();
//        initGameDeck();
        gc = canvas.getGraphicsContext2D();
        Image ground = new Image("ground.png", 400, 500, false, false);
        gc.drawImage(ground, 0, 0);
    }




    @FXML
    public void groundClick(MouseEvent mouseEvent) {




        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        System.out.println("x :" + x);
        System.out.println("y :" + y);
    }
//    void initGameDeck()
//    {
//        slots.add(slot1);slots.add(slot2);slots.add(slot3);slots.add(slot4);
//        Collections.shuffle(cards);
//        for (int i = 0; i < 3; i++) {
//            slots.get(i).setImage(cards.get(i).getImage());
//        }
//        setNextPhoto();
//    }
//    void setNextPhoto()
//    {
//        Image image = cards.get(randomGenerator.nextInt(cards.size())).getImage();
//        ImageView imageView = new ImageView(image);
//        if(!(slots.contains(imageView)))
//            upComingPhoto.setImage(image);
//    }

    @FXML
    public void slot1Click(MouseEvent event){
        if(!(slot1.getEffect() instanceof DropShadow)){
        addDropShadow(slot1);
        slot1Selected = true;
        slot2Selected=slot3Selected=slot4Selected=false;
        }
        else if(slot1.getEffect() instanceof DropShadow)
        {
            slot1.setEffect(null);
            slot1Selected= slot2Selected=slot3Selected=slot4Selected=false;
        }

    }

    @FXML
    public void slot2Click(MouseEvent event){
        if(!(slot2.getEffect() instanceof DropShadow)){
            addDropShadow(slot2);
            slot2Selected = true;
            slot1Selected=slot3Selected=slot4Selected=false;
        }
        else if(slot2.getEffect() instanceof DropShadow)
        {
            slot2.setEffect(null);
            slot1Selected= slot2Selected=slot3Selected=slot4Selected=false;
        }
    }

    @FXML
    public void slot3Click(MouseEvent event){
        if(!(slot3.getEffect() instanceof DropShadow)){
            addDropShadow(slot3);
            slot3Selected = true;
            slot2Selected=slot1Selected=slot4Selected=false;
        }
        else if(slot3.getEffect() instanceof DropShadow)
        {
            slot3.setEffect(null);
            slot1Selected= slot2Selected=slot3Selected=slot4Selected=false;
        }
    }

    @FXML
    public void slot4Click(MouseEvent event){
        if(!(slot4.getEffect() instanceof DropShadow)){
            addDropShadow(slot4);
            slot4Selected = true;
            slot2Selected=slot3Selected=slot1Selected=false;
        }
        else if(slot4.getEffect() instanceof DropShadow)
        {
            slot4.setEffect(null);
            slot1Selected= slot2Selected=slot3Selected=slot4Selected=false;
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
    void addDropShadow(ImageView slot)
    {
            slot.setEffect(new DropShadow(0.0,-3,3, Color.RED));
        for (ImageView imageSlot:slots
             ) {
                if(!slot.equals(imageSlot))
                {
                    imageSlot.setEffect(null);
                }
        }
    }
    void addGlow(ImageView slot)
    {
        if(slot.getEffect()==null)
            slot.setEffect(new Glow(0.3));

    }
    @FXML
    void spawnCharacter(MouseEvent event) {
        if(event.getY()>228) {
            Point2D point2D = new Point2D(event.getX(), event.getY());
            boolean photoChange = false;
            if (slot1Selected){
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot1.getImage()), point2D));
                slot1Selected=false;
                slot1.setEffect(null);
                slot1.setImage(upComingPhoto.getImage());
                photoChange = true;
            }
            if (slot2Selected){
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot2.getImage()), point2D));
                slot2Selected=false;
                slot2.setEffect(null);
                slot2.setImage(upComingPhoto.getImage());
                photoChange = true;
            }
            if (slot3Selected){
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot3.getImage()), point2D));
                slot3Selected=false;
                slot3.setEffect(null);
                slot3.setImage(upComingPhoto.getImage());
                photoChange = true;
            }
            if (slot4Selected){
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot4.getImage()), point2D));
                slot4Selected=false;
                slot4.setEffect(null);
                slot4.setImage(upComingPhoto.getImage());
                photoChange = true;
            }

            if(photoChange)
//                setNextPhoto();
            System.out.println(spawnCharacters.size());
        }
    }


//    @FXML
//    void slot1Click(MouseEvent event) {
//        slot1.setEffect(getEffect());
//        delteEffects(slot1);
//        for (int row = 0; row < 15; row++) {
//            for (int col = 0; col < 18; col++) {
//                Image image =  new Image("grass.png");
//                map[row][col].setImage(image);
//            }
//        }
//
//
//    }


}
