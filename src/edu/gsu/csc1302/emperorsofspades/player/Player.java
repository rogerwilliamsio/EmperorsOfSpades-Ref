package edu.gsu.csc1302.emperorsofspades.player;

import edu.gsu.csc1302.coll1.instr.ArrayListDeck;

/**
 * Simulates a generic player in the game.
 * @author Roger Williams
 */
public abstract class Player {
    /**
     * The player's name.
     */
    private String name;
    private ArrayListDeck hand;

    /**
     * Class constructor.
     * @param name the name of the player
     */
    public Player(final String name) {
        this.name = name;
        hand = null;
        
    }

    /**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(ArrayListDeck hand) {
		this.hand = hand;
	}

	/**
     * Returns the player's name.
     * @return player's name
     */
    public String getName() {
        return name;
    }
    /**
     * returns the Deck of the player.
     */
    public  ArrayListDeck getHand() {
        return hand;
    }
    /**
     * Print-friendly string.
     * @return
     */
    public String toString() {
        return "[Player] Name: " + this.getName();
    }
}
