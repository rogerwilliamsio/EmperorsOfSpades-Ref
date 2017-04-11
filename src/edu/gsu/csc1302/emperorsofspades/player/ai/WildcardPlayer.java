package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesComparator;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.IllegalPlayerStateException;

import java.util.ArrayList;
import java.util.Random;

/**
 * Simulates a wild card player.
 * A player who makes random and erratic choices.
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
     * Plays a card, given a lead suit.
     * @param leadSuit the lead suit of the current hand.
     * @return card card form the players hand.
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
     * this places the bid for the player.
     * Wild card players places random bids [4, 10].
     * @return a random bid.
     */
    @Override
    public int placeBid() {
        final int randomBid = (new Random().nextInt((10 - 4) + 1)) + 4;
        return randomBid;
    }
    /**
     * Plays a card, given a lead suit.
     * @param leadSuit the lead suit of the current hand.
     * @param leadCard of the game.
     * @param hand the cards on the table.
     * @return card card form the players hand.
     */
    public Card playCard(final Card.Suit leadSuit,
    		final Card leadCard, final CardDeck hand) {

		 SpadesComparator comp = new  SpadesComparator(leadSuit);
		 CardDeck myDeck = (CardDeck) getCards().clone();

		 Card myLeadCard = new Card(null, null);
		 for (int j = 0; j < myDeck.size(); j++) {
			Card myComp = myDeck.drawFromTop();
			myDeck.addToTop(myComp);
			int result = comp.compare(myComp, leadCard);
			if (result < 0) {
				myLeadCard = myComp;
				break;
			}
		 }
		 return myLeadCard;
    }
	 /**
     * this method is used to blindBid.
     * @return the blind bid of the team.
     */
	 public int setBlindBid() {
	        final int bidBound = (SpadesEngine.MAXIMUM_BLIND_BID
	        		- SpadesEngine.MINIMUM_BLIND_BID) + 1;
	        return new Random().nextInt(bidBound)
	        		+ SpadesEngine.MINIMUM_BLIND_BID;
	    }
	 /**
	 * returns integer for blind bidding.
	 * @return integer for blind bidding.
	 */
		@Override
		public int placeBlindBid() {
			Random rand = new Random();
			int n = rand.nextInt(4) + 6;
			return n;
		}
}
