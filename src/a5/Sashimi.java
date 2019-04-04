package a5;

//A piece of sashimi is comprised of 0.75 ounces of some type of seafood. 
//There are five types of sashimi: tuna, yellowtail, eel, crab, and shrimp.
public class Sashimi implements Sushi {
	
	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	SashimiType type;
	private IngredientPortion[] portion;
	private String name;

	public Sashimi(SashimiType type) {
		
		this.type = type;
		portion = new IngredientPortion[1];
		
		switch(type) {
	
		case TUNA:
		name = "tuna sashimi";
		portion[0] = new TunaPortion(0.75);
		break;
		
		case YELLOWTAIL:
		name = "yellowtail sashimi";
		portion[0] = new YellowtailPortion(0.75);
		break;
		
		case EEL:
		name = "eel sashimi";
		portion[0] = new EelPortion(0.75);
		break;
		
		case CRAB:
		name = "crab sashimi";
		portion[0] = new CrabPortion(0.75);
		break;
		
		case SHRIMP:
		name = "shrimp sashimi";
		portion[0] = new ShrimpPortion(0.75);
		break;
		
		}
		
	}

	@Override
//	returns the name of the type of Sashimi 
	public String getName() {
		return name;
	}

	@Override
//	returns a clone of the set of ingredient portions that make up the Sashimi
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] newPortion = portion.clone();
		return newPortion;
	}

	@Override
//	returns the calories of the Sashimi object 
//	iterates through the entire set of ingredient portions to add up the calories of each ingredient
	public int getCalories() {
		double sum  = 0;
		for (int i = 0; i < this.portion.length; i++) {
			sum += this.portion[i].getCalories();
		}
		return (int) Math.round(sum);
	}

	@Override
//	returns the cost of the Sashimi object
//	iterates through the entire set of ingredient portions to add up the cost of each ingredient
	public double getCost() {
		double sum  = 0;
		for (int i = 0; i < this.portion.length; i++) {
			sum += this.portion[i].getCost();
		}
		return sum;
	}

	@Override
//	returns true if any of the ingredients of the Sashimi object are rice
	public boolean getHasRice() {
		for (int i = 0; i < this.portion.length; i++) {
			this.portion[i].getIsRice();
			if (portion[i].getIsRice() == true) {
				return true;
			}
		}
		return false;
	}

	@Override
//	returns true is any of the ingredients of the Sashimi object are shellfish
	public boolean getHasShellfish() {
		for (int i = 0; i < this.portion.length; i++) {
			this.portion[i].getIsShellfish();
			if (portion[i].getIsShellfish() == true) {
				return true;
			}
		}
		return false;
	}

	@Override
//	returns true if any of the ingredients of the Sashimi object are vegetarian
	public boolean getIsVegetarian() {
		for (int i = 0; i < this.portion.length; i++) {
			this.portion[i].getIsVegetarian();
			if (portion[i].getIsVegetarian() == true) {
				return true;
			}
		}
		return false;
	}

}
