package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Wizard.
 */
public class Wizard extends Troops implements Serializable {

    /**
     * Instantiates a new Wizard.
     */
    public Wizard() {
        super(info.getWizardHP(SharedData.getInstance().player.getLevel()), info.getWizardDamage(SharedData.getInstance().player.getLevel()), 1,"7", "Medium", "Medium", true, 1, 5, "wizard_00000.png");
    }
}
