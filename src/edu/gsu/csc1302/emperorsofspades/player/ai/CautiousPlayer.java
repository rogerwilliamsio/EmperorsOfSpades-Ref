package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;

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

    /**
     * PLays a card, given a lead suit.
     * @param leadSuit the lead suit of the current hand.
     * @return card
     */
    @Override
    public Card playCard(Card.Suit leadSuit) {
        return null;
    }

    /**
     * A cautious player makes slightly lower bids.
     * @return a bid
     */
    @Override
    public int placeBid() {
        double bidProbability = Player.generateBidProbability(this.getCards());

        //Lower the bid by 20%
        final int bid = (int) (Math.floor((bidProbability * 0.8)));

        if (bid >= SpadesEngine.MAXIMUM_TEAM_BID) {
            return SpadesEngine.MAXIMUM_TEAM_BID;
        } else if (bid < SpadesEngine.MINIMUM_TEAM_BID){
            return SpadesEngine.MINIMUM_TEAM_BID;
        }
        return bid;
    }
}
