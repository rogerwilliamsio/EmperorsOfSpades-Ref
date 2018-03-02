package io.rogerwilliams.emperorsofspades.player.ai;

import java.util.Random;

import io.rogerwilliams.emperorsofspades.CardDeck;
import io.rogerwilliams.emperorsofspades.SpadesComparator;
import io.rogerwilliams.emperorsofspades.SpadesEngine;
import io.rogerwilliams.emperorsofspades.instructorsolutions.Card;
import io.rogerwilliams.emperorsofspades.instructorsolutions.Card.Suit;
import io.rogerwilliams.emperorsofspades.player.Player;

/**
 * Simulates a cautious player. A player who tends to make slightly lower bids.
 *
 * @author Roger Williams
 */
public class CautiousPlayer extends AIPlayer {

    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public CautiousPlayer(final String name) {
        super(name, PersonalityType.CAUTIOUS);
    }

//    /**
//     * PLays a card, given a lead suit.
//     * @param leadSuit the lead suit of the current hand.
//     * @return card
//     */
//    @Override
//    public Card playCard(Card.Suit leadSuit) {
//        return null;
//    }

    /**
     * A cautious player makes slightly lower bids.
     * @return a bid
     */
    @Override
    public int placeBid() {
        double bidProbability = Player.generateBidProbability(this.getCards());

        //Lower the bid by 5%
        final int bid = (int) (Math.floor((bidProbability * 0.95)));

        if (bid >= SpadesEngine.MAXIMUM_TEAM_BID) {
            return SpadesEngine.MAXIMUM_TEAM_BID;
        } else if (bid < SpadesEngine.MINIMUM_TEAM_BID) {
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
     * Plays a card, given a lead suit.
     * @param leadSuit the lead suit of the current hand.
     * @param leadCard of the game.
     * @param hand the cards on the table.
     * @return card card form the players hand.
     */
	@Override
	public Card playCard(final Suit leadSuit, final Card leadCard,
			final CardDeck hand) {
		if (leadCard.getSuit() == null) {

   		 getCards().sort(Suit.DIAMOND);
   		 Card myLowCard = getCards().get(getCards().size() - 1);
   		 getCards().remove(myLowCard);
   		 return myLowCard;

		}
		 SpadesComparator comp = new  SpadesComparator(leadSuit);
		 getCards().sort(leadSuit);
		 CardDeck myDeck = (CardDeck) getCards().clone();

		 Card myLeadCard = new Card(null, null);
		 for (int j = myDeck.size() - 1; j >= 0; j--) {
			Card myComp = myDeck.get(j);
			int result = comp.compare(myComp, leadCard);
			if (result < 0) {
				myLeadCard = myComp;
				break;
			}
		 }
		 if (myLeadCard.getSuit() == null) {
			 CardDeck cardsInSuit = new CardDeck();
			 //Find all the cards that are in-suit
		        for (Card card : this.getCards()) {
		            if (card.getSuit().equals(leadSuit)) {
		                cardsInSuit.add(card);
		            }
		        }
		        cardsInSuit.sort(leadSuit);
	            if (cardsInSuit.size() != 0) {
		            Card myLowCard = cardsInSuit.get(cardsInSuit.size() - 1);
		            getCards().remove(myLowCard);
		            return myLowCard;
	            }
	            Card anyCard = getCards().get(0);
	            getCards().remove(anyCard);
	            return anyCard;
		 }
		 getCards().remove(myLeadCard);
		 return myLeadCard;
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
//	/**
//  * Returns a blind team bid [6, 10], randomly generated.
//  * @return a team bid
//  */
//  public int setBlindBid() {
// 	Random rand = new Random();
//		int n = rand.nextInt(4) + 6;
//		return n;
// }
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
