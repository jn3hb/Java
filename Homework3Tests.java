import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;




public class Homework3Tests {

	// references to objects of my classes
	Library Clark;
	Person Kathryn;
	Person An;
	Person Sam;
	Person Jocelyn;
	Book bootCamp;
	Book harryPotter;
	Book TKAM;


	// creating new instances of my classes 
	@Before
	public void setUp() {
		Clark = new Library("Clark");
		Kathryn = new Person("Kathryn", "New Jersey", 1234);
		An = new Person("An", "Ashburn", 5678);
		Sam = new Person("Sam", "New Jersey", 9012);
		Jocelyn = new Person("Jocelyn", "Fredericksburg", 3456);
		bootCamp = new Book("Boot Camp", "Todd Strasser", 0000, 12.00);
		harryPotter = new Book("The Goblet of Fire", "J. K. Rowling", 0001, 25.00);
		TKAM = new Book("To Kill A Mockingbird", "Harper Lee", 0002, 17.00);
		
		// adding books to my library to then be able to have the patrons
		// check out books and set due dates for them
		Clark.getLibraryBooks().add(bootCamp);
		Clark.getLibraryBooks().add(harryPotter);
		Clark.getLibraryBooks().add(TKAM);
		Clark.getPatrons().add(Kathryn);
		Clark.getPatrons().add(An);
		Clark.getPatrons().add(Jocelyn);
		Clark.getPatrons().add(Sam);
		Clark.checkOut(Jocelyn, harryPotter, "18 03 2018");
		Clark.setCurrentDate("29 03 2018");
		bootCamp.setDueDate("31 10 2023");
		TKAM.setDueDate("31 10 2023");
		harryPotter.setDueDate("18 03 2018");


	}

	@Test
	public void checkNumCopiesTest() {
		assertEquals(1, Clark.checkNumCopies("Boot Camp", "Todd Strasser"));
	}

	@Test
	public void checkNumCopiesTest2() {
		assertEquals(1, Clark.checkNumCopies("The Goblet of Fire", "J. K. Rowling"));
	}

	// should return 0 as Kathryn never checked out any books 
	@Test
	public void lateFeeTest() {
		assertEquals(0, Clark.lateFee(Kathryn), .1);
	}

	// book is over due so Jocelyn will have to pay the (double) amount of 2.75
	@Test
	public void lateFeeTest2() {
		assertEquals(2.75, Clark.lateFee(Jocelyn), .1);
	}

	@Test
	public void checkOut_isTrue() {
		assertTrue(Clark.checkOut(Jocelyn, TKAM, "25 03 2018"));
	}

	// book already checked out by Jocelyn so she could not possibly check the book out again
	@Test
	public void checkOut_isFalse() {
		assertFalse(Clark.checkOut(Jocelyn, harryPotter, "18 03 2018"));
	}

	@Test
	public void bookDueOnDateTest() {
		assertEquals(2, Clark.booksDueOnDate("31 10 2023").size());
	}
	
	// only one book has a due date of March 18th -- my birthday!
	@Test
	public void bookDueOnDateTest1() {
		assertEquals(1, Clark.booksDueOnDate("18 03 2018").size());
	}

}
