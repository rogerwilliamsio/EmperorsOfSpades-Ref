package edu.gsu.csc1302.GUI;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

/**
 * the spades GUI class.
 * @author Mahetem Moges
 */
public final class SpadesGUI {
	/**
	 * this makes the class have private owner.
	 */
	private SpadesGUI() {
	}
	/**
	 * this is the main method of the class.
	 * @param args the arguments used.
	 */
	public static void main(final String[] args) {
		JFrame fram = new JFrame();
		fram.setBackground(Color.LIGHT_GRAY);
		fram.setForeground(Color.BLUE);
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setLocation(new Point(10, 50));
		fram.setSize(3000, 1200);
		fram.setTitle("My First Frame");
		fram.setVisible(true);
	}
}
