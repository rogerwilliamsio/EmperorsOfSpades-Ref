package edu.gsu.csc1302.GUI.heading;

import java.awt.Color;
import java.awt.Font;

import edu.gsu.csc1302.GUI.text.SpadesText;



/**
 * the class for the heading of the texts.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SpadesHeading extends SpadesText {

    /**
     * The GUI base heading class.
     * @param headingText the text
     * @param fontSize the font size
     * @param fontColor color of the font
     */
    public SpadesHeading(final String headingText,
    		final int fontSize, final Color fontColor) {
        super(headingText);
        this.headingStyles(fontSize, fontColor);
    }

    /**
     * The GUI base heading class, with a specified alignment.
     * @param headingText the text
     * @param fontSize the font size
     * @param fontColor color of the font
     * @param alignment the alignment of the text.
     */
    public SpadesHeading(final String headingText,
    		final int fontSize, final Color fontColor,
                         final int alignment) {
        super(headingText, alignment);
        this.headingStyles(fontSize, fontColor);
    }

    /**
     * The the styles for the base heading class.
     * @param fontSize the font size
     * @param color the color of the font
     */
    private void headingStyles(final int fontSize, final Color color) {
        this.setForeground(color);
        this.setFont(new Font("Arial", Font.BOLD, fontSize));
    }
}
