package a5;

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
	public Ingredient getIngredient() {
		return ing;
	}

	@Override
	public String getName() {
		return ing.getName();
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public double getCalories() {
		return ing.getCaloriesPerOunce() * amount;
	}

	@Override
	public double getCost() {
		return ing.getPricePerOunce() * amount;
	}

	@Override
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

	@Override
	public boolean getIsRice() {
		return ing.getIsRice();
	}

	@Override
	public boolean getIsShellfish() {
		return ing.getIsShellfish();
	}

}
