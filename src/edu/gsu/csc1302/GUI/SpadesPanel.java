package edu.gsu.csc1302.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * A Default, grid-style panel for the spades gui.
 *
 * @author Roger Williams
 */
public class SpadesPanel extends JPanel {
    private final GridBagConstraints gridConstraints = new GridBagConstraints();

    public SpadesPanel() {
        super(new GridBagLayout());
    }

    public GridBagConstraints contraints() {
        return this.gridConstraints;
    }

    public void goToNextRow() {
        System.out.println(this.gridConstraints.gridx);
        this.goToPoint(this.gridConstraints.gridx,
                this.gridConstraints.gridy + 1);
    }

    public void goToNthRow(final int nthRow) {
        System.out.println(this.gridConstraints.gridx);
        this.goToPoint(this.gridConstraints.gridx,
                this.gridConstraints.gridy + nthRow);
    }

    public void goToNextColumn() {
        System.out.println(this.gridConstraints.gridx);
        this.goToPoint(this.gridConstraints.gridx + 1,
                this.gridConstraints.gridy);
    }

    public void goToNthColumn(final int nthColumn) {
        System.out.println(this.gridConstraints.gridx + nthColumn);
        this.goToPoint(this.gridConstraints.gridx,
                this.gridConstraints.gridy);
    }

    public void goToPoint(final int xPos, final int yPos) {
        this.gridConstraints.gridx = xPos;
        this.gridConstraints.gridy = yPos;
    }

    public void add(final JComponent component) {
        super.add(component, this.gridConstraints);
    }

    public void addToNextRow(final JComponent component) {
        this.goToNextRow();
        this.add(component);
    }

    public void addToNthRow(final JComponent component, final int nthRow) {
        this.goToNthRow(nthRow);
        this.add(component);
    }

    public void addToNextColumn(final JComponent component, final int nthColumn) {
        this.goToNthColumn(nthColumn);
        this.add(component);
    }

    public void addToNthColumn(final JComponent component) {
        this.goToNextColumn();
        this.add(component);
    }
}
