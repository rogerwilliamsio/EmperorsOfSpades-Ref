package edu.gsu.csc1302.emperorsofspades.player.ai;

import java.util.Random;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card.Suit;
import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * Simulates an aggressive AI player.
 * @author Roger Williams
 */
public class AggressivePlayer extends AIPlayer {

    /**
     * Class constructor.
     * @param name the name of the player
     */
    public AggressivePlayer(final String name) {
        super(name, PersonalityType.AGGRESSIVE);
    }
    /**
     * Plays a card, given a lead suit.
     * @param leadSuit the lead suit of the current hand.
     * @param leadCard of the game.
     * @param hand the cards on the table.
     * @return card card form the players hand.
     */
    @Override
    public Card playCard(final Card.Suit leadSuit,
    		final Card leadCard, final CardDeck hand) {
    	 if (leadCard.getSuit() == null) {

    		 getCards().sort(Suit.SPADE);
    		 Card myLeadCard = getCards().get(0);
    		 getCards().remove(myLeadCard);
    		 return myLeadCard;

    	 }
		 getCards().sort(leadSuit);
		 Card myLeadCard = getCards().get(0);
		 getCards().remove(myLeadCard);
		 return myLeadCard;
    }

    /**
     * PLaces a bid for the aggressive player.
     * @return bid the number of bid.
     */
    @Override
    public int placeBid() {
        double bidProbability = Player.generateBidProbability(this.getCards());

        //Raises the bid by 25%
        final int bid = (int) (Math.round((bidProbability * 1.25)));

        if (bid >= SpadesEngine.MAXIMUM_TEAM_BID) {
            return SpadesEngine.MAXIMUM_TEAM_BID;
        } else if (bid < SpadesEngine.MINIMUM_TEAM_BID) {
            return SpadesEngine.MINIMUM_TEAM_BID;
        }
        return (bid / 2);
    }
    /**
     * Places a bid for the aggressive player.
     * @param player the player in the same team.
     * @return bid the number of bid.
     */
    @Override
    public int placeBid(final Player player) {
    	int bid = placeBid();
        int otherBid = player.placeBid();
        return (otherBid + bid);
    }
    /**
     * returns integer for blind bidding.
     * @return integer for blind bidding.
     */
	@Override
	public int placeBlindBid() {
		final int bidBound = (SpadesEngine.MAXIMUM_BLIND_BID
        		- SpadesEngine.MINIMUM_BLIND_BID) + 1;
        return new Random().nextInt(bidBound)
        		+ SpadesEngine.MINIMUM_BLIND_BID;
	}
}
