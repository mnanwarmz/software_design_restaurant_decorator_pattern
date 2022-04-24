package assignment1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {

	private JPanel containerPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel tableDetailsPanel = new JPanel();
	private ArrayList<Table> tables;

	public AdminPage(ArrayList<Table> tables) {
		this.tables = tables;
		JLabel header = new JLabel("Welcome to the Restaurant");
		header.setFont(new Font("Verdana", Font.BOLD, 20));
		JLabel footer = new JLabel("Anwar Zaid Sdn. Bhd.");
		footer.setFont(new Font("Verdana", Font.PLAIN, 10));
		setTitle("Admin Page");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(containerPanel);
		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
		add(header, BorderLayout.NORTH);
		// align text Center
		header.setHorizontalAlignment(JLabel.CENTER);
		footer.setHorizontalAlignment(JLabel.CENTER);
		// End align text Center
		mainPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(getOrdersPanel());
		mainPanel.add(tableDetailsPanel);
		// add Back Button
		JButton backBtn = new JButton("<");
		backBtn.setPreferredSize(new Dimension(100, 50));
		backBtn.setBackground(new Color(22, 160, 133));
		backBtn.setForeground(Color.WHITE);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				createFrame(new Main(tables));
			}
		});
		add(backBtn, BorderLayout.LINE_START);
		// End add Back Button
	}

	private JPanel getOrdersPanel() {
		JPanel ordersPanel = new JPanel();
		ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));
		JLabel ordersHeader = new JLabel("Orders");
		ordersHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		ordersPanel.add(ordersHeader);
		for (Table table : tables) {
			ordersPanel.add(new JLabel("Table " + table.getTableNumber()));
			// Add a button to view table details
			JButton viewTableButton = new JButton("View");
			ordersPanel.add(viewTableButton);
			viewTableButton.addActionListener(e -> {
				tableDetailsPanel.removeAll();
				tableDetailsPanel = getTableDetailsPanel(table);
				mainPanel.add(tableDetailsPanel);
				mainPanel.revalidate();
				mainPanel.repaint();
			});
		}
		return ordersPanel;
	}

	private JPanel getTableDetailsPanel(Table table) {
		tableDetailsPanel.setLayout(new BoxLayout(tableDetailsPanel,
				BoxLayout.Y_AXIS));
		tableDetailsPanel.add(new JLabel("Table Details"));
		tableDetailsPanel.add(new JLabel("Table Number: "
				+ table.getTableNumber()));
		tableDetailsPanel.add(new JLabel("Number of Items: "
				+ table.getNumberOfItems()));
		tableDetailsPanel.add(new JLabel("Total Price: "
				+ table.getTotalPrice()));
		tableDetailsPanel.add(new JLabel("Time: " + table.getTimeDisplay()));

		return tableDetailsPanel;
	}

	private void createFrame(JFrame obj) {
		this.dispose();
		obj.setSize(800, 600);
		obj.setVisible(true);
	}
}
