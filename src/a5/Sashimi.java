package a5;

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
	public String getName() {
		return name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] newPortion = portion.clone();
		return newPortion;
	}

	@Override
	public int getCalories() {
		double sum  = 0;
		for (int i = 0; i < this.portion.length; i++) {
			sum += this.portion[i].getCalories();
		}
		return (int) Math.round(sum);
	}

	@Override
	public double getCost() {
		double sum  = 0;
		for (int i = 0; i < this.portion.length; i++) {
			sum += this.portion[i].getCost();
		}
		return sum;
	}

	@Override
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
