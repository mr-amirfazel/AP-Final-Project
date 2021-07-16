package sample.Model.Cards;

abstract class Spells extends Card {
    String ability;
    double radius;
    int cost;

    public Spells(String ability, double radius, int cost) {
        this.ability = ability;
        this.radius = radius;
        this.cost = cost;
    }
}

class Rage extends Spells {
    double duration;

    public Rage() {
        super("increase 40%", 5, 3);
//        ability = "increase 40%";//+40% Damage Boost +40% Speed Boost +40% Hit Speed Boost
        this.duration = 6;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}

class Fireball extends Spells {
    double areaDamage;


    public Fireball() {
        super("damage", 2.5, 4);
//        ability = "damage";//Incinerates a small area, dealing high damage. Reduced damage to Crown Towers.
        this.areaDamage = 325;
    }

    public void setAreaDamage(double areaDamage) {
        this.areaDamage = areaDamage;
    }
}

class Arrows extends Spells {
    double areaDamage;

    public Arrows() {
        super("damage", 4, 3);
//        ability = "damage";//Arrows pepper a large area, damaging everyone hit. Reduced damage to Crown Towers.
        this.areaDamage = 144;
    }

    public void setAreaDamage(double areaDamage) {
        this.areaDamage = areaDamage;
    }
}
