package sample.Model.Cards.BuildingCards;

import javafx.scene.image.Image;
import sample.Model.Cards.Card;

import java.io.Serializable;

/**
 * The type Buildings.
 */
public abstract class Buildings extends Card implements Serializable {
    /**
     * The Hp.
     */
    int HP;
    /**
     * The Damage.
     */
    int damage;
    /**
     * The Hit speed.
     */
    double hitSpeed;
    /**
     * The Target.
     */
    String target;//earth,air,both
    /**
     * The Range.
     */
    String range;//melee ranged
    /**
     * The Life time.
     */
    int lifeTime;
    /**
     * The Cost.
     */
    int cost;

    /**
     * Instantiates a new Buildings.
     *
     * @param HP       the hp
     * @param damage   the damage
     * @param hitSpeed the hit speed
     * @param target   the target
     * @param range    the range
     * @param lifeTime the life time
     * @param cost     the cost
     * @param url      the url
     */
    public Buildings(int HP, int damage, double hitSpeed, String target, String range, int lifeTime, int cost, String url) {
        super(cost, url);
        this.HP = HP;
        this.damage = damage;
        this.hitSpeed = hitSpeed;
        this.target = target;
        this.range = range;
        this.lifeTime = lifeTime;
        this.cost = cost;
    }


    /**
     * Sets hp.
     *
     * @param HP the hp
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
}

