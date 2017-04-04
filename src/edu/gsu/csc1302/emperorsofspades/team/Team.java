package edu.gsu.csc1302.emperorsofspades.team;

import edu.gsu.csc1302.emperorsofspades.player.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Simulates a set of player in a game of Spades.
 *
 * @author Roger Williams
 */
public class Team {
    /**
     * The maximum number of  teammates allowed on a team.
     */
    private static final int MAXIMUM_TEAMMATES = 2;

    /**
     * Name of the team.
     */
    private final String teamName;

    /**
     * Set of players on the team.
     */
    private final HashSet<Player> teammates = new HashSet<>();

    /**
     * Class constructor. A team cannot be created without at least 1 player.
     * @param teamName name of team.
     * @param team set of teammates.
     * @throws TooManyPlayersException when number of players exceed the max.
     * @throws InsufficientPlayersException if the set of players is null.
     */
    public Team(final String teamName, final HashSet<Player> team)
            throws TooManyPlayersException, InsufficientPlayersException {

        if (team == null) {
            throw new InsufficientPlayersException("Team needs "
                    + "at least 1 player.");
        }

        if (team.size() > 2) {
            throw new TooManyPlayersException();
        }

        this.teamName = teamName;
        this.teammates.addAll(team);
    }

    /**
     * Adds a player to the team.
     * @param player the player to add
     * @return whether or not the player was added to the team.
     * @throws TooManyPlayersException if team size is already at the max.
     */
    public boolean addPlayer(final Player player)
            throws TooManyPlayersException {
        if (this.teammates.size() + 1 > getMaximumTeammates()) {
            throw new TooManyPlayersException("Player cannot be "
                    + "added to team because team size is "
                    + "already at the maximum allowed.");
        }
        return this.teammates.add(player);
    }

    /**
     * Returns the maximum number of players on a team.
     * @return max teammates.
     */
    public static int getMaximumTeammates() {
        return MAXIMUM_TEAMMATES;
    }

    /**
     * Returns the set of players.
     * @return
     */
    public Set<Player> getTeammates() {
        return Collections.unmodifiableSet(this.teammates);
    }

    /**
     * Returns the number of players on the team.
     * @return num of players
     */
    public int getNumberOfPlayers() {
        return this.teammates.size();
    }
}
