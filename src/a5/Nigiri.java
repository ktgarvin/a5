package a5;

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
		return (int)(sum + 0.5);
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
