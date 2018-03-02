package edu.gsu.csc1302.GUI;

import javax.swing.JComponent;

/**
 * A Spades GUI component.
 *
 * @author Roger Williams
 */
public abstract class SpadesComponent extends JComponent {
    /**
     * The width of the component.
     */
    private final int componentGridWidth = 1;

    /**
     * Returns the width of the component, with respect to the layout grid.
     * @return width
     */
    public int getComponentGridWidth() {
        return this.componentGridWidth;
    }

}
