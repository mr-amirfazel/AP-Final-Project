package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;
import sample.Model.Cards.Card;

import java.io.Serializable;

/**
 * The type Troops.
 */
public abstract class Troops extends Card implements Serializable {

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
     * The Speed.
     */
    String speed;//slow medium fast
    /**
     * The Target.
     */
    String target;//earth,air,both
    /**
     * The Range.
     */
    String range;//melee ranged
    /**
     * The Area splash.
     */
    boolean areaSplash;//radius 1
    /**
     * The Count.
     */
    int count;
    /**
     * The Cost.
     */
    int cost;
    /**
     * The Image.
     */
    Image image;

    /**
     * Instantiates a new Troops.
     *
     * @param HP         the hp
     * @param damage     the damage
     * @param hitSpeed   the hit speed
     * @param speed      the speed
     * @param target     the target
     * @param range      the range
     * @param areaSplash the area splash
     * @param count      the count
     * @param cost       the cost
     * @param url        the url
     */
    public Troops(int HP, int damage, double hitSpeed, String speed, String target, String range, boolean areaSplash, int count, int cost, String url) {
        super(cost, url);
        this.HP = HP;
        this.damage = damage;
        this.hitSpeed = hitSpeed;
        this.speed = speed;
        this.target = target;
        this.range = range;
        this.areaSplash = areaSplash;
        this.count = count;
        this.cost = cost;

    }

//    public Troops(int hp, int damage, double hitSpeed, String fast, String ground, String melee, boolean areaSplash, int count, int cost) {
//        super();
//    }


    /**
     * Gets hp.
     *
     * @return the hp
     */
    public int getHP() {
        return HP;
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
     * Gets damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Gets hit speed.
     *
     * @return the hit speed
     */
    public double getHitSpeed() {
        return hitSpeed;
    }

    /**
     * Sets hit speed.
     *
     * @param hitSpeed the hit speed
     */
    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     * Gets target.
     *
     * @return the target
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets target.
     *
     * @param target the target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Gets range.
     *
     * @return the range
     */
    public String getRange() {
        return range;
    }

    /**
     * Sets range.
     *
     * @param range the range
     */
    public void setRange(String range) {
        this.range = range;
    }

    /**
     * Is area splash boolean.
     *
     * @return the boolean
     */
    public boolean isAreaSplash() {
        return areaSplash;
    }

    /**
     * Sets area splash.
     *
     * @param areaSplash the area splash
     */
    public void setAreaSplash(boolean areaSplash) {
        this.areaSplash = areaSplash;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int getCost() {
        return cost;
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }


}

