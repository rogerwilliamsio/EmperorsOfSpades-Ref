package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * Simulates a sophisticated player. A player who tends to to bid based on the current state of the game.
 *
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

        if (bid >= SpadesEngine.getMaximumTeamBid()) {
            return SpadesEngine.getMaximumTeamBid();
        } else {
            return bid;
        }
    }
}
