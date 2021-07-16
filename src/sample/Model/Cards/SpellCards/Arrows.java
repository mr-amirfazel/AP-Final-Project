package sample.Model.Cards.SpellCards;

public class Arrows extends Spells {
    double areaDamage;

    public Arrows() {
        super("damage", 4, 3);
//        ability = "damage";//Arrows pepper a large area, damaging everyone hit. Reduced damage to Crown Towers.
        this.areaDamage = 144;
    }

    public void setAreaDamage(double areaDamage) {
        this.areaDamage = areaDamage;
    }
}
