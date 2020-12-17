package homework;
/**
 * This is the body of the architect class and it is a subclass of the person class.
 * It gets every data of the superclass and implements interfaces of it.
 * Also, has extra methods.
 */
public class Architect extends Person{
	/**
	 * There is a method overload in case of that there might be a architects that are given with architectures,
	 * but not separately as an architect.
	 */
	public Architect(String name) {
		this(name, (-1), (-1), null);
	}
	
	public Architect(String name, int born, int died, String nationality) {
		super(name, born, died, nationality);
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
