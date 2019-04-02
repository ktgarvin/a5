package a5;

public class RedPlate implements Plate {

	private double price = 1.0;
	private Sushi contents;
	private Sushi oldContents;

	public RedPlate(Sushi contents) throws PlatePriceException {
		
		this.contents = contents;
		
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
		return Math.round(price);
	}

	@Override
	public Color getColor() {
		return Plate.Color.RED;
	}

	@Override
	public double getProfit() {
		if (!hasContents()) {
			return 0.0;
		} else {
			return Math.round(this.getPrice() - contents.getCost());
		}
	}

}
