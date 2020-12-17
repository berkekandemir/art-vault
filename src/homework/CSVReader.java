package homework;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This is where the program takes all the info.
 */
public class CSVReader {
	Scanner personVault;
	Scanner artVault;
	Scanner keyboard;
	Vault vault;
	ArrayListSorter sorter;
	List<ISearchable> persons;
	ISearchable artist;
	List<ISearchable> artists;
	ISearchable architect;
	List<ISearchable> architects;
	ISearchable painting;
	List<ISearchable> paintings;
	ISearchable sculpture;
	List<ISearchable> sculptures;
	ISearchable architecture;
	List<ISearchable> architectures;
	/**
	 * Arraylists are created to be fulfilled.
	 * The same file is opened twice for two iterates.
	 */
	public CSVReader() {
		vault = new Vault();
		persons = new ArrayList<ISearchable>();
		artists = new ArrayList<ISearchable>();
		architects = new ArrayList<ISearchable>();
		paintings = new ArrayList<ISearchable>();
		sculptures = new ArrayList<ISearchable>();
		architectures = new ArrayList<ISearchable>();
		sorter = new ArrayListSorter();
		keyboard = new Scanner(System.in);
		try {
			personVault = new Scanner(new File("CENG211_HW2_ArtVaultData.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		try {
			artVault = new Scanner(new File("CENG211_HW2_ArtVaultData.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
	/**
	 * Only public method of the class. It collects all the data in one object and return it.
	 * @return
	 */
	public Vault returnVault() {
		read();
		List<ISearchable> artistsSorted = sorter.selectionSortByNameForPersons(artists);
		vault.add(artistsSorted);
		List<ISearchable> architectsSorted = sorter.selectionSortByNameForPersons(architects);
		vault.add(architectsSorted);
		List<ISearchable> paintingsSorted = sorter.selectionSortByName(paintings);
		vault.add(paintingsSorted);
		List<ISearchable> sculpturesSorted = sorter.selectionSortByName(sculptures);
		vault.add(sculpturesSorted);
		List<ISearchable> architecturesSorted = sorter.selectionSortByName(architectures);
		vault.add(architecturesSorted);
		return vault;
	}
	/**
	 * In the first loop, the personVault file is used and,
	 * The separated artists and architects objects are created.
	 * 
	 * In the second loop, the artVault file is used and,
	 * The artwork objects are created.
	 * 
	 * We separated the loops because the logic is that,
	 * We first create the architects and artists that have separated lines in the file.
	 * Then, while we creating the artwork objects,
	 * If the artist or the architect of the artwork is not created before,
	 * We understand that the artist/architect has no info in the file.
	 * Then, we create the artist/architect object with only name and put it into the artwork object.
	 */
	private void read() {
		while (personVault.hasNextLine()) {
			String line = personVault.nextLine();
			String[] lineArr = line.split(",");
			if (Integer.parseInt(lineArr[0]) == 4) {
				artistCreator(lineArr);
			} else if (Integer.parseInt(lineArr[0]) == 5) {
				architectCreator(lineArr);
			}
		}
		personVault.close();
		while (artVault.hasNextLine()) {
			String line = artVault.nextLine();
			String[] lineArr = line.split(",");
			if (Integer.parseInt(lineArr[0]) == 1) {
				paintingCreator(lineArr);
			} else if (Integer.parseInt(lineArr[0]) == 2) {
				sculptureCreator(lineArr);
			} else if (Integer.parseInt(lineArr[0]) == 3) {
				architectureCreator(lineArr);
			}
		}
		artVault.close();
	}
	/**
	 * When the method is called, it simple created the artist object with the given info at the file.
	 */
	private void artistCreator(String[] lineArr) {
		int defaultLength = 5;
		int actualLength = lineArr.length;
		String name = lineArr[1];
		int born = Integer.parseInt(lineArr[2]);
		int died = Integer.parseInt(lineArr[3]);
		String nationality = lineArr[4];
		List<String> periods = new ArrayList<String>();
		for (int i = 0; i < actualLength; i++) {
			if (i >= defaultLength) {
				periods.add(lineArr[i]);
			}
		}
		artist = new Artist(name, born, died, nationality, periods);
		artists.add(artist);
	}
	/**
	 * When the method is called, it simple created the architect object with the given info at the file.
	 */
	private void architectCreator(String[] lineArr) {
		String name = lineArr[1];
		int born = Integer.parseInt(lineArr[2]);
		int died = Integer.parseInt(lineArr[3]);
		String nationality = lineArr[4];
		architect = new Architect(name, born, died, nationality);
		architects.add(architect);
	}
	/**
	 * When the method is called, it simple created the painting object with the given info at the file.
	 */
	private void paintingCreator(String[] lineArr) {
		String name = lineArr[1];
		String style = lineArr[2];
		float length = Float.parseFloat(lineArr[4]);
		float width = Float.parseFloat(lineArr[5]);
		for (int i = 0; i < artists.size(); i++) {
			if (artists.get(i).getName().equals(lineArr[3])) {
				artist = artists.get(i);
				break;
			} else if (i == (artists.size() - 1)) {
				artist = new Artist(lineArr[3]);
				break;
			}
		}
		painting = new Painting(name, style, artist, length, width);
		paintings.add(painting);
	}
	/**
	 * When the method is called, it simple created the sculpture object with the given info at the file.
	 */
	private void sculptureCreator(String[] lineArr) {
		String name = lineArr[1];
		String style = lineArr[2];
		String material = lineArr[4];
		float weight = Float.parseFloat(lineArr[5]);
		for (int i = 0; i < artists.size(); i++) {
			if (artists.get(i).getName().equals(lineArr[3])) {
				artist = artists.get(i);
				break;
			} else if (i == (artists.size() - 1)) {
				artist = new Artist(lineArr[3]);
				break;
			}
		}
		sculpture = new Sculpture(name, style, artist, material, weight);
		sculptures.add(sculpture);
	}
	/**
	 * When the method is called, it simple created the architecture object with the given info at the file.
	 */
	private void architectureCreator(String[] lineArr) {
		int defaultLength = 6;
		int actualLength = lineArr.length;
		String name = lineArr[1];
		String style = lineArr[2];
		float length = Float.parseFloat(lineArr[3]);
		float width = Float.parseFloat(lineArr[4]);
		float height = Float.parseFloat(lineArr[5]);
		List<String> tempArchitects = new ArrayList<String>();
		List<ISearchable> architectsFinal = new ArrayList<ISearchable>();
		for (int i = 0; i < actualLength; i++) {
			if (i >= defaultLength) {
				tempArchitects.add(lineArr[i]);
			}
		}
		for (int i = 0; i < tempArchitects.size(); i++) {
			for (int j = 0; j < architects.size(); j++) {
				if (tempArchitects.get(i).equals(architects.get(j).getName())) {
					architectsFinal.add(architects.get(j));
					break;
				} else if (j == (architects.size() - 1)) {
					architect = new Architect(tempArchitects.get(i));
					architectsFinal.add(architect);
					break;
				}
			}
		}
		architecture = new Architecture(name, style, length, width, height, architectsFinal);
		architectures.add(architecture);
	}
}
