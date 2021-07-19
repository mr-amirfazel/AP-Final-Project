package sample.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import sample.Model.Cards.Card;
import sample.Model.Cards.TroopCards.Archer;
import sample.Model.GameModel;
import sample.Model.Player;
import sample.Model.SharedData;
import sample.Model.Spawn;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

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

    private boolean slot1Selected = false;
    private boolean slot2Selected = false;
    private boolean slot3Selected = false;
    private boolean slot4Selected = false;

    private Random randomGenerator;
    private ArrayList<Card>cards;
    private ArrayList<Card>slotCards;
    private final SharedData sharedData = SharedData.getInstance();
    private final Player player = sharedData.player;
    private GraphicsContext gc;
    private  ImageView[] slots;
    private ArrayList<Spawn> spawnCharacters = new ArrayList<>();
    private final GameModel gameModel = new GameModel();

    public Card anyCard() {
        int index = randomGenerator.nextInt(cards.size());
        return cards.get(index);
    }


    public void addToSlots(){
        boolean flag = true;
        if (slot1Selected){
            while  (flag){
                if (slotCards.contains(anyCard())){
                    anyCard();
                }
                else{
                    flag = false;
                }
            }


            slot1.setImage(anyCard().getImage());
            slotCards.add(anyCard());

        }
        if (slot2Selected){

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        Image ground = new Image("ground.png", 400, 500, false, false);
        gc.drawImage(ground, 0, 0);
         slots = new ImageView[]{slot1, slot2, slot3, slot4};
    }




    @FXML
    public void groundClick(MouseEvent mouseEvent) {




        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        System.out.println("x :" + x);
        System.out.println("y :" + y);
    }

    @FXML
    public void slot1Click(MouseEvent event){
        addDropShadow(slot1);
        slot1Selected = true;
        slot2Selected=slot3Selected=slot4Selected=false;

    }

    @FXML
    public void slot2Click(MouseEvent event){
        addDropShadow(slot2);
        slot2Selected = true;
        slot1Selected=slot3Selected=slot4Selected=false;
    }

    @FXML
    public void slot3Click(MouseEvent event){
        addDropShadow(slot3);
        slot3Selected = true;
        slot2Selected=slot1Selected=slot4Selected=false;
    }

    @FXML
    public void slot4Click(MouseEvent event){
        addDropShadow(slot4);
        slot4Selected = true;
        slot2Selected=slot3Selected=slot1Selected=false;
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
            Point2D point2D = new Point2D(event.getX(), event.getY());;
            if (slot1Selected){
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot1.getImage().getUrl()), point2D));
            }
            if (slot2Selected){
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot2.getImage().getUrl()), point2D));
            }
            if (slot3Selected){
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot3.getImage().getUrl()), point2D));
            }
            if (slot4Selected){
                spawnCharacters.add(new Spawn(gameModel.getCardByDirectory(slot4.getImage().getUrl()), point2D));
            }
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
