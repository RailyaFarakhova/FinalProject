import java.util.Calendar;
import java.util.Date;

public class Book {
    // Book properties.
    private String title;
    private String author;
    private int yearPublished;

    private boolean checkedOut;

    private String loaner; // The name of the person who checked out the book.
    private String email; // As in the email address.
    private Calendar dueDate; // In 00.00.00 format ex. 05.05.26
    private Calendar loanDate;

    // Creates an empty book.
    public Book(){
        title = "";
        author = "";
        yearPublished = 0;
        checkedOut = false;
        loaner = "";
        email = "";
        dueDate = Calendar.getInstance();
        loanDate = Calendar.getInstance();
    }

    /**
     * Creates a book with using details provided.
     * Sets all other properties to be empty.
     * @param title - The title of the book.
     * @param author - The author of the book.
     * @param yearPublished - The year the book was published.
     */
    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
        this.loaner = "";
        this.email = "";
        this.dueDate = Calendar.getInstance();
        this.loanDate = Calendar.getInstance();
    }

    /**
     * Gets the book's title.
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the book's author.
     * @return The author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the year the book was published.
     * @return The year published.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Gets the date the book was checked out.
     * Follows a month, day, and year format.
     * @return The date.
     */
    public String getCheckoutDate() {
        return loanDate.get(Calendar.MONTH) + "/"
                + loanDate.get(Calendar.DAY_OF_MONTH) + "/"
                + loanDate.get(Calendar.YEAR);
    }

    /**
     * Gets the book's due date.
     * Follows a month, day, and year format.
     * This is two weeks after the book was checked out.
     * @return The date.
     */
    public String getDueDate(){
        return dueDate.get(Calendar.MONTH) + "/"
                + loanDate.get(Calendar.DAY_OF_MONTH) + "/"
                + loanDate.get(Calendar.YEAR);
    }

    /**
     * Changes the book's title.
     * @param newTitle - The new book title.
     */
    public void changeTitle(String newTitle){
        title = newTitle;
    }

    /**
     * Changes the book's author.
     * @param newAuthor - The new author.
     */
    public void changeAuthor(String newAuthor){
        author = newAuthor;
    }

    /**
     * Changes the year the book was published.
     * @param newYear - The new publishing year.
     */
    public void changeYear(String newYear){
        yearPublished = Integer.parseInt(newYear);
    }

    /**
     * Replaces the book's checkout details to the provided.
     * Sets the book's due date two weeks after the checkout date.
     * This is to be used to keep track of who is responsible for the book.
     * @param name - The name of the person who checked out the book.
     * @param address - The email address of the person who checked out the book.
     */
    public void checkOut(String name, String address){
        loaner = name;
        email = address;
        loanDate = Calendar.getInstance();
        dueDate.add(Calendar.DATE, 14);

        checkedOut = true;
    }
}
