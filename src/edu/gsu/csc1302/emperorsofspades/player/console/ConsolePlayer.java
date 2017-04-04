package edu.gsu.csc1302.emperorsofspades.player.console;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * description
 *
 * @author Roger Williams
 */
public class ConsolePlayer extends Player {
    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public ConsolePlayer(String name) {
        super(name);
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
