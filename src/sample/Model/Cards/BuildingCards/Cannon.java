package sample.Model.Cards.BuildingCards;

import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Cannon.
 */
public class Cannon extends Buildings implements Serializable {

    /**
     * Instantiates a new Cannon.
     */
    public Cannon() {
        super(info.getCannonHP(SharedData.getInstance().player.getLevel()), info.getCannonDamage(SharedData.getInstance().player.getLevel()), 0.8, "Ground", "5.5", 30, 6, "canon_00000.png");
    }
}
