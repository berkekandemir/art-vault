package homework;
/**
 * This is the body of the buyer objects.
 * It creates the attributes and the object.
 */
public class Buyer {
	Wallet wallet;
	PrivateCollection privateCollection;
	
	public Buyer() {
		wallet = new Wallet();
		privateCollection = new PrivateCollection();
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public PrivateCollection getPrivateCollection() {
		return privateCollection;
	}

	public void setPrivateCollection(PrivateCollection privateCollection) {
		this.privateCollection = privateCollection;
	}
	
	public void addToPrivateCollection(ITradable item) {
		privateCollection.add(item);
	}
	
	
}
