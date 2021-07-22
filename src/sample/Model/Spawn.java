package sample.Model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import sample.Model.Cards.BuildingCards.Cannon;
import sample.Model.Cards.BuildingCards.InfernoTower;
import sample.Model.Cards.Card;
import sample.Model.Cards.TroopCards.*;


public class Spawn {
    private final Card card;
    private String imageURL;
    private Point2D point2D;
    private int velocity;


    public Spawn(Card card, String imageURL, Point2D point2D,int velocity) {
        this.card = card;
        this.imageURL = imageURL;
        this.point2D = point2D;
        this.velocity = velocity;

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


    public String getImageURL() {
        return imageURL;
    }

    public int getVelocity() {
        return velocity;
    }
}
