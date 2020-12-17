package homework;
/**
 * This is the body of the person class.
 * This class is the superclass of the architect and the artist class'.
 */
public abstract class Person implements IComparable, ISearchable{
	String name;
	int born;
	int died;
	String nationality;
	
	public Person(String name, int born, int died, String nationality) {
		this.name = name;
		this.born = born;
		this.died = died;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBorn() {
		return born;
	}

	public void setBorn(int born) {
		this.born = born;
	}

	public int getDied() {
		return died;
	}

	public void setDied(int died) {
		this.died = died;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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
	
	public int compareToByBirthday(int other) {
		if (getBorn() < other) {
			return -1;
		} else if (getBorn() > other) {
			return 1;
		} else {
			return 0;
		}
	}

	public int compareToByNationality(String other) {
		if (getNationality().compareTo(other) < 0) {
			return -1;
		} else if (getNationality().compareTo(other) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
