package sample.Model.Cards.TroopCards;


import javafx.scene.image.Image;

import java.io.Serializable;

public class BabyDragon extends Troops implements Serializable {

    public BabyDragon() {
        super(800, 100, 1.8, "Fast", "Air&Ground", "3", true, 1, 4, new Image("barbarian_00000.png"));
    }
}
