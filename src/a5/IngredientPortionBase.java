package a5;

// IngredientPortionBase implements the IngredientPortion interface
// this class is a super class for the eight portions of each Ingredient
public abstract class IngredientPortionBase implements IngredientPortion {

	private Ingredient ing;
	private double amount;
	
	public IngredientPortionBase (Ingredient ing, double amount) {
		if (ing == null) {
			throw new RuntimeException("Ingredient is null!");
		}
		if (amount < 0) {
			throw new RuntimeException("Amount is negative!");
		}
		this.ing = ing;
		this.amount = amount;
		
	}
	
	@Override
//	returns the Ingredient
	public Ingredient getIngredient() {
		return ing;
	}

	@Override
//	returns the name of the Ingredient
	public String getName() {
		return ing.getName();
	}

	@Override
//	returns the amount of the Ingredient
	public double getAmount() {
		return amount;
	}

	@Override
//	returns the Calories per Ounce of the Ingredient
//	the Calories per Ounce are multiplied by the amount of the Ingredient
	public double getCalories() {
		return ing.getCaloriesPerOunce() * amount;
	}

	@Override
//	return the Price per Ounce of the Ingredient
//	the Price per Ounce is multiplied by the amount of the Ingredient
	public double getCost() {
		return ing.getPricePerOunce() * amount;
	}

	@Override
//	returns true if the Ingredient is vegetarian
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

	@Override
//	returns true if the Ingredient has rice
	public boolean getIsRice() {
		return ing.getIsRice();
	}

	@Override
//	returns true if the Ingredient has shellfish
	public boolean getIsShellfish() {
		return ing.getIsShellfish();
	}

}
