public class Main {
    public static void main(String[] args){
        // This is used to test the program. :)
        BookLogic bookLogic = new BookLogic();

        bookLogic.importBooks("CSV", "book.csv");
        System.out.println(bookLogic.getTitles());

        bookLogic.removeBook("Title", "The lorax");
        System.out.println(bookLogic.getTitles());

        bookLogic.updateBook("over the garden wall", "title", "Dr Cucumber");
        System.out.println(bookLogic.getTitles());

        bookLogic.addBook("Lord of the Rings", "Squirtle", 2020);
        System.out.println(bookLogic.getTitles());

        bookLogic.getBook("Title", "Lord of the Rings").checkOut("mochi", "mochi@gmail.com");
        System.out.println(bookLogic.getBook("Title", "Lord of the Rings").getCheckoutDate());
        System.out.println(bookLogic.getBook("Title", "Lord of the Rings").getDueDate());

        new MainGUI();
    }
}
