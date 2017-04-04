package edu.gsu.csc1302.emperorsofspades.instructorsolutions;

/**
 * A French-style playing card. Has a Suit that's one of HEART, DIAMOND, CLUB,
 * or SPADE. Has a Rank that's one of TWO through TEN, JACK, QUEEN, KING, or
 * ACE. Objects of this type are immutable.
 *
 * @author Anwar Reddick
 *
 */
public final class Card {

	/**
	 * Suits of a standard French-style deck of cards.
	 */
	public enum Suit {
		/**
		 * Hearts.
		 */
		HEART,

		/**
		 * Diamonds.
		 */
		DIAMOND,

		/**
		 * Clubs.
		 */
		CLUB,

		/**
		 * Spades.
		 */
		SPADE;
	}

	/**
	 * Ranks of a standard French-style deck of cards.
	 */
	public enum Rank {
		/**
		 * Two is not a face card.
		 */
		TWO(false),

		/**
		 * Three is not a face card.
		 */
		THREE(false),

		/**
		 * Four is not a face card.
		 */
		FOUR(false),

		/**
		 * Five is not a face card.
		 */
		FIVE(false),

		/**
		 * Six is not a face card.
		 */
		SIX(false),

		/**
		 * Seven is not a face card.
		 */
		SEVEN(false),

		/**
		 * Eight is not a face card.
		 */
		EIGHT(false),

		/**
		 * Nine is not a face card.
		 */
		NINE(false),

		/**
		 * Ten is not a face card.
		 */
		TEN(false),

		/**
		 * Jack is a face card.
		 */
		JACK(true),

		/**
		 * Queen is a face card.
		 */
		QUEEN(true),

		/**
		 * King is a face card.
		 */
		KING(true),

		/**
		 * Ace is not a face card.
		 */
		ACE(false);

		/**
		 * Whether this rank denotes a face card.
		 */
		private boolean face;

		/**
		 * Initializes a Rank with a boolean denoting whether this rank
		 * denotes a face card.
		 * @param face Whether this rank denotes a face card.
		 */
		Rank(final boolean face) {
			this.face = face;
		}

		/**
		 * Returns whether this Rank denotes a face card.
		 * @return Whether this Rank denotes a face card.
		 */
		public boolean isFace() {
			return face;
		}

	}

	/**
	 * Suit of this Card.
	 */
	private Suit suit;

	/**
	 * Rank of this Card.
	 */
	private Rank rank;

	/**
	 * Constructs a new Card with the provided {@link Suit} and {@link Rank}.
	 * @param s The {@link Suit} of the Card.
	 * @param r The {@link Rank} of the Card.
	 */
	public Card(final Suit s, final Rank r) {
		this.suit = s;
		this.rank = r;
	}

	/**
	 * Returns whether this Card is a face card.
	 * @return Whether this Card is a face card.
	 */
	public boolean isFaceCard() {
		return rank.isFace();
	}

	/**
	 * Returns this Card's {@link Suit}.
	 * @return This Card's {@link Suit}.
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Returns this Card's {@link Rank}.
	 * @return This Card's {@link Rank}.
	 */
	public Rank getRank() {
		return rank;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = suit + "-" + rank;
		return str;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Card other = (Card) obj;
		if (rank != other.rank) {
			return false;
		}
		if (suit != other.suit) {
			return false;
		}
		return true;
	}
}
