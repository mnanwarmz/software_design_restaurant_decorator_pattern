package assignment1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * Main
 */
public class Main {
	public static void main(String[] args) {
		createFrame(new OrderPage(new Menu()));
	}

	private static void createFrame(JFrame obj) {
		obj.setSize(800, 600);
		obj.setVisible(true);
	}

}