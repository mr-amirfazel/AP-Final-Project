package sample.Model.Cards.TroopCards;

import sample.Model.Cards.TroopCards.Troops;

import java.io.Serializable;

public class Barbarian extends Troops implements Serializable {

    public Barbarian() {
        super(300, 75, 1.5, "Medium", "Ground", "Melee", false, 4, 5);
    }
}