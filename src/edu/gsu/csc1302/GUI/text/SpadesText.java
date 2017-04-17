package edu.gsu.csc1302.GUI.text;

import javax.swing.*;
import java.awt.*;

/**
 * A spades text. A spades text is a JLabel
 *
 * @author Roger Williams
 */
public class SpadesText extends JLabel {

    public SpadesText(final String text) {
        super(text);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
    }

    public SpadesText(final String text, final int alignment) {
        super(text, alignment);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
    }
}
