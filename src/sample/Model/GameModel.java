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

                if (image.getUrl().equals(archer.getUrl()))
                    card = new Archer();

              if (image.getUrl().equals(arrows.getUrl()))
                    card = new Arrows();

              if (image.getUrl().equals(babyDragon.getUrl()))
                    card = new BabyDragon();

                if (image.getUrl().equals(canon.getUrl()))
                    card = new Cannon();

                 if (image.getUrl().equals(fireball.getUrl()))
                    card = new Fireball();
                   if (image.getUrl().equals(giant.getUrl()))
                    card = new Giant();
                if (image.getUrl().equals(inferno.getUrl()))
                    card = new InfernoTower();

                  if (image.getUrl().equals(miniPekka.getUrl()))
                    card = new MiniPekka();

                  if (image.getUrl().equals(rage.getUrl()))
                    card = new Rage();

                     if (image.getUrl().equals(valkyrie.getUrl()))
                     card = new Valkyrie();

                    if (image.getUrl().equals(wizard.getUrl()))
                    card = new Wizard();

            return card;
    }
    public String getUrl(Image image)
    {
            String url = "";

                if (image.getUrl().equals(archer.getUrl()))
                   url = "archer.png";

              if (image.equals(arrows))


              if (image.getUrl().equals(babyDragon.getUrl()))
                  url = "babyDragon.png";

                if (image.getUrl().equals(archer.getUrl()))
                    url = "archer.png";
                else if(image.getUrl().equals(babyDragon.getUrl()))
                    url = "babyDragon.png";
                else if(image.getUrl().equals(barbarian.getUrl()))
                    url ="barbar.png";
                else if(image.getUrl().equals(valkyrie.getUrl()))
                    url ="valkyrie.png";
                else if(image.getUrl().equals(giant.getUrl()))
                    url ="giant.png";
                else if(image.getUrl().equals(miniPekka.getUrl()))
                    url ="miniPekka.png";
                else if(image.getUrl().equals(wizard.getUrl()))
                    url ="wizard.png";
                else if(image.getUrl().equals(canon.getUrl()))
                    url ="Buildings/cannon.png";
                else if(image.getUrl().equals(inferno.getUrl()))
                    url ="Buildings/inferno.png";

            return url;
    }

}
