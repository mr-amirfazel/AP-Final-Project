package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;

import java.io.Serializable;

public class MiniPekka extends Troops implements Serializable {

    public MiniPekka() {
        super(600, 325, 1.8, "Fast", "Ground", "Melee", false, 1, 4,new Image("miniPekka_00000.png"));
    }
}
