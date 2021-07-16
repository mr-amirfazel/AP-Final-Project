package sample.Model.Cards.SpellCards;

import java.io.Serializable;

public class Fireball extends Spells implements Serializable {
    double areaDamage;


    public Fireball() {
        super("damage", 2.5, 4);
//        ability = "damage";//Incinerates a small area, dealing high damage. Reduced damage to Crown Towers.
        this.areaDamage = 325;
    }

    public void setAreaDamage(double areaDamage) {
        this.areaDamage = areaDamage;
    }
}
