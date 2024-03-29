package io.rogerwilliams.GUI.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import io.rogerwilliams.GUI.SpadesGUI;
import io.rogerwilliams.GUI.heading.FrameHeading;


/**
 * Defines a JFrame with a header and content area.
 * It uses a border-layout for the container panel.
 */
@SuppressWarnings("serial")
public abstract class SpadesHeaderFrame extends SpadesFrame {

    /**
     * The actual frame/ container for the entire window.
     * Uses a border layout.
     */
    protected final JPanel theContainerPanel = new JPanel();

    /**
     * The header of the frame
     * Uses absolute positioning.
     */
    protected final JPanel theHeaderPanel = new JPanel();

    /**
     * Contains the main content for the given frame.
     * Uses a flow layout.
     */
    protected final JPanel theContentPanel = new JPanel();

    /**
     * Class constructor.
     * @param partialFrameTitle the partial title
     * @param backgroundColor background color of the frame
     * @param frameDimensions the dimensions of the frame
     */
    public SpadesHeaderFrame(final String partialFrameTitle,
    		final Color backgroundColor, final Dimension frameDimensions) {
        super(partialFrameTitle, backgroundColor, frameDimensions);
        this.setupHeaderPanel(partialFrameTitle);
//        this.setupContentPanel();
//        this.setupContainerPanel();
//
//        this.getContentPane().add(this.theContainerPanel);
    }

    /**
     * Class constructor with just title.
     * @param partialTitle the title
     */
    public SpadesHeaderFrame(final String partialTitle) {
        super(partialTitle);
        this.setupHeaderPanel(partialTitle);
//        this.setupContentPanel();
//        this.setupContainerPanel();
//        this.getContentPane().add(this.theContainerPanel);
//        this.getContentPane().add(this.theContainerPanel);
    }

    /**
     * Sets up the main content area panel of the frame with all the components
     * added to the theHeaderPanel field. ALL subclasses must implement
     */
    protected abstract void setupContentPanel();

    /**
     * Sets up the header panel of the frame with all the components
     * added to the theHeaderPanel field. This is consistent throughout.
     * @param title title of the frame
     */
    private void setupHeaderPanel(final String title) {
        this.theHeaderPanel.setPreferredSize(new
        		Dimension(SpadesGUI.DEFAULT_FRAME_WIDTH, 100));
        this.theHeaderPanel.setLayout(null);
        this.theHeaderPanel.setOpaque(false);

        JLabel logoLabel = new JLabel(SpadesGUI.getSmallLogo());
        FrameHeading frameTitleLabel = new FrameHeading(
        		title, SwingConstants.CENTER);

        this.theHeaderPanel.add(logoLabel);
        this.theHeaderPanel.add(frameTitleLabel);
        logoLabel.setBounds(300, 0, 300, 50);
        frameTitleLabel.setBounds(620, 0, 200, 50);

        JSeparator horiline =  SpadesGUI.generateSeparator();
        this.theHeaderPanel.add(horiline);
        horiline.setBounds(0, 51, SpadesGUI.DEFAULT_FRAME_WIDTH, 4);
    }

    /**
     * This is the container for the frame. The frame's layout is set here.
     * It uses the border-layout and utilizes the NORTH and CENTER regions.
     * NORTH is for the header. CENTER is for the main content area.
     */
    protected void setupContainerPanel() {
        this.theContainerPanel.setPreferredSize(
        		new Dimension(SpadesGUI.DEFAULT_FRAME_WIDTH,
        				SpadesGUI.DEFAULT_FRAME_HEIGHT));
        this.theContainerPanel.setBackground(SpadesGUI.UI_BACKGROUND_COLOR);

        BorderLayout layout = new BorderLayout(0, 0);
        this.theContainerPanel.setLayout(layout);

//       Setup the header and content area panels.
        this.setupContentPanel();

//       Add header and content areas to the container panel.
        this.theContainerPanel.add(this.theContentPanel, BorderLayout.CENTER);
        this.theContainerPanel.add(this.theHeaderPanel, BorderLayout.NORTH);
    }
}
