import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BookLogic {
    // Used to store the books.
    private ArrayList<Book> bookList;

    // Creates an empty catalog.
    public BookLogic(){
        bookList = new ArrayList<>();
    }

    /**
     * Adds a book to the catalog using the title, author, and year published.
     * @param title - The title of the book.
     * @param author - The author of the book.
     * @param yearPublished - The year the book was published.
     */
    public void addBook(String title, String author, int yearPublished){
        bookList.add(new Book(title, author, yearPublished));
    }

    /**
     * Removes a book from the catalog.
     * @param entryType - How to search for the book (title or author).
     * @param entry - The details of the book to remove.
     */
    public void removeBook(String entryType, String entry){
        String input = entry.toUpperCase();
        Book bookToRemove = new Book();

        // Used to find the book to remove
        switch (entryType.toUpperCase()){
            case "TITLE":
                for(Book book : bookList){
                    if(book.getTitle().toUpperCase().equals(input)){
                        bookToRemove = book;
                    }
                }
                break;
            case "AUTHOR":
                for(Book book : bookList){
                    if(book.getAuthor().toUpperCase().equals(input)){
                        bookToRemove = book;
                    }
                }
                break;
        }

        bookList.remove(bookToRemove);
    }

    /**
     * Removes a book from the catalog.
     * @param title - The title of the book to update.
     * @param entryType - How to update the book (title, author, or year).
     * @param newEntry - The new details of the book to overwrite the old.
     */
    public void updateBook(String title, String entryType, String newEntry){

        for(Book book : bookList) {
            if (book.getTitle().toUpperCase().equals(title)) {
                
                // Used to find the book to update
                switch (entryType.toUpperCase()) {
                    case "TITLE":  book.changeTitle(newEntry);
                    case "AUTHOR": book.changeAuthor(newEntry);
                    case "YEAR":   book.changeYear(Integer.parseInt(newEntry));
                }
            }
        }    
    }

    /**
     * Finds a book in the catalog.
     * @param entryType - How to search for the book (title or author).
     * @param entry - The details of the book.
     * @return The book.
     */
    public Book getBook(String entryType, String entry){
        String input = entry.toUpperCase();
        Book book = new Book();

        switch (entryType.toUpperCase()){
            case "TITLE":
                for(Book newBook : bookList){
                    if(newBook.getTitle().toUpperCase().equals(input)){
                        book = newBook;
                    }
                }
                break;
            case "AUTHOR":
                for(Book newBook : bookList){
                    if(newBook.getAuthor().toUpperCase().equals(input)){
                        book = newBook;
                    }
                }
                break;
        }
        return book;
    }

    /**
     * @return The book catalog.
     */
    public ArrayList<Book> getCollection() {
        return bookList;
    }

    /**
     * @return All titles of the books in the catalog.
     */
    public ArrayList<String> getTitles(){
        ArrayList<String> titles = new ArrayList<>();

        for(Book book : bookList){
            titles.add(book.getTitle());
        }
        return titles;
    }

    /**
     * @return All authors of the books in the catalog.
     */
    public ArrayList<String> getAuthors(){
        ArrayList<String> titles = new ArrayList<>();

        for(Book book : bookList){
            titles.add(book.getTitle());
        }
        return titles;
    }

    /**
     * @return All years published from the books in the catalog.
     */
    public ArrayList<String> getYears(){
        ArrayList<String> titles = new ArrayList<>();

        for(Book book : bookList){
            titles.add(book.getTitle());
        }
        return titles;
    }

    /**
     * Gets the book's details. 
     * @param book - The book to get the information of.
     * @return The title, author, and year published of the book.
     */
    public String getBookInfo(Book book){
        return book.getTitle() + ", " + book.getAuthor() + ", " + book.getYearPublished();
    }

    /**
     * Uses a csv file to enter the books into the catalog.
     * Uses a comma to separate the values.
     * Prints out an error message if the file cannot be read.
     */
    public void importBooks(){
        String split = ",";
        ArrayList<String> books = new ArrayList<>();

        try{
            File file = new File("book.csv");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                books.add(scanner.nextLine());
            }
            scanner.close();

        }catch(Exception e){
            System.out.println("Error reading file.");
        }

        for(String book : books){
            String[] bookInfo = book.split(split);
            addBook(bookInfo[0], bookInfo[1], Integer.parseInt(bookInfo[2]));
        }
    }
}
