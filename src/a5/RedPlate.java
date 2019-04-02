package a5;

public class RedPlate implements Plate {

	private Color RED = null;
	private double price = 1.0;
	private Sushi contents;

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
		if (contents == null) {
			return null;
		} else {
			Sushi priorContents = contents;
			contents = null;
			return priorContents;
		}
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
		return price;
	}

	@Override
	public Color getColor() {
		return this.RED;
	}

	@Override
	public double getProfit() {
		if (!hasContents()) {
			return 0.0;
		} else {
			return this.getPrice() - contents.getCost();
		}
	}

}
