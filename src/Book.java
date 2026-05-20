public class Book {
    // Book properties.
    private String title;
    private String author;
    private int yearPublished;

    private boolean checkedOut;

    private String loaner; // The name of the person who checked out the book.
    private String email; // As in the email address.
    private int loanDate; // In 00.00.00 format ex. 05.05.26

    // Creates an empty book.
    public Book(){
        title = "";
        author = "";
        yearPublished = 0;
        checkedOut = false;
        loaner = "";
        email = "";
        loanDate = 0;
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
        this.loanDate = 0;
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
     * This is to be used to keep track of who is responsible for the book.
     * @param name - The name of the person who checked out the book.
     * @param address - The email address of the person who checked out the book.
     * @param date - The date the book was checked out.
     */
    public void checkOut(String name, String address, int date){
        loaner = name;
        email = address;
        loanDate = date;

        checkedOut = true;
    }
}
