package sample.Model.Cards.SpellCards;

import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Arrows.
 */
public class Arrows extends Spells implements Serializable {
    /**
     * The Area damage.
     */
    int areaDamage;

    /**
     * Instantiates a new Arrows.
     */
    public Arrows() {
        super("damage", 4, 3, "arrows_00000.png");
//        ability = "damage";//Arrows pepper a large area, damaging everyone hit. Reduced damage to Crown Towers.
        this.areaDamage = info.getArrowsAreaDamage(SharedData.getInstance().player.getLevel());
    }

    /**
     * Sets area damage.
     *
     * @param areaDamage the area damage
     */
    public void setAreaDamage(int areaDamage) {
        this.areaDamage = areaDamage;
    }
}
