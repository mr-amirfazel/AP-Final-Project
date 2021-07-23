package sample.Model.Cards;

import javafx.scene.image.Image;

import java.io.Serializable;

/**
 * The type Card.
 */
public abstract class Card implements Serializable {
    private final String imageUrl;
    private int cost;


    /**
     * Instantiates a new Card.
     *
     * @param cost     the cost
     * @param imageUrl the image url
     */
    public Card(int cost, String imageUrl) {
        this.cost = cost;
        this.imageUrl = imageUrl;

    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public Image getImage() {
        return new Image(imageUrl);
    }


}











