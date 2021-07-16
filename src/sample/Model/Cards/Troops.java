package sample.Model.Cards;

class Troops extends Card {

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

class Barbarian extends Troops {

    public Barbarian() {
        super(300, 75, 1.5, "Medium", "Ground", "Melee", false, 4, 5);
    }
}

class Archer extends Troops {

    public Archer() {
        super(125, 33, 1.2, "Medium", "Air&Ground", "5", false, 2, 3);
    }
}

class BabyDragon extends Troops {

    public BabyDragon() {
        super(800, 100, 1.8, "Fast", "Air&Ground", "3", true, 1, 4);
    }
}

class Wizard extends Troops {

    public Wizard() {
        super(340, 130, 1,"7", "Medium", "Medium", true, 1, 5);
    }
}

class MiniPekka extends Troops {

    public MiniPekka() {
        super(600, 325, 1.8,"Fast", "Ground", "Melee", false, 1, 4 );
    }
}

class Giant extends Troops {

    public Giant() {
        super(2000, 126, 1.5, "Slow", "Buildings", "Melee", false, 1, 5);
    }
}

class Valkyrie extends Troops {

    public Valkyrie() {
        super(880, 120, 1.5, "Medium", "Ground", "Melee", true, 1, 4 );
    }
}

