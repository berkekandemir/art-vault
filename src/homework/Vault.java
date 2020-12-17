package homework;
import java.util.*;
/**
 * This is the body of the vault class.
 * By this class' objects, we store every data of the read file.
 */
public class Vault {
	List<List<ISearchable>> vault;
	
	public Vault() {
		vault = new ArrayList<List<ISearchable>>();
	}
	
	public void add(List<ISearchable> list) {
		vault.add((ArrayList<ISearchable>) list);
	}
	
	public List<ISearchable> get(int index) {
		return vault.get(index);
	}
	
	public int size() {
		return vault.size();
	}
	
	public void set(int index, List<ISearchable> list) {
		vault.set(index, list);
	}
}
