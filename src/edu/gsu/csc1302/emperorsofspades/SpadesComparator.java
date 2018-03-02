package edu.gsu.csc1302.emperorsofspades;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card.Suit;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.InstrSpadesComparator;
/**
 * the class that extends the instructors spade comparator class.
 * @author Mahetem Moges
 */
public class SpadesComparator extends InstrSpadesComparator {
	/**
	 * this is a constructor for the spade comparator.
	 * @param leadSuit the lead suit of the game.
	 */
	public SpadesComparator(final Suit leadSuit) {
		super(leadSuit);
	}

}
