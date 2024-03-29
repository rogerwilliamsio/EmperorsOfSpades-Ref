package io.rogerwilliams.emperorsofspades.player.ai;

import io.rogerwilliams.emperorsofspades.CardDeck;
import io.rogerwilliams.emperorsofspades.SpadesComparator;
import io.rogerwilliams.emperorsofspades.SpadesEngine;
import io.rogerwilliams.emperorsofspades.instructorsolutions.Card;
import io.rogerwilliams.emperorsofspades.player.Player;

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
     * Places a bid for the aggressive player.
	 * @todo: Remove extra placebid methods.
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
    public Card playCard(final Card.Suit leadSuit,
    		final Card leadCard, final CardDeck hand) {

    	if (leadCard.getSuit() == null) {
	   		 Card myCard = getCards().get(getCards().size() - 1);
	   		 getCards().remove(myCard);
	   		 return myCard;

		}
		 SpadesComparator comp = new  SpadesComparator(leadSuit);
		 getCards().sort(leadSuit);
		 Card myLeadCard1 = getCards().get(getCards().size() - 1);
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
	            	Random rand = new Random();
		            int randomNumber2 = rand.nextInt(cardsInSuit.size());
		            return cardsInSuit.get(randomNumber2);
	            }
	            Random rand = new Random();
	            int randomNumber1 = rand.nextInt(getCards().size());
	            Card anyCard = getCards().get(randomNumber1);
	            getCards().remove(anyCard);
	            return anyCard;
		 }
		 Random rand = new Random();
		 int randomNumber = rand.nextInt(2);
		 if (randomNumber == 1) {
			 getCards().remove(myLeadCard);
			 return myLeadCard;
		 } else {
			 getCards().remove(myLeadCard1);
			 return myLeadCard1;
		 }
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
//		/**
	//  * Returns a blind team bid [6, 10], randomly generated.
	//  * @return a team bid
	//  */
	//  public int setBlindBid() {
//	 	Random rand = new Random();
//			int n = rand.nextInt(4) + 6;
//			return n;
	// }
//	   /**
//	     * Plays a card, given a lead suit.
//	     * @param leadSuit the lead suit of the current hand.
//	     * @return card card form the players hand.
//	     */
//	    @Override
//	    public Card playCard(final Card.Suit leadSuit) {
//	        if (this.numOfCardsInDeck() == 0) {
//	            throw new IllegalPlayerStateException("Player cannot play a "
//	                    + "card because player's deck is empty.");
//	        }
//
//	        final int randCardIndex;
//	        //Are the players allowed to renege? Then just return a random card.
//	        if (SpadesEngine.RENEGE_ALLOWED) {
//	            randCardIndex = new Random().nextInt(this.numOfCardsInDeck());
//	        }
//
//	        ArrayList<Card> cardsInSuit = new ArrayList<Card>();
//
//	        //Find all the cards that are in-suit
//	        for (Card card : this.getHand()) {
//	            if (card.getSuit().equals(leadSuit)) {
//	                cardsInSuit.add(card);
//	            }
//	        }
//
//	        return this.getHand().remove(2);
//
//	    }
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
