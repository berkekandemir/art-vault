package homework;
import java.util.*;
/**
 * This is the body of sorting algorithms.
 */
public class ArrayListSorter {
	/**
	 * This method takes arraylist, and two indexes.
	 * It swaps the locations of the objects that are at the given indexes.
	 */
	private void swapper(List<ISearchable> arrayList, int i, int j) {
		ISearchable temp = arrayList.get(j);
		arrayList.set(j, arrayList.get(i));
		arrayList.set(i, temp);
	}
	/**
	 * This method sorts all the artwork objects with the selection sort method by names.
	 */
	public List<ISearchable> selectionSortByName(List<ISearchable> arrayList) {
	    for(int i = 0; i < arrayList.size(); i++) {
	        for(int j = i + 1; j < arrayList.size(); j++) {
	            if (((Artwork) arrayList.get(j)).compareToByName(arrayList.get(i).getName()) < 0) {
	                swapper(arrayList, i, j);
	            }
	        }
	    }
		return arrayList;
	}
	/**
	 * This method sorts all the artwork objects with the selection sort method by styles.
	 */
	public List<ISearchable> selectionSortByStyle(List<ISearchable> arrayList) {
	    for(int i = 0; i < arrayList.size(); i++) {
	        for(int j = i + 1; j < arrayList.size(); j++) {
	            if (((Artwork) arrayList.get(j)).compareToByStyle(((Artwork) arrayList.get(i)).getStyle()) < 0) {
	            	swapper(arrayList, i, j);
	            }
	        }
	    }
		return arrayList;
	}
	/**
	 * Since artist attribute does not exist for all the artwork objects, there is a separated method that has artists.
	 * This method sorts all the artwork objects with the selection sort method by artists.
	 */
	public List<ISearchable> selectionSortByArtistForPainting(List<ISearchable> arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
	        for(int j = i + 1; j < arrayList.size(); j++) {
	            if (((Painting) arrayList.get(j)).compareToByArtist(((Painting) arrayList.get(i)).getArtist().getName()) < 0) {
	            	swapper(arrayList, i, j);
	            }
	        }
	    }
		return arrayList;
	}
	/**
	 * Since artist attribute does not exist for all the artwork objects, there is a separated method that has artists.
	 * This method sorts all the artwork objects with the selection sort method by artists.
	 */
	public List<ISearchable> selectionSortByArtistForSculpture(List<ISearchable> arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
	        for(int j = i + 1; j < arrayList.size(); j++) {
	            if (((Sculpture) arrayList.get(j)).compareToByArtist(((Sculpture) arrayList.get(i)).getArtist().getName()) < 0) {
	            	swapper(arrayList, i, j);
	            }
	        }
	    }
		return arrayList;
	}
	/**
	 * Since material attribute does not exist for all the artwork objects, there is a separated method that has material.
	 * This method sorts all the artwork objects with the selection sort method by artists.
	 */
	public List<ISearchable> selectionSortByMaterial(List<ISearchable> arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
	        for(int j = i + 1; j < arrayList.size(); j++) {
	            if (((Sculpture) arrayList.get(j)).compareToByMaterial(((Sculpture) arrayList.get(i)).getMaterial()) < 0) {
	            	swapper(arrayList, i, j);
	            }
	        }
	    }
		return arrayList;
	}
	/**
	 * This method sorts person objects according to their names with selection sort method.
	 */
	public List<ISearchable> selectionSortByNameForPersons(List<ISearchable> arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
	        for(int j = i + 1; j < arrayList.size(); j++) {
	            if (((Person) arrayList.get(j)).compareToByName(arrayList.get(i).getName()) < 0) {
	            	swapper(arrayList, i, j);
	            }
	        }
	    }
		return arrayList;
	}
	/**
	 * This method sorts person objects according to their birthdays with selection sort method.
	 */
	public List<ISearchable> selectionSortByBirthday(List<ISearchable> arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
	        for(int j = i + 1; j < arrayList.size(); j++) {
	            if (((Person) arrayList.get(j)).compareToByBirthday(((Person) arrayList.get(i)).getBorn()) < 0) {
	            	swapper(arrayList, i, j);
	            }
	        }
	    }
		return arrayList;
	}
	/**
	 * This method sorts person objects according to their nationalities with selection sort method.
	 */
	public List<ISearchable> selectionSortByNationality(List<ISearchable> arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
	        for(int j = i + 1; j < arrayList.size(); j++) {
	            if (((Person) arrayList.get(j)).compareToByNationality(((Person) arrayList.get(i)).getNationality()) < 0) {
	            	swapper(arrayList, i, j);
	            }
	        }
	    }
		return arrayList;
	}
	
	
}
