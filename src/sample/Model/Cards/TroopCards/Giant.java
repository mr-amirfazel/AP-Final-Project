package sample.Model.Cards.TroopCards;

import sample.Model.Cards.TroopCards.Troops;

import java.io.Serializable;

public class Giant extends Troops implements Serializable {

    public Giant() {
        super(2000, 126, 1.5, "Slow", "Buildings", "Melee", false, 1, 5);
    }
}
