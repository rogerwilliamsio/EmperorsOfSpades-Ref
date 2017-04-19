package edu.gsu.csc1302.emperorsofspades.test;

import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.player.ai.AIPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.AggressivePlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.CautiousPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.SophisticatedPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.WildcardPlayer;
import edu.gsu.csc1302.emperorsofspades.player.console.ConsolePlayer;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * this is the main method that runs the game.
 * @author Mahetem Moges
 */
public final class Test {
	/**
	 * this makes the class have private constructor.
	 */
	private Test() {
	}
	/**
	 * the main method of the class.
	 * @param args parameters of the method.
	 */
    public static void main(final String[] args) {

    	CardDeck deck = new CardDeck();
    	for (Card.Suit suit: Card.Suit.values()) {
    		for (Card.Rank rank: Card.Rank.values()) {
    			Card c = new Card(suit, rank);
    			deck.add(c);
    		}
    	}
    	Scanner console = new Scanner(System.in);
    	String playing = "y";

    	while (playing.equals("y")) {
    		runGame(console, deck);
    		System.out.println("Do you want to play again?");
        	System.out.println("Enter y for yes and n "
        			+ "(or any letter) for no.");
    		String ans = console.nextLine();
    		if (ans.length() == 0) {
    			ans = "n";
    		}
    		playing = ans;
    		playing = playing.substring(0, 1);
    		playing = playing.toLowerCase();
    	}
    	System.out.println("Game over close program.");
    }
    /**
     * this method simulates the game by using the classes created.
     * @param console used for user input.
     * @param deck the deck for the game.
     */
	private static void runGame(final Scanner console, final CardDeck deck) {

		System.out.println("Do you want to play with the game?");
		System.out.println("Enter y for yes and n (or any letter) for no.");
	    String ans = console.nextLine();
	    if (ans.length() == 0) {
	    	ans = "n";
	    }
    	ans = ans.substring(0, 1);
    	ans = ans.toLowerCase();
    	String name = null;
    	Player cat;
    	if (ans.equals("y")) {

    		System.out.println("Enter your name.");
        	name = console.nextLine();
        	if (name.length() == 0) {
        		name = "anonymous";
        		System.out.println("your name will be anonymous.");
        	}
    		cat = new ConsolePlayer(name);

    	}
    	else {
            cat = new CautiousPlayer("cautious");
    	}
        AIPlayer agr = new AggressivePlayer("aggressive");
        AIPlayer sop = new SophisticatedPlayer("sophisticated");
        AIPlayer wil = new WildcardPlayer("wild");
        ArrayList<Player> players = new ArrayList<>();

        players.add(agr);
        players.add(wil);
        players.add(cat);
        players.add(sop);

        SpadesEngine game = new SpadesEngine(players, deck);
        if (ans.equals("y")) {
        	String teamName = cat.getTeamName();
            System.out.println(name + " you are on team: " + teamName + ".");
    	}
        game.startRound();
    	boolean ending = game.isGameEnd();

        while (!ending) {
        	game.startNewRound();
        	ending = game.isGameEnd();
        }
        System.out.println("Game Ended.");
        System.out.println(" ");
    }
}