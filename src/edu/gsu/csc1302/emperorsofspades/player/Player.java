package edu.gsu.csc1302.emperorsofspades.player;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card.Suit;

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
    private final CardDeck cards = new CardDeck();

    /**
     * The team that the player is on.
     */
    private String teamName;


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
        cards.addToTop(card);
    }
    /**
     * Given the lead suit, lead card and the current hand
     * player will play a card.
     * @param leadSuit the lead suit of the current hand
     * @param leadCard the lead card of the current hand
     * @param hand the list of cards already played in this hand
     * @return a card
     */

    public abstract Card playCard(Suit leadSuit, Card leadCard, CardDeck hand);

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
            throw new IllegalPlayerStateException(
            		"Player has no cards in hand.");
        }
        return cards;
    }

    /**
     * Allows a user to place a bid in a given hand.
     * Logic is differed to the concrete player implementations.
     * @return a bid [4, 10].
     */
    public abstract int placeBid();

    /**
     * Places a blind bid.
     * @return bid
     */
    public abstract int placeBlindBid();
    /**
     * Return the number of cards in the user's deck of cards.
     * @return # of cards
     */
    public int numOfCardsInDeck() {
        if (this.cards == null) {
            return 0;
        }
        return cards.size();
    }

    /**
     * Returns the team that the player is on.
     * @return team
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * sets the name of the team.
     * @param name the name of the team.
     */

    public void setTeamName(final String name) {
        teamName = name;
    }

    /**
     * this generates a probability for setting a bid.
     * @TODO Finish the implementation.
     * Given a deck of cards, a bid probability is generated
     * based on  the cards in the deck.
     * @param cards the card deck
     * @return bid probability
     */
    public static double generateBidProbability(final CardDeck cards) {
        double bidProbability = 0.0;
        for (Card card : cards) {
            // Possibility of winning a hand if the card is the Big Joker
            if (card.getSuit().equals(Card.Suit.HEART)
                    && card.getRank().equals(Card.Rank.TWO)) {
                bidProbability++;
                // Possibility of winning a hand if the card is the Little Joker
            } else if (card.getSuit().equals(Card.Suit.CLUB)
                    && card.getRank().equals(Card.Rank.TWO)) {
                bidProbability++;
                // Possibility of winning a hand if the card is the Big Joker
            } else if (card.getSuit().equals(Card.Suit.DIAMOND)
                    && card.getRank().equals(Card.Rank.TWO)) {
                bidProbability += 0.95;
            } else if (card.getSuit().equals(Card.Suit.SPADE)
                    && card.getRank().equals(Card.Rank.TWO)) {
                bidProbability += 0.75;
                //SPADES suit
            } else if (card.getSuit().equals(Card.Suit.SPADE)) {
                bidProbability += 0.5;
            } else if (card.getRank().equals(Card.Rank.ACE)
            		|| card.isFaceCard()) {
                bidProbability += 0.4;
            } else {
                bidProbability += 0.10;
            }
        }
//        System.out.println("Cards: " + cards);
//        System.out.println("\nBid Probability: " + bidProbability + "\n\n");
        return (bidProbability / 13) * 10;
    }

    /**
     * Print-friendly string.
     * @return String of the player.
     */
    public String toString() {
        return "[Player] Name: " + getName();
    }
    /**
     * places the bid of a player.
     * @param player player biding.
     * @return integer the bid.
     */

	public abstract int placeBid(Player player);
	/**
	 * returns the card for the player.
	 * @param hand the deck of the cards played.
	 * @return the card for the player.
	 */
	public abstract Card playCard(CardDeck hand);

	/**
	 * clone the player.
	 * @return a clone.
	 */
	public Object clone() {
	    try {
	        return super.clone();
	    } catch (Exception e) {
	        return null;
	    }
	}
}
