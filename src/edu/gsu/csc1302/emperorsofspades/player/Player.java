package edu.gsu.csc1302.emperorsofspades.player;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;

/**
 * Simulates a generic player in the game.
 * @author Roger Williams
 */
public abstract class Player {
    /**
     * The player's name.
     */
    private final String name;

    /**
     * The player's cards.
     */
    private final CardDeck cards = null;

    /**
     * Class constructor.
     * @param name the name of the player
     */
    public Player(final String name) {
        this.name = name;
    }

    /**
     * Returns the player's name.
     * @return player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a card to the given player's deck.
     * @param card the card to add.
     */
    public void addToCardDeck(final Card card) {
        this.cards.addToTop(card);
    }

    /**
     * Functionality for the player to play a card in a given hand.
     * Logic is differed to the concrete player implementations.
     * @return a card.
     */
    public abstract Card playCard();

    /**
     * Functionality for the player to play a card in a given hand.
     * @param index play the card at the given index.
     * @return a card.
     */
    public Card playCard(final int index) {
        return this.cards.remove(index);
    }

    /**
     * Returns the player's deck of cards.
     * @return deck of cards.s
     */
    protected CardDeck getCards() {
        if (this.cards == null) {
            throw new IllegalPlayerStateException("Player has no cards in hand.");
        }
        return this.cards;
    }

    /**
     * Allows a user to place a bid in a given hand.
     * Logic is differed to the concrete player implementations.
     * @return a bid [4, 10].
     */
    public abstract double placeBid();

    /**
     * Return the number of cards in the user's deck of cards.
     * @return # of cards
     */
    public int numOfCardsInDeck() {
        if (this.cards == null) {
            return 0;
        }
        return this.cards.size();
    }

    /**
     * Print-friendly string.
     * @return
     */
    public String toString() {
        return "[Player] Name: " + this.getName();
    }
}
