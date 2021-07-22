package sample.Model.Cards.SpellCards;

import javafx.scene.image.Image;
import sample.Model.SharedData;
import sample.Model.info;

import java.io.Serializable;

public class Fireball extends Spells implements Serializable {
    int areaDamage;


    public Fireball() {
        super("damage", 2.5, 4, "fireball_00000.png");
//        ability = "damage";//Incinerates a small area, dealing high damage. Reduced damage to Crown Towers.
        this.areaDamage = info.getFireballAreaDamage(SharedData.getInstance().player.getLevel());
    }

    public void setAreaDamage(int areaDamage) {
        this.areaDamage = areaDamage;
    }
}
