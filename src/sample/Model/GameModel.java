package sample.Model;

import javafx.scene.image.Image;
import sample.Model.Cards.BuildingCards.Cannon;
import sample.Model.Cards.BuildingCards.InfernoTower;
import sample.Model.Cards.Card;
import sample.Model.Cards.SpellCards.Arrows;
import sample.Model.Cards.SpellCards.Fireball;
import sample.Model.Cards.SpellCards.Rage;
import sample.Model.Cards.TroopCards.*;

public class GameModel {
    private Image archer;
    private Image arrows;
    private Image babyDragon;
    private Image barbarian;
    private Image canon;
    private Image fireball;
    private Image giant;
    private Image inferno;
    private Image miniPekka;
    private Image rage;
    private Image valkyrie;
    private Image wizard;

    public GameModel() {
        archer = new Image("archer_00000.png");
        arrows = new Image("arrows_00000.png");
        babyDragon = new Image("babyDragon_00000.png");
        barbarian = new Image("barbarian_00000.png");
        canon = new Image("canon_00000.png");
        fireball = new Image("fireball_00000.png");
        giant = new Image("giant_00000.png");
        inferno = new Image("inferno_00000.png");
        miniPekka = new Image("miniPekka_00000.png");
        rage = new Image("rage_00000.png");
        valkyrie = new Image("valkyrie_00000.png");
        wizard = new Image("wizard_00000.png");
    }

    public Card getCardByDirectory(Image image)
    {
            Card card = null;

                if (image.equals(archer))
                    card = new Archer();

              if (image.equals(arrows))
                    card = new Arrows();

              if (image.equals(babyDragon))
                    card = new BabyDragon();

                if (image.equals(babyDragon))
                        card = new Barbarian();

                if (image.equals(canon))
                    card = new Cannon();

                 if (image.equals(fireball))
                    card = new Fireball();
                   if (image.equals(giant))
                    card = new Giant();
                if (image.equals(inferno))
                    card = new InfernoTower();

                  if (image.equals(miniPekka))
                    card = new MiniPekka();

                  if (image.equals(rage))
                    card = new Rage();

                     if (image.equals(valkyrie))
                     card = new Valkyrie();

                    if (image.equals(wizard))
                    card = new Wizard();


            return card;
    }
}
