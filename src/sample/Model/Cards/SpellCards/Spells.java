package sample.Model.Cards.SpellCards;

import sample.Model.Cards.Card;

public abstract class Spells extends Card {
    String ability;
    double radius;
    int cost;

    public Spells(String ability, double radius, int cost) {
        this.ability = ability;
        this.radius = radius;
        this.cost = cost;
    }
}

