import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20041411, 13 Aug 2021 4:03:20 pm
 */


public class PlaceOrderTest {

	private order order1;
	private order order2;
	
	private ArrayList<order> orderList;
	
	public PlaceOrderTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		//id, date, quantity, meal, drink, fruit
		order1 = new order(123, "1-Aug-2021","Burger", "Orange Juice", "Apple Slices");
		order2 = new order(124 , "2-Aug-2021", "Dumpling Soup", "Apple Juice", "Honey Dew");

		orderList= new ArrayList<order>();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAddOrder() {
		// orderlist is not null, so that can add a new order
		assertNotNull("Test if there is valid order arraylist to add to", orderList);

		// Given an empty list, after adding 1 order, the size of the list is 1
		PlaceOrder.addOrder (orderList, order1);
		assertEquals("Test if that order arraylist size is 1?", 1, orderList.size());
  
		// The order just added is as same as the first Order of the list
		assertSame("Test that order is added same as the 1st item of the list?", order1, orderList.get(0));

		// Add another order. test the size of the list is 2?
		PlaceOrder.addOrder(orderList, order2);
		assertEquals("Test that Order arraylist size is 2?", 2, orderList.size());
		assertSame("Test that Order is added same as the 1st item of the list?", order2, orderList.get(0));
	}
	
	@Test
	public void testRetrieveAllOrder() {
		// Test if Order list is not null but empty
		assertNotNull("Test if there is valid Order arraylist to retrieve item", orderList);
		
		//test if the list of Order retrieved from the PlaceOrder is empty
		String retrieveOrder = PlaceOrder.retrieveOrder(orderList);
		String testOutput = "";
		assertEquals("Check that orderList", testOutput, retrieveOrder);
		
		//Given an empty list, after adding 2 Order, test if the size of the list is 2
		PlaceOrder.addOrder(orderList, order1);
		PlaceOrder.addOrder(orderList, order2);
		assertEquals("Test if Order arraylist size is 2", 2, orderList.size());
		
		//test if the expected output string same as the list of Order retrieved from C206_CaseStudy	
		retrieveOrder = PlaceOrder.retrieveOrder(orderList);
		testOutput = String.format("%-10d %-20s %-10s %-20s %-20s\n",123, "01-Aug-2021","Burger","Orange Juice","Apple Slices");
		testOutput += String.format("%-10d %-20s %-10s %-10s %-20s\n",124, "02-Aug-2021", "Dumpling Soup", "Apple Juice", "Honey Dew");
	
		assertEquals("Test that orderList", testOutput, retrieveOrder);
	}
	
	public void testDeleteOrder() {
		// Order list is not null, so that can delete Order
		assertNotNull("Test if there is valid Order arraylist to delete to", orderList);
		PlaceOrder.deleteOrder(orderList); 

		// Given an empty list, after adding 2 Order, the size of the list is 2
		orderList.add(order1);
		orderList.add(order2);
		assertEquals("Test if that Order arraylist size is 2?", 2, orderList.size());

		// After removing, the size of the list is 1?
		PlaceOrder.deleteOrder (orderList);
		assertEquals("Test if that Order arraylist size is 1?", 1, orderList.size());

		// Remove another Order. test the list is empty
		orderList.remove(0);
		assertEquals("Test that Order arraylist size is 0?", 0, orderList.size());
	}

	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("PlaceOrder_SampleTest ",true);
	}
}
