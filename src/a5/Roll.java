package a5;

import java.util.ArrayList;

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
		
		for (int i = 0; i < roll_ingredients.length; i++) {
			
			boolean hasItem = false;
			for (int j = 0; j < repeats.size(); j++) {
				if (roll_ingredients[i].getName().equals(repeats.get(j).getName()) ) {
					 IngredientPortion food = roll_ingredients[i].combine(repeats.get(j));
					 repeats.set(j, food);
					 hasItem = true;
				}
			}
			if (!hasItem) {
				repeats.add(roll_ingredients[i]);
			}
		}
		
		boolean hasSeaweed = false;
		for (int i= 0; i < repeats.size(); i++) {
			if(repeats.get(i).getIngredient().getName().equals("seaweed")) {
				hasSeaweed = true;
				if (repeats.get(i).getAmount() < 0.1) {
					repeats.set(i, new SeaweedPortion(0.1));
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
	public String getName() {
		return name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] newPortion = repeatedIngredients.clone();
		return newPortion;
	}

	@Override
	public int getCalories() {
		int sum  = 0;
		for (int i = 0; i < this.repeatedIngredients.length; i++) {
			sum += repeatedIngredients[i].getCalories();
		}
		return (int) (sum + 0.5);
	}

	@Override
	public double getCost() {
		double sum = 0;
		for (int i = 0; i < this.repeatedIngredients.length; i++) {
			sum += repeatedIngredients[i].getCost() ;
		}
		return ((int)(100*sum+.5))/100.0;
	}

	@Override
	public boolean getHasRice() {
		for (int i = 0; i < this.repeatedIngredients.length; i++) {
//			this.repeatedIngredients[i].getIsRice();
			if (repeatedIngredients[i].getIsRice() == true) {
				return true;
			}
		}
		return false;
	}

	@Override
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
