package edu.gsu.csc1302.emperorsofspades.test;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.team.Team;
import edu.gsu.csc1302.emperorsofspades.player.ai.AIPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.AggressivePlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.SophisticatedPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.WildcardPlayer;

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
    	
        AIPlayer roger = new AggressivePlayer("agr");
        AIPlayer sam = new SophisticatedPlayer("sop");
        AIPlayer kirk = new WildcardPlayer("Kirk");

        HashSet<Player> teammates = new HashSet<Player>();
        teammates.add(roger);
//      teammates.add(sam);

        Team teamBlue = new Team("Team Blue", teammates);
        teamBlue.addPlayer(kirk);
        System.out.println(teamBlue.getTeammates());
        sam.addToCardDeck(new Card(Card.Suit.HEART, Card.Rank.TWO));
        System.out.println("BIDS:");
        System.out.println(sam.placeBid() + " END BIDDING");
        System.out.println(teamBlue.getNumberOfPlayers());

        for (Player player : teamBlue.getTeammates()) {
            System.out.println(((AIPlayer) player).playCard(Card.Suit.CLUB));
        }
    }
}
