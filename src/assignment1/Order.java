package assignment1;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import assignment1.Interfaces.Item;
import assignment1.Items.MainMeal;

public class Order {
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<ItemDisplay> itemDisplays = new ArrayList<ItemDisplay>();

	public void addItem(Item item) {
		// if Item of instance mainmeal already exists alert user
		if (item instanceof MainMeal) {
			for (Item i : items) {
				if (i instanceof MainMeal) {
					JOptionPane.showMessageDialog(null, "Main Meal already exists");
					return;
				}
			}
		}
		for (ItemDisplay itemDisplay : itemDisplays) {
			if (itemDisplay.getDescription().equals(item.getDescription())) {
				itemDisplay.setQuantity(itemDisplay.getQuantity() + 1);
				return;
			}
		}
		ItemDisplay itemDisplay = new ItemDisplay(item.getDescription(), 1, item.getPrice());
		items.add(item);
		itemDisplays.add(itemDisplay);
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
		for (ItemDisplay item : itemDisplays) {
			totalPrice += item.getPrice() * item.getQuantity();
		}
		return totalPrice;
	}

	public ArrayList<ItemDisplay> getItemDisplays() {
		return itemDisplays;
	}
}

class ItemDisplay {
	private String description;
	private int quantity;
	private double price;

	public ItemDisplay(String description, int quantity, double price) {
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		String formattedPrice = String.format("%.2f", price);
		return description + ": " + formattedPrice + " x " + quantity;
	}

}