package io.rogerwilliams.emperorsofspades;

import io.rogerwilliams.emperorsofspades.instructorsolutions.Card.Suit;
import io.rogerwilliams.emperorsofspades.instructorsolutions.InstrSpadesComparator;
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
