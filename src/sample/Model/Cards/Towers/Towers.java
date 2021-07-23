package sample.Model.Cards.Towers;

import sample.Model.Cards.Card;

/**
 * The type Towers.
 */
public abstract class Towers extends Card {
    /**
     * The Range.
     */
    double range;
    /**
     * The Hit speed.
     */
    double hitSpeed;
    /**
     * The Hp.
     */
    int HP;
    /**
     * The Damage.
     */
    int damage;

    /**
     * Instantiates a new Towers.
     *
     * @param range    the range
     * @param hitSpeed the hit speed
     * @param HP       the hp
     * @param damage   the damage
     */
    public Towers(double range, double hitSpeed, int HP, int damage) {
        super(0, null);
        this.range = range;
        this.hitSpeed = hitSpeed;
        this.HP = HP;
        this.damage = damage;
    }

    /**
     * Gets range.
     *
     * @return the range
     */
    public double getRange() {
        return range;
    }

    /**
     * Sets range.
     *
     * @param range the range
     */
    public void setRange(double range) {
        this.range = range;
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
}
