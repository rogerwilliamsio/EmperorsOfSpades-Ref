package edu.gsu.csc1302.emperorsofspades.team;

import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.player.Player;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Simulates a set of player in a game of Spades.
 * @author Roger Williams
 */
public class Team {

	/**
     * number of the team bid.
     */
	private int teamBid = 0;

	/**
	 * blind bet checker.
	 */
	private boolean isBlindBid;

	/**
     * Name of the team.
     */
    private String teamName;
	/**
     * Set of players on the team.
     */
    private final LinkedList<Player> teammates = new LinkedList<Player>();

    /**
     * Total points accumulated throughout the rounds.
     */
    private int teamScore = 0;
    /**
     * Returns the total number of trick this team
     * has accumulated.
     */
    private int totalTricks = 0;
    /**
     * Number of sets.
     */
    private int numOfSets = 0;
    /**
     * this is a default constructor for team class.
     */
    public Team() {

        this.teamName = null;
        teammates.add(null);
    }
    /**
     * Class constructor. A team cannot be created without at least 1 player.
     * @param teamName name of team.
     * @param player a player.
     * @throws TooManyPlayersException when number of players exceed the max.
     * @throws InsufficientPlayersException if the set of players is null.
     */
    public Team(final String teamName, final Player player) {

        this.teamName = teamName;
        teammates.add(player);
        player.setTeamName(teamName);
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
        // Add the player to the list if not already on the team.
        if (this.teammates.indexOf(player) > -1) {
            throw new IllegalTeamStateException(
            		"This player is already on the team.");
        }
        player.setTeamName(this.teamName);
        return this.teammates.add(player);
    }

    /**
     * Returns the maximum number of players on a team.
     * @return max team mates.
     */
    public static int getMaximumTeammates() {
        return SpadesEngine.MAXIMUM_TEAMMATES;
    }
    /**
     * Returns the list of players.
     * @return team mates the players in the team.
     */
    public List<Player> getTeammates() {
        return Collections.unmodifiableList(this.teammates);
    }

    /**
     * this method places the teams bid.
     * @param player the player who makes the team bid.
     * @return team bid
     */

    public int placeTeamBid(final Player player) {
    	if (isBlindBid) {
    		teamBid = player.placeBlindBid();
    	} else {
    		teamBid = player.placeBid();
    	}
    	return teamBid;
    }
    /**
     * Returns the number of players on the team.
     * @return number of players
     */
    public int getNumberOfPlayers() {
        return this.teammates.size();
    }
    /**
     * sets the name of the team.
	 * @param teamName the teamName to set
	 */
	public void setTeamName(final String teamName) {
		this.teamName = teamName;
	}
    /**
     * Returns the team name.
     * @return teamName the teams name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Returns the score of the team.
     * Score is accumulated across rounds.
     * @return teamScore integer the teams score.
     */
    public int getScore() {
        return teamScore;
    }
    /**
     * Returns the number of tricks the team has.
     * @return integer the total tricks won.
     */
    public int getTricks() {
        return totalTricks;
    }
    /**
     * Adds a certain number of tricks to the total number of team tricks.
     */
    public void addTrick() {
        this.totalTricks++;
    }
    /**
     * this sets the points to the team who succeeded.
     * Updates the team's success score.
     * @param bidNum the bid number
     */
    public void setSuccess(final int bidNum) {
    	if (isBlindBid) {
    		teamScore = teamScore + 20 * teamBid;
    	} else {
    		teamScore = teamScore + 10 * teamBid;
    	}
        this.numOfSets = 0;
        totalTricks = 0;
    }
    /**
     * this deducts point on the team.
     */
    public void setSets() {
        teamScore = teamScore - (teamBid * 10);
        numOfSets++;
        totalTricks = 0;
    }
    /**
     * Returns the number of sets the team has.
     * @return sets
     */
    public int getNumOfSets() {
        return numOfSets;
    }
    /**
     * this gets the team's bid.
   	 * @return the teamBid
   	 */
   	public int getTeamBid() {
   		return teamBid;
   	}

   	/**
   	 * this sets the team bid with input number.
   	 * @param teamBid the teamBid to set
   	 */
   	public void setTeamBid(final int teamBid) {
   		this.teamBid = teamBid;
   	}

	/**
	 * gets if the team has to blind bid or not.
	 * @return the blindBet
	 */
	public boolean getIsBlindBid() {
		return isBlindBid;
	}

	/**
	 * this sets the blind bid of a team.
	 * @param blindBet the blindBet to set
	 */
	public void setIsBlindBid(final boolean blindBet) {
		this.isBlindBid = blindBet;
	}

    /**
     * Print-friendly output.
     * @return team name
     */
    public String toString() {
        return String.format("[Team] %s", this.getTeamName());
    }
}
