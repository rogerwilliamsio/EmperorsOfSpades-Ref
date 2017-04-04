package edu.gsu.csc1302.emperorsofspades.team;

import edu.gsu.csc1302.emperorsofspades.SpadesException;

/**
 * description
 *
 * @author Roger Williams
 */
public class IllegalTeamStateException extends SpadesException {

    /**
     * Class constructor.
     *
     * @param errorMessage the error message to return.
     */
    public IllegalTeamStateException(final String errorMessage) {
        super(errorMessage);
    }
}
