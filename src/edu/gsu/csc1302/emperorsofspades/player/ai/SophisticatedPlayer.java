package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;

/**
 * Simulates a sophisticated player. A player who tends to to bid based on the current state of the game.
 *
 * @author Roger Williams
 */
public class SophisticatedPlayer  extends AIPlayer {
    /**
     * Class constructor.
     *
     * @param name            the name of the player
     * @param personalityType of the AI player
     */
    public SophisticatedPlayer(final String name, final PersonalityType personalityType) {
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
