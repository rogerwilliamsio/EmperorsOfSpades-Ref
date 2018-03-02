package edu.gsu.csc1302.GUI.heading;

import java.awt.Color;

import javax.swing.SwingConstants;

/**
 * A Frame label.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class FrameHeading extends SpadesHeading {
	/**
	 * constructor for the frame heading.
	 * @param headingText the heading text
	 * @param alignment the alignment of the heading.
	 */
    public FrameHeading(final String headingText, final int alignment) {
        super(headingText, 20, Color.WHITE, SwingConstants.CENTER);
    }
}
