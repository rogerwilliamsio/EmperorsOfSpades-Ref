package edu.gsu.csc1302.emperorsofspades;

/**
 * The main exception class for the spades game. All exceptions should extend this class.
 *
 * @author Roger Williams
 */
public class SpadesException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 24995588419165014L;

	/**
     * Class constructor.
     * @param errorMessage the error message to return.
     */
    public SpadesException(final String errorMessage) {
        super(errorMessage);
    }
}