package edu.gsu.csc1302.emperorsofspades.player.ai;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;

import java.util.Random;

/**
 * Simulates a wildcard player. A player who makes random and erratic choices.
 *
 * @author Roger Williams
 */
public class WildcardPlayer extends AIPlayer {
    /**
     * Class constructor.
     *
     * @param name            the name of the player
     * @param personalityType of the AI player
     */
    public WildcardPlayer(final String name, final PersonalityType personalityType) {
        super(name, personalityType);
    }

    /**
     * Plays a card in a given hand.
     * This player makes random choices.
     * @return a card
     */
    @Override
    public Card playCard() {
        final int randCardIndex = new Random().nextInt(this.numOfCardsInDeck());
        return this.getCards().remove(randCardIndex);
    }

    @Override
    public double placeBid() {
        double intRandom = new Random().nextDouble();

        return intRandom;
    }
}
