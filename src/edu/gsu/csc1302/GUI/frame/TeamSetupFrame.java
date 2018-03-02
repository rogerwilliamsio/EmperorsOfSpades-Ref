package edu.gsu.csc1302.GUI.frame;

import edu.gsu.csc1302.GUI.GUIHelper;
import edu.gsu.csc1302.GUI.SpadesGUI;
import edu.gsu.csc1302.GUI.button.SpadesButton;
import edu.gsu.csc1302.GUI.heading.SpadesH2Heading;
import edu.gsu.csc1302.emperorsofspades.SpadesEngineGUI;
import edu.gsu.csc1302.emperorsofspades.player.Player;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The team setup frame. Displayed at the beginning of the game.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class TeamSetupFrame extends SpadesHeaderFrame {
	/**
	 * the game engine.
	 */
    private final SpadesEngineGUI theGameEngine;
    /**
     * Class constructor.
     * @param theGameEngine the game object
     */
    public TeamSetupFrame(final SpadesEngineGUI theGameEngine) {
        super("Team Setup");
//
        this.theGameEngine = theGameEngine;

        this.setPreferredSize(new Dimension(
        		SpadesGUI.DEFAULT_FRAME_WIDTH, SpadesGUI.DEFAULT_FRAME_HEIGHT));

        this.setupContainerPanel();
        this.getContentPane().add(this.theContainerPanel);
        this.pack();
        this.setVisible(true);
    }

    /**
     * this sets up the content panel.
     */
    @Override
    protected void setupContentPanel() {
        this.theContentPanel.setLayout(null);
        this.theContentPanel.setOpaque(false);

        this.theContentPanel.add(this.getDisplayOfTeamsInfo());
        this.theContentPanel.add(this.getDisplayBottomMenusButtons());
    }
    /**
     * returns the menu panel.
     * @return the menu panel.
     */
    private JPanel getDisplayBottomMenusButtons() {
        final JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        final SpadesButton proceedButton =
        		new SpadesButton("Let's GO!!!", Color.YELLOW, Color.BLACK);

        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println("GOING");
                new GamePlayFrame("Round 1", TeamSetupFrame.this.theGameEngine);
                TeamSetupFrame.this.dispose();
            }
        });

        menuPanel.add(proceedButton);

        menuPanel.setBounds(300, 300, 500, 200);

        return menuPanel;
    }
    /**
     * returns the team information panel.
     * @return the team information panel.
     */
    private JPanel getDisplayOfTeamsInfo() {
        //        Holds the team info split panel
        final JPanel teamInfoPanel = new JPanel();
        teamInfoPanel.setLayout(new GridLayout(1, 2, 0, 0));
        teamInfoPanel.setOpaque(false);

        //      TEAM ONE

//      when list of teams is passed in the game engine object
        JPanel teamOneInfo = new JPanel();
        teamOneInfo.setLayout(new BoxLayout(teamOneInfo, BoxLayout.Y_AXIS));
        teamOneInfo.setOpaque(false);

//        TEAM TWO
        JPanel teamTwoInfo = new JPanel();
        teamTwoInfo.setLayout(new BoxLayout(teamTwoInfo, BoxLayout.Y_AXIS));
        teamTwoInfo.setOpaque(false);


//       Team 1 setup
        for (Player t1Player : this.theGameEngine.getTeam1().getTeammates()) {
            JLabel player1Label = new JLabel(
                    GUIHelper.getPlayerImg(t1Player, false));

            player1Label.setBorder(GUIHelper.uiPadding(10, 0));

            player1Label.setAlignmentX(Component.LEFT_ALIGNMENT);

            teamOneInfo.add(player1Label, SwingConstants.CENTER);
        }

//      Team 2 setup
        for (Player t2Player : this.theGameEngine.getTeam2().getTeammates()) {
            JLabel playerLabel = new JLabel(
                    GUIHelper.getPlayerImg(t2Player, false));

            playerLabel.setBorder(GUIHelper.uiPadding(10, 0));

            playerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            teamTwoInfo.add(playerLabel, SwingConstants.CENTER);
        }


        SpadesH2Heading teamOneLbl = new SpadesH2Heading("Team 1");
        SpadesH2Heading teamTwoLbl = new SpadesH2Heading("Team 2");

        teamOneLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        teamTwoLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        teamOneInfo.add(teamOneLbl, SwingConstants.CENTER);
        teamTwoInfo.add(teamTwoLbl, SwingConstants.CENTER);

        teamInfoPanel.add(teamOneInfo);
        teamInfoPanel.add(teamTwoInfo);

        teamInfoPanel.setBounds(300, 0, 700, 400);

        return teamInfoPanel;
    }
}
