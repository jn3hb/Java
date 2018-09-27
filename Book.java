// Jhonathan Nivar (jn3hb)
// Homework 3: Book
public class Book {

	// initialized variables 
	private String title;
	private String author;
	private String dueDate;
	private boolean checkedOut;
	private int bookId;
	private double bookValue;

	// constructor
	public Book (String title, String author, int bookId, double bookValue) {
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.bookValue = bookValue;
		this.dueDate = "";
	}

	// Getters 
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCheckedOut() {
		return this.checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public double getBookValue() {
		return this.bookValue;
	}

	public void setBookValue(double bookValue) {
		this.bookValue = bookValue;
	}

	public int getBookId() {
		return this.bookId;
	}

	// .equals() method 
	// comparing the bookId of two Book objects to check if they're the same book as ID's are unique to one book
	public boolean equals(Object b) {

		if (b instanceof Book) {
			Book b2 = (Book) b;
			return (this.bookId == b2.bookId) ; // if the bookId is the same we have the same book
		}

		else
			return false; // not a Book object
	}

	// .toString() method will return the Id of the book
	public String toString() {
		return "Book ID: " + this.bookId;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
