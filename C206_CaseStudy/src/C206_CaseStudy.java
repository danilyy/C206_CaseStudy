import java.util.ArrayList;

/**
 
* I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20038360, 11 Aug 2021 11:40:03 pm
 */

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 20038360, 11 Aug 2021 11:40:03 pm
 */
public class C206_CaseStudy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Arraylist for menu items
		
		ArrayList<Items> itemList = new ArrayList<Items>();
		
		itemList.add(new Items(1, "WesternFood", "Spaghetti", 3.50));
		itemList.add(new Items(2, "WesternFood", "Baked Rice", 4.50));
		
		int option = 0;
		
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				//view menu item
				C206_CaseStudy.viewItems(itemList);
			}
			
			else if (option == 2) {
				Items item = inputItem();
				C206_CaseStudy.addItem(itemList, item);
			}
			else if (option == 3) {
				C206_CaseStudy.deleteItem(itemList);
			}
			else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		
		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Menu Items");
		System.out.println("1. View Menu Items");
		System.out.println("2. Add Menu Items");
		System.out.println("3. Delete Menu Items");
		System.out.println("4. Quit");
		Helper.line(50, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//create view items
	public static String retrieveItems(ArrayList<Items> itemList) {
		String output = "";
		
		for (int i = 0; i < itemList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10.2fs\n", itemList.get(i).getItemID(),
					itemList.get(i).getCategory(), itemList.get(i).getName(), itemList.get(i).getPrice());
		}
		return output;
	}
	
	public static void viewItems(ArrayList<Items> itemList) {
		C206_CaseStudy.setHeader("View Items");
		String output = String.format("%-10s %-30s %-10s  %-10s\n", "ITEM ID", "CATEGORY",
				"NAME", "PRICE");
		 output += retrieveItems(itemList);	
		System.out.println(output);
	}
	// create add items
	public static Items inputItem() {
		int itemID = Helper.readInt("Enter item ID > ");
		String category = Helper.readString("Enter Item Category > ");
		String name = Helper.readString("Enter Item Name > ");
		double price = Helper.readDouble("Enter Item Price > ");

		Items item = new Items(itemID, category, name, price);
		return item;
		
	}
	public static void addItem(ArrayList<Items> itemList, Items item){
		itemList.add(item);
		System.out.println("Item has been successfully added!");
	}
	
	// create delete items
	public static boolean searchID(ArrayList<Items> itemList, int itemID) {
		for (int i = 0; i < itemList.size(); i++) {
			if(itemID == itemList.get(i).getItemID()) {
				return true;
			}
		}
		return false;
	}
	
	public static void deleteItem(ArrayList<Items> itemList){
		// 
		int itemID = Helper.readInt("Enter Menu ID to delete > ");
		if(searchID(itemList, itemID)) {
			for (int i = 0; i < itemList.size(); i++) {
				if(itemID == itemList.get(i).getItemID()) {
					itemList.remove(i);
				}
			}System.out.println("Menu Item ID"+ itemID + "has been successfully deleted!");
		}
		
	}

}
