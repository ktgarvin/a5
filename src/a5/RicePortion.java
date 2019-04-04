package a5;

public class RicePortion extends IngredientPortionBase {

	public double amount;

	public RicePortion(double amount) {
		super(new Rice(), amount);
		if (amount < 0) {
			throw new RuntimeException("Amount is less than 0!");
		}
		this.amount = amount;
	}

	@Override
//	combines two of the same Ingredients
//	input: a new IngredientPortion object
//	output: a new Ingredient Portion object that is the combined amount of the original 
//	Ingredient Portion object and the Ingredient Portion object passed into the constructor
//	returns a new Ingredient object with their combined amount
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else {
			if (this.getIngredient().equals(other.getIngredient())) {
				double combinedAmount = this.amount + other.getAmount();
				AvocadoPortion newAvocado = new AvocadoPortion(combinedAmount);
				return newAvocado;
			} else {
				throw new RuntimeException ("Cannot be combined!");
			}
		}
	}

}
