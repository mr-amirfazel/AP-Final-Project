package sample.Model.Cards.BuildingCards;

import javafx.scene.image.Image;
import sample.Model.Cards.Card;

import java.io.Serializable;

public abstract class Buildings extends Card implements Serializable {
    int HP;
    int damage;
    double hitSpeed;
    String target;//earth,air,both
    String range;//melee ranged
    int lifeTime;
    int cost;

    public Buildings(int HP, int damage, double hitSpeed, String target, String range, int lifeTime, int cost, String url) {
        super(url);
        this.HP = HP;
        this.damage = damage;
        this.hitSpeed = hitSpeed;
        this.target = target;
        this.range = range;
        this.lifeTime = lifeTime;
        this.cost = cost;
    }




    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

