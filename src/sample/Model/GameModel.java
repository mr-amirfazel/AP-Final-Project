package sample.Model;

import sample.Model.Cards.BuildingCards.Cannon;
import sample.Model.Cards.BuildingCards.InfernoTower;
import sample.Model.Cards.Card;
import sample.Model.Cards.SpellCards.Arrows;
import sample.Model.Cards.SpellCards.Fireball;
import sample.Model.Cards.SpellCards.Rage;
import sample.Model.Cards.TroopCards.*;

public class GameModel {
    public Card getCardByDirectory(String url)
    {
            Card card ;
            switch (url)
            {
                case "archer_00000.png":
                    card = new Archer();
                    break;
                case "arrows_00000.png.png":
                    card = new Arrows();
                    break;
                case "babyDragon_00000.png":
                    card = new BabyDragon();
                    break;
                case "barbarian_00000.png":
                        card = new Barbarian();
                    break;
                case "canon_00000.png":
                    card = new Cannon();
                    break;
                case "fireball_00000.png":
                    card = new Fireball();
                case "giant_00000.png":
                    card = new Giant();
                case "inferno_00000.png":
                    card = new InfernoTower();
                    break;
                case "miniPekka_00000.png":
                    card = new MiniPekka();
                    break;
                case "rage_00000.png":
                    card = new Rage();
                    break;
                case "valkyrie_00000.png":
                    card = new Valkyrie();
                    break;
                case "wizard_00000.png":
                    card = new Wizard();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + url);
            }
            return card;
    }
}
