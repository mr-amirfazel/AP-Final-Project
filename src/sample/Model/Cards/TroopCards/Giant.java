package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;
import sample.Model.Cards.TroopCards.Troops;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

public class Giant extends Troops implements Serializable {

    public Giant() {
        super(info.getGiantHP(SharedData.getInstance().player.getLevel()), info.getGiantDamage(SharedData.getInstance().player.getLevel()), 1.5, "Slow", "Buildings", "Melee", false, 1, 5, "giant_00000.png");
    }
}
