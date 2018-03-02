package io.rogerwilliams.emperorsofspades.team;

import io.rogerwilliams.emperorsofspades.SpadesException;

/**
 * this is the class for Illegal State exception.
 * @author Roger Williams
 */
public class IllegalTeamStateException extends SpadesException {

    /**
	 * this gives it a default serial version.
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Class constructor.
     *
     * @param errorMessage the error message to return.
     */
    public IllegalTeamStateException(final String errorMessage) {
        super(errorMessage);
    }
}
