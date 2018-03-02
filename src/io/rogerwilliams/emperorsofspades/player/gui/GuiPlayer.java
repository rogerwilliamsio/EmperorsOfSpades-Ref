package io.rogerwilliams.emperorsofspades.player.gui;

import io.rogerwilliams.emperorsofspades.CardDeck;
import io.rogerwilliams.emperorsofspades.instructorsolutions.Card;
import io.rogerwilliams.emperorsofspades.player.Player;

import java.util.Collections;
import java.util.List;

/**
 * the GUI player class.
 * @author Roger Williams
 */
public class GuiPlayer extends Player {

    /**
     * Class constructor.
     **/
    public GuiPlayer() {
        super("GUIPlayer");
    }

    /**
     * Plays a card into the game hand.
     * @param leadSuit the lead suit of the current hand
     * @param leadCard the lead card of the current hand
     * @param hand the list of cards already played in this hand
     * @return a card
     */
    @Override
    public Card playCard(final Card.Suit leadSuit,
    		final Card leadCard, final CardDeck hand) {
        return null;
    }
    /**
     * return the cards on the table.
     * @return the cards on the table
     */
    public List<Card> getHand() {
        return Collections.unmodifiableList(this.getCards());
    }
    /**
     * returns the bid of the GUI player.
     * @return teh bid.
     */
    @Override
    public int placeBid() {
        return 0;
    }
    /**
     * the blind bid of the GUI player.
     * @return the blind bid.
     */
    @Override
    public int placeBlindBid() {
        return 0;
    }
    /**
     * returns the other players bid.
     * @return to other players bid.
     */
    @Override
    public int placeBid(final Player player) {
        return 0;
    }
    /**
     * returns a card.
     * @param hand the hand of the game.
     */
    @Override
    public Card playCard(final CardDeck hand) {
        return null;
    }
    /**
     * returns a card.
     * @param card the lead card of the game.
     */
    public void playCard(final Card card) {
        this.getCards().remove(card);
    }
    /**
     * returns a name.
     * @return the name.
     */
    public String getName() {
        return "You";
    }

}
