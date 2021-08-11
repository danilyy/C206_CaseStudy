/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20009334, 11 Aug 2021 2:03:12 pm
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private OrderBill bill1;
	private OrderBill bill2;
	
	private ArrayList<OrderBill> billList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		//id, date, quantity, meal, drink, fruit
		bill1 = new OrderBill("BB0101", "01-08-2021", 4,"Chicken Chop Rice","Lemon Tea","Watermelon");
		bill2 = new OrderBill("BB0102", "11-08-2021", 3, "Chicken Noodle Soup", "Green Tea", "Orange");

		billList= new ArrayList<OrderBill>();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAddOrderBill() {
		// OrderBill list is not null, so that can add a new OrderBill
		assertNotNull("Test if there is valid OrderBill arraylist to add to", billList);

		// Given an empty list, after adding 1 OrderBill, the size of the list is 1
		C206_CaseStudy.addOrderBill (billList, bill1);
		assertEquals("Test if that OrderBill arraylist size is 1?", 1, billList.size());

		// The OrderBill just added is as same as the first OrderBill of the list
		assertSame("Test that OrderBill is added same as the 1st item of the list?", bill1, billList.get(0));

		// Add another OrderBill. test the size of the list is 2?
		C206_CaseStudy.addOrderBill(billList, bill2);
		assertEquals("Test that OrderBill arraylist size is 2?", 2, billList.size());
		assertSame("Test that OrderBill is added same as the 1st item of the list?", bill2, billList.get(0));
	}
	
	@Test
	public void testRetrieveAllOrderBill() {
		// Test if OrderBill list is not null but empty
		assertNotNull("Test if there is valid OrderBill arraylist to retrieve item", billList);
		
		//test if the list of OrderBill retrieved from the C206_CaseStudy is empty
		String retrieveBill = C206_CaseStudy.retrieveOrderBill(billList);
		String testOutput = "";
		assertEquals("Check that BillList", testOutput, retrieveBill);
		
		//Given an empty list, after adding 2 OrderBills, test if the size of the list is 2
		C206_CaseStudy.addOrderBill(billList, bill1);
		C206_CaseStudy.addOrderBill(billList, bill2);
		assertEquals("Test if OrderBill arraylist size is 2", 2, billList.size());
		
		//test if the expected output string same as the list of OrderBill retrieved from C206_CaseStudy	
		retrieveBill= C206_CaseStudy.retrieveOrderBill(billList);
		testOutput = String.format("%-10s %-20s %-10d %-10s %-20s %-20s\n","BB0101", "01-08-2021", 4,"Chicken Chop Rice","Lemon Tea","Watermelon");
		testOutput += String.format("%-10s %-20s %-10d %-10s %-20s %-20s\n","BB0102", "11-08-2021", 3, "Chicken Noodle Soup", "Green Tea", "Orange");
	
		assertEquals("Test that BillList", testOutput, retrieveBill);
	}
	
	@Test
	public void testDeleteOrderBill() {
		// OrderBill list is not null, so that can delete OrderBill
		assertNotNull("Test if there is valid OrderBill arraylist to delete to", billList);
		C206_CaseStudy.deleteOrderBill (billList, bill1); 

		// Given an empty list, after adding 2 OrderBill, the size of the list is 2
		billList.add(bill1);
		billList.add(bill2);
		assertEquals("Test if that OrderBill arraylist size is 2?", 2, billList.size());

		// After removing, the size of the list is 1?
		C206_CaseStudy.deleteOrderBill (billList, bill2);
		assertEquals("Test if that OrderBill arraylist size is 1?", 1, billList.size());

		// Remove another OrderBill. test the list is empty
		billList.remove(0);
		assertEquals("Test that OrderBill arraylist size is 0?", 0, billList.size());
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
