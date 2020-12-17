package homework;
/**
 * The interface for the comparable objects.
 * It only contains one method because this is the only method,
 * That the every comparable object should implement.
 * The other methods are specific for the objects. It changes.
 */
public interface IComparable {
	public int compareToByName(String other);
	
}
