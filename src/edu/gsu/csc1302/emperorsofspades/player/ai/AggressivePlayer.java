package edu.gsu.csc1302.emperorsofspades.player.ai;

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
     *
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
    public Card playCard(final Card.Suit leadSuit) {
        return null;
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
}
