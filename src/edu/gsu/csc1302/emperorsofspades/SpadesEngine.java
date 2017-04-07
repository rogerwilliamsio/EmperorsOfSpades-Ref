package edu.gsu.csc1302.emperorsofspades;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.team.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The game engine.
 *
 * @author Roger Williams
 */
public class SpadesEngine {
    /**
     * The minimum required team bid.
     */
	public static final int MINIMUM_TEAM_BID = 4;

    /**
     * The maximum required team bid.
     */
	public static final int MAXIMUM_TEAM_BID = 10;

    /**
     * The minimum required blind bid.
     */
	public static final int MINIMUM_BLIND_BID = 6;

    /**
     * The maximum required blind bid.
     */
    public static final int MAXIMUM_BLIND_BID = 10;

    /**
     * The maximum number of  team mates allowed on a team.
     */
    public static final int MAXIMUM_TEAMMATES = 2;

	/**
	 * Whether or not player's are allowed to renege.
	 */
    public static final boolean REGENE_ALLOWED = false;
    /**
     * this is the array that holds the players.
     */
    private ArrayList<Player> players = new ArrayList<>();
    /**
     * this is the card deck of the game.
     */
	private CardDeck gameDeck = new CardDeck();
	/**
	 * this is the map of the table.
	 * it tracks who is the dealer and who
	 * is sitting next to the dealer and so on.
	 */
	private Map<String, Player> table = new HashMap<>();
	/**
	 * this is the cards on the table.
	 * the cards that are played.
	 */
	private CardDeck hand = new CardDeck();
	/**
	 * this is the lead suit of the hand.
	 */
	private Card.Suit leadSuit = null;
	/**
	 * this the the number of rounds played.
	 */
	private int roundNumber;
	/**
	 * this is used to end the game.
	 * it tracks if there is a winner or not.
	 */
	private boolean gameEnd = false;

