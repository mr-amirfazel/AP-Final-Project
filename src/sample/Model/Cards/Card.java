package sample.Model.Cards;

import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Card implements Serializable {
    private final String imageUrl;
    private int cost;


    public Card(int cost, String imageUrl) {
        this.cost = cost;
        this.imageUrl = imageUrl;

    }

    public int getCost() {
        return cost;
    }

    public Image getImage() {
        return new Image(imageUrl);
    }


}











