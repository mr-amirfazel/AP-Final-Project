package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Mini pekka.
 */
public class MiniPekka extends Troops implements Serializable {

    /**
     * Instantiates a new Mini pekka.
     */
    public MiniPekka() {
        super(info.getMiniPekkaHP(SharedData.getInstance().player.getLevel()), info.getMiniPekkaDamage(SharedData.getInstance().player.getLevel()), 1.8, "Fast", "Ground", "Melee", false, 1, 4,"miniPekka_00000.png");
    }
}
