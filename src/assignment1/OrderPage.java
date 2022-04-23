package assignment1;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import assignment1.Interfaces.Item;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderPage extends JFrame {

	private JLabel header = new JLabel("Order Page");
	private JLabel footer = new JLabel("Anwar Zaid Sdn. Bhd");
	private Menu menu;

	private JPanel containerPanel = new JPanel();
	// private JPanel mainPanel = new JPanel();
	// private JPanel menuPanel = new JPanel();
	private JPanel receiptPanel = new JPanel();
	// private JPanel orderPanel = new JPanel();
	private Order order = new Order();

	public OrderPage(Menu menu) {
		// Panels for menu, receipt and order
		this.menu = menu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(containerPanel);
		setLayout(new BorderLayout());
		add(getMainPanel(), BorderLayout.CENTER);
		add(header, BorderLayout.NORTH);
		header.setFont(new Font("Arial", Font.BOLD, 16));
		header.setHorizontalAlignment(JLabel.CENTER);
		add(footer, BorderLayout.SOUTH);
		footer.setFont(new Font("Arial", Font.BOLD, 16));
		footer.setHorizontalAlignment(JLabel.CENTER);
		// add(getMenuPanel(), BorderLayout.WEST);
		receiptPanel = getReceiptPanel();
		add(receiptPanel, BorderLayout.EAST);

		// add(getOrderPanel(), BorderLayout.SOUTH);
		// Add panels to main panel
	}

	public JPanel getMainPanel() {
		JPanel mainPanel = new JPanel();

		mainPanel.setLayout(new GridLayout(1, 3));

		mainPanel.add(getFoodsPanel());
		mainPanel.add(getBeveragesPanel());
		mainPanel.add(getSideDishPanel());

		return mainPanel;
	}

	private JPanel getFoodsPanel() {
		JLabel foodsLabel = new JLabel("Foods");
		JPanel foodsPanel = new JPanel();
		JPanel foodButtonsPanel = new JPanel();
		foodsLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		foodsPanel.setLayout(new BorderLayout());
		foodButtonsPanel.setLayout(new BoxLayout(foodButtonsPanel, BoxLayout.Y_AXIS));
		foodsPanel.add(foodsLabel, BorderLayout.NORTH);
		foodsPanel.add(foodButtonsPanel, BorderLayout.CENTER);
		for (Item food : menu.getMeals()) {
			String formattedPrice = String.format("%.2f", food.getPrice());
			String foodName = food.getDescription();
			int quantity = order.getQuantityOfItem(food);
			System.out.println(quantity);
			JLabel foodLabel = new JLabel(foodName + " - RM" + formattedPrice);
			JButton foodBtn = new JButton("Add To Cart");
			foodBtn.setPreferredSize(new Dimension(200, 50));
			foodBtn.setBackground(new Color(22, 160, 133));
			foodButtonsPanel.add(foodLabel);
			foodButtonsPanel.add(foodBtn);
			foodBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						order.addItem(food);
						refreshComponent(receiptPanel);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			});
		}
		return foodsPanel;
	}

	public JPanel getBeveragesPanel() {
		JLabel beveragesLabel = new JLabel("Beverages");
		JPanel beveragesPanel = new JPanel();
		JPanel beverageButtonsPanel = new JPanel();
		beveragesLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		beveragesPanel.setLayout(new BorderLayout());
		beverageButtonsPanel.setLayout(new BoxLayout(beverageButtonsPanel, BoxLayout.Y_AXIS));
		beveragesPanel.add(beveragesLabel, BorderLayout.NORTH);
		beveragesPanel.add(beverageButtonsPanel, BorderLayout.CENTER);
		for (Item beverage : menu.getBeverages()) {
			String formattedPrice = String.format("%.2f", beverage.getPrice());
			String beverageName = beverage.getDescription();
			JLabel beverageLabel = new JLabel(beverageName + " - RM" + formattedPrice);
			JButton beverageBtn = new JButton("Add To Cart");
			beverageBtn.setPreferredSize(new Dimension(200, 50));
			beverageBtn.setBackground(new Color(22, 160, 133));
			beverageButtonsPanel.add(beverageLabel);
			beverageButtonsPanel.add(beverageBtn);
			beverageBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			});
		}
		return beveragesPanel;
	}

	public JPanel getSideDishPanel() {
		JLabel sideDishesLabel = new JLabel("Side Dishes");
		JPanel sideDishesPanel = new JPanel();
		JPanel sideDishButtonsPanel = new JPanel();
		sideDishesLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		sideDishesPanel.setLayout(new BorderLayout());
		sideDishButtonsPanel.setLayout(new BoxLayout(sideDishButtonsPanel, BoxLayout.Y_AXIS));
		sideDishesPanel.add(sideDishesLabel, BorderLayout.NORTH);
		sideDishesPanel.add(sideDishButtonsPanel, BorderLayout.CENTER);
		for (Item sideDish : menu.getSideDishes()) {
			String formattedPrice = String.format("%.2f", sideDish.getPrice());
			String sideDishName = sideDish.getDescription();
			JLabel sideDishLabel = new JLabel(sideDishName + " - RM" + formattedPrice);
			JButton sideDishBtn = new JButton("Add To Cart");
			sideDishBtn.setPreferredSize(new Dimension(200, 50));
			sideDishBtn.setBackground(new Color(22, 160, 133));
			sideDishButtonsPanel.add(sideDishLabel);
			sideDishButtonsPanel.add(sideDishBtn);
			sideDishBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			});
		}
		return sideDishesPanel;
	}
	// public JPanel getMenuPanel() {
	// // return menuPanel;
	// }

	public JPanel getReceiptPanel() {
		JPanel receiptPanel = new JPanel();
		receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));
		JLabel receiptLabel = new JLabel("Receipt");
		receiptLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		receiptPanel.add(receiptLabel);
		for (Item item : order.getItems()) {
			JLabel itemLabel = new JLabel(order.itemToString(item));
			receiptPanel.add(itemLabel);
		}
		JLabel totalLabel = new JLabel("Total: RM" + String.format("%.2f", order.getTotalPrice()));
		// insert panel gap
		receiptPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		receiptPanel.add(totalLabel);

		return receiptPanel;
	}

	public void refreshComponent(JPanel panel) {
		panel.removeAll();
		panel.add(getReceiptPanel());
		panel.revalidate();
		panel.repaint();
	}
}
