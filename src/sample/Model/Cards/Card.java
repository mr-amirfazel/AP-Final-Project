package sample.Model.Cards;

import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Card implements Serializable {
    private Image image;

    public Card(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}











