package edu.gsu.csc1302.emperorsofspades;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gsu.csc1302.coll1.Card;
import edu.gsu.csc1302.coll1.instr.ArrayListDeck;
import edu.gsu.csc1302.coll1.instr.InstrSpadesComparator;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.team.Team;

/**
 * The game engine.
 *
 * @author Roger Williams
 */
public class SpadesEngine {
	
	 private ArrayList<Player> players;
	 private ArrayListDeck gameDeck;
	 private HashMap<String , Player> table;
	 private ArrayListDeck hand;
	 private boolean round;
	 private int roundNumber;
	 
	 /**
	  * 
	  * @param players
	  * @param gameDeck
	  */
	 public SpadesEngine( ArrayList<Player> players,  ArrayListDeck gameDeck){
		 this.setPlayers(players);
		 this.gameDeck = gameDeck;
		 table.put("dealer", players.get(0));
		 table.put("lDealer", players.get(1));
		 table.put("llDealer", players.get(2));
		 table.put("rDealer", players.get(3));
		 setHand(null);
		 round = false;
		 roundNumber = 0;
	 }
	 public void dealCard() {
		 if(gameDeck.size() != 52) {
			 System.out.println("insuficinet number of cards in the deck");
		 }
		 else {
			 while (gameDeck.size() != 0) {
				Card c1 = gameDeck.drawFromTop();
				table.get("dealer").getHand().add(c1);
				Card c2 = gameDeck.drawFromTop();
				table.get("lDealer").getHand().add(c2);
				Card c3 = gameDeck.drawFromTop();
				table.get("llDealer").getHand().add(c3);
				Card c4 = gameDeck.drawFromTop();
				table.get("rDealer").getHand().add(c4);
			 }
		 }
	 }
	 public void startRound() { 
		 round = true;
		 roundNumber = roundNumber + 1;
		 dealCard();
	 }
	 public void startNewRound() { 
		 round = true;
		 roundNumber = roundNumber + 1;
		 int n1 =players.indexOf(table.get("dealer"));
		 int n2 =players.indexOf(table.get("lDealer"));
		 int n3 =players.indexOf(table.get("llDealer"));
		 int n4 =players.indexOf(table.get("rDealer"));
		 table.put("dealer", players.get(n2));
		 table.put("lDealer", players.get(n3));
		 table.put("llDealer", players.get(n4));
		 table.put("rDealer", players.get(n1));
		 dealCard();
	 }
	 public Team playHand() {
		 Team winner;
		 if ((table.get("dealer").getHand().isEmpty()) || (!round) ){
			 System.out.println("this round is over start another round");
			 round = false;
		 } 
		 else {
			 Card c1 = table.get("dealer").getHand().drawFromTop();
			 hand.add(c1);
			 Card c2 = table.get("lDealer").getHand().drawFromTop();
			 hand.add(c2);
			 Card c3 = table.get("llDealer").getHand().drawFromTop();
			 hand.add(c3);
			 Card c4 = table.get("rDealer").getHand().drawFromTop();
			 hand.add(c4);
			 InstrSpadesComparator comp = new  InstrSpadesComparator(c1.getSuit());
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
			 if ((win == 0) || (win == 2)){
				 winner = table.get("dealer").getTeam();
			 } 
			 else{
				 winner =  table.get("ldealer").getTeam();
			 }
		 }
		return winner;
	 }
	 public void handWinner() {
		 
	 }
	/**
	 * @return the hand
	 */
	public ArrayListDeck getHand() {
		return hand;
	}
	/**
	 * @param hand the hand to set
	 */
	public void setHand(ArrayListDeck hand) {
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
}
