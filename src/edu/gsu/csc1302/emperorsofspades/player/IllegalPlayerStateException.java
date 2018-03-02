package edu.gsu.csc1302.emperorsofspades.player;

import edu.gsu.csc1302.emperorsofspades.SpadesException;

/**
 * this is the class for Illegal player state exception.
 * @author Roger Williams
 */
public class IllegalPlayerStateException extends SpadesException {
    /**
	 * this gives it a defult serial nimber.
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Class constructor.
     * @param errorMessage the error message to return.
     */
    public IllegalPlayerStateException(final String errorMessage) {
        super(errorMessage);
    }
}
