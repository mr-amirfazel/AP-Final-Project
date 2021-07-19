package sample.Model;

import javafx.geometry.Point2D;
import sample.Model.Cards.Card;



public class Spawn {
    private final Card card;
    private Point2D point2D;

    public Spawn(Card card, Point2D point2D) {
        this.card = card;
        this.point2D = point2D;
    }



    public Card getCard() {
        return card;
    }

    public Point2D getPoint2D() {
        return point2D;
    }

    public void setPoint2D(Point2D point2D) {
        this.point2D = point2D;
    }
}
