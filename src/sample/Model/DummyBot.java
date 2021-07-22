package sample.Model;

import javafx.geometry.Point2D;

import java.util.Random;

public class DummyBot extends Bot {

    private Random random;

    public DummyBot() {
       super();
        random = new Random();
    }

    public Point2D getBotCoordinate() {
        int Y = random.nextInt(44)+90;
        int X = random.nextInt(264)+45;

        return  new Point2D(X,Y);
    }



}
