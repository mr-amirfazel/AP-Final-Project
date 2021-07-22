package sample.Model.Cards.TroopCards;


import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

public class Archer extends Troops implements Serializable {

    public Archer() {
        super(info.getArcherHP(SharedData.getInstance().player.getLevel()), info.getArcherDamage(SharedData.getInstance().player.getLevel()), 1.2, "Medium", "Air&Ground", "5", false, 2, 3, "archer_00000.png");
    }
}
