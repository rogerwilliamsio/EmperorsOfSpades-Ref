package io.rogerwilliams.GUI.heading;

import java.awt.Color;

/**
 * H1(major heading). Largest heading.
 *
 * @author Roger Williams
 */
public class SpadesH1Heading extends SpadesHeading {
    /**
     * The default h1 heading font size.
     */
    private static final int DEFAULT_H1_SIZE = 25;

    /**
     * The default h1 heading font color.
     */
    private static final Color DEFAULT_H1_COLOR = Color.WHITE;

    /**
     * Class constructor.
     * @param headingText the text
     * @param fontColor the font color
     */
    public SpadesH1Heading(final String headingText, final Color fontColor) {
        super(headingText, DEFAULT_H1_SIZE, fontColor);
    }

    /**
     * Class constructor.
     * @param headingText the heading
     */
    public SpadesH1Heading(final String headingText) {
        super(headingText, DEFAULT_H1_SIZE, DEFAULT_H1_COLOR);
    }
}
