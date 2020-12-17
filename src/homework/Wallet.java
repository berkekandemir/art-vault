package homework;
/**
 * This is the body of the main class.
 * We use this class' objects in the seller and the buyer objects.
 */
public class Wallet {
	float amount;
	
	public Wallet() {
		amount = 5000000;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
