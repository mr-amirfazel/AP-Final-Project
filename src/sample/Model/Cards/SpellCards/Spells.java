package sample.Model.Cards.SpellCards;

import javafx.scene.image.Image;
import sample.Model.Cards.Card;

import java.io.Serializable;

public abstract class Spells extends Card implements Serializable {
    String ability;
    double radius;
    int cost;


    public Spells(String ability, double radius, int cost, String url) {
        super(url);
        this.ability = ability;
        this.radius = radius;
        this.cost = cost;
    }

}

