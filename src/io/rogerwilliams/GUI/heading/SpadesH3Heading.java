package io.rogerwilliams.GUI.heading;

import java.awt.Color;

/**
 * H3(3rd level heading).
 *
 * @author Roger Williams
 */
public class SpadesH3Heading extends SpadesHeading {
    /**
     * The default h1 heading font size.
     */
    private static final int DEFAULT_H1_SIZE = 16;

    /**
     * The default h1 heading font color.
     */
    private static final Color DEFAULT_H1_COLOR = Color.WHITE;

    /**
     * Class constructor.
     * @param headingText the text
     * @param fontColor the font color
     */
    public SpadesH3Heading(final String headingText, final Color fontColor) {
        super(headingText, DEFAULT_H1_SIZE, fontColor);
    }

    /**
     * Class constructor.
     * @param headingText the heading
     */
    public SpadesH3Heading(final String headingText) {
        super(headingText, DEFAULT_H1_SIZE, DEFAULT_H1_COLOR);
    }
}
