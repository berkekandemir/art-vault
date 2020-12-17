package homework;
import java.util.*;
/**
 * This class is the body of the private collection class.
 * By this class, we create seller and the buyers' private collections.
 */
public class PrivateCollection {
	List<ITradable> privateCollection;
	
	public PrivateCollection() {
		privateCollection = new ArrayList<ITradable>();
	}
	
	public void add(ITradable item) {
		privateCollection.add(item);
	}
	
	public ITradable remove(ITradable item) {
		privateCollection.remove(item);
		return item;
	}
	
	public ITradable get(int index) {
		return privateCollection.get(index);
	}
	public int size() {
		return privateCollection.size();
	}
}
