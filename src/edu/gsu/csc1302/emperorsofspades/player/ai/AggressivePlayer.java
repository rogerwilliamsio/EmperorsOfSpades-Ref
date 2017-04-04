package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;

/**
 * Simulates an aggressive AI player.
 *
 * @author Roger Williams
 */
public class AggressivePlayer extends AIPlayer {

    /**
     * Personality type of the AI player.
     */
    private final PersonalityType personalityType = PersonalityType.AGGRESSIVE;

    /**
     * Sayings. Used to give the player a personality while playing the game.
     */
//    private static final String[] AGGRESSIVE_PLAYER_SAYINGS = {
//            "I'm  feeling risky!!!",
//            "Let's go high!",
//            "Maybe I should take it easy......NOT!",
//            "HIGH trumps low, let's GO!!",
//            "I'm going HIGH, because I CAN!"
//    };

    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public AggressivePlayer(final String name) {
        super(name, PersonalityType.AGGRESSIVE);
    }

    @Override
    public Card playCard() {
        return null;
    }

    @Override
    public int placeBid() {
        return 0;
    }


    /**
     * returns the personality type of the AI player.
     * @return personality type
     */
    public PersonalityType getPersonalityType() {
        return personalityType;
    }
}
