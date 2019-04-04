package a5;

//IngredientBase implements the IngredientPortion interface
//this class is a super class for the eight Ingredients
public abstract class IngredientBase implements Ingredient {

	private String name;
	private double price;
	private int calories;
	private boolean is_vegetarian;
	private boolean is_rice;
	private boolean is_shellfish;
	
	public IngredientBase (String name, double price, int calories, boolean is_vegetarian, boolean is_rice, boolean is_shellfish) {
		if (name == null) {
			throw new RuntimeException("Name is null!");
		}
		if (price < 0) {
			throw new RuntimeException("Price is negative!");
		}
		if (calories < 0) {
			throw new RuntimeException("Calories are negative!");
		}
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.is_vegetarian = is_vegetarian;
		this.is_rice = is_rice;
		this.is_shellfish = is_shellfish;
		
	}
	
	@Override
//	returns the name of the Ingredient
	public String getName() {
		return name;
	}

	@Override
//	returns the calories per dollar of the Ingredient
	public double getCaloriesPerDollar() {
		return calories / price;
	}

	@Override
//	returns the calories per ounce of the Ingredient
	public int getCaloriesPerOunce() {
		return calories;
	}

	@Override
//	returns the price per ounce of the Ingredient
	public double getPricePerOunce() {
		return price;
	}

	@Override
//	returns true if the Ingredient object passed in as a parameter has the same name,
//	the same calories per ounce, is within $0.01 in price per ounce, and has the same characteristics
//	input: a new Ingredient object
//	output: a true or false value dependent on if the two Ingredients are equal to each other
	public boolean equals(Ingredient other) {
		if (other.getName().equals(this.name)) {
			if (other.getCaloriesPerOunce() == this.calories) {
				if (Math.abs(this.getPricePerOunce() - other.getPricePerOunce()) <= 0.01 ) {
					if (this.getIsVegetarian() == other.getIsVegetarian()) {
						if (this.getIsRice() == other.getIsRice()) {
							if (this.getIsShellfish() == other.getIsShellfish()) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	@Override
//	returns true if the Ingredient is vegetarian
	public boolean getIsVegetarian() {
		return is_vegetarian;
	}

	@Override
//	returns true if the Ingredient has rice
	public boolean getIsRice() {
		return is_rice;
	}

	@Override
//	returns true if the Ingredient has shellfish
	public boolean getIsShellfish() {
		return is_shellfish;
	}

}
