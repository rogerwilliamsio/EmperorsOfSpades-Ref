package edu.gsu.csc1302.emperorsofspades.team;

import edu.gsu.csc1302.emperorsofspades.SpadesException;

/**
 * Thrown when too many players are on a team.
 *
 * @author Roger Williams
 */
public class TooManyPlayersException extends SpadesException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 902056601818158253L;
	
	/**
     * Error message to display when team size exceed the maximum allowed players.
     */
    private static final String TOO_MANY_PLAYERS_ERROR
            = "Only " + Team.getMaximumTeammates() + " players are allowed on a team.";

    /**
     * Class constructor.
     */
    public TooManyPlayersException() {
        super(TOO_MANY_PLAYERS_ERROR);
    }

    /**
     * Class constructor.
     * @param error the error message.
     */
    public TooManyPlayersException(final String error) {
        super(error);
    }
}
