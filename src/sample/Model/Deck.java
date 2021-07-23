package sample.Model;

import sample.Model.Cards.Card;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Deck.
 */
public class Deck implements Serializable {

    private ArrayList<Card> cards;

    /**
     * Instantiates a new Deck.
     *
     * @param cards the cards
     */
    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Sets cards.
     *
     * @param cards the cards
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
}
