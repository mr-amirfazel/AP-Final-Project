package sample.Model.Cards.SpellCards;

import javafx.scene.image.Image;
import sample.Model.Cards.Card;

import java.io.Serializable;

/**
 * The type Spells.
 */
public abstract class Spells extends Card implements Serializable {
    /**
     * The Ability.
     */
    String ability;
    /**
     * The Radius.
     */
    double radius;
    /**
     * The Cost.
     */
    int cost;


    /**
     * Instantiates a new Spells.
     *
     * @param ability the ability
     * @param radius  the radius
     * @param cost    the cost
     * @param url     the url
     */
    public Spells(String ability, double radius, int cost, String url) {
        super(cost, url);
        this.ability = ability;
        this.radius = radius;
        this.cost = cost;
    }

}

