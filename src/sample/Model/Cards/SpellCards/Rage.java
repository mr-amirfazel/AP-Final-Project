package sample.Model.Cards.SpellCards;

public class Rage extends Spells {
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
