package edu.gsu.csc1302.GUI;

import edu.gsu.csc1302.GUI.dialog.SpadesConfirmDialog;
import edu.gsu.csc1302.GUI.dialog.SpadesDialog;
import edu.gsu.csc1302.GUI.frame.SplashScreenFrame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * The entry point for the Emperors of Spades game engine.
 *
 * @author Roger Williams
 */
public final class SpadesGUI {
	/**
	 * The default background color of the UI.
	 */
	public static final Color UI_BACKGROUND_COLOR = new Color(27, 94, 32);

	/**
	 * The default width of a frame.
	 */
	public static final int DEFAULT_FRAME_WIDTH = 1200;

	/**
	 * The default height of a frame.
	 */
	public static final int DEFAULT_FRAME_HEIGHT = 700;

	/**
	 * The name of the application.
	 */
	public static final String APP_NAME = "Emperors of Spades";

	/**
	 * Stores the current/active frame.
	 */
	private static JFrame currentFrame = null;

	/**
	 * class constructor.
	 */
	private SpadesGUI() {

	}

	/**
	 * Initializes the application.
	 * @param args the arguments used.
	 */
	public static void main(final String[] args) {
		currentFrame = new SplashScreenFrame();
	}
	/**
	 * returns the dialog that will be displayed.
	 * @return the dialog that will be displayed.
	 */

	public static boolean promptUserToPlayFrame() {
		return SpadesConfirmDialog.show(null,
				SpadesDialog.MessageType.PLAIN, "Confirm", "Do you want to play!");
	}
	/**
	 * Returns the current frame.
	 * @return frame
	 */
	public static JFrame getCurrentFrame() {
		return currentFrame;
	}

	/**
	 * returns the image icon needed.
	 * @param pathToImage variable to access the image.
	 * @return image icon.
	 */
	public static ImageIcon getImage(final String pathToImage) {
		return new ImageIcon(SpadesGUI.class.getResource(pathToImage));
	}

	/**
	 * returns the small logo to be displayed.
	 * @return the smaller logo.
	 */
	public static ImageIcon getSmallLogo() {
		return SpadesGUI.getImage(
				"/edu/gsu/csc1302/GUI/resources/images/logo-small-1.png");
	}
	/**
	 * return the separator to use in the display.
	 * @return the separator to use in the display.
	 */
	public static JSeparator generateSeparator() {

		JSeparator separator =  new JSeparator(SwingConstants.HORIZONTAL);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		return separator;
	}
}
