package edu.gsu.csc1302.GUI;

import edu.gsu.csc1302.GUI.frame.GamePlayFrame;
import edu.gsu.csc1302.GUI.frame.TeamSetupFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Main event/action listener for the entire GUI.
 * @todo: add window listener so can't close while playing.
 *
 * @author Roger Williams
 */
public class SpadesGUIActionListener implements ActionListener {
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
     * Triggered when action is performed.
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

        if (userPlay) {
            new TeamSetupFrame();
        } else {
            System.out.println("Does NOT want to play will do stuff here.");
        }
        SpadesGUI.getCurrentFrame().dispose();
    }
    /**
     * the game lunch method.
     * @param e action form dialog box/frame.
     */
    private void launchGame(final ActionEvent e) {
        JButton button = (JButton) e.getSource();
        JFrame parent = (JFrame) button.getParent();

        parent.dispose();

        new GamePlayFrame("Round 1: Hand 1");

    }
}
