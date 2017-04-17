package edu.gsu.csc1302.GUI;

import edu.gsu.csc1302.GUI.button.SpadesButton;
import edu.gsu.csc1302.GUI.dialog.SpadesConfirmDialog;
import edu.gsu.csc1302.GUI.dialog.SpadesDialog;
import edu.gsu.csc1302.GUI.dialog.SpadesInputDialog;
import edu.gsu.csc1302.GUI.frame.SplashScreenFrame;
import edu.gsu.csc1302.GUI.heading.SpadesH1Heading;

import javax.swing.*;
import java.awt.*;

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
	 * OS window toolkit.
	 */
	private final Toolkit toolkit = Toolkit.getDefaultToolkit();

	/**
	 * class constructor.
	 * @param partialTitle the partial title for the window
	 */
	private SpadesGUI(final String partialTitle) {

	}

	/**
	 * Initializes the application.
	 * @param args the arguments used.
	 */
	public static void main(final String[] args) {
		currentFrame = new SplashScreenFrame();
	}



	public static boolean promptUserToPlayFrame() {
		return SpadesConfirmDialog.show(null, SpadesDialog.MessageType.PLAIN, "Confirm", "Do you want to play!");
	}

	/**
	 * Returns the current frame
	 * @return frame
	 */
	public static JFrame getCurrentFrame() {
		return currentFrame;
	}

	/**
	 * update the current frame.
	 * @param frame frame
	 */
	public static void setCurrentFrame(final JFrame frame) {
		currentFrame = frame;
	}

	public static ImageIcon getImage(final String pathToImage) {
		return new ImageIcon(SpadesGUI.class.getResource(pathToImage));
	}

	public static ImageIcon getLargeLogo() {
		return SpadesGUI.getImage("/edu/gsu/csc1302/GUI/resources/images/logo-large-1.png");
	}

	public static ImageIcon getSmallLogo() {
		return SpadesGUI.getImage("/edu/gsu/csc1302/GUI/resources/images/logo-small-1.png");
	}

	public static JSeparator generateSeparator() {
		JSeparator separator =  new JSeparator(SwingConstants.HORIZONTAL);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		return separator;
	}
}
