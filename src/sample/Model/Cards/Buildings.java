package sample.Model.Cards;

class Buildings extends Card {
    int HP;
    int damage;
    double hitSpeed;
    String target;//earth,air,both
    String range;//melee ranged
    int lifeTime;
    int cost;

    public Buildings(int HP, int damage, double hitSpeed, String target, String range, int lifeTime, int cost) {
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

class Cannon extends Buildings {

    public Cannon() {
        super(380, 60, 0.8, "Ground", "5.5", 30, 6);
    }

}

class InfernoTower extends Buildings {

    public InfernoTower() {
        super(800, 20, 0.4, "Air&Ground", "6", 40, 5);
    }
}
