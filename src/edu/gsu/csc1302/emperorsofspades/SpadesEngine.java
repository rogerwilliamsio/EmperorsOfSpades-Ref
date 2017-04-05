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

     private ArrayList<Player> players = new ArrayList<>();
	 private CardDeck gameDeck = new CardDeck();
	 private Map<String , Player> table = new HashMap<>();
	 private CardDeck hand = new CardDeck();
	 private Card.Suit leadSuit = null;
	 private int roundNumber;
	 private boolean gameEnd = false;
	 Set<Player> first = new HashSet<>();
     Set<Player> second = new HashSet<>();
     Team one = new Team("one", first);
     Team two = new Team("two", second);
	 
	 
	 /**
	  * @param players
	  * @param gameDeck
	  */
	 public SpadesEngine(ArrayList<Player> players,  CardDeck gameDeck){

		 this.setPlayers(players);
		 this.gameDeck = gameDeck;
		 table.put("dealer", players.get(0));
		 table.put("lDealer", players.get(1));
		 table.put("llDealer", players.get(2));
		 table.put("rDealer", players.get(3));
		 setHand(null);
		 roundNumber = 0;
		 
		 first.add(players.get(0));
	     first.add(players.get(1));
	     second.add(players.get(2));
	     second.add(players.get(3));
	     
	 }
	 public void dealCard() {
		 if(gameDeck.size() != 52) {
			 System.out.println("insufficient number of cards in the deck");
		 }
		 else {
			 
			 while (gameDeck.size() != 0) {
				Card c2 = gameDeck.drawFromTop();
				table.get("lDealer").addToCardDeck(c2);;
				Card c3 = gameDeck.drawFromTop();
				table.get("llDealer").addToCardDeck(c3);
				Card c4 = gameDeck.drawFromTop();
				table.get("rDealer").addToCardDeck(c4);
				Card c1 = gameDeck.drawFromTop();
				table.get("dealer").addToCardDeck(c1);
				
			 }
		 }
	 }
	 public void startRound() {
		 
		 roundNumber = roundNumber + 1;
		 
		 dealCard();
		 
		 playFirstRound();
		 
	 }
	 public void startNewRound() {
		 
		 roundNumber = roundNumber + 1;
		 
		 switchPlayers();
		 
		 dealCard();
		 
		 playRound();
		 
	 } 
	
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
	
	 private void playRound() {

		 int b1 = table.get("Dealer").placeBid();
		 int b2 = table.get("lDealer").placeBid();

		 for (int i = 0; i < 13; i++) {
	        	playHand();
	     }
		 
		 int b11 = table.get("dealer").getTeam().getTricks();

		 int b22 = table.get("lDealer").getTeam().getTricks();
		 
		 if ((b1 >= 10) && (b11 == 13)) {
			 System.out.println("team: "+  table.get("dealer").getTeam() +" has won.(Boston)"); 
			 setGameEnd(true);
		 }
		 if ((b2 >= 10) && (b22 == 13)) {
			 System.out.println("team: "+  table.get("lDealer").getTeam() +" has won.(Boston)"); 
			 setGameEnd(true);
		 }
		 if ((b1 <= b11) && (b1 >= b11 - 3)) {
			 table.get("dealer").getTeam().setSuccess(b1);
		 } 
		 else {
			 table.get("dealer").getTeam().setSets();
		 }
		 if ((b2 <= b22) && (b2 >= b22 - 3)) {
			 table.get("lDealer").getTeam().setSuccess(b2);
		 } 
		 else {
			 table.get("lDealer").getTeam().setSets();
		 } 
		 
		 checkWinner();
		
	}
	
	private void switchPlayers() {
		
		 int n1 =players.indexOf(table.get("dealer"));
		 int n2 =players.indexOf(table.get("lDealer"));
		 int n3 =players.indexOf(table.get("llDealer"));
		 int n4 =players.indexOf(table.get("rDealer"));
		 
		 
		 table.put("dealer", players.get(n2));
		 table.put("lDealer", players.get(n3));
		 table.put("llDealer", players.get(n4));
		 table.put("rDealer", players.get(n1));
		
	}
	
	public void playHand() { 
		 
		 CardDeck newHand = new CardDeck();
		 
		 this.hand = newHand;
		 
		 Card c2 = table.get("lDealer").playCard(leadSuit);
		 hand.add(c2);
		 
		 leadSuit = c2.getSuit();
		 
		 Card c3 = table.get("llDealer").playCard(leadSuit);
		 hand.add(c3);
		 Card c4 = table.get("rDealer").playCard(leadSuit);
		 hand.add(c4);
		 Card c1 = table.get("dealer").playCard(leadSuit);
		 hand.add(c1);
		 
		 SpadesComparator comp = new  SpadesComparator(leadSuit);
		 
		 int n1 = comp.compare(c1, c2);
		 int n2 = comp.compare(c1, c3);
		 int n3 = comp.compare(c1, c4);
		 int n4 = comp.compare(c2, c3);
		 int n5 = comp.compare(c2, c4);
		 int n6 = comp.compare(c3, c4);
		 
		 Card leadCard;
		 
		 if (n1<0){
			 leadCard = c1;
			 if (n2>0) {
				 leadCard = c3;
				 if (n6>0) {
					 leadCard = c4;
				 }
			 }
			 if (n3>0) {
				 leadCard = c4;
			 }
		 }
		 else {
			 leadCard = c2;
			 if (n4>0) {
				 leadCard = c3;
				 if (n6>0) {
					 leadCard = c4;
				 }
			 }
			 if (n5>0) {
				 leadCard = c4;
			 }
		 }
		 
		 int win = hand.indexOf(leadCard);
		 
		 if ((win == 0) || (win == 2)) {
			 table.get("dealer").getTeam().addTrick();
		 } 
		 else {
			 table.get("ldealer").getTeam().addTrick();
		 }
		 
	}
	
	private void checkWinner() {
		 int s1 = table.get("dealer").getTeam().getSets();
		 int s2 = table.get("lDealer").getTeam().getSets();

		 if (s1 == 0){
			 if (s2 == 2){
				System.out.println("team: "+  table.get("dealer").getTeam() +" has won."); 
				setGameEnd(true);
			 }
		 }
		 if (s2 == 0){
			 if (s1 == 2){
				System.out.println("team: "+  table.get("lDealer").getTeam() +" has won."); 
				setGameEnd(true);
			 }
		 }
		 
		 int s11 = table.get("dealer").getTeam().getScore();
		 int s22 = table.get("lDealer").getTeam().getScore();
		 
		 if (s11 >= s22 + 100) {
			 table.get("lDealer").getTeam().setBlindBet(true);
		 }
		 else{
			 table.get("lDealer").getTeam().setBlindBet(false);
		 }
		 if (s22 >= s11 + 100) {
			 table.get("dealer").getTeam().setBlindBet(true);
		 }
		 else{
			 table.get("dealer").getTeam().setBlindBet(false);
		 }
		 
		 if ((s11 >= 500) || (s22 >= 500)){
			 if (s11 > s22){
				 System.out.println("team: "+  table.get("dealer").getTeam() +" has won."); 
				 setGameEnd(true);
			 }
			 else {
				 System.out.println("team: "+  table.get("lDealer").getTeam() +" has won."); 
				 setGameEnd(true);
			 }
		 }
		 
	}
	
	/**
	 * @return the hand
	 */
	public CardDeck getHand() {
		return hand;
	}
	/**
	 * @param hand the hand to set
	 */
	public void setHand(CardDeck hand) {
		this.hand = hand;
	}
	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	/**
	 * @return the gameEnd
	 */
	public boolean isGameEnd() {
		return gameEnd;
	}
	/**
	 * @param gameEnd the gameEnd to set
	 */
	public void setGameEnd(boolean gameEnd) {
		this.gameEnd = gameEnd;
	}
	/**
	 * @return the leadSuit
	 */
	public Card.Suit getLeadSuit() {
		return leadSuit;
	}
	/**
	 * @param leadSuit the leadSuit to set
	 */
	public void setLeadSuit(Card.Suit leadSuit) {
		this.leadSuit = leadSuit;
	}
}
