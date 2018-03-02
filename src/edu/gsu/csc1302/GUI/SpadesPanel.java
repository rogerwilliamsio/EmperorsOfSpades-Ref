package edu.gsu.csc1302.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * A Default, grid-style panel for the spades GUI.
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SpadesPanel extends JPanel {
	/**
	 * grid constrain.
	 */
    private final GridBagConstraints gridConstraints = new GridBagConstraints();
    /**
     * constructor for the class.
     */
    public SpadesPanel() {
        super(new GridBagLayout());
    }
    /**
     * returns the grid constraint.
     * @return the grid constraint.
     */
    public GridBagConstraints contraints() {
        return this.gridConstraints;
    }
    /**
     * moves to the next row.
     */
    public void goToNextRow() {
        System.out.println(this.gridConstraints.gridx);
        this.goToPoint(this.gridConstraints.gridx,
                this.gridConstraints.gridy + 1);
    }
    /**
     * goes to specific row.
     * @param nthRow the row to got to.
     */
    public void goToNthRow(final int nthRow) {
        System.out.println(this.gridConstraints.gridx);
        this.goToPoint(this.gridConstraints.gridx,
                this.gridConstraints.gridy + nthRow);
    }
    /**
     * Goes to the next column.
     */
    public void goToNextColumn() {
        System.out.println(this.gridConstraints.gridx);
        this.goToPoint(this.gridConstraints.gridx + 1,
                this.gridConstraints.gridy);
    }
    /**
     * goes to the given column.
     * @param nthColumn the column to go to.
     */
    public void goToNthColumn(final int nthColumn) {
        System.out.println(this.gridConstraints.gridx + nthColumn);
        this.goToPoint(this.gridConstraints.gridx,
                this.gridConstraints.gridy);
    }
    /**
     * moves the panel to a specific position.
     * @param xPos the x position.
     * @param yPos the y position.
     */
    public void goToPoint(final int xPos, final int yPos) {
        this.gridConstraints.gridx = xPos;
        this.gridConstraints.gridy = yPos;
    }
    /**
     * adds component.
     * @param component the component to be added.
     */
    public void add(final JComponent component) {
        super.add(component, this.gridConstraints);
    }
    /**
     * adds component to the next row.
     * @param component the component to be added.
     */
    public void addToNextRow(final JComponent component) {
        this.goToNextRow();
        this.add(component);
    }
    /**
     * adds component.
     * @param component the component to be added.
     * @param nthRow the row were the component will be added.
     */
    public void addToNthRow(final JComponent component, final int nthRow) {
        this.goToNthRow(nthRow);
        this.add(component);
    }
    /**
     * adds the component to a specific column.
     * @param component the component to be added
     * @param nthColumn the column where the component will be added
     */
    public void addToNextColumn(final JComponent component,
    		final int nthColumn) {
        this.goToNthColumn(nthColumn);
        this.add(component);
    }
    /**
     * adds component to the next column.
     * @param component the component to be added.s
     */
    public void addToNthColumn(final JComponent component) {
        this.goToNextColumn();
        this.add(component);
    }
}
