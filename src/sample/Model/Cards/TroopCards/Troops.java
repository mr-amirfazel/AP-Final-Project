package sample.Model.Cards.TroopCards;

import sample.Model.Cards.Card;

import java.io.Serializable;

public abstract class Troops extends Card implements Serializable {

    int HP;
    int damage;
    double hitSpeed;
    String speed;//slow medium fast
    String target;//earth,air,both
    String range;//melee ranged
    boolean areaSplash;//radius 1
    int count;
    int cost;

    public Troops(int HP, int damage, double hitSpeed, String speed, String target, String range, boolean areaSplash, int count, int cost) {

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

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

