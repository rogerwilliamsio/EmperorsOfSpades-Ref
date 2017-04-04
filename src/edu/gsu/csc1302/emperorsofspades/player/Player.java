package edu.gsu.csc1302.emperorsofspades.player;

/**
 * Simulates a generic player in the game.
 * @author Roger Williams
 */
public abstract class Player {
    /**
     * The player's name.
     */
    private String name;

    /**
     * Class constructor.
     * @param name the name of the player
     */
    public Player(final String name) {
        this.name = name;
    }

    /**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Returns the player's name.
     * @return player's name
     */
    public String getName() {
        return name;
    }
    /**
     * Print-friendly string.
     * @return
     */
    public String toString() {
        return "[Player] Name: " + this.getName();
    }
}
