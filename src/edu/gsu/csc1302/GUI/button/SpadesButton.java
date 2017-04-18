package edu.gsu.csc1302.GUI.button;

import edu.gsu.csc1302.GUI.SpadesGUIActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

/**
 * A custom button made for the spades gui.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SpadesButton extends JButton {
    /**
     * The default background color for the buttons.
     */
    public static final Color DEFAULT_BACKGROUND_COLOR = Color.BLACK;

    /**
     * The default foreground color for the buttons, AKA text color.
     */
    public static final Color DEFAULT_FOREGROUND_COLOR = Color.WHITE;

    /**
     * The width of this button, with respect to the grid.
     */
    private int componentGridWidth = 1;

    /**
     * Init with just the text and default settings.
     * @param text to put on the button
     */
    public SpadesButton(final String text) {
        this(text, null, null);
    }

    /**
     * Class constructor. Init with overriding settings.
     * @param text to put on the button
     * @param backgroundColor background color of the button
     * @param foregroundColor foreground color of the button (text color)
     */
    public SpadesButton(final String text,
    		final Color backgroundColor, final Color foregroundColor) {
        super(text);
//        Add event listener to all spades button
        this.addActionListener(new SpadesGUIActionListener());
        applySpadesStyles(backgroundColor, foregroundColor);

    }

    /**
     * Deafult settings for every spades button.
     * @param backgroundColor the required background color for the button
     * @param foregroundColor the require text color for the button
     */
    private void applySpadesStyles(final Color backgroundColor,
    		final Color foregroundColor) {
        this.setFocusPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if (backgroundColor == null) {
            this.setBackground(DEFAULT_BACKGROUND_COLOR);
        } else {
            this.setBackground(backgroundColor);
        }

        if (foregroundColor == null) {
            this.setForeground(DEFAULT_FOREGROUND_COLOR);
        } else {
            this.setForeground(foregroundColor);
        }
    }

    /**
     * Returns the with of the button.
     * @return the component width
     */
    public int getComponentGridWidth() {
        return componentGridWidth;
    }
}
