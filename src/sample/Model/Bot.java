package sample.Model;

import javafx.geometry.Point2D;

import java.util.Random;

/**
 * The type Bot.
 */
public abstract class Bot {
    /**
     * The Cards url.
     */
    protected String[] cardsUrl;
    private Random random;

    /**
     * Instantiates a new Bot.
     */
    public Bot() {
        cardsUrl = new String[]{"archerB.png","babyDragonB.png","barbarianB.png","miniPekkaB.png","giantB.png","wizardB.png",
                "valkyrieB.png"};
        random = new Random();
    }


    /**
     * Get element string.
     *
     * @return the string
     */
    public String getElement(){
        int index = random.nextInt(cardsUrl.length);
        return cardsUrl[index];
    }

}
