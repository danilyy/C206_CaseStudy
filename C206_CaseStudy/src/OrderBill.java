/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20009334, 11 Aug 2021 2:03:12 pm
 */

public class OrderBill {
	
	private String id;
	private String date;
	private int quantity;
	private String meal;
	private String drink;
	private String fruit;
	
	public OrderBill(String id, String date, int quantity, String meal,  String drink,  String fruit) {
		super();
		this.id = id;
		this.date = date;
		this.quantity = quantity;
		this.meal = meal;
		this.drink = drink;
		this.fruit = fruit;
	}
	
	public String getID() {
		return id;
	}

	public String getDate() {
		return date;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getMeal() {
		return meal;
	}
	
	public String getDrink() {
		return drink;
	}
	
	public String getFruit() {
		return fruit;
	}
	
}
