package edu.gsu.csc1302.emperorsofspades.player.console;

import java.util.InputMismatchException;
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
				+ " cards)");

		if (getCards().size() > 8) {

			CardDeck clone = (CardDeck) getCards().clone();
			System.out.println(clone.drawFromTop(8).toString());
			System.out.println(clone.toString());

		}
		else {
			System.out.println(getCards().toString());
		}

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

		System.out.println("paly a card form your hand");

		Card myCard = new Card(null, null);

		if (leadCard.getSuit() == null) {

			System.out.println("you are the first player");

			getCards().sort(Suit.HEART);

			myCard = getCard();

		}

		else {

			getCards().sort(leadSuit);
			System.out.println("cards on the table\n" + hand.toString());
			System.out.println("the lead card\n" + leadCard.toString());
			myCard = getCard();

		}
		return myCard;

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
	/**
	 * return the card the player plays.
	 * @return card the player will play
	 */
	private Card getCard() {

		Card myCard = new Card(null, null);

		int cardIndex = -2;
		do {
			cardIndex = getIndexOfCard();
			if (cardIndex != -2) {
				if ((cardIndex > getCards().size() - 1) || (cardIndex < 0)) {
					System.out.println("it should be no more"
							+ " than\n the number of cards you have\n"
							+ " and no less than 1.)");
					cardIndex = -2;
				}
			}
		} while (cardIndex == -2);

		myCard = getCards().remove(cardIndex);
		return myCard;

	}
	/**
	 * returns the index of the card.
	 * @return index of the card.
	 */
	private int getIndexOfCard() {
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);

		System.out.println("cards on your hand (" + getCards().size()
				+ " cards)");
		if (getCards().size() > 8) {

			CardDeck clone = (CardDeck) getCards().clone();
			System.out.println(clone.drawFromTop(8).toString());
			System.out.println(clone.toString());

		}
		else {
			System.out.println(getCards().toString());
		}

		int cardIndex = -1;
		System.out.println("Enter the location (number) "
				+ "of the card you want to play.)");
		try {
			cardIndex = console.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("You can only enter a number.");
			cardIndex = -1;
		}
		cardIndex--;
		return cardIndex;

	}
}
