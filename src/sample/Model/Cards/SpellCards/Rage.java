package sample.Model.Cards.SpellCards;

import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

/**
 * The type Rage.
 */
public class Rage extends Spells implements Serializable {
    /**
     * The Duration.
     */
    double duration;

    /**
     * Instantiates a new Rage.
     */
    public Rage() {
        super("increase 40%", 5, 3, "rage_00000.png");
//        ability = "increase 40%";//+40% Damage Boost +40% Speed Boost +40% Hit Speed Boost
        this.duration = info.getRageDuration(SharedData.getInstance().player.getLevel());
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }
}
