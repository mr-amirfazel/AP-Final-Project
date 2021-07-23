package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;
import sample.Model.Cards.TroopCards.Troops;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Barbarian.
 */
public class Barbarian extends Troops implements Serializable {

    /**
     * Instantiates a new Barbarian.
     */
    public Barbarian() {
        super(info.getBarbarianHP(SharedData.getInstance().player.getLevel()), info.getBarbarianDamage(SharedData.getInstance().player.getLevel()), 1.5, "Medium", "Ground", "Melee", false, 4, 5, "barbarian_00000.png");
    }
}
