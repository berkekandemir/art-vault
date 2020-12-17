package homework;
import java.util.*;
/**
 * This is the heart of the program. All the operations are executed in here.
 */
public class ArtVaultAppMenu {
	Scanner keyboard;
	
	public ArtVaultAppMenu() {
		keyboard = new Scanner(System.in);
	}
	/**
	 * This method is the only public method of the class.
	 * The method calls the private method and they do the performs.
	 */
	public void app(Vault vault) {
		boolean exit = false;
		while (!exit) {
			System.out.println("Please enter the number of the operation you want to perform:");
			System.out.println("");
			System.out.println("1) Print the list");
			System.out.println("2) Search the vault");
			System.out.println("3) Trade");
			System.out.println("0) Exit");
			System.out.println("");
			int operation = keyboard.nextInt();
			keyboard.nextLine();
			if (operation == 0) {
				exit = true;
			} else if (operation == 1) {
				System.out.println("");
				exit = sorter(vault);
			} else if (operation == 2) {
				System.out.println("");
				searcher(vault);
			} else if (operation == 3) {
				trader(vault);
				
			} else {
				System.out.println("Wrong input! Try again.");
				System.out.println("");
			}
		}
	}
	/**
	 * This method creates seller and buyers. Selects random artworks from seller's private collection.
	 * If the artwork is tradable, it carries out the trade.
	 */
	private void trader(Vault vault) {
		PrivateCollection sellerPrivateCollection = new PrivateCollection();
		for (int i = 0; i < vault.size(); i++) {
			for (int j = 0; j < vault.get(i).size(); j++) {
				if (i >= 2) {
					sellerPrivateCollection.add((ITradable) vault.get(i).get(j));
				}
			}
		}
		/**
		 * One seller and the buyer array is created.
		 */
		Seller seller = new Seller(sellerPrivateCollection);
		Buyer[] buyerArr = new Buyer[4];
		/**
		 * As asked, four buyer objects are created and added to the array.
		 * In future, easily the number can be changed.
		 */
		for (int i = 0; i < 4; i++) {
			Buyer buyer = new Buyer();
			buyerArr[i] = buyer;
		}
		/**
		 * Initial condition of the seller and the buyers' wallet amounts are printed.
		 * In future, if the buyer count changes, this part also changes automatically.
		 */
		System.out.println("");
		System.out.println("Seller's money: " + (int) seller.getWallet().getAmount() + " TL");
		
		for (int i = 0; i < buyerArr.length; i++) {
			System.out.println("Buyer " + (i + 1) + "'s money: " + (int) buyerArr[i].getWallet().getAmount() + " TL");
		}
		
		System.out.println("");
		System.out.println("Trade started: ");
		System.out.println("");
		/**
		 * The trade operation is completed automatically with respect to the buyer count.
		 * In case of the number change, program keep working according to the buyer object number.
		 */
		for (int i = 0; i < buyerArr.length; i++) {
			System.out.println("Buyer " + (i + 1) + " bought: ");
			System.out.println("");
			int random = randomNum(0, sellerPrivateCollection.size() - 1);
			ITradable object = seller.getPrivateCollection().get(random);
			while (!object.isTradable()) {
				random = randomNum(0, sellerPrivateCollection.size());
				object = seller.getPrivateCollection().get(random);
			}
			System.out.println(object);
			object.tradeToBuyer(buyerArr[i], seller);
		}
		/**
		 * Final condition of the seller and the buyers' wallet amounts are printed.
		 * In future, if the buyer count changes, this part also changes automatically.
		 */
		System.out.println("Trade completed:");
		System.out.println("");
		System.out.println("Seller's money: " + seller.getWallet().getAmount() + " TL");
		
		for (int i = 0; i < buyerArr.length; i++) {
			System.out.println("Buyer " + (i + 1) + "'s money: " + buyerArr[i].getWallet().getAmount() + " TL");
		}
		System.out.println("");
	}
	/**
	 * This is the helper method to pick a random number between the specific numbers.
	 */
	private int randomNum(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("Maximum number must be greater than the minimum number.");
		}

