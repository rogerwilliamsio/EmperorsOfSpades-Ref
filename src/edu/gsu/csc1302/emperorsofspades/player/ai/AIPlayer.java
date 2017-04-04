package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * Simulates an AI Spades player.
 *
 * @author Roger Williams
 */
public abstract class AIPlayer extends Player {

    /**
     * Personality type of the AI player.
     */
    private final PersonalityType personalityType;

    /**
     * Class constructor.
     *
     * @param name the name of the player
     * @param personalityType of the AI player
     */
    public AIPlayer(final String name, final PersonalityType personalityType) {
        super(name);
        this.personalityType = personalityType;
    }

    /**
     * Available personality types for AI players.
     */
    enum PersonalityType {
        /**
         * An aggressive player.
         */
        AGGRESSIVE,

        /**
         * A cautious player.
         */
        CAUTIOUS,

        /**
         * A sophisticated player.
         */
        SOPHISTICATED,

        /**
         * A wildcard player.
         */
        WILDCARD
    }

    /**
     * Returns the personality type of the AI player.
     * @return the personality type of the player
     */
    public PersonalityType getPersonalityType() {
        return this.personalityType;
    }
}
