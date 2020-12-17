package homework;
/**
 * This is the body of the painting class and it is a subclass of the artwork class.
 * It gets every data of the superclass and implements abstract method and the interfaces of it.
 * Also, has extra methods.
 */
public class Painting extends Artwork{
	float length;
	float width;
	ISearchable artist;
	
	public Painting(String name, String style, ISearchable artist, float length, float width) {
		super(name, style);
		this.artist = artist;
		this.length = length;
		this.width = width;
	}
	/**
	 * This method checks if the objects is tradable or not.
	 */
	public boolean isTradable() {
		boolean result = true;
		if (style.equals("Gothic")) {
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
			System.out.println("Cannot trade this type of painting!");
		} else {
			if (style.equals("Renaissance")) {
				result = length * width * 7;
			} else if (style.equals("Baroque")){
				result = length * width * (5.5);
			} else {
				result = length * width * (4.5);
			}
		}
		return (float) result;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
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
		System.out.println("Painting:");
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
}
