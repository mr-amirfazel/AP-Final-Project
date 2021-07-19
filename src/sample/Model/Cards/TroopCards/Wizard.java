package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;

import java.io.Serializable;

public class Wizard extends Troops implements Serializable {

    public Wizard() {
        super(340, 130, 1,"7", "Medium", "Medium", true, 1, 5, new Image("wizard_00000.png"));
    }
}
