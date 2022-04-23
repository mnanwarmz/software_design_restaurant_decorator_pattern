package assignment1;

import java.util.ArrayList;

import assignment1.Items.*;
import assignment1.Decorators.Topping.*;
import assignment1.Items.Beverages.*;
import assignment1.Items.MainMeals.*;
import assignment1.Items.SideDishes.*;

public class Menu {
	ArrayList<MainMeal> meals = new ArrayList<MainMeal>();
	ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	ArrayList<SideDish> sideDishes = new ArrayList<SideDish>();

	public Menu() {
		meals.add(new Burger());
		meals.add(new Cheese(new Burger()));
		meals.add(new Mozarella(new Cheese(new Burger())));
		meals.add(new Mozarella(new Pizza()));
		beverages.add(new Espresso());
		sideDishes.add(new Fries());
	}

	public ArrayList<MainMeal> getMeals() {
		return meals;
	}

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public ArrayList<SideDish> getSideDishes() {
		return sideDishes;
	}
}
