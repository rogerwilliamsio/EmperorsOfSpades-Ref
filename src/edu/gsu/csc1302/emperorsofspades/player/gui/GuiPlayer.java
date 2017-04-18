package edu.gsu.csc1302.emperorsofspades.player.gui;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;

import java.util.Collections;
import java.util.List;

/**
 * description
 *
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
     * Plays a card into the game hand
     * @param leadSuit the lead suit of the current hand
     * @param leadCard the lead card of the current hand
     * @param hand the list of cards already played in this hand
     * @return a card
     */
    @Override
    public Card playCard(final Card.Suit leadSuit, final Card leadCard, final CardDeck hand) {
        System.out.println("Your turn gui player.");
        return null;
    }

    public List<Card> getHand() {
        return Collections.unmodifiableList(this.getCards());
    }

    @Override
    public int placeBid() {
        return 0;
    }

    @Override
    public int placeBlindBid() {
        return 0;
    }

    @Override
    public int placeBid(Player player) {
        return 0;
    }
}
