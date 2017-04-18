package edu.gsu.csc1302.GUI.frame;

import edu.gsu.csc1302.GUI.GUIHelper;
import edu.gsu.csc1302.GUI.SpadesGUI;
import edu.gsu.csc1302.GUI.heading.SpadesH3Heading;
import edu.gsu.csc1302.GUI.heading.SpadesHeading;
import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * A frame for game play windows.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class GamePlayFrame extends SpadesHeaderFrame {

    /**
     * Panel to hold the JLabels of cards played in this hand.
     */
    private final JPanel gameCardsPanel = new JPanel();

    /**
     * Holds the cards that were played in the current hand of the game.
     */
    private final CardDeck gameCards = new CardDeck();

    /**
     * Maps the cards dealt to the console used to the
     * JLabels used to display them.
     * IMPORTANT when the user clicks on a card image (JLabel),
     * that JLabel is looked-up in the hash-map and the card object is returned.
     */
    private final HashMap<JLabel, Card>
    consolePlayerHandMapping = new HashMap<>();

    /**
     * Holds/controls the game notification center, located above the
     * game hand deck of cards in the center panel.
     */
    private final JPanel notificationCenterPanel = new JPanel();


    /**
     * Main Method.
     * @todo: Remove this.
     * @param args used.
     */
    public static void main(final String[] args) {
        new GamePlayFrame("Round 1");
    }

    /**
     * Class constructor.
     * @param partialTitle the title
     */
    public GamePlayFrame(final String partialTitle) {
        super(partialTitle);
        this.setupContainerPanel();

        this.getContentPane().add(this.theContainerPanel);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Houses the list of players (left), played cards (hand deck) (center),
     * and the game stats (right) panels.
     */
    @Override
    protected void setupContentPanel() {
        this.theContentPanel.setOpaque(false);
        this.theContentPanel.setLayout(new BorderLayout(0, 0));

//        ADD: The center panel
        this.theContentPanel.add(
        		this.getDisplayOfCenterPanel(), BorderLayout.CENTER);

//      ADD: List of players
        this.theContentPanel.add(
        		this.getDisplayOfPlayersPanel(), BorderLayout.WEST);

//      ADD: The Console user's hand of cards
//        @todo: to be removed
        CardDeck deck = new CardDeck();
        for (int i = 0; i < 13; i++) {
            deck.add(new Card(Card.Suit.CLUB, Card.Rank.JACK));
        }
        this.theContentPanel.add(
        		this.getDisplayOfConsolePlayerCards(deck), BorderLayout.SOUTH);

//      ADD: The status panel (on the east of border-layout)
        JPanel statsPanel = getDisplayOfStatsPanel();
        statsPanel.setAlignmentX(Component.TOP_ALIGNMENT);
        this.theContentPanel.add(statsPanel, BorderLayout.EAST);
    }

    /**
     *
     * @return
     */
//    private JPanel getDisplayOfNotificationCenter() {
//        this.notificationCenterPanel.add(new JLabel(
//    		"Hello. Your turn....!"));
//
//        return this.notificationCenterPanel;
//    }

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

        this.gameCards.add(new Card(Card.Suit.CLUB, Card.Rank.JACK));
        this.gameCards.add(new Card(Card.Suit.DIAMOND, Card.Rank.KING));
        this.gameCards.add(new Card(Card.Suit.HEART, Card.Rank.EIGHT));


//      Current hand layout holder
        this.gameCardsPanel.setLayout(new GridLayout(1, 4, 0, 0));
        this.gameCardsPanel.setOpaque(false);

//        Notification Center uses flow layout
        this.notificationCenterPanel.setOpaque(true);
        this.notificationCenterPanel.setBackground(new Color(255, 171, 0));
        this.notificationCenterPanel.add(new SpadesHeading(
        		"Notice: Your turn!!", 16, Color.RED, SwingConstants.CENTER));

//        Add the game hand cards to the holding panel
        for (Card handCard : this.gameCards) {
            this.gameCardsPanel.add(new JLabel(GUIHelper.getCardImg(handCard)));
        }

//        ADD: the notification center and the hand deck to container.
        contentPanelCenter.add(this.notificationCenterPanel);
        contentPanelCenter.add(this.gameCardsPanel);

        this.notificationCenterPanel.setBounds(0, 0, 600, 30);
        this.gameCardsPanel.setBounds(0, 12, 600, 300);
        this.notificationCenterPanel.setVisible(false);
        return contentPanelCenter;
    }

    /**
     * DISPLAYS the console player's hand of cards.
     * @param cardsDealt cards dealt to users by the dealer.
     * @return the panel
     */
    private JPanel getDisplayOfConsolePlayerCards(final CardDeck cardsDealt) {
//      console user panel is a border-layout
        JPanel consolePlayerOutterWrap = new JPanel();
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
        for (Card theCard : cardsDealt) {
            JLabel cardLabel = new JLabel(GUIHelper.getCardImg(theCard, true));
            consolePlayerHandMapping.put(cardLabel, theCard);
            cardLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            cardLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                    JLabel cardClicked = (JLabel) e.getSource();

                    JPanel parent = (JPanel) cardClicked.getParent();
                    parent.remove(cardClicked);
//                    @todo: trigger event here for when
                    //card is removed from player hand

                    parent.revalidate();
                    parent.repaint();
                    GamePlayFrame.this.addCardToHandDeck((
                    		consolePlayerHandMapping.get(cardClicked)));
                }
            });
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
        this.gameCards.add(card);
        this.gameCardsPanel.add(new JLabel(GUIHelper.getCardImg(card)));

