package sample.Model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import sample.Model.Cards.BuildingCards.Cannon;
import sample.Model.Cards.BuildingCards.InfernoTower;
import sample.Model.Cards.Card;
import sample.Model.Cards.TroopCards.*;


public class Spawn {
    private final Card card;
    private Point2D point2D;
    private Image element;

    public Spawn(Card card, Point2D point2D) {
        this.card = card;
        this.point2D = point2D;
        setElement();
    }



    public Card getCard() {
        return card;
    }

    public Point2D getPoint2D() {
        return point2D;
    }

    public void setPoint2D(Point2D point2D) {
        this.point2D = point2D;
    }

    private void setElement()
    {
        if(card instanceof Valkyrie)
            element = new Image("valkyrie.png", 60, 75, false, false);
        else if(card instanceof Archer)
            element = new Image("archer.png", 60, 75, false, false);
        else if(card instanceof Barbarian)
            element = new Image("barbar.png", 60, 75, false, false);
        else if(card instanceof BabyDragon)
            element = new Image("babyDragon", 60, 75, false, false);
        else if(card instanceof Giant)
            element = new Image("giant.png", 60, 75, false, false);
        else if( card instanceof  Wizard)
            element = new Image("wizard.png", 60, 75, false, false);
        else if(card instanceof MiniPekka)
            element = new Image("miniPekka.png", 60, 75, false, false);
        else if(card instanceof Cannon)
            element = new Image("Buildings/cannon.png", 60, 75, false, false);
        else if(card instanceof InfernoTower)
            element = new Image("Buildings/inferno.png", 60, 75, false, false);

    }

    public Image getElement() {
        return element;
    }
}
