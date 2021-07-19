package sample.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Model.Cards.Card;
import sample.Model.Cards.TroopCards.Archer;
import sample.Model.Player;
import sample.Model.SharedData;

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

    private boolean slot1Selected = false;
    private boolean slot2Selected = false;
    private boolean slot3Selected = false;
    private boolean slot4Selected = false;

    private Random randomGenerator;
    private ArrayList<Card>cards;
    private ArrayList<Card>slotCards;
    private final SharedData sharedData = SharedData.getInstance();
    private final Player player = sharedData.player;

    public GameController(ArrayList<Card> cards) {
        this.cards = player.getBattleDeck().getCards();
        this.randomGenerator = new Random();
    }

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
        GraphicsContext gc = canvas.getGraphicsContext2D();
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

    @FXML
    public void slot1Click(MouseEvent event){
        slot1Selected = true;
    }

    @FXML
    public void slot2Click(MouseEvent event){

    }

    @FXML
    public void slot3Click(MouseEvent event){

    }

    @FXML
    public void slot4Click(MouseEvent event){

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
