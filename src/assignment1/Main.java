package assignment1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * Main
 */
public class Main extends JFrame {
	private JLabel header, footer;
	private JPanel p1, p2, p3;
	private JButton userBtn, adminBtn;
	private ArrayList<Table> tables;
	private Menu menu;

	public Main(ArrayList<Table> tables) {
		header = new JLabel("Welcome to the Restaurant");
		header.setFont(new Font("Verdana", Font.BOLD, 20));
		footer = new JLabel("Anwar Zaid Sdn. Bhd.");
		footer.setFont(new Font("Verdana", Font.PLAIN, 10));
		// End Labels

		// Buttons
		userBtn = new JButton("I am a User");
		userBtn.setPreferredSize(new Dimension(130, 50));
		adminBtn = new JButton("I am a Waiter/Cook");
		adminBtn.setPreferredSize(new Dimension(160, 50));

		userBtn.setBackground(new Color(22, 160, 133));
		adminBtn.setBackground(new Color(22, 160, 133));
		// End Buttons

		p1 = new JPanel();
		p1.setBackground(new Color(22, 160, 133));

		p1.add(header);

		p2 = new JPanel();
		p2.add(userBtn);
		p2.add(adminBtn);
		p2.setLocation(10, 10);
		p2.setBackground(new Color(26, 188, 156));

		p3 = new JPanel();
		p3.add(footer);
		p3.setBackground(new Color(26, 188, 156));

		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		p2.setLayout(new GridLayout(1, 2));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					menu = new Menu();
					createFrame(new OrderPage(new Menu()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		adminBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					createFrame(new AdminPage(tables));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		Main main = new Main(new ArrayList<Table>());
		main.setSize(500, 500);
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createFrame(JFrame obj) {
		this.dispose();
		obj.setSize(800, 600);
		obj.setVisible(true);
	}

}