package edu.gsu.csc1302.emperorsofspades.player.ai;

import java.util.Random;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesComparator;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * Simulates an aggressive AI player.
 *
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
     * @return card
     */
    @Override
    public Card playCard(final Card.Suit leadSuit, final Card leadCard, final CardDeck hand) {

		 SpadesComparator comp = new  SpadesComparator(leadSuit);
		 CardDeck myDeck = (CardDeck) getCards().clone();

		 Card myLeadCard = new Card(null,null);
		 for (int j =0; j < myDeck.size(); j++) {
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
     * PLaces a bid for the aggressive player.
     * @return card
     */
    @Override
    public int placeBid() {
        double bidProbability = Player.generateBidProbability(this.getCards());

        //Raises the bid by 25%
        final int bid = (int) (Math.round((bidProbability * 1.25)));

        if (bid >= SpadesEngine.MAXIMUM_TEAM_BID) {
            return SpadesEngine.MAXIMUM_TEAM_BID;
        } else if (bid < SpadesEngine.MINIMUM_TEAM_BID){
            return SpadesEngine.MINIMUM_TEAM_BID;
        }
        return bid;
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

//	@Override
//	public Card playCard(Suit leadSuit) {
//		return null;
//	}
}
