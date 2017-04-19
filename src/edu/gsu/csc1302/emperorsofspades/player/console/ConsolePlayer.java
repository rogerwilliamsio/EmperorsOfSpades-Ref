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
 * @author Mahetem Moges
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

		CardDeck clone = (CardDeck) getCards().clone();
		clone.sort(Card.Suit.HEART);
		System.out.println(clone.drawFromTop(8).toString());
		System.out.println(clone.toString());

    	System.out.println("place your bid");
    	System.out.println("it is a number b/n 4 and 10.");
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

			myCard = getCard(leadSuit);

		}

		else {

			getCards().sort(leadSuit);
			System.out.println("cards on the table\n" + hand.toString());
			System.out.println("the lead card\n" + leadCard.toString());
			myCard = getCard(leadSuit);

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
    	System.out.println("it is a number b/n 6 and 10.");
    	int bid = console.nextInt();
        return bid;
	}
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

	@Override
	public Card playCard(CardDeck hand) {
		return null;
	}

	/**
	 * return the card the player plays.
	 * @param leadSuit the lead suit of the hand.
	 * @return card the player will play
	 */
	private Card getCard(final Card.Suit leadSuit) {

		Card myCard = new Card(null, null);

		int cardIndex = -2;
		do {
			cardIndex = getIndexOfCard();
			if (cardIndex != -2) {
				boolean indexValidity = (cardIndex > getCards().size() - 1)
						|| (cardIndex < 0);
				if (indexValidity) {
					System.out.println("the number should be no more"
							+ " than\n the number of cards you have\n"
							+ " and no less than 1.");
					cardIndex = -2;
				}
			}
		} while (cardIndex == -2);

		myCard = getCards().get(cardIndex);

		enforceNoRenege(myCard, leadSuit);

		getCards().remove(myCard);
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
	/**
	 * enforces no renege.
	 * @param myCard the card the console player chose.
	 * @param leadSuit the lead suit of the hand.
	 */
	private void enforceNoRenege(final Card myCard, final Card.Suit leadSuit) {
		boolean renege = (myCard.getRank().equals(Card.Rank.TWO))
				|| (myCard.getSuit().equals(Card.Suit.SPADE))
				|| (myCard.getSuit().equals(leadSuit));
		if (!renege) {
			 CardDeck cardsInSuit = new CardDeck();
			 //Find all the cards that are in-suit
		        for (Card card : this.getCards()) {
		        	boolean canPlay = ((card.getSuit().equals(leadSuit))
		        			&& (!card.getRank().equals(Card.Rank.TWO)));
		            if (canPlay) {
		                cardsInSuit.add(card);
		            }
		        }
		        cardsInSuit.sort(leadSuit);
	            if (cardsInSuit.size() != 0) {
	            	System.out.println("You can only play a "
	    					+ "card that is in the Lead-Suit, \n"
	    					+ "unless it is a trump card.");
	            	System.out.println("the Lead Suit for the hand is "
	    					+ leadSuit.toString() + ".");
	    			getCard(leadSuit);
	            }
		}
	}

}
