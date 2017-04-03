package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * @author Roger Williams
 */
public class AggressivePlayer extends AIPlayer {

    /**
     * Personality type of the AI player.
     */
    private PersonalityType personalityType = PersonalityType.AGGRESSIVE;

    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public AggressivePlayer(final String name) {
        super(name, PersonalityType.AGGRESSIVE);
    }


    /**
     * returns the personality type of the AI player.
     * @return personality type
     */
    public PersonalityType getPersonalityType() {
        return personalityType;
    }
}
