package sample.Model.Cards.TroopCards;


import java.io.Serializable;

public class Archer extends Troops implements Serializable {

    public Archer() {
        super(125, 33, 1.2, "Medium", "Air&Ground", "5", false, 2, 3);
    }
}
