package edu.gsu.csc1302.emperorsofspades.player.ai;

/**
 * Simulates a sophisticated player. A player who tends to to bid based on the current state of the game.
 *
 * @author Roger Williams
 */
public class SophisticatedPlayer extends AIPlayer{
    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public SophisticatedPlayer(String name) {
        super(name, PersonalityType.SOPHISTICATED);
    }

    @Override
    public PersonalityType getPersonalityType() {
        return null;
    }
}
