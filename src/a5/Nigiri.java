package a5;

//A piece of nigiri is comprised of 0.75 ounces of some type of seafood and 0.5 ounces of rice. 
//There are five types of nigiri: tuna, yellowtail, eel, crab, and shrimp.
public class Nigiri implements Sushi {
	
	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	NigiriType type;
	private IngredientPortion[] portion;
	private String name;

	public Nigiri(NigiriType type) {

		this.type = type;
		portion = new IngredientPortion[2];
		
		portion[1] = new RicePortion(0.5);
		
		switch(type) {
	
		case TUNA:
		name = "tuna nigiri";
		portion[0] = new TunaPortion(0.75);
		break;
		
		case YELLOWTAIL:
		name = "yellowtail nigiri";
		portion[0] = new YellowtailPortion(0.75);
		break;
		
		case EEL:
		name = "eel nigiri";
		portion[0] = new EelPortion(0.75);
		break;
		
		case CRAB:
		name = "crab nigiri";
		portion[0] = new CrabPortion(0.75);
		break;
		
		case SHRIMP:
		name = "shrimp nigiri";
		portion[0] = new ShrimpPortion(0.75);
		break;
		
		}
	}

	@Override
//	returns the name of the type of Nigiri 
	public String getName() {
		return name;
	}

	@Override
//	returns a clone of the set of ingredient portions that make up the Nigiri
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] newPortion = portion.clone();
		return newPortion;
	}

	@Override
//	returns the calories of the Nigiri object 
//	iterates through the entire set of ingredient portions to add up the calories of each ingredient
	public int getCalories() {
		double sum  = 0;
		for (int i = 0; i < this.portion.length; i++) {
			sum += this.portion[i].getCalories();
		}
		return (int)(sum + 0.5);
	}

	@Override
//	returns the cost of the Nigiri object
//	iterates through the entire set of ingredient portions to add up the cost of each ingredient
	public double getCost() {
		double sum  = 0;
		for (int i = 0; i < this.portion.length; i++) {
			sum += this.portion[i].getCost();
		}
		return sum;
	}

	@Override
//	returns true if any of the ingredients of the Nigiri object are rice
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
//	returns true is any of the ingredients of the Nigiri object are shellfish
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
//	returns true if any of the ingredients of the Nigiri object are vegetarian
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