	 /**
	 * constructor for the Spades Engine class.
	 * @param players the list of players
	 * @param gameDeck the deck of the game.
	 */
	 public SpadesEngine(final ArrayList<Player> players,
			 final CardDeck gameDeck) {

		 this.setPlayers(players);
		 this.gameDeck = gameDeck;
		 table.put("dealer", players.get(0));
		 table.put("lDealer", players.get(1));
		 table.put("llDealer", players.get(2));
		 table.put("rDealer", players.get(3));
		 setHand(null);
		 roundNumber = 0;

		 Set<Player> first = new HashSet<>();

		 Set<Player> second = new HashSet<>();

		 first.add(players.get(0));
	     first.add(players.get(1));
	     second.add(players.get(2));
	     second.add(players.get(3));

	     Team one = new Team("one", first);

		 Team two = new Team("two", second);

		 players.get(0).addToTeam(one);
	     players.get(1).addToTeam(one);
	     players.get(2).addToTeam(two);
	     players.get(3).addToTeam(two);

	 }
	 /**
	  * this method deals/gives card to the players.
	  */
	 public void dealCard() {
		 if (gameDeck.size() != 52) {
			 System.out.println("insufficient number of cards in the deck");
		 }
		 else {

			 while (gameDeck.size() != 0) {
				Card c2 = gameDeck.drawFromTop();
				table.get("lDealer").addToCardDeck(c2);
				Card c3 = gameDeck.drawFromTop();
				table.get("llDealer").addToCardDeck(c3);
				Card c4 = gameDeck.drawFromTop();
				table.get("rDealer").addToCardDeck(c4);
				Card c1 = gameDeck.drawFromTop();
				table.get("dealer").addToCardDeck(c1);

			 }
		 }
	 }
	 /**
	  * this method calls other methods to play the first round.
	  */
	 public void startRound() {

		 roundNumber = roundNumber + 1;

		 dealCard();

		 playFirstRound();

	 }
	 /**
	  * this method calls other methods to play consecutive rounds.
	  */
	 public void startNewRound() {

		 roundNumber = roundNumber + 1;

		 switchPlayers();

		 dealCard();

		 playRound();

	 }
	/**
	 * this is the method is called for the first round.
	 * the players don't have to bid to play this round.
	 * it checks to see if there are any winners using an other method.
	 */
	 private void playFirstRound() {

		 for (int i = 0; i < 13; i++) {
	        	playHand();
	     }

		 int b11 = table.get("dealer").getTeam().getTricks();

		 int b22 = table.get("lDealer").getTeam().getTricks();

		 table.get("dealer").getTeam().setSuccess(b11);

		 table.get("lDealer").getTeam().setSuccess(b22);


		 checkWinner();

	 }
	/**
	 * this method is called to play any round after the first round.
	 * it uses an other method to check if there are any winners on each call.
	 */
	 private void playRound() {

		 int bidOfTeam1;
		 int bidOfTeam2;

		 if (table.get("dealer").getTeam().isBlindBid()) {
			 bidOfTeam1 = table.get("dealer").placeBlindBid();
		 }
		 else
		 {
			 bidOfTeam1 = table.get("dealer").placeBid();
		 }
		 if (table.get("lDealer").getTeam().isBlindBid()) {
			 bidOfTeam2 = table.get("lDealer").placeBlindBid();
		 }
		 else
		 {
			 bidOfTeam2 = table.get("lDealer").placeBid();
		 }


		 for (int i = 0; i < 13; i++) {
	        	playHand();
	     }

		 int team1Tricks = table.get("dealer").getTeam().getTricks();

		 int team2Tricks = table.get("lDealer").getTeam().getTricks();

		 if ((bidOfTeam1 >= 10) && (team1Tricks == 13)) {
			 System.out.println("team: "
		 +  table.get("dealer").getTeam() + " has won.(Boston)");
			 setGameEnd(true);
		 }
		 if ((bidOfTeam2 >= 10) && (team2Tricks == 13)) {
			 System.out.println("team: "
		 +  table.get("lDealer").getTeam() + " has won.(Boston)");
			 setGameEnd(true);
		 }
		 if ((bidOfTeam1 <= team1Tricks) && (bidOfTeam1 >= team1Tricks - 3)) {
			 table.get("dealer").getTeam().setSuccess(bidOfTeam1);
		 }
		 else {
			 table.get("dealer").getTeam().setSets();
		 }
		 if ((bidOfTeam2 <= team2Tricks) && (bidOfTeam2 >= team2Tricks - 3)) {
			 table.get("lDealer").getTeam().setSuccess(bidOfTeam2);
		 }
		 else {
			 table.get("lDealer").getTeam().setSets();
		 }

		 checkWinner();

	}
	/**
	 * this method is used to change the dealer after each round.
	 */
	private void switchPlayers() {

		 int indexOfDealer = players.indexOf(table.get("dealer"));
		 int indexOfLeftPlayer = players.indexOf(table.get("lDealer"));
		 int indexOfNextPlayer = players.indexOf(table.get("llDealer"));
		 int indexOfLastPlayer = players.indexOf(table.get("rDealer"));

		 table.put("dealer", players.get(indexOfLeftPlayer));
		 table.put("lDealer", players.get(indexOfNextPlayer));
		 table.put("llDealer", players.get(indexOfLastPlayer));
		 table.put("rDealer", players.get(indexOfDealer));

	}
	/**
	 * this method is called to pay each hand game.
	 * each players will throw one card at a time.
	 * the method will also evaluate who won the hand.
	 */
	public void playHand() {

		 CardDeck newHand = new CardDeck();

		 this.hand = newHand;

		 Card leadCard = new Card(null, null);

		 Card firstCard = table.get("lDealer").playCard(leadSuit, leadCard, hand);
		 hand.add(firstCard);

		 leadCard = firstCard;
		 leadSuit = firstCard.getSuit();
		 SpadesComparator comp = new  SpadesComparator(leadSuit);

		 Card secondCard = table.get("llDealer").playCard(leadSuit, leadCard, hand);
		 hand.add(secondCard);
		 int firstComp = comp.compare(firstCard, secondCard);
		 if (firstComp > 0) {
			  leadCard = secondCard;
		 }

		 Card thirdCard = table.get("rDealer").playCard(leadSuit, leadCard, hand);
		 hand.add(thirdCard);
		 int secondComp = comp.compare(leadCard, thirdCard);
		 if (secondComp > 0) {
			  leadCard = thirdCard;
		 }

		 Card fourthCard = table.get("dealer").playCard(leadSuit, leadCard, hand);
		 hand.add(fourthCard);

		 int thirdComp = comp.compare(leadCard, thirdCard);
		 if (thirdComp > 0) {
			  leadCard = fourthCard;
		 }

		 int win = hand.indexOf(leadCard);

		 if ((win == 0) || (win == 2)) {
			 System.out.println(table.get("dealer").getTeam());
			 table.get("dealer").getTeam().addTrick();
		 }
		 else {
			 table.get("ldealer").getTeam().addTrick();
		 }

	}
	/**
	 * this method is called to check who won the game.
	 * it is called after each round.
	 */
	private void checkWinner() {
		 int s1 = table.get("dealer").getTeam().getSets();
		 int s2 = table.get("lDealer").getTeam().getSets();

		 if (s1 == 0) {
			 if (s2 == 2) {
				System.out.println("team: "
			  + table.get("dealer").getTeam() + " has won.");
				setGameEnd(true);
			 }
		 }
		 if (s2 == 0) {
			 if (s1 == 2) {
				System.out.println("team: " + table.get("lDealer").getTeam()
						+ " has won.");
				setGameEnd(true);
			 }
		 }

		 int s11 = table.get("dealer").getTeam().getScore();
		 int s22 = table.get("lDealer").getTeam().getScore();

		 if (s11 >= s22 + 100) {
			 table.get("lDealer").getTeam().setBlindBid(true);
		 }
		 else {
			 table.get("lDealer").getTeam().setBlindBid(false);
		 }
		 if (s22 >= s11 + 100) {
			 table.get("dealer").getTeam().setBlindBid(true);
		 }
		 else {
			 table.get("dealer").getTeam().setBlindBid(false);
		 }

		 if ((s11 >= 500) || (s22 >= 500)) {
			 if (s11 > s22) {
				 System.out.println("team: "
			 + table.get("dealer").getTeam() + " has won.");
				 setGameEnd(true);
			 }
			 else {
				 System.out.println("team: "
			 + table.get("lDealer").getTeam() + " has won.");
				 setGameEnd(true);
			 }
		 }

	}

