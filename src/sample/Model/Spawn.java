package sample.Model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import sample.Model.Cards.BuildingCards.Cannon;
import sample.Model.Cards.BuildingCards.InfernoTower;
import sample.Model.Cards.Card;
import sample.Model.Cards.TroopCards.*;


/**
 * The type Spawn.
 */
public class Spawn {
    private final Card card;
    private String imageURL;
    private Point2D point2D;
    private int velocity;


    /**
     * Instantiates a new Spawn.
     *
     * @param card     the card
     * @param imageURL the image url
     * @param point2D  the point 2 d
     * @param velocity the velocity
     */
    public Spawn(Card card, String imageURL, Point2D point2D,int velocity) {
        this.card = card;
        this.imageURL = imageURL;
        this.point2D = point2D;
        this.velocity = velocity;

    }


    /**
     * Gets card.
     *
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    /**
     * Gets point 2 d.
     *
     * @return the point 2 d
     */
    public Point2D getPoint2D() {
        return point2D;
    }

    /**
     * Sets point 2 d.
     *
     * @param point2D the point 2 d
     */
    public void setPoint2D(Point2D point2D) {
        this.point2D = point2D;
    }


    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public int getVelocity() {
        return velocity;
    }
}
