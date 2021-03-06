package assignment1;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import assignment1.Interfaces.Item;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OrderPage extends JFrame {

	private JLabel header = new JLabel("Order Page");
	private JLabel footer = new JLabel("Anwar Zaid Sdn. Bhd");
	private Menu menu;

	private JPanel containerPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	// private JPanel menuPanel = new JPanel();
	private JPanel receiptPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private Order order = new Order();
	private int tableNo = 1;
	private ArrayList<Table> tables = new ArrayList<Table>();

	public OrderPage(Menu menu) {
		// Panels for menu, receipt and order
		this.menu = menu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(containerPanel);
		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		mainPanel = getMainPanel();
		add(header, BorderLayout.NORTH);
		header.setFont(new Font("Arial", Font.BOLD, 16));
		header.setHorizontalAlignment(JLabel.CENTER);
		add(footer, BorderLayout.SOUTH);
		footer.setFont(new Font("Arial", Font.BOLD, 16));
		footer.setHorizontalAlignment(JLabel.CENTER);
		// add(getMenuPanel(), BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(receiptPanel, BorderLayout.CENTER);

		receiptPanel = getReceiptPanel();

		// Add borders to panels
		rightPanel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

		// add button to return to previous frame
		JButton backButton = new JButton("<");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				createFrame(new Main(tables));
			}
		});
		add(backButton, BorderLayout.LINE_START);
		backButton.setPreferredSize(new Dimension(20, 20));
		backButton.setBackground(new Color(22, 160, 133));
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Arial", Font.BOLD, 16));
	}

	public JPanel getMainPanel() {

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
			JLabel foodLabel = new JLabel(foodName + " - RM" + formattedPrice);
			JButton foodBtn = new JButton("Add To Cart");
			// if Food already exists disable buttons
			foodBtn.setPreferredSize(new Dimension(200, 50));
			foodBtn.setBackground(new Color(22, 160, 133));
			foodButtonsPanel.add(foodLabel);
			foodButtonsPanel.add(foodBtn);
			foodBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						order.addItem(food);
						refreshComponent(rightPanel);
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
						order.addItem(beverage);
						refreshComponent(rightPanel);
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
						order.addItem(sideDish);
						refreshComponent(rightPanel);
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
		for (ItemDisplay item : order.getItemDisplays()) {
			JLabel itemLabel = new JLabel(item.toString());
			receiptPanel.add(itemLabel);
		}
		// insert panel gap

		JLabel totalLabel = new JLabel("Total: RM" + String.format("%.2f", order.getTotalPrice()));
		totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
		// Make a Payment Button
		JButton makePaymentBtn = new JButton("Make Payment");
		makePaymentBtn.setPreferredSize(new Dimension(200, 50));
		makePaymentBtn.setBackground(new Color(22, 160, 133));
		// onclick show payment successful
		makePaymentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Table table = new Table(tableNo);
				table.addOrder(order);
				tables.add(table);
				dispose();
				createFrame(new Main(tables));
				JOptionPane.showMessageDialog(null,
						"Payment of RM " + new String().format("%.2f", order.getTotalPrice())
								+ " has been successfully made. Table No: " + tableNo);
				refreshComponent(rightPanel);
			}
		});
		JPanel paymentPanel = new JPanel();
		paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));
		// add Table No. dropdown Section
		JLabel tableNoLabel = new JLabel("Table No. ");
		tableNoLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		JComboBox<Integer> tableNoDropdown = new JComboBox<Integer>();
		for (int i = 1; i <= 10; i++) {
			tableNoDropdown.addItem(i);
		}
		tableNoDropdown.setPreferredSize(new Dimension(100, 50));
		tableNoDropdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableNo = (int) tableNoDropdown.getSelectedItem();
			}
		});
		paymentPanel.add(tableNoLabel);
		paymentPanel.add(tableNoDropdown);
		paymentPanel.add(makePaymentBtn);
		paymentPanel.add(totalLabel);
		rightPanel.add(paymentPanel, BorderLayout.SOUTH);

		return receiptPanel;
	}

	public void refreshComponent(JPanel panel) {
		panel.removeAll();
		panel.add(getReceiptPanel(), BorderLayout.CENTER);
		panel.revalidate();
		panel.repaint();
	}

	private void createFrame(JFrame obj) {
		this.dispose();
		obj.setSize(800, 600);
		obj.setVisible(true);
	}
}
