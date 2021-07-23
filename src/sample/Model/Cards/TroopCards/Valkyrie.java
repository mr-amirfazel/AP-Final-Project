package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Valkyrie.
 */
public class Valkyrie extends Troops implements Serializable {

    /**
     * Instantiates a new Valkyrie.
     */
    public Valkyrie() {
        super(info.getValkyrieHP(SharedData.getInstance().player.getLevel()), info.getValkyrieDamage(SharedData.getInstance().player.getLevel()), 1.5, "Medium", "Ground", "Melee", true, 1, 4, "valkyrie_00000.png");
    }
}
