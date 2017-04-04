package edu.gsu.csc1302.emperorsofspades.player;

import edu.gsu.csc1302.emperorsofspades.SpadesException;

/**
 * description
 *
 * @author Roger Williams
 */
public class IllegalPlayerStateException extends SpadesException{
    /**
     * Class constructor.
     *
     * @param errorMessage the error message to return.
     */
    public IllegalPlayerStateException(final String errorMessage) {
        super(errorMessage);
    }
}
