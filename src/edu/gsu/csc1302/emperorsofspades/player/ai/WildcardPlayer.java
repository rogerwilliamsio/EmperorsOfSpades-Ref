package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card.Suit;
import edu.gsu.csc1302.emperorsofspades.player.IllegalPlayerStateException;

import java.util.ArrayList;
import java.util.Random;

/**
 * Simulates a wildcard player. A player who makes random and erratic choices.
 *
 * @author Roger Williams
 */
public class WildcardPlayer extends AIPlayer {
    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public WildcardPlayer(final String name) {
        super(name, PersonalityType.WILDCARD);
    }

    /**
     * Plays a card in a given hand.
     * This player makes random choices.
     * @return a card
     */
    @Override
    public Card playCard(final Card.Suit leadSuit) {
        if (this.numOfCardsInDeck() == 0) {
            throw new IllegalPlayerStateException("Player cannot play a "
                    + "card because player's deck is empty.");
        }

        final int randCardIndex;
        //Are the players allowed to renege? Then just return a random card.
        if (SpadesEngine.RENEGE_ALLOWED) {
            randCardIndex = new Random().nextInt(this.numOfCardsInDeck());
        }

        ArrayList<Card> cardsInSuit = new ArrayList<Card>();

        //Find all the cards that are in-suit
        for (Card card : this.getCards()) {
            if (card.getSuit().equals(leadSuit)) {
                cardsInSuit.add(card);
            }
        }

        return this.getCards().remove(2);

    }


    /**
     * @TODO: Remove hard-coded values
     * Wildcard players places random bids [4, 10].
     * @return a random bid.
     */
    @Override
    public int placeBid() {
        final int randomBid = (new Random().nextInt((10 - 4) + 1)) + 4;
        return randomBid;
    }

	@Override
	public Card playCard(Suit leadSuit, Card leadCard, CardDeck hand) {
		if (this.numOfCardsInDeck() == 0) {
            throw new IllegalPlayerStateException("Player cannot play a "
                    + "card because player's deck is empty.");
        }
        final int randCardIndex = new Random().nextInt(this.numOfCardsInDeck());
        return this.getCards().remove(randCardIndex);
	}
	 /**
     * this method is used to blindBid.
     * @return the blind bid of the team.
     */
    public int placeBlindBid() {
    	Random rand = new Random();
    	int blindBid = (rand.nextInt(10)+ 6);
		return blindBid;
    }
}