	/**
	 * returns the cards that are thrown by the players.
	 * @return the hand the cards on the table.
	 */
	public CardDeck getHand() {
		return hand;
	}
	/**
	 * this sets the hand.
	 * @param hand the hand to set.
	 */
	private void setHand(final CardDeck hand) {
		this.hand = hand;
	}
	/**
	 * returns the players in the game.
	 * @return the players the players in the game.
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	/**
	 * sets the players in the game.
	 * @param players the players to set
	 */
	public void setPlayers(final ArrayList<Player> players) {
		this.players = players;
	}
	/**
	 * returns the the variable that tracks if the game should end or not.
	 * @return the gameEnd tracks the status of the game.
	 */
	public boolean isGameEnd() {
		return gameEnd;
	}
	/**
	 * sets the status of the game.
	 * @param gameEnd the gameEnd to set
	 */
	public void setGameEnd(final boolean gameEnd) {
		this.gameEnd = gameEnd;
	}
	/**
	 * returns the lead suit of the hand.
	 * @return the leadSuit
	 */
	public Card.Suit getLeadSuit() {
		return leadSuit;
	}
	/**
	 * sets the lead suit of the hand.
	 * @param leadSuit the leadSuit to set
	 */
	public void setLeadSuit(final Card.Suit leadSuit) {
		this.leadSuit = leadSuit;
	}
}
