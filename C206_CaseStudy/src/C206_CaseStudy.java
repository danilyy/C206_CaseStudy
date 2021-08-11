import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20009334, 11 Aug 2021 2:03:12 pm
 */

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<OrderBill> billList = new ArrayList<OrderBill>();

		billList.add(new OrderBill("BB01013", "11-07-2021", 1,"Fried Rice","Coke","Grapes"));
		billList.add(new OrderBill("BB01014", "09-08-2021", 2,"Vegetarian Bee Hoon","Hot Milk Tea","Apple"));

		int option = 0;

		while (option != 4) {

			C206_CaseStudy.orderBill();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.viewOrderBill(billList);

			} else if (option == 2) {
				// Add a new item
				OrderBill e = inputOrderBill();
				C206_CaseStudy.addOrderBill(billList, e);


			} else if (option == 3) {
				// Delete item
				// Add a new item
				OrderBill e = inputOrderBill();
				C206_CaseStudy.deleteOrderBill(billList,e);
				
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void orderBill() {
		C206_CaseStudy.setHeader("Order Bill");
		System.out.println("1. Add Order Bill");
		System.out.println("2. View Order Bill");
		System.out.println("3. Delete Order Bill");
		System.out.println("4. Quit");
		Helper.line(50, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(50, "-");
		System.out.println(header);
		Helper.line(50, "-");
	}

	//================================= Option 1 View (CRUD - Read) =================================
	public static String retrieveOrderBill(ArrayList<OrderBill> billList) {
		String output = "";

		for (int i = 0; i < billList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", billList.get(i).getID(),
					billList.get(i).getDate(), billList.get(i).getQuantity(),billList.get(i).getMeal(),
					billList.get(i).getDrink(), billList.get(i).getFruit());
		}
		return output;
	}
	public static void viewOrderBill(ArrayList<OrderBill> billList) {
		C206_CaseStudy.setHeader("ORDER BILL");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ID", "DATE",
				"QUANTITY", "MEAL","DRINK", "FRUIT");
		output += retrieveOrderBill(billList);	
		System.out.println(output);
	}

	//================================= Option 2 Add (CRUD - Create)=================================
	public static OrderBill inputOrderBill() {
		String id = Helper.readString("Enter ID > ");
		String date = Helper.readString("Enter date > ");
		int quantity = Helper.readInt("Enter quantity > ");
		String meal = Helper.readString("Enter meal > ");
		String drink = Helper.readString("Enter drink > ");
		String fruit = Helper.readString("Enter fruit > ");	

		OrderBill e = new OrderBill(id, date, quantity, meal, drink, fruit);
		return e;
		
	}
	public static void addOrderBill(ArrayList<OrderBill> billList, OrderBill e) {
		
		billList.add(e);
		System.out.println("Order bill added!");
	}
	
	//================================= Option 3 Delete (CURD- Update) =================================
	public static boolean doDeleteOrderBill(ArrayList<OrderBill> billList,String id) {
		boolean isDeleted = false;
		
		String idToDelete = Helper.readString("Enter ID to delete > ");

		for (int i = 0; i < billList.size(); i++) {
			if (id.equals(idToDelete)) {
				billList.remove(0);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void deleteOrderBill(ArrayList<OrderBill> billList, OrderBill e) {
		billList.remove(e);
		System.out.println("Order bill deleted!");
	}
}
