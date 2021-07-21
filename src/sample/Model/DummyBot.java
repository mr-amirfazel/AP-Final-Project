package sample.Model;

import javafx.geometry.Point2D;

import java.util.Random;

public class DummyBot extends Bot {
    private String[] cardsUrl;
    private Random random;

    public DummyBot() {
        cardsUrl = new String[]{"archerB.png","babyDragonB.png","barbarianB.png","Buildings/cannonB.png","miniPekkaB.png","giantB.png","wizardB.png",
        "valkyrieB.png","Buildings/inferno.png"};
        random = new Random();
    }
    public Point2D getBotCoordinate(){
            int Y = random.nextInt(64)+140;
            int X = random.nextInt(264)+45;

            return  new Point2D(X,Y);
    }
    public String getElement(){
       int index = random.nextInt(cardsUrl.length);
       return cardsUrl[index];
    }

}
