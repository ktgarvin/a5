package a5;

public class PlatePriceException extends Exception {

	public PlatePriceException(String message) {
		super("Illegal plate price");
	}

}
