package edu.gsu.csc1302.GUI.text;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * A spades text. A spades text is a JLabel
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SpadesText extends JLabel {
	/**
	 * Creates the label.
	 * @param text the text to be used on the label.
	 */
    public SpadesText(final String text) {
        super(text);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
    }
    /**
     * another constructor to create the label.
     * @param text to be used for the label.
     * @param alignment the alignment of the label.
     */
    public SpadesText(final String text, final int alignment) {
        super(text, alignment);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
    }
}
