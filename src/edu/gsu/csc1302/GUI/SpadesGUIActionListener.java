package edu.gsu.csc1302.GUI;

import edu.gsu.csc1302.GUI.frame.GamePlayFrame;
import edu.gsu.csc1302.GUI.frame.TeamSetupFrame;
import edu.gsu.csc1302.emperorsofspades.team.Team;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @todo: add window listener so can't close while playing.
 * Main event/action listener for the entire GUI.
 *
 * @author Roger Williams
 */
public class SpadesGUIActionListener implements ActionListener {
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
     * Triggered when action is performed.
     * @param e the event
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getActionCommand().equals(GuiActions.START_GAME.getString())) {
            this.startGame(e);
        } else if (e.getActionCommand().equals(GuiActions.LAUNCH_GAME.getString())) {
            this.launchGame(e);
        }
    }

    private void startGame(final ActionEvent e) {
        boolean userPlay = SpadesGUI.promptUserToPlayFrame();

        if (userPlay) {
            new TeamSetupFrame();
        } else {
            System.out.println("Does NOT want to play will do stuff here.");
        }
        SpadesGUI.getCurrentFrame().dispose();
    }

    private void launchGame(final ActionEvent e) {
        JButton button = (JButton) e.getSource();
        JFrame parent = (JFrame) button.getParent();

        parent.dispose();

        new GamePlayFrame("Round 1: Hand 1");

    }
}
