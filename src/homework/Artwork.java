package homework;
/**
 * This is the body of the artwork class.
 * This class is the superclass of the painting, sculpture and architecture class'.
 */
public abstract class Artwork implements IComparable, ISearchable, ITradable{
	String name;
	String style;
	
	public Artwork(String name, String style) {
		this.name = name;
		this.style = style;
	}
	/**
	 * This method is abstract because it should be in the every subclass but,
	 * Should be calculated differently in the every subclass.
	 * So, the implementation is left to the subclasses.
	 */
	public abstract float calculateCost();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	public int compareToByName(String other) {
		if (getName().compareTo(other) < 0) {
			return -1;
		} else if (getName().compareTo(other) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int compareToByStyle(String other) {
		if (getStyle().compareTo(other) < 0) {
			return -1;
		} else if (getStyle().compareTo(other) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
