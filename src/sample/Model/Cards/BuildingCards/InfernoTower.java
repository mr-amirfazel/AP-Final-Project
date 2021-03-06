package sample.Model.Cards.BuildingCards;

import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Inferno tower.
 */
public class InfernoTower extends Buildings implements Serializable {

    /**
     * Instantiates a new Inferno tower.
     */
    public InfernoTower() {
        super(info.getInfernoHP(SharedData.getInstance().player.getLevel()), info.getInfernoDamage(SharedData.getInstance().player.getLevel()), 0.4, "Air&Ground", "6", 40, 5, "inferno_00000.png");
    }
}