package a5;

public class GoldPlate implements Plate {
	
	private double price = 5.0;
	private Sushi contents;

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		this.contents = contents;
		if (price < 5.0) {
			throw new IllegalArgumentException("Price must be more than $5.00!");
		}
	}

	@Override
	public Sushi getContents() {
		if (contents == null) {
			return null;
		} else {
			return contents;
		}
	}

	@Override
	public Sushi removeContents() {
		Sushi oldContents = contents;
		contents = null;
		return oldContents;
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException("s is null!");
		}
		if (this.getPrice() <= s.getCost()) {
			throw new PlatePriceException("There is no profit!");
		}
		this.contents = s;
	}

	@Override
	public boolean hasContents() {
		if (contents != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double getPrice() {
		return (Math.round(100*price))/100.0;
	}

	@Override
	public Color getColor() {
		return Plate.Color.GOLD;
	}

	@Override
	public double getProfit() {
		if (!hasContents()) {
			return 0;
		} else {
			return (Math.floor((100 * (this.getPrice() - contents.getCost())))) / 100.0; 
		}
	}

}
