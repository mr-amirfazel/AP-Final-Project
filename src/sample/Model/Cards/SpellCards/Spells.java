package sample.Model.Cards.SpellCards;

import sample.Model.Cards.Card;

import java.io.Serializable;

public abstract class Spells extends Card implements Serializable {
    String ability;
    double radius;
    int cost;

    public Spells(String ability, double radius, int cost) {
        this.ability = ability;
        this.radius = radius;
        this.cost = cost;
    }
}

