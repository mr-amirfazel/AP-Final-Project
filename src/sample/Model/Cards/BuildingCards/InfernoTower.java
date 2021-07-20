package sample.Model.Cards.BuildingCards;

import javafx.scene.image.Image;

import java.io.Serializable;

public class InfernoTower extends Buildings implements Serializable {

    public InfernoTower() {
        super(800, 20, 0.4, "Air&Ground", "6", 40, 5, "inferno_00000.png");
    }
}