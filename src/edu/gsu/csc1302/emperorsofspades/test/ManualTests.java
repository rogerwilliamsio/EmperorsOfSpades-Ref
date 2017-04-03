package edu.gsu.csc1302.emperorsofspades.test;

import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.team.Team;
import edu.gsu.csc1302.emperorsofspades.player.ai.AIPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.AggressivePlayer;

import java.util.HashSet;

/**
 * description
 *
 * @author Roger Williams
 */
public class ManualTests {

    public static void main(String[] args) {
        AIPlayer roger = new AggressivePlayer("Roger");
        AIPlayer sam = new AggressivePlayer("Samuel");

        HashSet<Player> teammates = new HashSet<Player>();
        teammates.add(roger);
        teammates.add(sam);

        Team teamBlue = new Team("team Blue", teammates);
        for (Player player : teamBlue.getTeammates()) {
            System.out.println(player.getName());
        }
    }
}
