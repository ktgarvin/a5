package a5;

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
	public String getName() {
		return name;
	}

	@Override
	public double getCaloriesPerDollar() {
		return calories / price;
	}

	@Override
	public int getCaloriesPerOunce() {
		return calories;
	}

	@Override
	public double getPricePerOunce() {
		return price;
	}

	@Override
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
	public boolean getIsVegetarian() {
		return is_vegetarian;
	}

	@Override
	public boolean getIsRice() {
		return is_rice;
	}

	@Override
	public boolean getIsShellfish() {
		return is_shellfish;
	}

}
