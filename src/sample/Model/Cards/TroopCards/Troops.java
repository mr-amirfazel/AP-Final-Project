package sample.Model.Cards.TroopCards;

import javafx.scene.image.Image;
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
    Image image;

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

    public double getHitSpeed() {
        return hitSpeed;
    }

    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public boolean isAreaSplash() {
        return areaSplash;
    }

    public void setAreaSplash(boolean areaSplash) {
        this.areaSplash = areaSplash;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


}

