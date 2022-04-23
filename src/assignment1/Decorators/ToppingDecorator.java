package assignment1.Decorators;

import assignment1.Items.MainMeal;

public abstract class ToppingDecorator extends MainMeal {

	protected MainMeal item;

	public ToppingDecorator(MainMeal item) {
		this.item = item;
	}

	public String getDescription() {
		return item.getDescription();
	}

	public double getPrice() {
		return item.getPrice();
	}
}