//        Repaint the hand deck panel/holder
        this.repaintPanel(this.gameCardsPanel);
    }

    /**
     * Sets up the stats panel.
     * @return the panel
     */
    private JPanel getDisplayOfStatsPanel() {
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setPreferredSize(new Dimension(200, 200));
        statsPanel.setOpaque(false);

//        Add team 2's stats
        JLabel team2Stats = new JLabel();
        team2Stats.setText("<html><p><span style="
        		+ "\"background-color: #0000ff; color: #ffffff;\""
        		+ "><strong>&nbsp;Score: 109&nbsp; &nbsp; &nbsp; "
        		+ "&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</strong></span><br"
        		+ " /><strong><span style=\"color: #000000; background-color:"
        		+ " #ffff00;\">&nbsp;Total Tricks: 12 &nbsp; &nbsp;"
        		+ "</span></strong><br /><span style=\"background-color:"
        		+ "#00ff00;\"><strong><span style=\"color: #000000;"
        		+ "\">&nbsp;Total wins: 6 &nbsp; &nbsp;&nbsp;"
        		+ "</span></strong></span><br /><strong><span style="
        		+ "\"color: #000000; background-color: #ff0000;\">&nbsp;Total"
        		+ " Sets: 3 &nbsp; &nbsp;</span></strong></p></html>");

        SpadesH3Heading team2Name = new SpadesH3Heading("Team 2", Color.WHITE);
        team2Name.setBorder(GUIHelper.uiPadding(0, 0, 10, 0));
        statsPanel.add(team2Name);

        statsPanel.add(team2Stats);

//        Add team 1's stats
        JLabel team1Stats = new JLabel();
        team1Stats.setText("<html><p><span style=\"background-color:"
        		+ " #0000ff; color: #ffffff;\"><strong>&nbsp;Score: "
        		+ "109&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;"
        		+ "</strong></span><br /><strong><span style=\"color: #000000;"
        		+ " background-color: #ffff00;\">&nbsp;Total Tricks: 12 &nbsp;"
        		+ " &nbsp;</span></strong><br /><span style=\"background-color:"
        		+ " #00ff00;\"><strong><span style=\"color: #000000;\">&nbsp;"
        		+ "Total wins: 6 &nbsp; &nbsp;&nbsp;</span></strong></span><br "
        		+ "/><strong><span style=\"color: #000000; background-color:"
        		+ " #ff0000;\">&nbsp;Total Sets: 3 &nbsp; &nbsp;"
        		+ "</span></strong></p></html>");

        SpadesH3Heading team1Name = new SpadesH3Heading("Team 1", Color.WHITE);
        team1Name.setBorder(GUIHelper.uiPadding(20, 0, 10, 0));
        statsPanel.add(team1Name);

        statsPanel.add(team1Stats);

//        Add the panel heading
        SpadesH3Heading panelHeading = new
        		SpadesH3Heading("Game Stats", Color.BLACK);
        statsPanel.add(panelHeading, SwingConstants.CENTER);

        return statsPanel;
    }

    /**
     * Sets up the player's panel. Lists the players in a vertical boxlayout.
     * @todo: change to list/set of players, not string and REMOVE personality
     * @return the panel
     */
    private JPanel getDisplayOfPlayersPanel() {
        final JPanel playersPanel = new JPanel();

        playersPanel.setPreferredSize(new Dimension(310, 200));
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        playersPanel.setOpaque(false);


        JLabel player01Img = new
        		JLabel(GUIHelper.getPlayerImg("aggressive", false));
        JLabel player02Img = new
        		JLabel(GUIHelper.getPlayerImg("console", true));
        JLabel player03Img = new
        		JLabel(GUIHelper.getPlayerImg("sophisticated", false));
        JLabel player04Img = new
        		JLabel(GUIHelper.getPlayerImg("wildcard", false));

        player01Img.setBorder(GUIHelper.uiPadding(10, 0));
        player02Img.setBorder(GUIHelper.uiPadding(10, 0));
        player03Img.setBorder(GUIHelper.uiPadding(10, 0));
        player04Img.setBorder(GUIHelper.uiPadding(10, 0));

        player01Img.setAlignmentX(Component.CENTER_ALIGNMENT);
        player02Img.setAlignmentX(Component.CENTER_ALIGNMENT);
        player03Img.setAlignmentX(Component.CENTER_ALIGNMENT);
        player04Img.setAlignmentX(Component.CENTER_ALIGNMENT);

        playersPanel.add(player01Img, SwingConstants.CENTER);
        playersPanel.add(player02Img, SwingConstants.CENTER);
        playersPanel.add(player03Img, SwingConstants.CENTER);
        playersPanel.add(player04Img, SwingConstants.CENTER);

        SpadesH3Heading panelHeading =
        		new SpadesH3Heading("Players", Color.BLACK);
        playersPanel.add(panelHeading, SwingConstants.CENTER);

        return playersPanel;
    }
}
