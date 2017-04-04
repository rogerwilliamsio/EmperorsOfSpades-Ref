package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;

/**
 * Simulates a cautious player. A player who tends to make slightly lower bids.
 *
 * @author Roger Williams
 */
public class CautiousPlayer extends AIPlayer {

    /**
     * Personality type of the AI player.
     */
    private final PersonalityType personalityType = PersonalityType.AGGRESSIVE;


    /**
     * Class constructor.
     *
     * @param name            the name of the player
     * @param personalityType of the AI player
     */
    public CautiousPlayer(final String name, final PersonalityType personalityType) {
        super(name, personalityType);
    }

    @Override
    public Card playCard() {
        return null;
    }

    @Override
    public int placeBid() {
        return 0;
    }
}
