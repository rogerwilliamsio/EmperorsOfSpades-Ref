package edu.gsu.csc1302.emperorsofspades.player.ai;

import java.util.Random;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesComparator;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card.Suit;
import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * Simulates a sophisticated player.
 * A player who tends to to bid based on the current state of the game.
 * @author Roger Williams
 */
public class SophisticatedPlayer  extends AIPlayer {
    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public SophisticatedPlayer(final String name) {
        super(name, PersonalityType.SOPHISTICATED);
    }

    /**
     * PLays a card.
     * @param leadSuit the lead suit of the current hand.
     * @return card
     */
    @Override
    public Card playCard(final Card.Suit leadSuit) {
        return null;
    }

    /**
     * Returns a bid.
     * @return bid.
     */
    @Override
    public int placeBid() {
        double bidProbability = Player.generateBidProbability(this.getCards());
        final int bid = (int) Math.round(bidProbability);

        if (bid >= SpadesEngine.MAXIMUM_TEAM_BID) {
            return SpadesEngine.MAXIMUM_TEAM_BID;
        } else {
            return bid;
        }
    }
    /**
     * Plays a card, given a lead suit.
     * @param leadSuit the lead suit of the current hand.
     * @param leadCard of the game.
     * @param hand the cards on the table.
     * @return card card form the players hand.
     */
	@Override
	public Card playCard(final Suit leadSuit, final Card leadCard,
			final CardDeck hand) {
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
