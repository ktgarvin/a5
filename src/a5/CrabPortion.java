package a5;

public class CrabPortion extends IngredientPortionBase {

	public double amount;

	public CrabPortion(double amount) {
		super(new Crab(), amount);
		if (amount < 0) {
			throw new RuntimeException("Amount is less than 0!");
		}
		this.amount = amount;
	}

	@Override
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
