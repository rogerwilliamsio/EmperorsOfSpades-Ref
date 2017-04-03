package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * Simulates a wildcard player. A player who makes random and erratic choices.
 *
 * @author Roger Williams
 */
public class WildcardPlayer extends AIPlayer{
    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public WildcardPlayer(final String name) {
        super(name, PersonalityType.WILDCARD);
    }

    @Override
    public PersonalityType getPersonalityType() {
        return null;
    }
}
