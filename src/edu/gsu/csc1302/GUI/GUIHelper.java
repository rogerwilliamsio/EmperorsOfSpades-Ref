package edu.gsu.csc1302.GUI;

import edu.gsu.csc1302.emperorsofspades.instructorsolutions.Card;

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
    		final String player, final boolean getRedImg) {
        if (getRedImg) {
            return SpadesGUI.getImage(
            		"/res/images/playericons/" + player + "_red.png");
        }

        return SpadesGUI.getImage("/res/images/playericons/" + player + ".png");

    }
    /**
     * 
     * @return
     */
    public static JSeparator generateSeparator() {
        JSeparator separator =  new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBackground(Color.BLACK);
        separator.setForeground(Color.BLACK);
        return separator;
    }
    /**
     * 
     * @param topBottom
     * @param leftRight
     * @return
     */
    public static Border uiPadding(final int topBottom, final int leftRight) {
        return  BorderFactory.createEmptyBorder(topBottom,leftRight,topBottom,leftRight);
    }
    /**
     * 
     * @param top
     * @param right
     * @param bottom
     * @param left
     * @return
     */
    public static Border uiPadding(final int top, final int right, final int bottom, final int left) {
        return  BorderFactory.createEmptyBorder(top,right,bottom,left);
    }
}
