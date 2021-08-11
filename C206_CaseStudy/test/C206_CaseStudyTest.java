import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Menu JanMenu;
	private Menu FebMenu;
	private Menu MarMenu;
	
	private ArrayList<Menu> MenuList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		//test data for viewMenu
		JanMenu = new Menu("Jan", "Chicken Rice", "$5", "Coke");
		FebMenu = new Menu("Feb", "Fish and Chips", "$6", "Sprite");
		MarMenu = new Menu("Mar", "Fish Soup", "$4.50", "Milo");
		
		MenuList = new ArrayList<Menu>();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAddMenu() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", MenuList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addMenu(MenuList, JanMenu);
		assertEquals("Test if that Menu arraylist size is 1?", 1, MenuList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Menu is added same as 1st item of the list?", JanMenu, MenuList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addMenu(MenuList, FebMenu);
		assertEquals("Test that Menu arraylist size is 2?", 2, MenuList.size());
		assertSame("Test that Menu is added same as 1st item of the list?", FebMenu, MenuList.get(0));
		
		// Add another item. test The size of the list is 3?
		C206_CaseStudy.addMenu(MenuList, MarMenu);
		assertEquals("Test that Menu arraylist size is 3?", 3, MenuList.size());
		assertSame("Test that Menu is added same as 1st item of the list?", MarMenu, MenuList.get(0));
	}
	
	
	@Test
	public void testRetrieveMenu() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Menu arraylist to add to", MenuList);

		// test if the list of Menu retrieved from C206_CaseStudy is empty
		String retrieveMenu = C206_CaseStudy.retrieveMenu(MenuList);
		String testOutput = "";
		assertEquals("Check that Menulist", testOutput, retrieveMenu);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addMenu(MenuList, JanMenu);
		C206_CaseStudy.addMenu(MenuList, FebMenu);
		assertEquals("Test if that Menu arraylist size is 2?", 2, MenuList.size());

		// test if the expected output string same as the list of menu retrieved
		// from C206_CaseStudy
		retrieveMenu = C206_CaseStudy.retrieveMenu(MenuList);

		testOutput = String.format("%-20s %-20s %-20s %-20s\\n", "Jan", "Chicken Rice", "$5", "Coke");
		testOutput += String.format("%-20s %-20s %-20s %-20s\\n", "Feb", "Fish and Chips", "$6", "Sprite");

		assertEquals("Check that ViewAllCamcorderlist", testOutput, retrieveMenu);

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
