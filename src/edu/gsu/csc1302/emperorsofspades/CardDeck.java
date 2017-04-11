package edu.gsu.csc1302.emperorsofspades;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Deck;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.InsufficientCardsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Deck class.
 * @author Roger Williams
 */
public class CardDeck extends ArrayList<Card> implements Deck {
    /**
	 * SerializedUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates an empty Deck.
     */
    public CardDeck() {

    }

    /**
     * Creates a deck from the given deck.
     * @param deck the given deck.
     */
    public CardDeck(final Deck deck) {
        super(deck);
    }

    /**
     * Creates a deck from the list of cards given.
     * @param cards the given deck.
     */
    public CardDeck(final List<Card> cards) {
        super(cards);
    }

    /**
     * removes count cards from the top of the deck.
     * @param count number of cards to remove.
     * @return new deck of cards.
     * @throws InsufficientCardsException if the deck is empty or
     * count > # of cards in deck.
     */
    @Override
    public Deck drawFromTop(final int count) throws InsufficientCardsException {
        if (isEmpty() || count > (size() - 1)) {
            throw new InsufficientCardsException();
        }
        final CardDeck subDeck = new CardDeck(this.subList(0, count));
        removeAll(subDeck);
        return subDeck;
    }

    /**
     * removes the top card from the deck.
     * @return the top card.
     * @throws InsufficientCardsException if the deck is empty.
     */
    @Override
    public Card drawFromTop() throws InsufficientCardsException {
        if (isEmpty()) {
            throw new InsufficientCardsException();
        }
        return remove(0);
    }

    /**
     * removes count cards from the bottom of the deck.
     * @param count number of cards to remove.
     * @return new deck of cards.
     * @throws InsufficientCardsException if the deck is empty or
     * count > # of cards in deck.
     */
    @Override
    public Deck drawFromBottom(final int count)
            throws InsufficientCardsException {
        if (isEmpty() || count > (size() - 1)) {
            throw new InsufficientCardsException();
        }
        final CardDeck subDeck = new CardDeck(
        		this.subList(size() - count, size()));
        removeAll(subDeck);
        return subDeck;
    }

    /**
     * removes the bottom card from the deck.
     * @return the bottom card.
     * @throws InsufficientCardsException if the deck is empty.
     */
    @Override
    public Card drawFromBottom() throws InsufficientCardsException {
        if (isEmpty()) {
            throw new InsufficientCardsException();
        }
        return remove(size() - 1);
    }

    /**
     * Returns a new deck of cards from the old deck.
     * @return the deck containing all the cards from old deck.
     */
    @Override
    public Deck drawAll() {
        if (isEmpty()) {
            return null;
        }
        CardDeck subDeck = new CardDeck(this.subList(0, size()));
        this.clear();
        return subDeck;
    }

    /**
     * Adds a given deck to the top of this deck.
     * @param deck the deck to append.
     */
    @Override
    public void addToTop(final Deck deck) {
        this.addAll(0, deck);
    }

    /**
     * Adds a given card to the top of this deck.
     * @param card the card to add.
     */
    @Override
    public void addToTop(final Card card) {
        this.add(0, card);
    }

    /**
     * Adds a given deck of cards to the bottom of this deck.
     * @param deck the deck to add
     */
    @Override
    public void addToBottom(final Deck deck) {
        this.addAll(deck);
    }

    /**
     * Adds a given card to the bottom of this deck.
     * @param card the card to add.
     */
    @Override
    public void addToBottom(final Card card) {
        this.add(card);
    }

    /**
     * Returns thw card at the top of the deck.
     * @return the card at the top.
     */
    @Override
    public Card peekTop() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    /**
     * Returns the card at the bottom of the deck.
     * @return the cards at the bottom.
     */
    @Override
    public Card peekBottom() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    /**
     * Feature coming soon.
     */
    @Override
    public void shuffle() {
        throw new UnsupportedOperationException("Feature coming soon!");

    }

    /**
     * Feature coming soon.
     * @return unmodifiable deck.
     */
    @Override
    public Deck createUnmodifiableView() {
        throw new UnsupportedOperationException("Feature coming soon!");
    }
}
