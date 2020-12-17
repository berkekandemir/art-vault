package homework;
/**
 * This is the main class of the program. It calls necessary class' methods to perform the operations.
 */
public class ArtVaultApp {
	public static void main(String[] args) {
		CSVReader reader = new CSVReader();
		Vault vault = reader.returnVault();
		ArtVaultAppMenu menu = new ArtVaultAppMenu();
		menu.app(vault);
	}
}
