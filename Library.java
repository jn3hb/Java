// Jhonathan Nivar (jn3hb)
// Homework 3: Library



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class Library {

	// Fields
	private ArrayList<Book> libraryBooks; 
	private ArrayList<Person> patrons;
	private String name;
	private int numBooks;
	private int numPeople;
	private String currentDate;

	// Constructor
	public Library(String name) {
		
		// initialized fields
		this.name = name;
		libraryBooks = new ArrayList<Book>();
		patrons = new ArrayList<Person>();
	}

	// Getters
	public ArrayList<Book> getLibraryBooks() {
		return libraryBooks;
	}

	public ArrayList<Person> getPatrons() {
		return patrons;
	}

	public String getName() {
		return name;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	// will get number of books currently in the library
	public int getNumBooks() {
		int books = 0;
		for (Book book : libraryBooks) {
			if (book.isCheckedOut() == false) {
				books += 1;
			}
		}
		return books;
	}

	// return the size of the patrons array list
	public int getNumPeople() {
		return patrons.size();
	}

	// Setters
	public void setLibraryBooks(ArrayList<Book> libraryBooks) {
		this.libraryBooks = libraryBooks;
	}

	public void setPatrons(ArrayList<Person> patrons) {
		this.patrons = patrons;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	// return an int of the copies the library has of a certain book 
	// title and author have to be the same as bookIds can vary
	public int checkNumCopies( String title, String author) {
		int numberOfBooks = 0;
		for (Book book : libraryBooks) {
			if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
				numberOfBooks += 1;
			}
		}
		return numberOfBooks;
	}

	// will return the number of books the library has whether the book is 
	//  currently checked out or not
	public int totalNumBooks() {
		int books = 0;
		for (Book books2 : libraryBooks) {
			if (books2.isCheckedOut() == true) {
				books += 1;
			}
			if (books2.isCheckedOut() == false) {
				books += 1;
			}
		}
		return books;
	}
	// setCheckedOut to true
	// will set checked out to true for the book being checked out
	// will assign the dueDate for the book
	// will add the book to the person's array list of books currently checked out
	public boolean checkOut(Person p, Book b, String dueDate) {
		if (patrons.contains(p) && libraryBooks.contains(b)) {
			if (!libraryBooks.get(libraryBooks.indexOf(b)).isCheckedOut()) {

				libraryBooks.get(libraryBooks.indexOf(b)).setCheckedOut(true);

				libraryBooks.get(libraryBooks.indexOf(b)).setDueDate(dueDate);

				patrons.get(patrons.indexOf(p)).addBook(b);
				return true;
			}

		}
		return false;
	}
	
	// will return an array list of books due by a certain
	// date: format for date is as follows -- "dd MM yyyy"
	public ArrayList<Book> booksDueOnDate(String date) {
		ArrayList<Book> booksDue = new ArrayList<Book>();
		for (Book bookDue : libraryBooks) {
			if (bookDue.getDueDate().equals(date)) {
				booksDue.add(bookDue);
			}
		}
		return booksDue;
	}

	// calculates the late fee due for a book based on 
	// 1% of the book's value for every day the book is over due
	public double lateFee(Person p) {
		double bookFee = 0;  	
		for (Book bookDue : p.getCheckedOut()) {

			GregorianCalendar dueDate = new GregorianCalendar();

			GregorianCalendar currentDatecal = new GregorianCalendar();

			SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");



			Date bookDueOnDate = null;
			try {
				bookDueOnDate = format.parse(bookDue.getDueDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Date calendarDate = null;
			try {
				calendarDate = format.parse(currentDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dueDate.setTime(bookDueOnDate);
			currentDatecal.setTime(calendarDate);

			long millisec = dueDate.getTimeInMillis();

			long millisec1 = currentDatecal.getTimeInMillis();

			long difference = millisec1 - millisec;

			// converts the time into days to get a more accurate representation
			// of the fee that shall be paid for the book being over due
			int days = (int) (difference / (1000 * 3600 * 24));

			if(days < 0) {

				days = 0;

			}

			double feeDueOnBook = 0.01 * days * bookDue.getBookValue();

			bookFee += feeDueOnBook;

		}

		return bookFee;
	}

	public static void main(String[] args) {

	}

}





























