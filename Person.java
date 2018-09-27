// Jhonathan Nivar (jn3hb)
// Homework 3: Person

import java.util.ArrayList;
public class Person {

	// initialized variables for the Person class
	private String name;
	// private int id;
	private ArrayList<Book> checkedOut;
	private String address;
	private int libraryCardNum;

	// Constructor
	public Person (String name, String address, int libraryCardNum) {
		this.name = name;
		this.address = address;
		this.libraryCardNum = libraryCardNum;
		// this.id = id;
		checkedOut = new ArrayList<Book>();
	}

	// Getters
	public String getName() {
		return name;
	}

	/*	public int getId() {
		return id;
	}*/

	public String getAddress() {
		return address;
	}

	public int getLibraryCardNum() {
		return libraryCardNum;
	}

	public ArrayList<Book> getCheckedOut() {
		return checkedOut;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// will add a book to the list of checked Out books if the book has been checked out
	public boolean addBook(Book b) {
		if (!(checkedOut.contains(b))) {
			this.checkedOut.add(b);
			return true;
		}
		return false;
	}

	// will return true if the person has checked out a book
	public boolean hasCheckedOut(Book b) {
		if (checkedOut.contains(b)) {
			return true;
		}
		return false;
	}

	// will remove the book from the person's list of books they've checked out if they can't remember checking
	// checking out the book in the first place
	public boolean forgetBook(Book b) {
		if (checkedOut.contains(b)) {
			checkedOut.remove(b);
			return true;
		}
		return false;
	}

	// will return the size of the arrayList of the number of books a person has checked out
	public int numBooksRead() {
		return checkedOut.size();
	}

	// will check if 2 library card numbers are the same meaning they are the same person
	public boolean equals(Object o) {

		if (o instanceof Person) {
			Person id_number = (Person) o;
			return (this.getLibraryCardNum() == id_number.getLibraryCardNum());
		}
		else
			return false;
	}

	// will return the name of a person, their ID number, and a list of their checked out books
	public String toString() {
		return "Name: " + this.name + " ID: " + this.libraryCardNum + " List of read books: " + this.checkedOut;
	}

	// will return a list of type Books of books two people have both read
	public static ArrayList<Book> commonBooks(Person a, Person b) {
		ArrayList<Book> booksRead = new ArrayList<Book>();
		for (Book bookA : a.checkedOut) {
			for ( Book bookB : b.checkedOut) {
				if (bookA.equals(bookB)) {
					booksRead.add(bookA);
				}
			}
		}
		return booksRead;
	}

	// Returns a measure of how similar the reading preferences of two readers are as a number between 0 and 1
	public static double similarity(Person a, Person b) {
		if ((a.getCheckedOut().size() == 0) || (b.getCheckedOut().size() == 0)) {
			return 0.0;
		}
		int numOfCommonBooks = commonBooks(a, b).size();
		if (a.getCheckedOut().size() <= b.getCheckedOut().size()) {
			double preference = numOfCommonBooks / (double) a.getCheckedOut().size();
			return preference;
		}
		else {
			double preference = numOfCommonBooks / (double) b.getCheckedOut().size();
			return preference;
		}
	}

	public static void main(String[] args) {
		/*		Book bootCamp = new Book("Boot Camp", "Todd Strasser");
		Book harryPotter = new Book("The Goblet of Fire", "J. K. Rowling");
		Book tkam = new Book("To Kill A Mockingbird", "Harper Lee");
		Person gracieW = new Person("Gracie Wright", 235645767);
		Person kathrynG = new Person("Kathryn Gimeno", 273826382);
		Person brianZ = new Person("Brian Zuluaga", 764269868);
		Person katDoppleganger = new Person("Kathryn G.", 273826382);

		System.out.println(kathrynG.addBook(harryPotter));
		System.out.println(gracieW.addBook(bootCamp));
		System.out.println(brianZ.addBook(tkam));

		System.out.println(kathrynG.hasRead(bootCamp));
		System.out.println(brianZ.hasRead(tkam));

		System.out.println(gracieW.forgetBook(bootCamp));
		System.out.println(kathrynG.forgetBook(bootCamp));

		System.out.println(brianZ.numBooksRead());
		System.out.println(gracieW.numBooksRead());

		System.out.println(kathrynG.equals(katDoppleganger));*/

	}

}

