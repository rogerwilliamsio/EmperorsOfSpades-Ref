package io.rogerwilliams.emperorsofspades.team;

import io.rogerwilliams.emperorsofspades.SpadesException;

/**
 * Thrown when there is not enough players on a team.
 *
 * @author Roger Williams
 */
public class InsufficientPlayersException extends SpadesException {

    /**
	 * this gives it a default serial number.
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Error message to display when team size exceed
     * the maximum allowed players.
     */
    private static final String INSUFFICIENT_PLAYER_ERROR_MESSAGE
            = "This team needs at least "
            		+ Team.getMaximumTeammates() + " players.";

    /**
     * Class constructor.
     * @param error the error message to display.
     */
    public InsufficientPlayersException(final String error) {
        super(error);
    }

    /**
     * Class constructor with without custom message.
     */
    public InsufficientPlayersException() {
        super(INSUFFICIENT_PLAYER_ERROR_MESSAGE);
    }
}
