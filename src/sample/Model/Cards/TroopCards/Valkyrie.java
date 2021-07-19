package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;

import java.io.Serializable;

public class Valkyrie extends Troops implements Serializable {

    public Valkyrie() {
        super(880, 120, 1.5, "Medium", "Ground", "Melee", true, 1, 4, new Image("valkyrie_00000.png"));
    }
}
