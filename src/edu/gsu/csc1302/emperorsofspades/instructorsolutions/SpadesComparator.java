package edu.gsu.csc1302.emperorsofspades.instructorsolutions;

import java.util.Comparator;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card.Suit;

/**
 * A card comparator that compares cards as if they were played in a hand of
 * a game of Spades, using the
 * <a href="https://www.pagat.com/boston/spades.html#NYC">New York Rules</a>.
 * The two of hearts takes the place of the big joker, and the two of clubs
 * takes the place of the little joker.<br>
 *
 * <p>The card that would win comes before the card that would loose. In other
 * words, if c1 would beat c2, then compare(c1, c2) should return a negative
 * number. The compare method should return 0 if comparing two cards that are
 * the same card.
 * </p>
 *
 * <p>The lead suit is used to simulate which suit led when playing a hand.
 * If the lead suit is not a spade or trump, then the highest spade or trump
 * wins. If the lead suit is not a spade or trump, and no spade or trump
 * is being compared, then the highest lead suit card wins.
 * </p>
 *
 * <p>More specifically, the card order is as follows:<br>
 * <ul>
 *  <li>The two of hearts (taking the place of the big joker) is the strongest
 *  card and beats every other card.</li>
 *  <li>The two of clubs (taking the place of the little joker) is the next
 *  strongest.</li>
 *  <li>The two of diamonds is next.</li>
 *  <li>Then the two of spades.</li>
 *  <li>Then the ace of spades on down to the three of spades.</li>
 *  <li>Then the ace of the lead suit on down to the three of the lead
 *  suit.</li>
 *  <li>All other cards have the same value. These cards are not spades and not
 *  of the lead suit.</li>
 * </ul>
 *
 * @author Anwar Reddick
 *
 */
public abstract class SpadesComparator implements Comparator<Card> {

	/**
	 * The lead suit of a simulated hand of Spades.
	 */
	protected final Suit leadSuit;

	/**
	 * Initializes fields.
	 * @param leadSuit The lead suit of a simulated hand of Spades.
	 */
	public SpadesComparator(final Suit leadSuit) {
		this.leadSuit = leadSuit;
	}

	/**
	 * Returns The lead suit of a simulated hand of Spades.
	 * @return The lead suit of a simulated hand of Spades.
	 */
	public Suit getLeadSuit() {
		return leadSuit;
	}
}
