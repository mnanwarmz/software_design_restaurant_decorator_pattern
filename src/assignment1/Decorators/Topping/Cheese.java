package assignment1.Decorators.Topping;

import assignment1.Decorators.ToppingDecorator;
import assignment1.Items.MainMeal;

public class Cheese extends ToppingDecorator {

	public Cheese(MainMeal item) {
		super(item);
	}

	public String getDescription() {
		return item.getDescription() + ", Cheese";
	}

	public double getPrice() {
		return item.getPrice() + 0.5;
	}
}
