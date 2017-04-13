package edu.gsu.csc1302.emperorsofspades.player.console;

import java.util.Scanner;

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
    	@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
    	System.out.println("cards on your hand (" + getCards().size()
				+ " cards)\n"
		+ getCards().toString());
    	System.out.println("place your bid");
    	System.out.println("get a number b/n 4 and 10 and half and round it.");
    	int bid = console.nextInt();
        return bid;
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
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		System.out.println("paly a card form your hand");
		Card myCard = new Card(null, null);

		if (leadCard.getSuit() == null) {
			System.out.println("you are the first player");
			System.out.println("cards on your hand (" + getCards().size()
					+ " cards)\n"
			+ getCards().toString());
			System.out.println("Enter the card location (index [starts from 0])");
			int cardIndex = console.nextInt();
			while (cardIndex > getCards().size() - 1) {
				System.out.println("index out of bound (it should be no more"
			+ "than\n the number of cards you have less by one.)");
				System.out.println("Enter the card location (index [starts from 0])");
				cardIndex = console.nextInt();
			}
			myCard = getCards().remove(cardIndex);
			return myCard;
		}

		else {
			System.out.println("cards on the table\n" + hand.toString());
			System.out.println("the lead card\n" + leadCard.toString());
			System.out.println("cards on your hand (" + getCards().size()
					+ " cards)\n"
			+ getCards().toString());
			System.out.println("Enter the card location (index [starts from 0])");
			int cardIndex = console.nextInt();
			while (cardIndex > getCards().size() - 1) {
				System.out.println("index out of bound (it should be no more"
			+ " than\n the number of cards you have less by one.)");
				System.out.println("Enter the card location (index [starts from 0])");
				cardIndex = console.nextInt();
			}
			myCard = getCards().remove(cardIndex);
			return myCard;
		}

	}
	/**
	 * this asks the console player to blind bid.
	 */
	@Override
	public int placeBlindBid() {
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
    	System.out.println("place your blind bid");
    	System.out.println("get a number 6 and 10.");
    	int bid = console.nextInt();
        return bid;
	}
//	 /**
//     * returns a card from the hand of the console player.
//     * @param leadSuit the lead suit of the hand.
//     * @return card form the hand of the console player.
//     */
//    public int placeBid(final Card.Suit leadSuit) {
//        return 0;
//    }
	/**
	 * this places a bid for the console player.
	 * @param player the other player in the team.
	 */
	@Override
	public int placeBid(final Player player) {
		int bid = placeBid();
		int otherBid = player.placeBid();
		return bid + otherBid;
	}
}
