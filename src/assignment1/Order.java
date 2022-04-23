package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import assignment1.Interfaces.Item;

public class Order {
	private ArrayList<Item> items = new ArrayList<Item>();

	public void addItem(Item item) {
		items.add(item);
	}

	public int getQuantityOfItem(Item item) {
		int quantity = 0;
		for (Item i : items) {
			if (i.getDescription().equals(item.getDescription())) {
				quantity++;
			}
		}
		return quantity;
	}

	public void showMealItems() {
		for (Item item : items) {
			System.out.println(item.getDescription());
		}
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (Item item : items) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

	public String itemToString(Item item) {
		String formattedPrice = String.format("%.2f", item.getPrice());
		return item.getDescription() + ": " + formattedPrice;
	}
}
