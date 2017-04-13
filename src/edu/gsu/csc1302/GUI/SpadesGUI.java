package edu.gsu.csc1302.GUI;

import oracle.jrockit.jfr.JFR;

import java.awt.*;

import javax.swing.*;
import  javax.swing.ImageIcon;

/**
 * The entry point for the Emperors of Spades game engine.
 *
 * @author Roger Williams
 */
public final class SpadesGUI extends JFrame {
	/**
	 * The default background color of the UI.
	 */
	private static final Color UI_BACKGROUND_COLOR = new Color(27, 94, 32);

	/**
	 * OS window toolkit.
	 */
	private final Toolkit toolkit = Toolkit.getDefaultToolkit();

	/**
	 * class constructor.
	 * @param partialTitle the partial title for the window
	 */
	private SpadesGUI(final String partialTitle) {
		super("Emperors of Spades - " + partialTitle);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		//Sets up the main content panel for this window.
		this.setupMainPanel();

		this.setVisible(true);

	}

	private void setupMainPanel() {
		JPanel mainPanel = new JPanel();

		mainPanel.setBackground(SpadesGUI.UI_BACKGROUND_COLOR);

		//The text
//		JLabel testLable = new JLabel("Emperors of Spades");
//		mainPanel.add(testLable);

		//THe logo panel
		JLabel logoLabel = new JLabel(new ImageIcon(this.getClass().getResource("/edu/gsu/csc1302/GUI/resources/images/logo-large-1.png")));

		mainPanel.add(logoLabel);

		JButton startBtn = new JButton("Start Game!");
		mainPanel.add(startBtn);



		//Add this panel to the frame
		this.add(mainPanel);
	}
	/**
	 * Initializes the application.
	 * @param args the arguments used.
	 */
	public static void main(final String[] args) {
		new SpadesGUI("Welcome!");
	}
}
