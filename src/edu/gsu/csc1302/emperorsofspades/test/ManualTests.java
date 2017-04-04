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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * description
 *
 * @author Roger Williams
 */
public class ManualTests {

    public static void main(String[] args) {
    	Scanner console = new Scanner(System.in);
    	System.out.println("Do you want to play with the gaame?");
    	System.out.println("Enter y for yes and n for no.");
    	String ans = console.next();
    	ans = ans.substring(0, 1);
    	ans = ans.toLowerCase();
    	String name;
    	Player cat;
    	if (ans == "y") {
    		System.out.println("Enter your name.");
    		name = console.next();
    		cat = new Player(name);
            System.out.println("You are on team two.");
    	}
    	else {
            AIPlayer cat = new CautiousPlayer("cat");
    	}
        AIPlayer agr = new AggressivePlayer("agr");
        AIPlayer sop = new SophisticatedPlayer("sop");
        AIPlayer wil = new WildcardPlayer("wil");
        ArrayList<Player> players = new ArrayList<>();
        players.add(agr);
        players.add(wil);
        players.add(sop);
        players.add(cat);
        Team one = new Team("one");
        Team two = new Team("two");
        one.addPlayer(wil);
        one.addPlayer(agr);
        two.addPlayer(cat);
        two.addPlayer(sop);
        CardDeck deck = new CardDeck();
        Card c;
        for (int i = 1; i <= 52; i++){
        	
        }
        SpadesEngine game = new SpadesEngine(players, deck);
        
        }
    }
}
