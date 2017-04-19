package edu.gsu.csc1302.GUI;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;
import edu.gsu.csc1302.emperorsofspades.player.Player;
import edu.gsu.csc1302.emperorsofspades.player.ai.AIPlayer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Color;

/**
 * Helper class with various methods to speed up design.
 * @author Roger Williams
 */
public final class GUIHelper {
	/**
	 * this gives it a private constructor.
	 */
	private  GUIHelper() {

	}
	/**
	 * path to the resource folder.
	 */
    public static final String PATH_TO_RESOURCE_FOLDER = "/res/";
    /**
     * returns the image wanted.
     * @param pathToImage the path to the image wanted.
     * @return the image icon.
     */
    public static ImageIcon getImage(final String pathToImage) {
        return new ImageIcon(SpadesGUI.class.getResource(pathToImage));
    }
    /**
     * gets the large logo form the computer directory.
     * @return image form computer.
     */
    public static ImageIcon getLargeLogo() {
        return SpadesGUI.getImage(
        		"/edu/gsu/csc1302/GUI/resources/images/logo-large-1.png");
    }
    /**
     * gets the small logo form the computer directory.
     * @return image form computer.
     */
    public static ImageIcon getSmallLogo() {
        return SpadesGUI.getImage(
        		"/edu/gsu/csc1302/GUI/resources/images/logo-small-1.png");
    }
    /**
     * returns the id of the card.
     * @param card gets the card.
     * @return the ID of the card.
     */
    public static String generateCardID(final Card card) {
        return card.getSuit() + "_" + card.getRank();
    }
    /**
     * gets the large logo form the computer directory.
     * @return image form computer.
     * @param card the card we are looking an image for.
     */
    public static ImageIcon getCardImg(final Card card) {
        return SpadesGUI.getImage("/res/images/cards/"
    + generateCardID(card) + ".png.png");
    }
    /**
     * gets the large logo form the computer directory.
     * @return image form computer.
     * @param card the card we will get the image of.
     * @param smallImg small image.
     */
    public static ImageIcon getCardImg(
    		final Card card, final boolean smallImg) {
        return SpadesGUI.getImage(
        		"/res/images/cards/small/" + generateCardID(card) + ".png.png");
    }
    /**
     * gets the players image.
     * @todo: change from string to player.
     * @param player the player the image is sought for.
     * @param getRedImg boolean telling wich image to chose form the choice.
     * @return  the image from memory.
     */
    public static ImageIcon getPlayerImg(
            final Player player, final boolean getRedImg) {
        String imgString;

        if (player instanceof AIPlayer) {
            imgString = ((AIPlayer) player).getPersonalityString();
            imgString = imgString.toLowerCase();
            System.out.println(imgString);
        } else {
            imgString = "console";
        }
        if (getRedImg) {
            return SpadesGUI.getImage(
            		"/res/images/playericons/" + imgString + "_red.png");
        }

        return SpadesGUI.getImage("/res/images/playericons/"
        + imgString + ".png");

    }

    /**
     * generates separator.
     * @return the separator generated.
     */
    public static JSeparator generateSeparator() {
        JSeparator separator =  new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBackground(Color.BLACK);
        separator.setForeground(Color.BLACK);
        return separator;
    }
    /**
     * creates padding using empty boarder.
     * @param topBottom the length from top to bottom.
     * @param leftRight the length from right to left.
     * @return an empty border
     */
    public static Border uiPadding(final int topBottom, final int leftRight) {
        return  BorderFactory.createEmptyBorder(
        		topBottom, leftRight, topBottom, leftRight);
    }
    /**
     * creates padding using empty boarder.
     * @param top location.
     * @param right location.
     * @param bottom location.
     * @param left location.
     * @return an empty border
     */
    public static Border uiPadding(final int top, final int right,
    		final int bottom, final int left) {
        return  BorderFactory.createEmptyBorder(top, right, bottom, left);
    }
}
