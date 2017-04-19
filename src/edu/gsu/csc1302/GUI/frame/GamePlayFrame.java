package edu.gsu.csc1302.GUI.frame;

import edu.gsu.csc1302.GUI.GUIHelper;
import edu.gsu.csc1302.GUI.SpadesGUI;
import edu.gsu.csc1302.GUI.heading.SpadesH3Heading;
import edu.gsu.csc1302.GUI.heading.SpadesHeading;
import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesEngineGUI;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.player.ai.AIPlayer;
import edu.gsu.csc1302.emperorsofspades.player.gui.GuiPlayer;
import edu.gsu.csc1302.emperorsofspades.team.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * A frame for game play windows.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class GamePlayFrame extends SpadesHeaderFrame {

   private final SpadesEngineGUI theGamesEngine;

    /**
     * Panel to hold the JLabels of cards played in this hand.
     */
    private final JPanel gameCardsPanel = new JPanel();

    /**
     * Holds the cards that were played in the current hand of the game.
     */
    private final CardDeck gameCards = new CardDeck();

    private final GuiPlayer theGuiPlayer;

    /**
     * Maps the cards dealt to the console used to the
     * JLabels used to display them.
     * IMPORTANT when the user clicks on a card image (JLabel),
     * that JLabel is looked-up in the hash-map and the card object is returned.
     */
    private final HashMap<JLabel, Card>
            consolePlayerHandMapping = new HashMap<>();

    private JPanel consolePlayerOutterWrap = new JPanel();

    private JPanel playersPanel = new JPanel();

    /**
     * Maps the players' images (in the list of players panel)
     * to their player object
     */
    private final HashMap<JLabel, Player> playersJlabelMapping = new HashMap<>();

    /**
     * Holds/controls the game notification center, located above the
     * game hand deck of cards in the center panel.
     */
    private final JPanel notificationCenterPanel = new JPanel();

//    @todo: ONLY add the deckImg and the game hand to this panel
    /**
     * The game table panel that displays the game hand
     * and deck of cards, when needed.
     */
    private final JPanel gameTablePanel = new JPanel();

    /**
     * The game stats panel on the right.
     */
    private final JPanel statsPanel = new JPanel();

    private boolean GUIUserPlayed = false;


    /**
     * Main Method.
     * @todo: Remove this.
     * @param args used.
     */
    public static void main(final String[] args) {
//        AggressivePlayer bob = new AggressivePlayer("Bob");
//        CautiousPlayer puff = new CautiousPlayer("Puff");
//        WildcardPlayer patrick = new WildcardPlayer("Patrick");
//
////        Optional console player
//        ConsolePlayer annon = new ConsolePlayer("Con");
//
//        ArrayList<Player> players = new ArrayList<>();
//        players.add(bob);
//        players.add(puff);
//        players.add(patrick);
//        players.add(annon);
//
////      the game deck
//        CardDeck deck = new CardDeck();
//        for (Card.Suit suit: Card.Suit.values()) {
//            for (Card.Rank rank: Card.Rank.values()) {
//                Card c = new Card(suit, rank);
//                deck.add(c);
//            }
//        }
//
//        new GamePlayFrame("Round 1: Hand 1", new SpadesEngine(players, deck));
    }

    /**
     * Class constructor.
     * @param partialTitle the title
     * @param theGameEngine the game object
     */
    public GamePlayFrame(final String partialTitle, final SpadesEngineGUI theGameEngine) {
        super(partialTitle);
        this.theGamesEngine = theGameEngine;

        GuiPlayer guiPlayer = null;
        if (this.theGamesEngine.getConsolePlayerIsPlaying()) {
            for (Object player : this.theGamesEngine.getPlayers()) {
                if (player instanceof GuiPlayer) {
                    guiPlayer = (GuiPlayer) player;
                    break;
                }
            }
        }

        this.theGuiPlayer = guiPlayer;

//        Deals the cards, etc
        this.startRound();

        this.setupContainerPanel();

        this.getContentPane().add(this.theContainerPanel);
        this.pack();
        this.setVisible(true);
        this.beginGamePlay();
    }

    /**
     * Houses the list of players (left), played cards (hand deck) (center),
     * and the game stats (right) panels.
     */
    @Override
    protected void setupContentPanel() {
        this.theContentPanel.setOpaque(false);
        this.theContentPanel.setLayout(new BorderLayout(0, 0));

//        @todo: Optimize this center panel
//        ADD: The center panel
        this.theContentPanel.add(
        		this.getDisplayOfCenterPanel(), BorderLayout.CENTER);

//      ADD: List of playersi
        this.getDisplayOfPlayersPanel();
        this.theContentPanel.add(this.playersPanel, BorderLayout.WEST);

        if (this.theGamesEngine.getConsolePlayerIsPlaying()) {
            this.theContentPanel.add(
                    this.getDisplayOfConsolePlayerCards(), BorderLayout.SOUTH);
        }

//      ADD: The status panel (on the east of border-layout)
        JPanel statsPanel = setupGameStatsPanel();
        statsPanel.setAlignmentX(Component.TOP_ALIGNMENT);
        this.theContentPanel.add(statsPanel, BorderLayout.EAST);
    }


    /**
     * Sets up the display for the center panel of the content area.
     * Holds the notification center and the current game hand deck.
     * @return the center panel for the main content area
     */
    private JPanel getDisplayOfCenterPanel() {

//      Use absolute layout to put notification center on top of game hand deck
        JPanel contentPanelCenter = new JPanel();
        contentPanelCenter.setLayout(null);
        contentPanelCenter.setOpaque(false);

        //      Current hand layout holder
        this.gameCardsPanel.setLayout(new GridLayout(1, 4, 0, 0));
        this.gameCardsPanel.setOpaque(false);

//        Notification Center uses flow layout
        this.notificationCenterPanel.setOpaque(true);
        this.notificationCenterPanel.setBackground(new Color(255, 171, 0));


//        ADD: the notification center and the hand deck to container.
        contentPanelCenter.add(this.notificationCenterPanel);

        this.notificationCenterPanel.setBounds(0, 0, 600, 30);

//        Card panel is init to empty, but is then updated when
        contentPanelCenter.add(this.gameCardsPanel);
       this.gameCardsPanel.setBounds(0, 12, 600, 300);

        this.gameCardsPanel.setVisible(true);
        this.notificationCenterPanel.setVisible(false);
        return contentPanelCenter;
    }

    private void updateGameTable() {
//        Add the game hand cards to the holding panel
        this.gameCardsPanel.removeAll();

        if (this.theGamesEngine.getHand() != null) {
            for (Card handCard : this.theGamesEngine.getHand()) {
                System.out.println("Card: " + handCard);
                this.gameCardsPanel.add(new JLabel(GUIHelper.getCardImg(handCard, true)));
            }
        }

        this.repaintPanel(this.gameCardsPanel);
    }

    /**
     * DISPLAYS the console player's hand of cards.
     * @return the panel
     */
    private JPanel getDisplayOfConsolePlayerCards() {
//      console user panel is a border-layout

        consolePlayerOutterWrap.setLayout(new BorderLayout());
        consolePlayerOutterWrap.setPreferredSize(
        		new Dimension(SpadesGUI.DEFAULT_FRAME_WIDTH, 160));
        consolePlayerOutterWrap.setOpaque(true);
        consolePlayerOutterWrap.setBackground(new Color(56, 142, 60));

//        The console panel header, uses absolute layout
        JPanel consolePlayerOuterHeader = new JPanel();
        consolePlayerOuterHeader.setPreferredSize(
        		new Dimension(SpadesGUI.DEFAULT_FRAME_WIDTH, 30));
        consolePlayerOuterHeader.setLayout(null);
        consolePlayerOuterHeader.setBackground(new Color(255, 171, 0));

        SpadesH3Heading headerCardLbl = new
        		SpadesH3Heading("Your cards", Color.BLACK);
        SpadesHeading headerNotifications = new
        		SpadesHeading("<Put some game control buttons here>",
        				15, Color.RED, SwingConstants.CENTER);
        headerNotifications.setBackground(Color.WHITE);
        consolePlayerOuterHeader.add(headerCardLbl);
        consolePlayerOuterHeader.add(headerNotifications);
        headerCardLbl.setBounds(10, 0, 150, 30);
        headerNotifications.setBounds(500, 0, 600, 30);

//        The actual panel for the console player's cards.
        JPanel consolePlayerCardsPanel = new JPanel();
        consolePlayerCardsPanel.setPreferredSize(
        		new Dimension(SpadesGUI.DEFAULT_FRAME_WIDTH, 120));
        consolePlayerCardsPanel.setLayout(new GridLayout(1, 13, 2, 0));
        consolePlayerCardsPanel.setOpaque(false);

        consolePlayerCardsPanel.setBorder(GUIHelper.uiPadding(5, 5));


//        @Todo: and remove card from the user's deck too.
        for (Card theCard : this.theGuiPlayer.getHand()) {
            JLabel cardLabel = new JLabel(GUIHelper.getCardImg(theCard, true));
            consolePlayerHandMapping.put(cardLabel, theCard);
            cardLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            cardLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(final MouseEvent e) {

//                    ONly process if user deck is enabled.
                    if (cardLabel.isEnabled() && GamePlayFrame.this.consolePlayerOutterWrap.isEnabled()) {
                        cardLabel.setEnabled(false);
                        GamePlayFrame.this.notificationCenterPanel.setVisible(false);
                        GamePlayFrame.this.repaintPanel(GamePlayFrame.this.notificationCenterPanel);
//                        Disable the frame
                        GamePlayFrame.this.consolePlayerOutterWrap.setEnabled(false);

                        GamePlayFrame.this.repaintPanel(GamePlayFrame.this.consolePlayerOutterWrap);

                        JLabel cardClicked = (JLabel) e.getSource();
//                      Removing from the container
                        JPanel parent = (JPanel) cardClicked.getParent();
                        parent.remove(cardClicked);
//                    @todo: trigger event here for when
                        //card is removed from player hand
                        GamePlayFrame.this.theGuiPlayer.playCard(
                                GamePlayFrame.this.consolePlayerHandMapping.get(cardClicked)
                        );

//                        Add card to the game deck
                        GamePlayFrame.this.addCardToHandDeck(consolePlayerHandMapping.get(cardClicked));
                        GamePlayFrame.this.GUIUserPlayed = true;
//                    GamePlayFrame.this.updateGameTable();
                    }
                }
            });

//            BACK to adding the cards to the user's deck
            consolePlayerCardsPanel.add(cardLabel);
        }

        consolePlayerOutterWrap.add(
        		consolePlayerOuterHeader, BorderLayout.NORTH);
        consolePlayerOutterWrap.add(
        		consolePlayerCardsPanel, BorderLayout.CENTER);

        return consolePlayerOutterWrap;
    }

    /**
     * Adds a given card to the current hand deck.
     * @Todo: check to make sure it is actually the use's term to play
     * @param card the card to add to the game deck
     */
    private void addCardToHandDeck(final Card card) {
        this.theGamesEngine.getHand().add(card);
        this.gameCardsPanel.add(new JLabel(GUIHelper.getCardImg(card, true)));

//        Repaint the hand deck panel/holder
        this.repaintPanel(this.gameCardsPanel);
    }

    /**
     * Sets up the stats panel.
     * @return the panel
     */
    private JPanel setupGameStatsPanel() {
        this.statsPanel.setLayout(new BoxLayout(this.statsPanel, BoxLayout.Y_AXIS));
        this.statsPanel.setPreferredSize(new Dimension(200, 200));
        this.statsPanel.setOpaque(false);

        this.updateTeamStats();

        return statsPanel;
    }

    /**
     * Sets up the player's panel. Lists the players in a vertical boxlayout.
     * @todo: change to list/set of players, not string and REMOVE personality
     * @return the panel
     */
    private void getDisplayOfPlayersPanel() {

        this.playersPanel.setPreferredSize(new Dimension(310, 200));
        this.playersPanel.setLayout(new BoxLayout(this.playersPanel, BoxLayout.Y_AXIS));
        this.playersPanel.setOpaque(false);

        for (Player player : theGamesEngine.getPlayers()) {
            JLabel playerLabel = new JLabel(
                    GUIHelper.getPlayerImg(player, false));
            playerLabel.setName(player.getName());

            this.playersJlabelMapping.put(playerLabel, player);

            playerLabel.setBorder(GUIHelper.uiPadding(10, 0));
            playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.playersPanel.add(playerLabel, SwingConstants.CENTER);
        }

        SpadesH3Heading panelHeading =
        		new SpadesH3Heading("Players", Color.BLACK);
        this.playersPanel.add(panelHeading, SwingConstants.CENTER);
    }

    private void updatePlayingUserImg(final Player thePlayer) {
        JLabel found = new JLabel();
        String name = thePlayer.getName();

        for (Component child : this.playersPanel.getComponents()) {
            if (child instanceof JLabel) {
                JLabel label = (JLabel) child;
                if (name.equals(label.getName())) {

                    JLabel playerLabel = new JLabel(
                            GUIHelper.getPlayerImg(thePlayer, true));
                    playerLabel.setName(thePlayer.getName());
                    this.playersJlabelMapping.put(label, thePlayer);
                    break;
                }
            }
        }
        this.playersPanel.removeAll();
        this.getDisplayOfPlayersPanel();
         this.repaintPanel(this.playersPanel);


    }


    private void updateNotificationCenter(final String text) {
        SpadesHeading notificationText = new SpadesHeading(
                text, 16, Color.RED, SwingConstants.CENTER);
        this.notificationCenterPanel.removeAll();
        this.notificationCenterPanel.add(notificationText);

        this.repaintPanel(this.notificationCenterPanel);
//        In case not visible
        this.notificationCenterPanel.setVisible(true);
    }

    private void updateTeamStats() {
        statsPanel.removeAll();
//        System.out.println("Size of teama array: " + this.theGamesEngine.getTeamsArray());
//        System.out.println("TEAM STUFF");
//        System.out.println(theTeam.getTeamName());
//        System.out.println(theTeam.getScore());
//        System.out.println(theTeam.getTricks());
//        System.out.println(theTeam.getNumOfSets());
//        System.out.println("END OF STATS");


//        Update team 1 stats
        Team teamOne = this.theGamesEngine.getTeam1();
        SpadesH3Heading teamOneName = new SpadesH3Heading("Team 1", Color.WHITE);
        teamOneName.setBorder(GUIHelper.uiPadding(20, 0, 10, 0));
        statsPanel.add(teamOneName, SwingConstants.CENTER);
//        generate team one's stats
        this.statsPanel.add(this.generateTeamStatsString(teamOne));


//        Update team 2 stats
        Team teamTwo = this.theGamesEngine.getTeam1();
        SpadesH3Heading teamTwoName = new SpadesH3Heading("Team 2", Color.WHITE);
        teamOneName.setBorder(GUIHelper.uiPadding(20, 0, 10, 0));
        statsPanel.add(teamTwoName, SwingConstants.CENTER);
//        generate team two's stats
        this.statsPanel.add(this.generateTeamStatsString(teamTwo));


        this.repaintPanel(statsPanel);
//        Add the panel heading
        SpadesH3Heading panelHeading = new
                SpadesH3Heading("Game Stats", Color.BLACK);
        statsPanel.add(panelHeading, SwingConstants.CENTER);
    }

    private JLabel generateTeamStatsString(final Team team) {
        JLabel teamLbl = new JLabel();
        teamLbl.setText("<html><p><span style="
                + "\"background-color: #0000ff; color: #ffffff;\""
                + "><strong>&nbsp;Score: " + team.getScore() + "&nbsp; &nbsp; &nbsp; "
                + "&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</strong></span><br"
                + " /><strong><span style=\"color: #000000; background-color:"
                + " #ffff00;\">&nbsp;Total Tricks: " + team.getTricks() + " &nbsp; &nbsp;"
                + "</span></strong><br /><span style=\"background-color:"
                + "#00ff00;\"><strong><span style=\"color: #000000;"
                + "</span></strong></span><br /><strong><span style="
                + "\"color: #000000; background-color: #ff0000;\">&nbsp;Total"
                + " Sets: " + team.getNumOfSets() + " &nbsp; &nbsp;</span></strong></p></html>");

        return teamLbl;
    }

    private void startRound() {
        this.theGamesEngine.startRoundGUI();
    }

    /**
     * SHould be called eveytime a new hand is started.
     */
    private void beginGamePlay() {

        for (int j = 0; j < 13; j++) {
            this.GUIUserPlayed = false;
            this.theGamesEngine.playHandGUI();
//            Emable the deck for each hand
            this.consolePlayerOutterWrap.setEnabled(true);

            for (int i = 0; i < 4; i++) {
                Player nextPlayer = this.theGamesEngine.getNextPlayer();

                if (nextPlayer instanceof AIPlayer) {
                    this.theGamesEngine.getHand().add(nextPlayer.playCard(this.theGamesEngine.getHand()));
                    this.updateGameTable();

                } else {
                    this.updateNotificationCenter("Your Turn!");

                    do {
                        JOptionPane.showMessageDialog(null, this.consolePlayerOutterWrap, "Your Cards",
                                JOptionPane.PLAIN_MESSAGE);
                    } while (!this.GUIUserPlayed);
                }
            }
            System.out.println("Console cards: " + this.theGuiPlayer.getHand());

//        End of hand
            System.out.println("End of hand=================================");
            this.theGamesEngine.endOfHand();
            this.updateTeamStats();

            System.out.printf("Sizze of list: "+ this.theGamesEngine.getHandHistory().size());

            HashMap<String, Object> handHist = this.theGamesEngine.getHandHistory().get(this.theGamesEngine.getHandHistory().size() - 1);
            Player winningPlayer = (Player) handHist.get("player");
            Card leadCard = (Card) handHist.get("leadCard");

            JOptionPane.showMessageDialog(null, "End of hand!", "Notice",
                    JOptionPane.INFORMATION_MESSAGE);

            this.gameCardsPanel.removeAll();
            GamePlayFrame.this.updateNotificationCenter(winningPlayer.getName() + " won that hand!!");
            GamePlayFrame.this.gameCardsPanel.add(new JLabel(GUIHelper.getCardImg(leadCard, true)));

            GamePlayFrame.this.repaintPanel(GamePlayFrame.this.gameCardsPanel);

            JOptionPane.showMessageDialog(null, "Start New Hand", "Notice",
                    JOptionPane.INFORMATION_MESSAGE);

        }
//        End of round
//        this.theGamesEngine.roun





    }

}