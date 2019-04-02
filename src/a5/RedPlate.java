package a5;

//RedPlate implements the Plate Interface
//RedPlate is a plate of Sushi with potentially 1 Sushi object
public class RedPlate implements Plate {

	private double price = 1.0;
	private Sushi contents;

	public RedPlate(Sushi contents) throws PlatePriceException {
		this.contents = contents;
	}

	@Override
//	gets the content of the Sushi plate
//	input: no parameter
//	output: null or 1 Sushi object
	public Sushi getContents() {
		if (contents == null) {
			return null;
		} else {
			return contents;
		}
	}

	@Override
//	removes the contents of the Sushi plate 
//	output: null or 1 Sushi object
//	returns the original contents of the plate and then empties the plate
	public Sushi removeContents() {
		Sushi oldContents = contents;
		contents = null;
		return oldContents;
	}

	@Override
//	sets the contents of the Sushi plate to a new Sushi object
//	input: a new Sushi object
//	output: void but replaces the contents of the original Sushi plate
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
//	returns true if the Sushi plate has a Sushi object on it
	public boolean hasContents() {
		if (contents != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
//	returns the price of the Sushi plate as specified 
//	the prices are based on the colors of the plates
	public double getPrice() {
		return (Math.round(100*price))/100.0;
	}

	@Override
//	returns the color of the Sushi plate as specified
//	the colors are specified in the Plate.Color enumeration in the Plate Interface
	public Color getColor() {
		return Plate.Color.RED;
	}

	@Override
//	returns the profit of the Sushi plate
//	profit = the price of the Sushi plate - the profit of the Sushi object's contents
	public double getProfit() {
		if (!hasContents()) {
			return 0.0;
		} else {
			return (Math.floor((100 * (this.getPrice() - contents.getCost())))) / 100.0; 
		}
	}

}
