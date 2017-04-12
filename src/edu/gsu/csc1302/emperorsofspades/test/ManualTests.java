//package edu.gsu.csc1302.emperorsofspades.test;
//
//import edu.gsu.csc1302.emperorsofspades.player.Player;
//import edu.gsu.csc1302.emperorsofspades.team.Team;
//import edu.gsu.csc1302.emperorsofspades.player.ai.AIPlayer;
//import edu.gsu.csc1302.emperorsofspades.player.ai.AggressivePlayer;
//import edu.gsu.csc1302.emperorsofspades.player.ai.SophisticatedPlayer;
//import edu.gsu.csc1302.emperorsofspades.player.ai.WildcardPlayer;
//
//import java.util.HashSet;
//
///**
// * this is the test class for the players.
// * @author Roger Williams
// */
//public final class ManualTests {
//	/**
//	 * this makes the class have a private constructor.
//	 */
//	private ManualTests() {
//	}
//	/**
//	 * the main method of the class.
//	 * @param args the arguments used.
//	 */
//    public static void main(final String[] args) {
//
//        AIPlayer roger = new AggressivePlayer("agr");
//        AIPlayer sam = new SophisticatedPlayer("sop");
//        AIPlayer kirk = new WildcardPlayer("Kirk");
//
//        HashSet<Player> teammates = new HashSet<Player>();
//        teammates.add(roger);
////      teammates.add(sam);
//
//        Team teamBlue = new Team("Blue", teammates);
//        System.out.println("Roger's Team: " + roger.getTeam());
//
//        teamBlue.addPlayer(kirk);
//        System.out.println("Kirk's Team: " + kirk.getTeam());
//
//        System.out.println("BIDS:");
//        System.out.println(sam.placeBid() + "\nEND BIDDING");
//
//        System.out.println(teamBlue.getNumberOfPlayers());
//
//    }
//}
