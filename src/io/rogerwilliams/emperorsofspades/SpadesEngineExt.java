//package edu.gsu.csc1302.emperorsofspades;
//
//import Card;
//import Player;
//import Team;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
///**
// * The game engine.
// *
// * @author Mahetem Moges
// */
//public abstract class SpadesEngineExt {
//    /**
//     * The minimum required team bid.
//     */
//	public static final int MINIMUM_TEAM_BID = 4;
//	/**
//	 * history of the hands.
//	 */
//	private ArrayList<HashMap<String, Object>> handHistory = new ArrayList<>();
//    /**
//     * The maximum required team bid.
//     */
//	public static final int MAXIMUM_TEAM_BID = 10;
//    /**
//     * The minimum required blind bid.
//     */
//	public static final int MINIMUM_BLIND_BID = 6;
//    /**
//     * The maximum required blind bid.
//     */
//    public static final int MAXIMUM_BLIND_BID = 10;
//
//    /**
//     * The maximum number of  team mates allowed on a team.
//     */
//    public static final int MAXIMUM_TEAMMATES = 2;
//
//	/**
//	 * Whether or not player's are allowed to renege.
//	 */
//    public static final boolean RENEGE_ALLOWED = false;
//    /**
//     * this is the array that holds the players.
//     */
//    private ArrayList<Player> players = new ArrayList<>();
//    /**
//	 * this is the map of the table.
//	 * it tracks who is the dealer and who
//	 * is sitting next to the dealer and so on.
//	 */
//	private Map<String, Player> table = new HashMap<>();
//    /**
//     * this is the card deck of the game.
//     */
//	private CardDeck gameDeck = new CardDeck();
//	/**
//	 * this is the map of the table.
//	 * it tracks the teams.
//	 */
//	private Map<String, Team> teams = new HashMap<>();
//	/**
//	 * this is the cards on the table.
//	 * the cards that are played.
//	 */
//	private CardDeck hand = new CardDeck();
//	/**
//	 * the hand winner.
//	 */
//	private Player handWinner;
//	/**
//	 * this is the lead suit of the hand.
//	 */
//	private Card.Suit leadSuit;
//	/**
//	 * name of the first team.
//	 */
//	private String teamName1;
//	/**
//	 * name of the second team.
//	 */
//	private String teamName2;
//	/**
//	 * this the the number of rounds played.
//	 */
//	@SuppressWarnings("unused")
//	private int roundNumber;
//	/**
//	 * this is used to end the game.
//	 * it tracks if there is a winner or not.
//	 */
//	private boolean gameEnd = false;
//	/**
//	 * a map of index number to the players on the table.
//	 */
//	private Map<Integer, String> order = new HashMap<>();
//	 /**
//	 * constructor for the Spades Engine class.
//	 * @param players the list of players
//	 * @param gameDeck the deck of the game.
//	 */
//	 public SpadesEngineExt(final ArrayList<Player> players,
//			 final CardDeck gameDeck) {
//
//		 this.setPlayers(players);
//		 this.gameDeck = gameDeck;
//
//		 Random rand = new Random();
//		 int randomIndex = rand.nextInt(4);
//		 int randomIndex1 = rand.nextInt(4);
//		 while (randomIndex == randomIndex1) {
//			 randomIndex1 = rand.nextInt(4);
//		 }
//		 int randomIndex2 = rand.nextInt(4);
//		 while ((randomIndex == randomIndex2) || (randomIndex1 == randomIndex2)) {
//			 randomIndex2 = rand.nextInt(4);
//		 }
//		 int randomIndex3 = rand.nextInt(4);
//		 while ((randomIndex == randomIndex3) || (randomIndex1 == randomIndex3)
//				 || (randomIndex2 == randomIndex3)) {
//			 randomIndex3 = rand.nextInt(4);
//		 }
//
//		 table.put("dealer", players.get(randomIndex));
//		 table.put("lDealer", players.get(randomIndex1));
//		 table.put("llDealer", players.get(randomIndex2));
//		 table.put("rDealer", players.get(randomIndex3));
//
//		 order.put(4, "dealer");
//		 order.put(1, "lDealer");
//		 order.put(2, "llDealer");
//		 order.put(3, "rDealer");
//
//		 this.hand = null;
//		 leadSuit = null;
//		 roundNumber = 0;
//		 teamName1 = "one";
//		 teamName2 = "two";
//	     Team one = new Team(teamName1,  players.get(randomIndex));
//	     one.addPlayer(players.get(randomIndex2));
//		 Team two = new Team(teamName2,  players.get(randomIndex1));
//		 two.addPlayer(players.get(randomIndex3));
//		 teams.put(teamName1, one);
//		 teams.put(teamName2, two);
//
//	 }
//	 /**
//	  * this method deals/gives card to the players.
//	  */
//	 public void dealCards() {
//		 if (gameDeck.size() != 52) {
//			 System.out.println("insufficient number of cards in the deck");
//		 }
//		 else {
//
//			 CardDeck clone = (CardDeck) gameDeck.clone();
//			 clone.shuffle();
//			 clone.shuffle();
//
//			 while (clone.size() != 0) {
//				Card card1 = clone.drawFromTop();
//				table.get("lDealer").addToCardDeck(card1);
//				Card card2 = clone.drawFromTop();
//				table.get("llDealer").addToCardDeck(card2);
//				Card card3 = clone.drawFromTop();
//				table.get("rDealer").addToCardDeck(card3);
//				Card card4 = clone.drawFromTop();
//				table.get("dealer").addToCardDeck(card4);
//
//			 }
//		 }
//	 }
//	/**
//	 * this method is used to change the dealer after each round.
//	 */
//	public void switchPlayers() {
//
//		 int indexOfDealer = players.indexOf(table.get("dealer"));
//		 int indexOfLeftPlayer = players.indexOf(table.get("lDealer"));
//		 int indexOfNextPlayer = players.indexOf(table.get("llDealer"));
//		 int indexOfLastPlayer = players.indexOf(table.get("rDealer"));
//
//		 table.put("dealer", players.get(indexOfLeftPlayer));
//		 table.put("lDealer", players.get(indexOfNextPlayer));
//		 table.put("llDealer", players.get(indexOfLastPlayer));
//		 table.put("rDealer", players.get(indexOfDealer));
//
//		 order.put(4, "dealer");
//		 order.put(1, "lDealer");
//		 order.put(2, "llDealer");
//		 order.put(3, "rDealer");
//
//	}
//	/**
//	 * this method is called to pay each hand game.
//	 * each players will throw one card at a time.
//	 * the method will also evaluate who won the hand.
//	 */
//	public abstract void playHand();
//
//	/**
//	 * returns the cards that are thrown by the players.
//	 * @return the hand the cards on the table.
//	 */
//	public CardDeck getHand() {
//		return hand;
//	}
//	/**
//	 * returns the players in the game.
//	 * @return the players the players in the game.
//	 */
//	public ArrayList<Player> getPlayers() {
//		return players;
//	}
//	/**
//	 * sets the players in the game.
//	 * @param players the players to set
//	 */
//	public void setPlayers(final ArrayList<Player> players) {
//		this.players = players;
//	}
//	/**
//	 * returns the the variable that tracks if the game should end or not.
//	 * @return the gameEnd tracks the status of the game.
//	 */
//	public boolean isGameEnd() {
//		return gameEnd;
//	}
//	/**
//	 * sets the status of the game.
//	 * @param gameEnd the gameEnd to set
//	 */
//	public void setGameEnd(final boolean gameEnd) {
//		this.gameEnd = gameEnd;
//	}
//	/**
//	 * returns the lead suit of the hand.
//	 * @return the leadSuit
//	 */
//	public Card.Suit getLeadSuit() {
//		return leadSuit;
//	}
//	/**
//	 * sets the lead suit of the hand.
//	 * @param leadSuit the leadSuit to set
//	 */
//	public void setLeadSuit(final Card.Suit leadSuit) {
//		this.leadSuit = leadSuit;
//	}
//	 /**
//	  * returns the team of the player.
//	  * @param player the player
//	  * @return team the team of the player
//	  */
//	public Team getTeam(final Player player) {
//		String name = player.getTeamName();
//		return teams.get(name);
//	}
//	/**
//	 * Switches order if the second player wins the hand.
//	 */
//	public void orderSwitch2() {
//
//		String winner = order.get(2);
//		String next2Winner = order.get(3);
//		String winnerTeamMate = order.get(4);
//		String lastPlayer = order.get(1);
//
//		order.put(1, winner);
//		order.put(2, next2Winner);
//		order.put(3, winnerTeamMate);
//		order.put(4, lastPlayer);
//	}
//	/**
//	 * Switches order if the second player wins the hand.
//	 */
//	public void orderSwitch3() {
//		String winner = order.get(3);
//		String next2Winner = order.get(4);
//		String winnerTeamMate = order.get(1);
//		String lastPlayer = order.get(2);
//
//		order.put(1, winner);
//		order.put(2, next2Winner);
//		order.put(3, winnerTeamMate);
//		order.put(4, lastPlayer);
//	}
//	/**
//	 * Switches order if the second player wins the hand.
//	 */
//	public void orderSwitch4() {
//
//		String winner = order.get(4);
//		String next2Winner = order.get(1);
//		String winnerTeamMate = order.get(2);
//		String lastPlayer = order.get(3);
//
//		order.put(1, winner);
//		order.put(2, next2Winner);
//		order.put(3, winnerTeamMate);
//		order.put(4, lastPlayer);
//
//	}
//	/**
//	 * returns the teams on the table.
//	 * @return the teams
//	 */
//	public Map<String, Team> getTeams() {
//		return teams;
//	}
//	/**
//	 * returns the name of team one.
//	 * @return the teamName1
//	 */
//	public String getTeamName1() {
//		return teamName1;
//	}
//	/**
//	 * returns the name of team two.
//	 * @return the teamName2
//	 */
//	public String getTeamName2() {
//		return teamName2;
//	}
//	/**
//	 * returns the order of players, which means who plays first and next.
//	 * @return the order
//	 */
//	public Map<Integer, String> getOrder() {
//		return order;
//	}
//	/**
//	 * returns the hand winner.
//	 * @return the handWinner
//	 */
//	public Player getHandWinner() {
//		return handWinner;
//	}
////	/**
////	 * sets the hand winner.
////	 * @param handWinner the handWinner to set
////	 */
////	public void setHandWinner(Player handWinner) {
////		this.handWinner = handWinner;
////	}
//	/**
//	 * returns team one.
//	 * @return the team one.
//	 */
//	public Team getTeam1() {
//		Team team = teams.get(teamName1);
//		return team;
//	}
//	/**
//	 * returns team two.
//	 * @return the team two.
//	 */
//	public Team getTeam2() {
//		Team team = teams.get(teamName2);
//		return team;
//	}
//	/**
//	 * returns the dealer in the round.
//	 * @return the dealer player.
//	 */
//	public Player getDealer() {
//
//		Player player = table.get("dealer");
//		return player;
//
//	}
//}
