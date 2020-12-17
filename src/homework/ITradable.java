package homework;
/**
 * This is the interface for the tradable objects.
 * isTradable and tradeToBuyer method should be implemented in the every artwork object class.
 */
public interface ITradable {
	public boolean isTradable();
	public void tradeToBuyer(Buyer buyer, Seller seller);
}
