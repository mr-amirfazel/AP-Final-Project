package sample.Model.Cards;

import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Card implements Serializable {
    private final String imageUrl;

    public Card(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Image getImage() {
        return new Image(imageUrl);
    }
}











