package assignment1.Decorators.Topping;

import assignment1.Decorators.ToppingDecorator;
import assignment1.Items.MainMeal;

public class Mozarella extends ToppingDecorator {

	public Mozarella(MainMeal item) {
		super(item);
	}

	public String getDescription() {
		return item.getDescription() + ", Mozarella";
	}

	public double getPrice() {
		return item.getPrice() + 0.5;
	}
}
