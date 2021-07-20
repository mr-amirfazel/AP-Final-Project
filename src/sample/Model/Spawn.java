package sample.Model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
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
            element = new Image("valkyrie.png");
        else if(card instanceof Archer)
            element = new Image("archer.png");
        else if(card instanceof Barbarian)
            element = new Image("barbar.png");
        else if(card instanceof BabyDragon)
            element = new Image("babyDragon");
        else if(card instanceof Giant)
            element = new Image("giant.png");
        else if( card instanceof  Wizard)
            element = new Image("wizard.png");
        else if(card instanceof MiniPekka)
            element = new Image("miniPekka.png");

    }
}
