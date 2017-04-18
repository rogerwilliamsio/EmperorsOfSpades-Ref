package edu.gsu.csc1302.GUI;

import edu.gsu.csc1302.GUI.frame.GamePlayFrame;
import edu.gsu.csc1302.GUI.frame.TeamSetupFrame;
import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.SpadesEngineGUI;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.player.ai.AggressivePlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.CautiousPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.SophisticatedPlayer;
import edu.gsu.csc1302.emperorsofspades.player.ai.WildcardPlayer;
import edu.gsu.csc1302.emperorsofspades.player.console.ConsolePlayer;
import edu.gsu.csc1302.emperorsofspades.player.gui.GuiPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Main event/action listener for the entire GUI.
 * @todo: add window listener so can't close while playing.
 *
 * @author Roger Williams
 */
public class SpadesGUIController implements ActionListener {
	/**
	 * the enum for the message.
	 * @author Roger Williams
	 */
    public enum GuiActions {
        /**
         * Command to start the game.
         */
        START_GAME("start_game"),

        /**
         * Command to launch the game.
         */
        LAUNCH_GAME("launch_game"),

        /**
         * Command to end the game.
         */
        END_GAME("end_game");

        /**
         * The string version of the action.
         */
        private final String string;

        /**
         * Constructor.
         * @param theString the string version of the action.
         */
        GuiActions(final String theString) {
            this.string = theString;
        }

        /**
         * Returns the string version of the command.
         * @return the string
         */
        public String getString() {
            return this.string;
        }
    }

    /**
     * Triggered when action is performed (buttons)
     * @param e the event
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getActionCommand().equals(GuiActions.START_GAME.getString())) {
            this.startGame(e);

        } else if (e.getActionCommand().
        		equals(GuiActions.LAUNCH_GAME.getString())) {
            this.launchGame(e);
        }
    }

    /**
     * the game start dialog box.
     * @param e the action event form the dialog box/frame.
     */
    private void startGame(final ActionEvent e) {
        boolean userPlay = SpadesGUI.promptUserToPlayFrame();

        AggressivePlayer bob = new AggressivePlayer("Bob");
        SophisticatedPlayer gary = new SophisticatedPlayer("Gary");
        WildcardPlayer patrick = new WildcardPlayer("Patrick");


        ArrayList<Player> players = new ArrayList<>();
        players.add(bob);
        players.add(gary);
        players.add(patrick);

//      the game deck
        CardDeck deck = new CardDeck();
        for (Card.Suit suit: Card.Suit.values()) {
            for (Card.Rank rank: Card.Rank.values()) {
                Card c = new Card(suit, rank);
                deck.add(c);
            }
        }

        if (userPlay) {
//        Optional console player
            GuiPlayer annon = new GuiPlayer();
            players.add(annon);

        } else {
            System.out.println("NOT playing");
            CautiousPlayer puff = new CautiousPlayer("Puff");
            players.add(puff);
        }
        SpadesEngineGUI gameEngine = new SpadesEngineGUI(players, deck);

        gameEngine.setConsolePlayerIsPlaying(userPlay);

//        Display the team setuo frame
        new TeamSetupFrame(gameEngine);

        SpadesGUI.getCurrentFrame().dispose();
    }
    /**
     * the game lunch method.
     * @param e action form dialog box/frame.
     */
    private void launchGame(final ActionEvent e) {
        JButton button =  (JButton) e.getSource();
        JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, button);
        parent.dispose();

        this.startFirstRound();

    }

    /**
     * Starts the first round, hand 1.
     */
    private void startFirstRound() {



    }
}
