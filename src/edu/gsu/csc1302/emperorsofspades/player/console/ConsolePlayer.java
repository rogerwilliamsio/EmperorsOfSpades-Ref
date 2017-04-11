package edu.gsu.csc1302.emperorsofspades.player.console;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card.Suit;
import edu.gsu.csc1302.emperorsofspades.player.Player;

/**
 * Simulates a console player.
 *
 * @author Roger Williams
 */
public class ConsolePlayer extends Player {
    /**
     * Class constructor.
     *
     * @param name the name of the player
     */
    public ConsolePlayer(final String name) {
        super(name);
    }
    /**
     * this places bid for the console player.
     */
    @Override
    public int placeBid() {
        return 0;
    }
    /**
     * returns a card from the hand of the console player.
     * @return card from the hand of the console player
     */
    public Card playCard() {
        return null;
    }
    /**
     * returns a card from the hand of the console player.
     * @param leadSuit the lead suit of the hand.
     * @return card form the hand of the console player.
     */
    public int placeBid(final Card.Suit leadSuit) {
        return 0;
    }
    /**
     * this plays a card from the hand of the console player.
     * @param leadSuit the lead suit of the game.
     * @param leadCard the lead card in the hand.
     * @param hand cards that have been played.
     * @return card form the hand of the console player.
     */
	@Override
	public Card playCard(final Suit leadSuit, final Card leadCard,
			final CardDeck hand) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * this asks the console player to blid bid.
	 */
	@Override
	public int placeBlindBid() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * this plays card from the hand of the console player.
	 * @return card form the hand of the console player.
	 */
	@Override
	public Card playCard(final Suit leadSuit) {
		// TODO Auto-generated method stub
		return null;
	}
}
