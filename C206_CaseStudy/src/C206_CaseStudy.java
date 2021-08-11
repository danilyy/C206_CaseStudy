import java.util.ArrayList;

public class C206_CaseStudy {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Menu> MenuList = new ArrayList<Menu>();

		MenuList.add(new Menu("Jan","Chicken Rice", "$5", "Coke"));
		MenuList.add(new Menu("Feb","Fish and Chips", "$6", "Sprite"));
		MenuList.add(new Menu("Mar","Fish Soup", "$4.50", "Milo"));
		
		int option = 0;

		while (option != 4) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add menu
				Menu m = inputMenu();
				C206_CaseStudy.addMenu(MenuList, m);

			} else if (option == 2) {
				//view menu
				C206_CaseStudy.viewMenu(MenuList);
				
			} else if (option == 3) {
				//Delete menu
				//C206_CaseStudy.deleteMenu();
				
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}


	public static void menu() {
		C206_CaseStudy.setHeader("Monthly Menu");
		System.out.println("1. Add Monthly menu");
		System.out.println("2. View Monthly menu");
		System.out.println("3. Delete Menu");
		System.out.println("4. Quit");
		Helper.line(40, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(40, "-");
		System.out.println(header);
		Helper.line(40, "-");
	}
	
	public static String retrieveMenu(ArrayList<Menu> MenuList) {
		String output = "";

		for (int i = 0; i < MenuList.size(); i++) {

			output += String.format("%-20s %-20s %-20s %-20s\n", MenuList.get(i).getMonth(), MenuList.get(i).getFood(),
					MenuList.get(i).getPrice(), MenuList.get(i).getDrinks());
		}
		return output;
	}
	
	public static void viewMenu(ArrayList<Menu> MenuList) {
		C206_CaseStudy.setHeader("Menu");
		String output = String.format("%-20s %-20s %-20s %-20s\n", "Month", "FOOD", "PRICE", "DRINKS");
		 output += retrieveMenu(MenuList);	
		System.out.println(output);
	}
		
		public static Menu inputMenu() {
			String month = Helper.readString("Enter Month > ");
			String food = Helper.readString("Enter Food > ");
			String price = Helper.readString("Enter Price > ");
			String drinks = Helper.readString("Enter Drinks > ");

			Menu m= new Menu(month, food, price, drinks);
			return m;
			
		}
		public static void addMenu(ArrayList<Menu> MenuList, Menu m) {
			
			MenuList.add(m);
			System.out.println("Menu added!");
		}
		
}
