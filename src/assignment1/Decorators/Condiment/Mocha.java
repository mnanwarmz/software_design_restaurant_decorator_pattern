package assignment1.Decorators.Condiment;

import assignment1.Decorators.CondimentDecorator;
import assignment1.Items.Beverage;

public class Mocha extends CondimentDecorator {

	public Mocha(Beverage item) {
		super(item);
	}

	public String getDescription() {
		return item.getDescription() + " Mocha";
	}

	public double getPrice() {
		return item.getPrice() + 0.5;
	}

}
