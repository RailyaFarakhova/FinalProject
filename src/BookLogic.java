import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BookLogic {
    // Used to store the books.
    private final ArrayList<Book> bookList;

    // Creates an empty catalog.
    public BookLogic(){
        bookList = new ArrayList<>();
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
        ArrayList<String> authors = new ArrayList<>();

        for(Book book : bookList){
            authors.add(book.getAuthor());
        }
        return authors;
    }

    /**
     * @return All years published from the books in the catalog.
     */
    public ArrayList<Integer> getYears(){
        ArrayList<Integer> years = new ArrayList<>();

        for(Book book : bookList){
            years.add(book.getYearPublished());
        }
        return years;
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
        bookList.remove(getBook(entryType, entry));
    }

    /**
     * Removes a book from the catalog.
     * @param title - The title of the book to update.
     * @param entryType - How to update the book (title, author, or year).
     * @param newEntry - The new details of the book to overwrite the old.
     */
    public void updateBook(String title, String entryType, String newEntry){
        Book book = getBook(entryType, title);

        switch (entryType.toUpperCase()) {
            case "TITLE":  book.changeTitle(newEntry); break;
            case "AUTHOR": book.changeAuthor(newEntry); break;
            case "YEAR":   book.changeYear(newEntry); break;
        }
    }

    /**
     * Enters the books into the catalog from a file.
     * Uses a comma to separate the values for CSV files
     * Uses a tab to separate the values for TSV files.
     * Prints out an error message if the file cannot be read.
     * @param fileType - The type of file to import.
     * @param fileName - The name of the file to import.
     */
    public void importBooks(String fileType, String fileName){
        String split = "";

        if(fileType.toUpperCase().equals("TSV")){
             split = "\t";
        } else if (fileType.toUpperCase().equals("CSV")){
            split = ",";
        }

        ArrayList<String> books = new ArrayList<>();

        try{
            File file = new File(fileName);
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
