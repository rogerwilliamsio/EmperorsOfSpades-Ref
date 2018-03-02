//package edu.gsu.csc1302.emperorsofspades;
//
//import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
//import edu.gsu.csc1302.emperorsofspades.player.Player;
//import edu.gsu.csc1302.emperorsofspades.team.Team;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
///**
// * The game engine for GUI.
// *
// * @author Mahetem Moges
// */
//public class SpadesEngineExtGUI extends SpadesEngineExt {
//	 /**
//	 * constructor for the Spades Engine class.
//	 * @param players the list of players
//	 * @param gameDeck the deck of the game.
//	 */
//	 public SpadesEngineExtGUI(final ArrayList<Player> players,
//			 final CardDeck gameDeck) {
//		 super(players, gameDeck);
//	 }
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
//	private void orderSwitch2() {
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
//	private void orderSwitch3() {
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
//	private void orderSwitch4() {
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
//	 * return the array list of the history for the hand.
//	 * @param deck the hand played
//	 * @param index the index of the player in the order
//	 * @param card the winning card of the hand
//	 */
//	private void updateStats(
//			final CardDeck deck, final int index, final Card card) {
//
//		Player winner = table.get(order.get(index));
//		CardDeck cDeck = deck;
//		Card leadCard = card;
//
//		handWinner = winner;
//
//		Map<String, Object> handStat = new HashMap<>();
//
//		handStat.put("player", winner);
//		System.out.println("this is pppppp " + winner);
//		handStat.put("hand", cDeck);
//		handStat.put("leadCard", leadCard);
//
//		handHistory.add((HashMap<String, Object>) handStat);
//	}
//	/**
//	 * checks if one team alone got set twice consecutively.
//	 */
//	private void checkSets() {
//
//		Team team1 = teams.get(teamName1);
//		Team team2 = teams.get(teamName2);
//
//		int teamTrick1 = team1.getNumOfSets();
//		int teamTrick2 = team2.getNumOfSets();
//
//		if (teamTrick1 > 0) {
//			if (teamTrick2 > 0) {
//				team1.setNumOfSets(0);
//				team2.setNumOfSets(0);
//			}
//		}
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
//	 * the hand history in an array list.
//	 * @return the handHistory
//	 */
//	public ArrayList<HashMap<String, Object>> getHandHistory() {
//		return handHistory;
//	}
////	/**
////	 * sets the hand history.
////	 * @param handHistory the handHistory to set
////	 */
////	public void setHandHistory(final ArrayList
////			<HashMap<String, Object>> handHistory) {
////		this.handHistory = handHistory;
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
//	 * returns teams in an array list.
//	 * @return teams in an array list.
//	 */
//	public ArrayList<Team> getTeamsArray() {
//		Team team1 = getTeam1();
//		Team team2 = getTeam2();
//		ArrayList<Team> gameTeam = new ArrayList<>();
//		gameTeam.add(team1);
//		gameTeam.add(team2);
//		return gameTeam;
//	}
//
//	/**
//	 * User's decision to play or not.
//	 * @return true/false
//	 */
//	public boolean getConsolePlayerIsPlaying() {
//		return this.consolePlayerIsPlaying;
//	}
//
//	/**
//	 * User's decision to play or not.
//	 * @param wantsToPlay true/false
//	 */
//	public void setConsolePlayerIsPlaying(final boolean wantsToPlay) {
//		this.consolePlayerIsPlaying = wantsToPlay;
//	}
//	/**
//	 * starts the round for the GUI.
//	 */
//	public void startRoundGUI() {
//
//		roundNumber++;
//		dealCards();
//
//	}
//	/**
//	 * this method is called to pay each hand game for the GUI.
//	 * each players will throw one card at a time.
//	 * the method will also evaluate who won the hand.
//	 */
//	public void playHandGUI() {
//
//		 CardDeck newHand = new CardDeck();
//		 handNumber++;
//		 turn = 0;
//
//		 this.hand = newHand;
//
//	}
//	/**
//	 * returns the next player in the hand.
//	 * @return the next player in the hand
//	 */
//	public Player getNextPlayer() {
//
//		turn++;
//		Player player = table.get(order.get(turn));
//		return player;
//
//	}
//
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
//	/**
//	 * returns the hand number.
//	 * @return the handNumber
//	 */
//	public int getHandNumber() {
//		return handNumber;
//	}
//	/**
//	 * sets the hand number.
//	 * @param handNumber the handNumber to set
//	 */
//	public void setHandNumber(final int handNumber) {
//		this.handNumber = handNumber;
//	}
//	/**
//	 * end of the hand record keeper.
//	 */
//	public void endOfHand() {
//
//		 CardDeck newHand = new CardDeck();
//
//		 Card leadCard = new Card(null, null);
//		 leadSuit = null;
//
//		 Card firstCard = hand.get(0);
//		 newHand.addToBottom(firstCard);
//
//		 leadCard = firstCard;
//		 leadSuit = firstCard.getSuit();
//
//		 SpadesComparator comp = new  SpadesComparator(leadSuit);
//
//		 Card secondCard = hand.get(1);
//		 newHand.addToBottom(secondCard);
//
//		 int firstComp = comp.compare(firstCard, secondCard);
//		 if (firstComp > 0) {
//			  leadCard = secondCard;
//		 }
//
//		 Card thirdCard = hand.get(2);
//		 newHand.addToBottom(thirdCard);
//
//		 int secondComp = comp.compare(leadCard, thirdCard);
//		 if (secondComp > 0) {
//			  leadCard = thirdCard;
//		 }
//
//		 Card fourthCard = hand.get(3);
//		 newHand.addToBottom(fourthCard);
//
//		 int thirdComp = comp.compare(leadCard, fourthCard);
//		 if (thirdComp > 0) {
//			  leadCard = fourthCard;
//		 }
//
//		 int win = newHand.indexOf(leadCard);
//
//		 if (win == 0) {
//			 updateStats(hand, win + 1, leadCard);
//			 updateTricks(win + 1);
//		 }
//		 if (win == 2) {
//			 updateStats(hand, win + 1, leadCard);
//			 updateTricks(win + 1);
//			 orderSwitch3();
//		 }
//		 if (win == 1) {
//			 updateStats(hand, win + 1, leadCard);
//			 updateTricks(win + 1);
//			 orderSwitch2();
//		 }
//		 if (win == 3) {
//			 updateStats(hand, win + 1, leadCard);
//			 updateTricks(win + 1);
//			 orderSwitch4();
//		 }
//
//	}
//	/**
//	 * end of the hand record keeper.
//	 */
//	public void endOfRound() {
//
//		Team team1 = getTeam1();
//		Team team2 = getTeam2();
//		team1.setTeamScore(10 * team1.getTricks());
//		team2.setTeamScore(10 * team2.getTricks());
//
//	}
//	/**
//	 * updates the trick of the winning team.
//	 * @param index of the winner player.
//	 */
//	private void updateTricks(final int index) {
//		Team winTeam = getTeam(table.get(order.get(index)));
//		winTeam.addTrick();
//	}
//	@Override
//	public void playHand() {
//		// TODO Auto-generated method stub
//
//	}
//}
