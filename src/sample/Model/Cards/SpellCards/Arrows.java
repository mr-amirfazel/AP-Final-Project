package sample.Model.Cards.SpellCards;

import javafx.scene.image.Image;

import java.io.Serializable;

public class Arrows extends Spells implements Serializable {
    double areaDamage;

    public Arrows() {
        super("damage", 4, 3, new Image("arrows_00000.png"));
//        ability = "damage";//Arrows pepper a large area, damaging everyone hit. Reduced damage to Crown Towers.
        this.areaDamage = 144;
    }

    public void setAreaDamage(double areaDamage) {
        this.areaDamage = areaDamage;
    }
}
