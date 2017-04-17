package edu.gsu.csc1302.GUI;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;

/**
 * Helper class with various methods to speed up design.
 *
 * @author Roger Williams
 */
public final class GUIHelper {
    public static final String PATH_TO_RESOURCE_FOLDER = "/res/";

    public static ImageIcon getImage(final String pathToImage) {
        return new ImageIcon(SpadesGUI.class.getResource(pathToImage));
    }

    public static ImageIcon getLargeLogo() {
        return SpadesGUI.getImage("/edu/gsu/csc1302/GUI/resources/images/logo-large-1.png");
    }

    public static ImageIcon getSmallLogo() {
        return SpadesGUI.getImage("/edu/gsu/csc1302/GUI/resources/images/logo-small-1.png");
    }

    public static String generateCardID(final Card card) {
        return card.getSuit() + "_" + card.getRank();
    }

    public static ImageIcon getCardImg(final Card card) {
        return SpadesGUI.getImage("/res/images/cards/" + generateCardID(card) + ".png.png");
    }

    public static ImageIcon getCardImg(final Card card, final boolean smallImg) {
        return SpadesGUI.getImage("/res/images/cards/small/" + generateCardID(card) + ".png.png");
    }

    /**
     * @todo: change from string to player
     * @param player
     * @return
     */
    public static ImageIcon getPlayerImg(final String player, final boolean getRedImg) {
        if (getRedImg) {
            return SpadesGUI.getImage("/res/images/playericons/" + player + "_red.png");
        }

        return SpadesGUI.getImage("/res/images/playericons/" + player + ".png");

    }

    public static JSeparator generateSeparator() {
        JSeparator separator =  new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBackground(Color.BLACK);
        separator.setForeground(Color.BLACK);
        return separator;
    }

    public static Border uiPadding(final int topBottom, final int leftRight) {
        return  BorderFactory.createEmptyBorder(topBottom,leftRight,topBottom,leftRight);
    }

    public static Border uiPadding(final int top, final int right, final int bottom, final int left) {
        return  BorderFactory.createEmptyBorder(top,right,bottom,left);
    }
}
