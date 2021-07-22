package sample.Model.Cards.Towers;

import sample.Model.Cards.Card;

public abstract class Towers extends Card {
    double range;
    double hitSpeed;
    int HP;
    int damage;

    public Towers(double range, double hitSpeed, int HP, int damage) {
        super(0, null);
        this.range = range;
        this.hitSpeed = hitSpeed;
        this.HP = HP;
        this.damage = damage;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getHitSpeed() {
        return hitSpeed;
    }

    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
