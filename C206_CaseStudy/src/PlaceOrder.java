import java.util.ArrayList;

/**
* I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20041411, 12 Aug 2021 14:19:03 pm
 */

public class PlaceOrder {

	public static void main(String[] args) {

		ArrayList<order> orderList = new ArrayList<order>();
		
		orderList.add(new order(123, "1-Aug-2021", "Burger", "Orange Juice", "Apple Slice"));
		orderList.add(new order(124, "2-Aug-2021", "dumpling soup", "Apple Juice", "Honey Dew"));
		
       int option = 0;
		
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				PlaceOrder.viewPlaceOrder(orderList);
				
			}
			
			else if (option == 2) {
				order order = inputorder();
				PlaceOrder.addOrder(orderList, order);
				
			}
			else if (option == 3) {
				PlaceOrder.deleteOrder(orderList);
			}
			else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		
		}
	}
	public static void menu() {
		C206_CaseStudy.setHeader("Menu Order");
		System.out.println("1. View Order");
		System.out.println("2. Place Order");
		System.out.println("3. Delete Order");
		System.out.println("4. Quit");
		Helper.line(50, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	public static String retrieveOrder(ArrayList<order> orderList) {
		String output = "";
		
		for (int i = 0; i < orderList.size(); i++) {

			output += String.format("%-10s %-20s %-20s %-20s %-20s\n", orderList.get(i).getId(),orderList.get(i).getDate()
					,orderList.get(i).getMeal(), orderList.get(i).getDrink(),orderList.get(i).getFood());
		}
		return output;
	}
	
	public static void viewPlaceOrder(ArrayList<order> orderList) {
		PlaceOrder.setHeader("View Order");
		String output = String.format("%-10s %-20s %-20s %-20s %-20s\n", "ITEM ID", "DATE",
				"MEAL", "DRINK","FOOD");
		 output += retrieveOrder(orderList);	
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
	
	public static order inputorder() {
		int id = Helper.readInt("Enter Order ID > ");
		String date = Helper.readString("Enter Date >");
		String meal = Helper.readString("Enter Order Meal > ");
		String drink = Helper.readString("Enter Drink Name > ");
		String food = Helper.readString("Enter Food Name > ");

		order order = new order(id, date,  meal, drink, food);
		return order;
		
	}

	public static void addOrder(ArrayList<order> orderList, order order) {
		orderList.add(order);
		System.out.println("Order has been successfully added!");
		
	}
	
	public static boolean searchID(ArrayList<order> orderList, int id) {
		for (int i = 0; i <orderList.size(); i++) {
			if(id == orderList.get(i).getId()) {
				return true;
			}
		}
		return false;
	}
	
	public static void deleteOrder(ArrayList<order> orderList){
		// 
		int id = Helper.readInt("Enter Order ID to delete > ");
		if(searchID(orderList, id)) {
			for (int i = 0; i < orderList.size(); i++) {
				if(id == orderList.get(i).getId()) {
					orderList.remove(i);
				}
			}System.out.println("Menu Order ID"+ id + "has been successfully deleted!");
		}
		
	}
}
	
