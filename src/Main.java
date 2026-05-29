public class Main {
    public static void main(String args[]){
        // This is used to test the program. :)
        BookLogic bookLogic = new BookLogic();

        bookLogic.importBooksCSV("book.csv");
        System.out.println(bookLogic.getTitles());

//        bookLogic.removeBook("Title", "The lorax");
//        System.out.println(bookLogic.getTitles());
//
//        bookLogic.updateBook("over the garden wall", "title", "Dr Cucumber");
//        System.out.println(bookLogic.getTitles());
//
//        bookLogic.addBook("Lord of the Rings", "Squirtle", 2020);
//        System.out.println(bookLogic.getTitles());

        bookLogic.getBook("Title", "The lorax").checkOut("mochi", "mochi@gmail.com");
        System.out.println(bookLogic.getBook("Title", "The lorax").getCheckoutDate());
        System.out.println(bookLogic.getBook("Title", "The lorax").getDueDate());

        new MainGUI();
    }
}
