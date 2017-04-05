package edu.gsu.csc1302.emperorsofspades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.team.Team;

/**
 * The game engine.
 *
 * @author Roger Williams
 */
public class SpadesEngine {
	
	 private ArrayList<Player> players = new ArrayList<>();
	 private CardDeck gameDeck = new CardDeck();
	 private Map<String , Player> table = new HashMap<>();
	 private CardDeck hand = new CardDeck();
	 private Card.Suit leadSuit = null;
	 private int roundNumber;
	 private boolean gameEnd = false;
	 
	 
	 /**
	  * @param players
	  * @param gameDeck
	  */
	 
	 public SpadesEngine( ArrayList<Player> players,  CardDeck gameDeck){
		 
		 this.setPlayers(players);
		 this.gameDeck = gameDeck;
		 table.put("dealer", players.get(0));
		 table.put("lDealer", players.get(1));
		 table.put("llDealer", players.get(2));
		 table.put("rDealer", players.get(3));
		 setHand(null);
		 roundNumber = 0;
		 
	 }
	 public void dealCard() {
		 if(gameDeck.size() != 52) {
			 System.out.println("insuficinet number of cards in the deck");
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
		 
		 playRound();
		 
	 }
	 public void startNewRound() {
		 
		 roundNumber = roundNumber + 1;
		 
		 switchPlayers();
		 
		 dealCard();
		 
		 playRound();
		 
	 }
	 private void playRound() {
		 
//		 int b1 = table.get("lDealer").placeABet();
//		 int b2 = table.get("Dealer").placeABet();

		 for (int i = 0; i <= 13; i++) {
	        	playHand();
	     }
		 
//		 int b11 = table.get("dealer").getTeam().getTricks();
//
//		 int b22 = table.get("ldealer").getTeam().getTricks();
//
//		 if (b1 <= b11 + 3) {
//			 table.get("dealer").getTeam().successScore();
//		 } 
//		 else {
//			 table.get("dealer").getTeam().setScore();
//		 }
//		 if (b2 <= b22 + 3) {
//			 table.get("ldealer").getTeam().successScore();
//		 } 
//		 else {
//			 table.get("ldealer").getTeam().setScore();
//		 } 
//		 
		 checkWinner();
		
	}
	private void checkWinner() {
		
//		 int s1 = table.get("ldealer").getTeam().getSets();
//		 int s2 = table.get("dealer").getTeam().getSets();
//		 
//		 if (s1 == 0){
//			 if (s2 == 2){
//				System.out.println("team: "+  table.get("ldealer").getTeam() +" has won."); 
//				setGameEnd(true);
//			 }
//		 }
//		 if (s2 == 0){
//			 if (s1 == 2){
//				System.out.println("team: "+  table.get("dealer").getTeam() +" has won."); 
//				setGameEnd(true);
//			 }
//		 }
//		 
//		 int s11 = table.get("ldealer").getTeam().getScore();
//		 int s22 = table.get("dealer").getTeam().getScore();
//		 
//		 if (s11 >= s22 + 100) {
//			 table.get("dealer").getTeam().setBlindBet();
//		 }
//		 if (s22 >= s11 + 100) {
//			 table.get("ldealer").getTeam().setBlindBet();
//		 }
//		 
//		 if ((s11 >= 500) || (s22 >= 500)){
//			 if (s11 > s22){
//				 System.out.println("team: "+  table.get("ldealer").getTeam() +" has won."); 
//				 setGameEnd(true);
//			 }
//			 else {
//				 System.out.println("team: "+  table.get("dealer").getTeam() +" has won."); 
//				 setGameEnd(true);
//			 }
//		 }
//		 
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
		 
		 CardDeck hand = new CardDeck();
		 
		 Card c2 = table.get("lDealer").playCard();
		 hand.add(c2);
		 Card c3 = table.get("llDealer").playCard();
		 hand.add(c3);
		 Card c4 = table.get("rDealer").playCard();
		 hand.add(c4);
		 Card c1 = table.get("dealer").playCard();
		 hand.add(c1);
		 
		 leadSuit = c2.getSuit();
		 SpadesComparator comp = new  SpadesComparator(leadSuit);
		 
		 int n1 = comp.compare(c1, c2);
		 int n2 = comp.compare(c1, c3);
		 int n3 = comp.compare(c1, c4);
		 int n4 = comp.compare(c2, c3);
		 int n5 = comp.compare(c2, c4);
		 int n6 = comp.compare(c3, c4);
		 Card leadCard;
		 
		 this.hand = hand;
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
		 
//		 if ((win == 0) || (win == 2)) {
//			 table.get("dealer").getTeam().addTrick();
//		 } 
//		 else {
//			 table.get("ldealer").getTeam().addTrick();
//		 }
	 }
	 public void handWinner() {
		 
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
