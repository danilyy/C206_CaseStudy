public class order {
	private int id;
	private String date;
	private String meal;
	private String drink;
	private String food;
	
	public order(int id, String date, String meal, String drink, String food) {
		super();
		this.id = id;
		this.date = date;
		this.meal = meal;
		this.drink = drink;
		this.food = food;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getMeal() {
		return meal;
	}

	public String getDrink() {
		return drink;
	}

	public String getFood() {
		return food;
	}
	
	

}
