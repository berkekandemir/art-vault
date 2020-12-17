package homework;
/**
 * This is the body of the sculpture class and it is a subclass of the artwork class.
 * It gets every data of the superclass and implements abstract method and the interfaces of it.
 * Also, has extra methods.
 */
public class Sculpture extends Artwork{
	String material;
	float weight;
	ISearchable artist;
	
	public Sculpture(String name, String style, ISearchable artist, String material, float weight) {
		super(name, style);
		this.artist = artist;
		this.material = material;
		this.weight = weight;
	}
	/**
	 * This method checks if the objects is tradable or not.
	 */
	public boolean isTradable() {
		boolean result = true;
		if (style.equals("Baroque")) {
			result = false;
		}
		return result;
	}
	/**
	 * This method performs the trade of the object from seller to buyer.
	 */
	public void tradeToBuyer(Buyer buyer, Seller seller) {
		float cost = (float) calculateCost();
		float buyerWallet = buyer.getWallet().getAmount();
		float sellerWallet = seller.getWallet().getAmount();
		if (buyerWallet > cost) {
			buyer.getWallet().setAmount(buyerWallet - cost);
			buyer.addToPrivateCollection(this);
			seller.getWallet().setAmount(sellerWallet + cost);
			seller.removeFromPrivateCollection(this);
		}
	}
	
	public float calculateCost() {
		double result = 0;
		if (!isTradable()) {
			System.out.println("Cannot trade this type of sculpture!");
		} else {
			if (material.equals("Marble")) {
				result = weight * 15;
			} else {
				result = weight * 180;
			}
		}
		return (float) result;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public ISearchable getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public boolean equals(Artwork art) {
		 boolean result = false;
		if (getName().equals(art.getName())) {
			result = true;
		}
		
		return result;
	}
	
	public String toString() {
		System.out.println("Sculpture:");
		System.out.println("	Name: " + name);
		System.out.println("	Price: " + calculateCost() + " TL");
		return "";
	}
	
	public int compareToByArtist(String other) {
		if (getArtist().getName().compareTo(other) < 0) {
			return -1;
		} else if (getArtist().getName().compareTo(other) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int compareToByMaterial(String other) {
		if (getMaterial().compareTo(other) < 0) {
			return -1;
		} else if (getMaterial().compareTo(other) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
}
