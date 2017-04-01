package cs1302.gsu.edu.emperorsofspades.instructorsolutions;

import java.util.List;

/**
 * A {@link List} of {@link Card}s. This interface extends {@link List} with
 * methods for drawing {@link Card}s from the top or bottom of a Deck,
 * adding {@link Card}s to the top or bottom of a Deck, and other related
 * card deck functionality. Index zero is the top of a Deck. Index size() - 1
 * is the bottom of a Deck.
 * <p>When adding or removing multiple cards at once,
 * they are added or removed collectively and not one at a time. For example,
 * if a Deck has cards H2, H3, H4, H5, H6 from top-to-bottom, then removing
 * the top 2, results in a new deck of H2, H3, and removing the bottom 2
 * results in a new deck of H5, H6. Similarly, when adding another deck, that
 * consists of C10, CJ, to your deck then the top card of your deck will be
 * C10. When adding another deck, that consists of CA, CK to the bottom of
 * your deck, then the bottom card of your deck will be CK.</p>
 *
 * @author Anwar Reddick
 *
 */
public interface Deck extends List<Card> {

	/**
	 * Removes {@code count} {@link Card}s from the top of this Deck
	 * and returns them as a new Deck.
	 *
	 * @param count The number of {@link Card}s to remove and return.
	 * @return count number of {@link Card}s as a new Deck.
	 * @throws InsufficientCardsException if deck has less than {@code count}
	 * cards.
	 */
	Deck drawFromTop(int count);

	/**
	 * Removes and returns the top {@link Card} of this Deck.
	 *
	 * @return The top card {@link Card} of this Deck.
	 * @throws InsufficientCardsException if this deck is empty.
	 */
	Card drawFromTop();

	/**
	 * Removes {@code count} {@link Card}s from the bottom of this Deck
	 * and returns them as a new Deck.
	 *
	 * @param count The number of {@link Card}s to remove and return.
	 * @return count number of {@link Card}s as a new Deck.
	 * @throws InsufficientCardsException if deck has less than {@code count}
	 * cards.
	 */
	Deck drawFromBottom(int count);

	/**
	 * Removes and returns the bottom {@link Card} of this Deck.
	 *
	 * @return The bottom card {@link Card} of this Deck.
	 * @throws InsufficientCardsException if this deck is empty.
	 */
	Card drawFromBottom();

	/**
	 * Removes all {@link Card}s from this Deck and returns them as a new
	 * Deck. If this deck is empty, then this method returns an empty new Deck.
	 *
	 * @return All {@link Card}s from this Deck as a new Deck.
	 */
	Deck drawAll();

	/**
	 * Adds all {@link Card}s from {@code deck} to the top of this Deck.
	 *
	 * @param deck The Deck of {@link Card}s to add to this Deck.
	 */
	void addToTop(Deck deck);

	/**
	 * Adds {@code card} to the top of this Deck.
	 *
	 * @param card The {@link Card} to add.
	 */
	void addToTop(Card card);

	/**
	 * Adds all {@link Card}s from {@code deck} to the bottom of this Deck.
	 *
	 * @param deck The Deck of {@link Card}s to add.
	 */
	void addToBottom(Deck deck);

	/**
	 * Adds {@code card} to the bottom of this Deck.
	 *
	 * @param card The {@link Card} to add.
	 */
	void addToBottom(Card card);

	/**
	 * Returns the Card that's at the top of this Deck, without removing it, or
	 * null if this deck is empty.
	 * @return the Card that's at the top of this Deck, without removing it, or
	 * null if this deck is empty.
	 */
	Card peekTop();

	/**
	 * Returns the Card that's at the bottom of this Deck, without removing it,
	 * or null if this deck is empty.
	 * @return the Card that's at the bottom of this Deck, without removing it,
	 * or null if this deck is empty.
	 */
	Card peekBottom();

	/**
	 * Shuffles this Deck.
	 */
	void shuffle();

	/**
	 * Returns an unmodifiable Deck that allows view access to the
	 * {@link Card}s in this Deck. The unmodifiable view should reflect
	 * updates to this Deck.
	 * @return An unmodifiable Deck that allows view access to the
	 * {@link Card}s in this Deck.
	 */
	Deck createUnmodifiableView();
}
