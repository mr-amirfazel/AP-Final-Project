package sample.Model.Cards.TroopCards;


import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Baby dragon.
 */
public class BabyDragon extends Troops implements Serializable {

    /**
     * Instantiates a new Baby dragon.
     */
    public BabyDragon() {
        super(info.getBabyDragonHP(SharedData.getInstance().player.getLevel()), info.getBabyDragonDamage(SharedData.getInstance().player.getLevel()), 1.8, "Fast", "Air&Ground", "3", true, 1, 4, "barbarian_00000.png");
    }
}
