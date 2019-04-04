package a5;

import java.util.ArrayList;

//A roll is a sushi creation that may be comprised of any number of different ingredient portions.
public class Roll implements Sushi {
	
	private String name;
	private IngredientPortion[] roll_ingredients;
	private IngredientPortion[] repeatedIngredients;
	private ArrayList<IngredientPortion> repeats  = new ArrayList<IngredientPortion>();
	

	public Roll(String name, IngredientPortion[] roll_ingredients) {
		
		this.name = name;
		
		if (roll_ingredients == null) {
			throw new RuntimeException("Array is null!");
		}
		
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i] == null) {
				throw new RuntimeException("Ingredient is null!");
			}
		}
		
//		iterates through the Ingredient Portion[] 
//		detects if a particular ingredient is repeated
//		combines the separate portions of a repeated ingredient type into a single portion
		for (int c = 0; c < roll_ingredients.length; c++) {
			boolean hasItem = false;
			for (int f = 0; f < repeats.size(); f++) {
				if (roll_ingredients[c].getName().equals(repeats.get(f).getName()) ) {
					 IngredientPortion newPortion = roll_ingredients[c].combine(repeats.get(f));
					 repeats.set(f, newPortion);
					 hasItem = true;
				}
			}
			if (!hasItem) {
				repeats.add(roll_ingredients[c]);
			}
		}
		
//		0.1 ounces of Seaweed represents the roll wrapper if the ingredient portion array passed to the constructor does not already include at least this much seaweed
//		if the ingredient portions passed to the constructor already have at least this much seaweed, no more is added
		boolean hasSeaweed = false;
		for (int k = 0; k < repeats.size(); k++) {
			if(repeats.get(k).getIngredient().getName().equals("seaweed")) {
				hasSeaweed = true;
				if (repeats.get(k).getAmount() < 0.1) {
					repeats.set(k, new SeaweedPortion(0.1));
					hasSeaweed = true;
				}
			}
			
		}
		
		if (!hasSeaweed) {
			repeats.add(new SeaweedPortion(0.1));
		}
		repeatedIngredients = repeats.toArray(new IngredientPortion[repeats.size()]);

	}

	@Override
//	returns the name of the roll object
	public String getName() {
		return name;
	}

	@Override
//	returns a clone of the set of ingredient portions that make up the Nigiri
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] newPortion = repeatedIngredients.clone();
		return newPortion;
	}

	@Override
//	returns the calories of the roll object 
//	iterates through the entire set of ingredient portions to add up the calories of each ingredient
	public int getCalories() {
		int calories  = 0;
		for (int i = 0; i < this.repeatedIngredients.length; i++) {
			calories += ((int) (repeatedIngredients[i].getCalories() + 0.5));
		}
		return calories;
	}

	@Override
//	returns the cost of the roll object
//	iterates through the entire set of ingredient portions to add up the cost of each ingredient
	public double getCost() {
		double cost = 0;
		for (int i = 0; i < this.repeatedIngredients.length; i++) {
			this.repeatedIngredients[i].getCost();
			cost += repeatedIngredients[i].getCost();
		}
		return ((int)((100 * cost) + 0.5)) / 100.0;
	}

	@Override
//	returns true if any of the ingredients of the roll object are rice
	public boolean getHasRice() {
		for (int i = 0; i < this.repeatedIngredients.length; i++) {
			this.repeatedIngredients[i].getIsRice();
			if (repeatedIngredients[i].getIsRice() == true) {
				return true;
			}
		}
		return false;
	}

	@Override
//	returns true is any of the ingredients of the roll object are shellfish
	public boolean getHasShellfish() {
		for (int i = 0; i < this.repeatedIngredients.length; i++) {
			this.repeatedIngredients[i].getIsShellfish();
			if (repeatedIngredients[i].getIsShellfish() == true) {
				return true;
			}
		}
		return false;
	}

	@Override
//	returns true if any of the ingredients of the roll object are vegetarian
	public boolean getIsVegetarian() {
		for (int i = 0; i < this.repeatedIngredients.length; i++) {
			this.repeatedIngredients[i].getIsVegetarian();
			if (repeatedIngredients[i].getIsVegetarian() == true) {
				return true;
			}
		}
		return false;
	}

}
