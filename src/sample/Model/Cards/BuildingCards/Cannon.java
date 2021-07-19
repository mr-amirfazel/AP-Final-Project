package sample.Model.Cards.BuildingCards;

import javafx.scene.image.Image;

import java.io.Serializable;

public class Cannon extends Buildings implements Serializable {

    public Cannon() {
        super(380, 60, 0.8, "Ground", "5.5", 30, 6, new Image("canon_00000.png"));
    }
}
