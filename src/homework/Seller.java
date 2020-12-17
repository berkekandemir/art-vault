package homework;
/**
 * This is the body of the seller objects.
 * It creates the attributes and the object and set the initial money to 0.
 */
public class Seller {
	Wallet wallet;
	PrivateCollection privateCollection;
	
	public Seller(PrivateCollection privateCollection) {
		wallet = new Wallet();
		this.privateCollection = privateCollection;
		wallet.setAmount(0);
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
	
	public ITradable removeFromPrivateCollection(ITradable item) {
		return privateCollection.remove(item);
	}
	
	
}
