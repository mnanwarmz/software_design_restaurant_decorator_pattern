package assignment1.Decorators.Condiment;

import assignment1.Decorators.CondimentDecorator;
import assignment1.Items.Beverage;

public class Soy extends CondimentDecorator {

	public Soy(Beverage item) {
		super(item);
	}

	public String getDescription() {
		return item.getDescription() + " Soy";
	}

	public double getPrice() {
		return item.getPrice() + 0.5;
	}

}
