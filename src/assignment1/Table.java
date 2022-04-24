package assignment1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Table {
	private ArrayList<Order> orders = new ArrayList<Order>();
	private int tableNumber;
	private int numberOfItems;
	private double totalPrice;
	private LocalDateTime time;
	private String timeDisplay;

	public Table(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public void addOrder(Order order) {
		orders.add(order);
		numberOfItems += order.getItems().size();
		totalPrice += order.getTotalPrice();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		time = LocalDateTime.now();
		timeDisplay = dtf.format(time);
	}

	public ArrayList<Order> showOrders() {
		return orders;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public String getTimeDisplay() {
		return timeDisplay;
	}
}
