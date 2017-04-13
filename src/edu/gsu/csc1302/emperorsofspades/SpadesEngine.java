package edu.gsu.csc1302.emperorsofspades;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.team.Team;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * The game engine.
 *
 * @author Mahetem Moges
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
    public static final boolean RENEGE_ALLOWED = false;

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
	 * it tracks the teams.
	 */
	private final Map<String, Team> teams = new HashMap<>();
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
	private Card.Suit leadSuit;
	/**
	 * name of the first team.
	 */
	private final String teamName1;
	/**
	 * name of the second team.
	 */
	private final String teamName2;
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

		 Random rand = new Random();
		 int randomIndex = rand.nextInt(4);
		 int randomIndex1 = rand.nextInt(4);
		 while (randomIndex == randomIndex1) {
			 randomIndex1 = rand.nextInt(4);
		 }
		 int randomIndex2 = rand.nextInt(4);
		 while ((randomIndex == randomIndex2) || (randomIndex1 == randomIndex2)) {
			 randomIndex2 = rand.nextInt(4);
		 }
		 int randomIndex3 = rand.nextInt(4);
		 while ((randomIndex == randomIndex3) || (randomIndex1 == randomIndex3)
				 || (randomIndex2 == randomIndex3)) {
			 randomIndex3 = rand.nextInt(4);
		 }

		 table.put("dealer", players.get(randomIndex));
		 table.put("lDealer", players.get(randomIndex1));
		 table.put("llDealer", players.get(randomIndex2));
		 table.put("rDealer", players.get(randomIndex3));

		 setHand(null);
		 leadSuit = null;
		 roundNumber = 0;
		 teamName1 = "one";
		 teamName2 = "two";
	     Team one = new Team(teamName1,  players.get(randomIndex));
	     one.addPlayer(players.get(randomIndex2));
		 Team two = new Team(teamName2,  players.get(randomIndex1));
		 two.addPlayer(players.get(randomIndex3));
		 teams.put(teamName1, one);
		 teams.put(teamName2, two);

	 }
	 /**
	  * this method calls other methods to play the first round.
	  */
	 public void startRound() {

		 roundNumber++;
		 System.out.println("round number " + roundNumber + ".");

		 dealCards();

		 playFirstRound();

	 }
	 /**
	  * this method calls other methods to play consecutive rounds.
	  */
	 public void startNewRound() {

		 roundNumber++;
		 System.out.println("round number " + roundNumber + ".");

		 switchPlayers();

		 dealCards();

		 playRound();

	 }
	 /**
	  * this method deals/gives card to the players.
	  */
	 public void dealCards() {
		 if (gameDeck.size() != 52) {
			 System.out.println("insufficient number of cards in the deck");
		 }
		 else {

			 CardDeck clone = (CardDeck) gameDeck.clone();
			 clone.shuffle();
			 clone.shuffle();

			 while (clone.size() != 0) {
				Card card1 = clone.drawFromTop();
				table.get("lDealer").addToCardDeck(card1);
				Card card2 = clone.drawFromTop();
				table.get("llDealer").addToCardDeck(card2);
				Card card3 = clone.drawFromTop();
				table.get("rDealer").addToCardDeck(card3);
				Card card4 = clone.drawFromTop();
				table.get("dealer").addToCardDeck(card4);

			 }
		 }
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

		 int teamTrick1 = teams.get(teamName1).getTricks();

		 int teamTrick2 = teams.get(teamName2).getTricks();

		 teams.get(teamName1).setSuccess(teamTrick1);

		 teams.get(teamName2).setSuccess(teamTrick2);

		 checkWinner();

	 }

	/**
	 * this method is called to play any round after the first round.
	 * it uses an other method to check if there are any winners on each call.
	 */
	 private void playRound() {

		 int bidOfTeam1;
		 int bidOfTeam2;

		 Team team1 = getTeam(table.get("dealer"));

		 Team team2 = getTeam(table.get("lDealer"));

		 bidOfTeam1 = team1.placeTeamBid(table.get("dealer"),
				 table.get("llDealer"));

		 bidOfTeam2 = team2.placeTeamBid(table.get("lDealer"),
				 table.get("rDealer"));

		 for (int i = 0; i < 13; i++) {
	        	playHand();
	     }

		 int team1Tricks = team1.getTricks();

		 int team2Tricks = team2.getTricks();

		 if ((bidOfTeam1 >= 10) && (team1Tricks == 13)) {
			 System.out.println("team: "
		 +  team1.toString() + " has won.(Boston)");
			 System.out.println(team1.getTeammates().toString());
			 setGameEnd(true);
		 }
		 if ((bidOfTeam2 >= 10) && (team2Tricks == 13)) {
			 System.out.println("team: "
		 +  team2.toString() + " has won.(Boston)");
			 System.out.println(team2.getTeammates().toString());
			 setGameEnd(true);
		 }
		 if ((bidOfTeam1 <= team1Tricks) && (bidOfTeam1 >= team1Tricks - 3)) {
			 team1.setSuccess(bidOfTeam1);
		 }
		 else {
			 team1.setSets();
		 }
		 if ((bidOfTeam2 <= team2Tricks) && (bidOfTeam2 >= team2Tricks - 3)) {
			 team2.setSuccess(bidOfTeam2);
		 }
		 else {
			 team2.setSets();
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

		 Team team1 = getTeam(table.get("dealer"));
		 Team team2 = getTeam(table.get("lDealer"));
		System.out.println("team 2: " + team2);
		 Card leadCard = new Card(null, null);
		 leadSuit = null;

		 Card firstCard = table.get("lDealer").playCard(leadSuit, leadCard, hand);

		 hand.addToTop(firstCard);
		 leadCard = firstCard;
		 leadSuit = firstCard.getSuit();
		 SpadesComparator comp = new  SpadesComparator(leadSuit);


		 Card secondCard = table.get("llDealer").playCard(leadSuit, leadCard, hand);
		 hand.addToTop(secondCard);

		 int firstComp = comp.compare(firstCard, secondCard);
		 if (firstComp > 0) {
			  leadCard = secondCard;
		 }


		 Card thirdCard = table.get("rDealer").playCard(leadSuit, leadCard, hand);
		 hand.addToTop(thirdCard);

		 int secondComp = comp.compare(leadCard, thirdCard);
		 if (secondComp > 0) {
			  leadCard = thirdCard;
		 }

		 Card fourthCard = table.get("dealer").playCard(leadSuit, leadCard, hand);
		 hand.addToTop(fourthCard);

		 int thirdComp = comp.compare(leadCard, thirdCard);
		 if (thirdComp > 0) {
			  leadCard = fourthCard;
		 }

		 int win = hand.indexOf(leadCard);

		 if ((win == 0) || (win == 2)) {
			 team1.addTrick();
		 }
		 else {
			 team2.addTrick();
		 }

	}
	/**
	 * this method is called to check who won the game.
	 * it is called after each round.
	 */
	private void checkWinner() {

		 int numOfSets1 = teams.get(teamName1).getNumOfSets();
		 int numOfSets2 = teams.get(teamName2).getNumOfSets();

		 if (numOfSets1 == 0) {
			 if (numOfSets2 == 2) {
				System.out.println("team: "
			  + teams.get(teamName1).toString() + " has won.");
				System.out.println(teams.get(teamName1).getTeammates().toString());
				System.out.println("team: "
						  + teams.get(teamName2).toString() + " got two sets in a row.");
				setGameEnd(true);
			 }
		 }
		 if (numOfSets2 == 0) {
			 if (numOfSets1 == 2) {
				 System.out.println("team: "
					  + teams.get(teamName2).toString() + " has won.");
				 System.out.println(teams.get(teamName2).getTeammates().toString());
						System.out.println("team: "
							+ teams.get(teamName1).toString() + " got two sets in a row.");
				setGameEnd(true);
			 }
		 }

		 int teamScore1 = teams.get(teamName1).getScore();
		 int teamScore2 = teams.get(teamName2).getScore();

		 if (teamScore1 >= teamScore2 + 100) {
			 teams.get(teamName1).setIsBlindBid(true);
		 }
		 else {
			 teams.get(teamName1).setIsBlindBid(false);
		 }
		 if (teamScore2 >= teamScore1 + 100) {
			 teams.get(teamName2).setIsBlindBid(true);
		 }
		 else {
			 teams.get(teamName2).setIsBlindBid(false);
		 }

		 if ((teamScore1 >= 500) || (teamScore2 >= 500)) {
			 if (teamScore1 > teamScore2) {
				 System.out.println("team: "
			 + teams.get(teamName1).toString() + " has won by points.");
				 System.out.println(teams.get(teamName1).getTeammates().toString());
				 setGameEnd(true);
			 }
			 else {
				 System.out.println("team: "
			 + teams.get(teamName2).toString() + " has won points.");
				 System.out.println(teams.get(teamName2).getTeammates().toString());
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

	 /**
	  * returns the team of the player.
	  * @param player the player
	  * @return team the team of the player
	  */
	public Team getTeam(final Player player) {
		String name = player.getTeamName();
		return teams.get(name);
	}
}
