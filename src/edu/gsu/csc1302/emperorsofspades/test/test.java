package edu.gsu.csc1302.emperorsofspades.test;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.team.Team;
import edu.gsu.csc1302.emperorsofspades.player.ai.AIPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.AggressivePlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.CautiousPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.SophisticatedPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.WildcardPlayer;
import edu.gsu.csc1302.emperorsofspades.player.console.ConsolePlayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * description
 *
 * @author Mahetem Moges
 */
public class test {
    public static void main(String[] args) {
    	
    	
    	CardDeck deck = new CardDeck();
    	for (Card.Suit suit: Card.Suit.values()) {
    		for (Card.Rank rank: Card.Rank.values()){
    			Card c = new Card(suit, rank);
    			deck.add(c);
    		}
    	}
    	Scanner console = new Scanner(System.in);
    	String playing = "y";
    	
    	while (playing.equals("y")) {
    		runGame(console, deck);
    		System.out.println("Do you want to play again?");
    		playing = console.next();
    		playing = playing.substring(0,1);
    		playing = playing.toLowerCase();
    	}
    	System.out.println("Game over close program.");
    }
	private static void runGame(Scanner console, CardDeck deck) {
		
		System.out.println("Do you want to play with the game?");
    	System.out.println("Enter y for yes and n for no.");
    	String ans = console.nextLine();
    	ans = ans.substring(0, 1);
    	ans = ans.toLowerCase();
    	String name;
    	Player cat;
    	if (ans.equals("y")) {
    		System.out.println("Enter your name.");
    		name = console.next();
    		cat = new ConsolePlayer(name);
            System.out.println("You are on team two.");
    	}
    	else {
            cat = new CautiousPlayer("cat");
    	}
    	
        AIPlayer agr = new AggressivePlayer("agr");
        AIPlayer sop = new SophisticatedPlayer("sop");
        AIPlayer wil = new WildcardPlayer("wil");
        ArrayList<Player> players = new ArrayList<>();
        players.add(agr);
        players.add(wil);
        players.add(sop);
        players.add(cat);
        Set<Player> first = new HashSet<>();
        Set<Player> second = new HashSet<>();
        first.add(wil);
        first.add(agr);
        second.add(cat);
        second.add(sop);
        
        Team one = new Team("one", first);
        Team two = new Team("two", second);
        
        SpadesEngine game = new SpadesEngine(players, deck);
        game.startRound();
        boolean ending = game.isGameEnd();
        while (!ending) {
        	game.startNewRound();
        	ending = game.isGameEnd();
        }
        System.out.println("Game Ended");
    }
}