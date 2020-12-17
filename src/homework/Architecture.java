package homework;
import java.util.*;
/**
 * This is the body of the architecture class and it is a subclass of the artwork class.
 * It gets every data of the superclass and implements abstract method and the interfaces of it.
 * Also, has extra methods.
 */
public class Architecture extends Artwork{
	float length;
	float width;
	float height;
	List<ISearchable> architects;
	
	public Architecture(String name, String style, float length, float width, float height, List<ISearchable> architects) {
		super(name, style);
		this.length = length;
		this.width = width;
		this.height = height;
		this.architects = architects;
	}
	/**
	 * This method checks if the objects is tradable or not.
	 */
	public boolean isTradable() {
		boolean result = true;
		if (style.equals("Renaissance")) {
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
			System.out.println("Cannot trade this type of architecture!");
		} else {
			if (style.equals("Gothic")) {
				result = length * width * height * 1;
			} else if (style.equals("Baroque")){
				result = length * width * height * (0.8);
			} else {
				result = length * width * height * (0.6);
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

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public List<ISearchable> getArchitects() {
		return architects;
	}

	public void setArchitects(List<ISearchable> architects) {
		this.architects = architects;
	}
	
	public boolean equals(Artwork art) {
		 boolean result = false;
		if (getName().equals(art.getName())) {
			result = true;
		}
		
		return result;
	}
	
	public String toString() {
		System.out.println("Architecture:");
		System.out.println("	Name: " + name);
		System.out.println("	Price: " + calculateCost() + " TL");
		return "";
	}
}
