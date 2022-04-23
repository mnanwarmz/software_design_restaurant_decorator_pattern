package assignment1.Decorators;

import assignment1.Items.Beverage;

public abstract class CondimentDecorator extends Beverage {

	protected Beverage item;

	public CondimentDecorator(Beverage item) {
		this.item = item;
	}

	public String getDescription() {
		return item.getDescription();
	};

	public double getPrice() {
		return item.getPrice();
	};

}
