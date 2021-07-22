package sample.Model;

import javafx.geometry.Point2D;

import java.util.Random;

public abstract class Bot {
    protected String[] cardsUrl;
    private Random random;

    public Bot() {
        cardsUrl = new String[]{"archerB.png","babyDragonB.png","barbarianB.png","miniPekkaB.png","giantB.png","wizardB.png",
                "valkyrieB.png"};
        random = new Random();
    }


    public String getElement(){
        int index = random.nextInt(cardsUrl.length);
        return cardsUrl[index];
    }

}
