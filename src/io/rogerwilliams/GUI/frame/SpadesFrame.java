package io.rogerwilliams.GUI.frame;

import io.rogerwilliams.GUI.SpadesGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Default spades frame.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SpadesFrame extends JFrame {

    /**
     * Class constructor.
     * @param partialFrameTitle the partial title
     */
    public SpadesFrame(final String partialFrameTitle) {
        this(partialFrameTitle, SpadesGUI.UI_BACKGROUND_COLOR,
        		new Dimension(SpadesGUI.DEFAULT_FRAME_WIDTH,
        				SpadesGUI.DEFAULT_FRAME_HEIGHT));
    }

    /**
     * Class constructor.
     * @param partialFrameTitle the partial title
     * @param backgroundColor background color of te frame
     * @param frameDimensions the dimensions of the frame
     */
    public SpadesFrame(final String partialFrameTitle,
    		final Color backgroundColor,
    		final Dimension frameDimensions) {
        super(SpadesGUI.APP_NAME + " - " + partialFrameTitle);

        this.setBackground(backgroundColor);
        this.setSize(frameDimensions);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }
    /**
     * Refresh/repaint the given panel.
     * @param panel the panel
     */
    protected void repaintPanel(final JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }
}
