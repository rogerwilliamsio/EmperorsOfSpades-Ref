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

//    @Override
//    public Card playCard(Card.Suit leadSuit) {
//        return null;
//    }

    @Override
    public int placeBid() {
        return 0;
    }


    public Card playCard() {
        return null;
    }

    public int placeBid(final Card.Suit leadSuit) {
        return 0;
    }

	@Override
	public Card playCard(Suit leadSuit, Card leadCard, CardDeck hand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int placeBlindBid() {
		// TODO Auto-generated method stub
		return 0;
	}
}
