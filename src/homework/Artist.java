package homework;
import java.util.*;
/**
 * This is the body of the artist class and it is a subclass of the person class.
 * It gets every data of the superclass and implements interfaces of it.
 * Also, has extra methods.
 */
public class Artist extends Person{
	private List<String> periods = new ArrayList<String>();
	/**
	 * There is a method overload in case of that there might be a artists that are given with artworks,
	 * but not separately as an artist.
	 */
	public Artist(String name) {
		this(name, (-1), (-1), null, new ArrayList<String>());
	}
	
	public Artist(String name, int born, int died, String nationality, List<String> periods) {
		super(name, born, died, nationality);
		this.periods = periods;
	}

	public List<String> getPeriods() {
		return periods;
	}

	public void setPeriods(List<String> periods) {
		this.periods = periods;
	}
	
	public boolean equals(Person person) {
		boolean result = false;
		if (getName().equals(person.getName())) {
			result = true;
		}
		
		return result;
	}
	
	public String toString() {
		return getName();
	}
}
