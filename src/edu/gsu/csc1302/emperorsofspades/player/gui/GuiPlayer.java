package edu.gsu.csc1302.emperorsofspades.player.gui;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;

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
        System.out.println("Your turn gui player.");
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
     * returns a card for the GUI player.
     */
	@Override
	public Card playCard(final CardDeck hand) {
		// TODO Auto-generated method stub
		return null;
	}
}
