package edu.gsu.csc1302.GUI.frame;

import edu.gsu.csc1302.GUI.SpadesGUI;
import edu.gsu.csc1302.GUI.SpadesGUIActionListener;
import edu.gsu.csc1302.GUI.SpadesPanel;
import edu.gsu.csc1302.GUI.button.SpadesButton;
import edu.gsu.csc1302.GUI.heading.SpadesH1Heading;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * The welcome/splash screen.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SplashScreenFrame extends SpadesFrame {
	/**
	 * creates the starting frame.
	 */
    public SplashScreenFrame() {
        super("Welcome!");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //Sets up the main content panel for this window.
        this.setupMainPanel();

        this.setVisible(true);
    }
    /**
     * this sets up the main panel.
     */
    private void setupMainPanel() {
        SpadesPanel mainPanel = new SpadesPanel();
        GridBagConstraints gridConstraints = mainPanel.contraints();
        gridConstraints.fill = GridBagConstraints.CENTER;
        mainPanel.goToPoint(0, 0);
        mainPanel.setBackground(SpadesGUI.UI_BACKGROUND_COLOR);

//		The text
        SpadesH1Heading welcomeLabel =
        		new SpadesH1Heading("Welcome to", Color.BLACK);
        mainPanel.add(welcomeLabel);

        //Create logo
        JLabel logoLabel = new JLabel(new ImageIcon(
        		this.getClass().getResource(
        				"/edu/gsu/csc1302/GUI/resources/images/logo-large-1.png")));
//		Add logo to panel
        mainPanel.contraints().weightx = 1;
        mainPanel.contraints().ipady = 100;
        mainPanel.addToNextRow(logoLabel);

//		Create the start button
        SpadesButton startBtn = new SpadesButton("Let's Play!");
        startBtn.setActionCommand(SpadesGUIActionListener
        		.GuiActions.START_GAME.getString());

        mainPanel.contraints().ipady = 0;
        mainPanel.addToNextRow(startBtn);

        //Add this panel to the frame
        this.add(mainPanel);
    }
}
