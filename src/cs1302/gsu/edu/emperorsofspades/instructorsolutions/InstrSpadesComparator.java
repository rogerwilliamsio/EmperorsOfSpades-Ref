package cs1302.gsu.edu.emperorsofspades.instructorsolutions;

import cs1302.gsu.edu.emperorsofspades.instructorsolutions.Card.Rank;
import cs1302.gsu.edu.emperorsofspades.instructorsolutions.Card.Suit;

/**
 * Instructor's {@link SpadesComparator} implementation.
 * @author Anwar Reddick
 *
 */
public class InstrSpadesComparator extends SpadesComparator {

	/**
	 * Initializes fields.
	 * @param leadSuit the lead suit of a simulated hand of Spades.
	 */
	public InstrSpadesComparator(final Suit leadSuit) {
		super(leadSuit);
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(final Card c1, final Card c2) {
		if (c1.equals(c2)) {
			return 0;
		}

		// deuce of hearts is used as the big joker and trumps everything else.
		if (c1.getRank() == Rank.TWO && c1.getSuit() == Suit.HEART) {
			return -1;
		}

		if (c2.getRank() == Rank.TWO && c2.getSuit() == Suit.HEART) {
			return 1;
		}

		// next is deuce of clubs which is used as the little joker.
		if (c1.getRank() == Rank.TWO && c1.getSuit() == Suit.CLUB) {
			return -1;
		}

		if (c2.getRank() == Rank.TWO && c2.getSuit() == Suit.CLUB) {
			return 1;
		}

		// next is deuce of diamonds.
		if (c1.getRank() == Rank.TWO && c1.getSuit() == Suit.DIAMOND) {
			return -1;
		}

		if (c2.getRank() == Rank.TWO && c2.getSuit() == Suit.DIAMOND) {
			return 1;
		}

		// next is deuce of spades.
		if (c1.getRank() == Rank.TWO && c1.getSuit() == Suit.SPADE) {
			return -1;
		}

		if (c2.getRank() == Rank.TWO && c2.getSuit() == Suit.SPADE) {
			return 1;
		}

		// then ace of spades on down, regardless of what led.
		if (c1.getSuit() == Suit.SPADE && c2.getSuit() != Suit.SPADE) {
			return -1;
		} else if (c1.getSuit() != Suit.SPADE && c2.getSuit() == Suit.SPADE) {
			return 1;
		} else if (c1.getSuit() == Suit.SPADE && c2.getSuit() == Suit.SPADE) {
			return c2.getRank().compareTo(c1.getRank());
		}

		// Check if a lead suit is present.
		if (c1.getSuit() == leadSuit && c2.getSuit() != leadSuit) {
			return -1;
		} else if (c1.getSuit() != leadSuit && c2.getSuit() == leadSuit) {
			return 1;
		} else if (c1.getSuit() == leadSuit && c2.getSuit() == leadSuit) {
			return c2.getRank().compareTo(c1.getRank());
		}

		// At this point, both of the following are true:
		//	Both are not spades.
		//	Both are not the lead suit.
		// In this case, both cards have the same value.

		return 0;
	}

}
