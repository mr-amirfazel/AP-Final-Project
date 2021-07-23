package sample.Model;

import javafx.geometry.Point2D;

import java.util.Random;

/**
 * The type Dummy bot.
 */
public class DummyBot extends Bot {

    private Random random;

    /**
     * Instantiates a new Dummy bot.
     */
    public DummyBot() {
       super();
        random = new Random();
    }

    /**
     * Gets bot coordinate.
     *
     * @return the bot coordinate
     */
    public Point2D getBotCoordinate() {
        int Y = random.nextInt(44)+90;
        int X = random.nextInt(264)+45;

        return  new Point2D(X,Y);
    }



}