		Random randomNum = new Random();
		return randomNum.nextInt((max - min) + 1) + min;
	}
	/**
	 * This method does the search operations.
	 * It asks user a keyword to search and checks every possible directory for that keyword.
	 */
	private void searcher(Vault vault) {
		System.out.println("Enter the keyword: ");
		System.out.println("");
		String keyword = keyboard.nextLine();
		System.out.println("");
		artistSearcher(keyword, vault);
		architectSearcher(keyword, vault);
		paintingSearcherArtist(keyword, vault);
		sculptureSearcherArtist(keyword, vault);
		architectureSearcherArchitect(keyword, vault);
		System.out.println("");
		paintingSearcher(keyword, vault);
		sculptureSearcher(keyword, vault);
		architectureSearcher(keyword, vault);
	}
	/**
	 * This method compares the architecture names with the keyword.
	 * If they match, prints out the architecture info.
	 */
	private void architectureSearcher(String keyword, Vault vault) {
		ArrayListSorter sorter = new ArrayListSorter();
		vault.set(4, sorter.selectionSortByName(vault.get(4)));
		for (int i = 0; i < vault.get(4).size(); i++) {
			if (vault.get(4).get(i).getName().equals(keyword)) {
				System.out.println("Architecture:");
				System.out.println("	Name: " + vault.get(4).get(i).getName());
				System.out.println("	Style: " + ((Artwork) vault.get(4).get(i)).getStyle());
				System.out.print("	Architects: ");
				for (int j = 0; j < ((Architecture) vault.get(4).get(i)).getArchitects().size(); j++) {
					if (j == (((Architecture) vault.get(4).get(i)).getArchitects().size() - 1)) {
						System.out.print(((Architecture) vault.get(4).get(i)).getArchitects().get(j));
					}
					System.out.print(((Architecture) vault.get(4).get(i)).getArchitects().get(j) + ", ");
				}
			}
		}
	}
	/**
	 * This method compares the sculpture names with the keyword.
	 * If they match, prints out the sculpture info.
	 */
	private void sculptureSearcher(String keyword, Vault vault) {
		ArrayListSorter sorter = new ArrayListSorter();
		vault.set(3, sorter.selectionSortByName(vault.get(3)));
		for (int i = 0; i < vault.get(3).size(); i++) {
			if (vault.get(3).get(i).getName().equals(keyword)) {
				System.out.println("Sculpture:");
				System.out.println("	Name: " + vault.get(3).get(i).getName());
				System.out.println("	Artist: " + ((Sculpture) vault.get(3).get(i)).getArtist().getName());
				System.out.println("	Style: " + ((Artwork) vault.get(3).get(i)).getStyle());
				System.out.println("	Material: " + ((Sculpture) vault.get(3).get(i)).getMaterial());
				System.out.println("	Weight: " + ((Sculpture) vault.get(3).get(i)).getWeight() + "kg");
				System.out.println("");
			}
		}
	}
	/**
	 * This method compares the painting names with the keyword.
	 * If they match, prints out the painting info.
	 */
	private void paintingSearcher(String keyword, Vault vault) {
		ArrayListSorter sorter = new ArrayListSorter();
		vault.set(2, sorter.selectionSortByName(vault.get(2)));
		for (int i = 0; i < vault.get(2).size(); i++) {
			if (vault.get(2).get(i).getName().equals(keyword)) {
				System.out.println("Painting:");
				System.out.println("	Name: " + vault.get(2).get(i).getName());
				System.out.println("	Artist: " + ((Painting) vault.get(2).get(i)).getArtist().getName());
				System.out.println("	Style: " + ((Artwork) vault.get(2).get(i)).getStyle());
				System.out.println("	Dimensions: " + ((Painting) vault.get(2).get(i)).getLength() + "cm X " + ((Painting) vault.get(2).get(i)).getWidth() + "cm");
				System.out.println("");
			}
		}
	}
	/**
	 * This method compares the artist names of the paintings with the keyword.
	 * If they match, prints out the painting info.
	 */
	private void paintingSearcherArtist(String keyword, Vault vault) {
		ArrayListSorter sorter = new ArrayListSorter();
		vault.set(2, sorter.selectionSortByName(vault.get(2)));
		for (int i = 0; i < vault.get(2).size(); i++) {
			if (((Painting) vault.get(2).get(i)).getArtist().getName().equals(keyword)) {
				System.out.println("Painting:");
				System.out.println("	Name: " + vault.get(2).get(i).getName());
				System.out.println("	Artist: " + ((Painting) vault.get(2).get(i)).getArtist().getName());
				System.out.println("	Style: " + ((Artwork) vault.get(2).get(i)).getStyle());
				System.out.println("	Dimensions: " + ((Painting) vault.get(2).get(i)).getLength() + "cm X " + ((Painting) vault.get(2).get(i)).getWidth() + "cm");
				System.out.println("");
			}
		}
	}
	/**
	 * This method compares the architect names of the architectures with the keyword.
	 * If they match, prints out the architecture info.
	 */
	private void architectureSearcherArchitect(String keyword, Vault vault) {
		ArrayListSorter sorter = new ArrayListSorter();
		vault.set(4, sorter.selectionSortByName(vault.get(4)));
		for (int i = 0; i < vault.get(4).size(); i++) {
			for (int j = 0; j < ((Architecture) vault.get(4).get(i)).getArchitects().size(); j++) {
				if (((Architecture) vault.get(4).get(i)).getArchitects().get(j).getName().equals(keyword)) {
					System.out.println("Architecture:");
					System.out.println("	Name: " + vault.get(4).get(i).getName());
					System.out.println("	Style: " + ((Artwork) vault.get(4).get(i)).getStyle());
					System.out.print("	Architects: ");
					for (int k = 0; k < ((Architecture) vault.get(4).get(i)).getArchitects().size(); k++) {
						if (k == (((Architecture) vault.get(4).get(i)).getArchitects().size() - 1)) {
							System.out.print(((Architecture) vault.get(4).get(i)).getArchitects().get(k));
							System.out.println("");
							System.out.println("");
							break;
						}
						System.out.print(((Architecture) vault.get(4).get(i)).getArchitects().get(k) + ", ");
					}
				}
			}
		}
	}
	/**
	 * This method compares the artist names of the sculptures with the keyword.
	 * If they match, prints out the sculpture info.
	 */
	private void sculptureSearcherArtist(String keyword, Vault vault) {
		ArrayListSorter sorter = new ArrayListSorter();
		vault.set(3, sorter.selectionSortByName(vault.get(3)));
		for (int i = 0; i < vault.get(3).size(); i++) {
			if (((Sculpture) vault.get(3).get(i)).getArtist().getName().equals(keyword)) {
				System.out.println("Sculpture:");
				System.out.println("	Name: " + vault.get(3).get(i).getName());
				System.out.println("	Artist: " + ((Sculpture) vault.get(3).get(i)).getArtist().getName());
				System.out.println("	Style: " + ((Artwork) vault.get(3).get(i)).getStyle());
				System.out.println("	Material: " + ((Sculpture) vault.get(3).get(i)).getMaterial());
				System.out.println("	Weight: " + ((Sculpture) vault.get(3).get(i)).getWeight() + "kg");
				System.out.println("");
			}
		}
	}
	/**
	 * This method compares the architect names with the keyword.
	 * If they match, prints out the architect info.
	 */
	private void architectSearcher(String keyword, Vault vault) {
		ArrayListSorter sorter = new ArrayListSorter();
		vault.set(1, sorter.selectionSortByNameForPersons(vault.get(1)));
		for (int i = 0; i < vault.get(1).size(); i++) {
			if (vault.get(1).get(i).getName().equals(keyword)) {
				System.out.println("Architect:");
				System.out.println("	Name: " + vault.get(1).get(i).getName());
				System.out.println("	Born: " + ((Person) vault.get(1).get(i)).getBorn());
				System.out.println("	Died: " + ((Person) vault.get(1).get(i)).getDied());
				System.out.println("	Nationality: " + ((Person) vault.get(1).get(i)).getNationality());
				System.out.println("");
			}
		}
	}
	/**
	 * This method compares the artists names with the keyword.
	 * If they match, prints out the artist info.
	 */
	private void artistSearcher(String keyword, Vault vault) {
		ArrayListSorter sorter = new ArrayListSorter();
		vault.set(0, sorter.selectionSortByNameForPersons(vault.get(0)));
		for (int i = 0; i < vault.get(0).size(); i++) {
			if (vault.get(0).get(i).getName().equals(keyword)) {
				System.out.println("Artist:");
				System.out.println("	Name: " + vault.get(0).get(i).getName());
				System.out.println("	Born: " + ((Person) vault.get(0).get(i)).getBorn());
				System.out.println("	Died: " + ((Person) vault.get(0).get(i)).getDied());
				System.out.println("	Nationality: " + ((Person) vault.get(0).get(i)).getNationality());
				System.out.print("	Periods: ");
				for (int j = 0; j < ((Artist) vault.get(0).get(i)).getPeriods().size(); j++) {
					if (j == (((Artist) vault.get(0).get(i)).getPeriods().size() - 1)) {
						System.out.print(((Artist) vault.get(0).get(i)).getPeriods().get(j));
						System.out.println("");
						break;
					}
					System.out.print(((Artist) vault.get(0).get(i)).getPeriods().get(j) + ", ");
				}
			}
		}
	}
	/**
	 * This method sorts the lists according to the user's choices.
	 */
	private boolean sorter(Vault vault) {
		/**
		 * It asks user for the list selection and then the sorting method according to the selected list.
		 * Then it sorts the list according to the choice.
		 * Then calls the printer methods to print out the list items.
		 */
		ArrayListSorter sorter = new ArrayListSorter();
		boolean exit = false;
		System.out.println("Please choose the list: ");
		System.out.println("");
		System.out.println("1) Print the list of artists");
		System.out.println("2) Print the list of architects");
		System.out.println("3) Print the list of paintings");
		System.out.println("4) Print the list of sculptures");
		System.out.println("5) Print the list of architectures");
		System.out.println("0) Exit");
		System.out.println("");
		int selection = keyboard.nextInt();
		System.out.println("");
		if (selection == 0) {
			exit = true;
		} else if (selection == 1) {
			System.out.println("Please choose the sorting method:");
			System.out.println("");
			System.out.println("1) Sort by name");
			System.out.println("2) Sort by birthday");
			System.out.println("3) Sort by nationality");
			System.out.println("0) Exit");
			System.out.println("");
			int sorting = keyboard.nextInt();
			if (sorting == 0) {
				exit = true;
			} else if (sorting == 1) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByNameForPersons(vault.get(0));
				artistPrinter(list);
			} else if (sorting == 2) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByBirthday(vault.get(0));
				artistPrinter(list);
			} else if (sorting == 3) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByNationality(vault.get(0));
				artistPrinter(list);
			} else {
				System.out.println("Wrong input! Try again.");
				System.out.println("");
			}
		} else if (selection == 2) {
			System.out.println("Please choose the sorting method:");
			System.out.println("");
			System.out.println("1) Sort by name");
			System.out.println("2) Sort by birthday");
			System.out.println("3) Sort by nationality");
			System.out.println("0) Exit");
			System.out.println("");
			int sorting = keyboard.nextInt();
			if (sorting == 0) {
				exit = true;
			} else if (sorting == 1) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByNameForPersons(vault.get(1));
				architectPrinter(list);
			} else if (sorting == 2) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByBirthday(vault.get(1));
				architectPrinter(list);
			} else if (sorting == 3) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByNationality(vault.get(1));
				architectPrinter(list);
			} else {
				System.out.println("Wrong input! Try again.");
				System.out.println("");
			}
		} else if (selection == 3) {
			System.out.println("Please choose the sorting method:");
			System.out.println("");
			System.out.println("1) Sort by name");
			System.out.println("2) Sort by style");
			System.out.println("3) Sort by artist");
			System.out.println("0) Exit");
			System.out.println("");
			int sorting = keyboard.nextInt();
			if (sorting == 0) {
				exit = true;
			} else if (sorting == 1) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByName(vault.get(2));
				paintingPrinter(list);
			} else if (sorting == 2) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByStyle(vault.get(2));
				paintingPrinter(list);
			} else if (sorting == 3) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByArtistForPainting(vault.get(2));
				paintingPrinter(list);
			} else {
				System.out.println("Wrong input! Try again.");
				System.out.println("");
			}
		} else if (selection == 4) {
			System.out.println("Please choose the sorting method:");
			System.out.println("");
			System.out.println("1) Sort by name");
			System.out.println("2) Sort by style");
			System.out.println("3) Sort by artist");
			System.out.println("4) Sort by material");
			System.out.println("0) Exit");
			System.out.println("");
			int sorting = keyboard.nextInt();
			if (sorting == 0) {
				exit = true;
			} else if (sorting == 1) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByName(vault.get(3));
				sculpturePrinter(list);
			} else if (sorting == 2) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByStyle(vault.get(3));
				sculpturePrinter(list);
			} else if (sorting == 3) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByArtistForSculpture(vault.get(3));
				sculpturePrinter(list);
			} else if (sorting == 4) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByMaterial(vault.get(3));
				sculpturePrinter(list);
			} else {
				System.out.println("Wrong input! Try again.");
				System.out.println("");
			}
		} else if (selection == 5) {
			System.out.println("Please choose the sorting method:");
			System.out.println("");
			System.out.println("1) Sort by name");
			System.out.println("2) Sort by style");
			System.out.println("0) Exit");
			System.out.println("");
			int sorting = keyboard.nextInt();
			if (sorting == 0) {
				exit = true;
			} else if (sorting == 1) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByName(vault.get(4));
				architecturePrinter(list);
			} else if (sorting == 2) {
				ArrayList<ISearchable> list = (ArrayList<ISearchable>) sorter.selectionSortByStyle(vault.get(4));
				architecturePrinter(list);
			} else {
				System.out.println("Wrong input! Try again.");
				System.out.println("");
			}
		} else {
			System.out.println("Wrong input! Try again.");
			System.out.println("");
		}
		return exit;
	}
	/**
	 * This method print the info of items of the given architecture list. 
	 */
	private void architecturePrinter(ArrayList<ISearchable> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Architecture:");
			System.out.println("	Name: " + list.get(i).getName());
			System.out.println("	Style: " + ((Artwork) list.get(i)).getStyle());
			System.out.print("	Architects: ");
			for (int j = 0; j < ((Architecture) list.get(i)).getArchitects().size(); j++) {
				if (j == (((Architecture) list.get(i)).getArchitects().size() - 1)) {
					System.out.print(((Architecture) list.get(i)).getArchitects().get(j));
					System.out.println("");
					System.out.println("");
					break;
				}
				System.out.print(((Architecture) list.get(i)).getArchitects().get(j) + ", ");
			}
		}
	}
	/**
	 * This method print the info of items of the given sculpture list. 
	 */
	private void sculpturePrinter(ArrayList<ISearchable> list) {
		System.out.println("");
		for (int i = 0; i < list.size(); i++) {
				System.out.println("Sculpture:");
				System.out.println("	Name: " + list.get(i).getName());
				System.out.println("	Artist: " + ((Sculpture) list.get(i)).getArtist().getName());
				System.out.println("	Style: " + ((Artwork) list.get(i)).getStyle());
				System.out.println("	Material: " + ((Sculpture) list.get(i)).getMaterial());
				System.out.println("	Weight: " + ((Sculpture) list.get(i)).getWeight() + "kg");
				System.out.println("");
		}
	}
	/**
	 * This method print the info of items of the given painting list. 
	 */
	private void paintingPrinter(ArrayList<ISearchable> list) {
		System.out.println("");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Painting:");
			System.out.println("	Name: " + list.get(i).getName());
			System.out.println("	Artist: " + ((Painting) list.get(i)).getArtist().getName());
			System.out.println("	Style: " + ((Artwork) list.get(i)).getStyle());
			System.out.println("	Dimensions: " + ((Painting) list.get(i)).getLength() + "cm X " + ((Painting) list.get(i)).getWidth() + "cm");
			System.out.println("");
		}
	}
	/**
	 * This method print the info of items of the given architect list. 
	 */
	private void architectPrinter(ArrayList<ISearchable> list) {
		System.out.println("");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Architect:");
			System.out.println("	Name: " + list.get(i).getName());
			System.out.println("	Born: " + ((Person) list.get(i)).getBorn());
			System.out.println("	Died: " + ((Person) list.get(i)).getDied());
			System.out.println("	Nationality: " + ((Person) list.get(i)).getNationality());
			System.out.println("");
		}
	}
	/**
	 * This method print the info of items of the given artists list. 
	 */
	private void artistPrinter(ArrayList<ISearchable> list) {
		System.out.println("");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Artist:");
			System.out.println("	Name: " + list.get(i).getName());
			System.out.println("	Born: " + ((Person) list.get(i)).getBorn());
			System.out.println("	Died: " + ((Person) list.get(i)).getDied());
			System.out.println("	Nationality: " + ((Person) list.get(i)).getNationality());
			System.out.print("	Periods: ");
			for (int j = 0; j < ((Artist) list.get(i)).getPeriods().size(); j++) {
				if (j == (((Artist) list.get(i)).getPeriods().size() - 1)) {
					System.out.print(((Artist) list.get(i)).getPeriods().get(j));
					System.out.println("");
					System.out.println("");
					break;
				}
				System.out.print(((Artist) list.get(i)).getPeriods().get(j) + ", ");
			}
		}
	}
}
