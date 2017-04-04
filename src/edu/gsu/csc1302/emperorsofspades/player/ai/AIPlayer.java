package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.player.IllegalPlayerStateException;
import edu.gsu.csc1302.emperorsofspades.player.Player;

import java.util.Random;

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
     * List of sayings for the AI player to give it some personality.
     * Sayings should somewhat match the declared personality of the player.
     */
    private final String[] playerSayings;

    /**
     * Class constructor.
     *
     * @param name the name of the player
     * @param personalityType of the AI player
     */
    public AIPlayer(final String name, final PersonalityType personalityType, final String[] sayings) {
        super(name);
        this.personalityType = personalityType;

        if (sayings.length < 0) {
            throw new IllegalPlayerStateException("Player must have at least 1 saying");
        }
        this.playerSayings = new String[sayings.length];
        System.arraycopy(sayings, 0, this.playerSayings, 0, this.playerSayings.length);
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

    /**
     * Returns a random saying/phrase from the player's array of sayings.
     * @return saying
     */
    public String saySomething() {
        //Generate a random number to say a random phrase.
        final int randInt = new Random().nextInt(this.playerSayings.length);
        return this.playerSayings[randInt];
    }


}
