package edu.gsu.csc1302.GUI.frame;

import edu.gsu.csc1302.GUI.GUIHelper;
import edu.gsu.csc1302.GUI.SpadesGUI;
import edu.gsu.csc1302.GUI.heading.SpadesH3Heading;
import edu.gsu.csc1302.GUI.heading.SpadesHeading;
import edu.gsu.csc1302.emperorsofspades.CardDeck;
import edu.gsu.csc1302.emperorsofspades.SpadesEngine;
import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.player.gui.GuiPlayer;
import edu.gsu.csc1302.emperorsofspades.team.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A frame for game play windows.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class GamePlayFrame extends SpadesHeaderFrame {

   private final SpadesEngine theGamesEngine;

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
    public GamePlayFrame(final String partialTitle, final SpadesEngine theGameEngine) {
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

        System.out.println(guiPlayer);
        this.theGuiPlayer = guiPlayer;

        // @todo: want to make user click on card deck to deal when his turn
//        this.theGamesEngine.startRound();
        this.theGamesEngine.dealCards();

        this.setupContainerPanel();

        this.getContentPane().add(this.theContainerPanel);
        this.pack();
        this.setVisible(true);

        this.notifyUserTOPlay();
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

//      ADD: List of players
        this.theContentPanel.add(
        		this.getDisplayOfPlayersPanel(), BorderLayout.WEST);

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

//        Add the game hand cards to the holding panel
        for (Card handCard : this.theGamesEngine.getHand()) {
            this.gameCardsPanel.add(new JLabel(GUIHelper.getCardImg(handCard)));
        }

//        ADD: the notification center and the hand deck to container.
        contentPanelCenter.add(this.notificationCenterPanel);

//        @Todo: make sure to init playhnad in the constructor
//        Display the deck card image if it's the first hand of a round
        if (this.theGamesEngine.getHandNumber() == 1) {
            JPanel cardDeckImg = this.displayDeckOfCards();
            contentPanelCenter.add(cardDeckImg);
            cardDeckImg.setBounds(0, 50, 600, 300);
        } else {
            contentPanelCenter.add(this.gameCardsPanel);
            this.gameCardsPanel.setBounds(0, 12, 600, 300);
        }

        this.notificationCenterPanel.setBounds(0, 0, 600, 30);


        this.notificationCenterPanel.setVisible(false);
        return contentPanelCenter;
    }

    /**
     * DISPLAYS the console player's hand of cards.
     * @return the panel
     */
    private JPanel getDisplayOfConsolePlayerCards() {
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
        for (Card theCard : this.theGuiPlayer.getHand()) {
            JLabel cardLabel = new JLabel(GUIHelper.getCardImg(theCard, true));
            consolePlayerHandMapping.put(cardLabel, theCard);
            cardLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            cardLabel.setEnabled(false);
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

//    private JPanel getDisplayOfGameHand() {
//        this.center
//    }

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
    private JPanel getDisplayOfPlayersPanel() {
        final JPanel playersPanel = new JPanel();

        playersPanel.setPreferredSize(new Dimension(310, 200));
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        playersPanel.setOpaque(false);

        for (Player player : theGamesEngine.getPlayers()) {
            JLabel playerLabel = new JLabel(
                    GUIHelper.getPlayerImg(player, false));

            this.playersJlabelMapping.put(playerLabel, player);

            playerLabel.setBorder(GUIHelper.uiPadding(10, 0));
            playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            playersPanel.add(playerLabel, SwingConstants.CENTER);
        }

        SpadesH3Heading panelHeading =
        		new SpadesH3Heading("Players", Color.BLACK);
        playersPanel.add(panelHeading, SwingConstants.CENTER);

        return playersPanel;
    }

    /**
     * Displays the deck of cards to be dealt.
     * @return image.
     */
    private JPanel displayDeckOfCards() {
        JPanel deckOfCards = new JPanel();
        JLabel deckImg = new JLabel(GUIHelper.getImage("/res/images/misc/carddeck.png"));
        deckImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deckOfCards.setOpaque(false);

        deckOfCards.add(deckImg);
        return deckOfCards;
    }

    private void notifyUserTOPlay() {
        SpadesHeading playNowLbl = new SpadesHeading(
                "It's your turn to play.", 16, Color.RED, SwingConstants.CENTER);
        this.notificationCenterPanel.add(playNowLbl);
        this.notificationCenterPanel.setVisible(true);
    }

    private void updateTeamStats() {
        Iterator itr = this.theGamesEngine.getTeams().entrySet().iterator();

        while (itr.hasNext()) {
            Team theTeam = (Team) itr.next();

            JLabel teamLbl = new JLabel();
            teamLbl.setText("<html><p><span style="
                    + "\"background-color: #0000ff; color: #ffffff;\""
                    + "><strong>&nbsp;Score: " + theTeam.getScore() + "&nbsp; &nbsp; &nbsp; "
                    + "&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</strong></span><br"
                    + " /><strong><span style=\"color: #000000; background-color:"
                    + " #ffff00;\">&nbsp;Total Tricks: " + theTeam.getTricks() + " &nbsp; &nbsp;"
                    + "</span></strong><br /><span style=\"background-color:"
                    + "#00ff00;\"><strong><span style=\"color: #000000;"
                    + "</span></strong></span><br /><strong><span style="
                    + "\"color: #000000; background-color: #ff0000;\">&nbsp;Total"
                    + " Sets: " + theTeam.getNumOfSets() + " &nbsp; &nbsp;</span></strong></p></html>");

            SpadesH3Heading teamName = new SpadesH3Heading(theTeam.getTeamName(), Color.WHITE);
            teamName.setBorder(GUIHelper.uiPadding(20, 0, 10, 0));
            statsPanel.add(teamName, SwingConstants.CENTER);

            this.statsPanel.add(teamLbl);
        }

//        Add the panel heading
        SpadesH3Heading panelHeading = new
                SpadesH3Heading("Game Stats", Color.BLACK);
        statsPanel.add(panelHeading, SwingConstants.CENTER);
    }

    private void startRound() {
//    Do stuff
    }

    private void startNewHand() {
        this.theGamesEngine.playHand();
    }
}
