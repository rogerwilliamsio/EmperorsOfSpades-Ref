package io.rogerwilliams.emperorsofspades.player.ai;

import java.util.Random;

import io.rogerwilliams.emperorsofspades.CardDeck;
import io.rogerwilliams.emperorsofspades.SpadesComparator;
import io.rogerwilliams.emperorsofspades.SpadesEngine;
import io.rogerwilliams.emperorsofspades.instructorsolutions.Card;
import io.rogerwilliams.emperorsofspades.instructorsolutions.Card.Suit;
import io.rogerwilliams.emperorsofspades.player.Player;

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

        //Raises the bid by 10%
        final int bid = (int) (Math.round((bidProbability * 1.10)));

        if (bid >= SpadesEngine.MAXIMUM_TEAM_BID) {
            return SpadesEngine.MAXIMUM_TEAM_BID;
        } else if (bid <= SpadesEngine.MINIMUM_TEAM_BID) {
            return SpadesEngine.MINIMUM_TEAM_BID;
        }
        return bid;
    }
    /**
     * Places a bid for the aggressive player.
     * @param player the player in the same team.
     * @return bid the number of bid.
     */
    @Override
    public int placeBid(final Player player) {
    	return placeBid();
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
	/**
	 * returns a card for the player.
	 * @param hand the hand of the game.
	 * @return a card for the player.
	 */
	public Card playCard(final CardDeck hand) {

		 CardDeck newHand = (CardDeck) hand.clone();

		 Card leadCard = new Card(null, null);
		 Card myCard = new Card(null, null);
		 Card.Suit leadSuit = null;

		 SpadesComparator comp;

		 if (newHand.size() >= 1) {
			 Card firstCard = newHand.get(0);
			 leadCard = firstCard;
			 leadSuit = firstCard.getSuit();
			 comp = new  SpadesComparator(leadSuit);
			 newHand.remove(0);
			 if (newHand.size() >= 1) {
				 for (Card card: newHand) {
					 int compare = comp.compare(leadCard, card);
					 if (compare > 0) {
						  leadCard = card;
					 }
				 }
			 }
		 }
		 myCard = playCard(leadSuit, leadCard, hand);
		return myCard;
	}
}
