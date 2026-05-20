public class Main {
    public static void main(String args[]){
        // This is used to test the program. :)
        BookLogic bookLogic = new BookLogic();

        bookLogic.importBooks();
        System.out.println(bookLogic.getTitles());

        bookLogic.removeBook("Title", "The lorax");
        System.out.println(bookLogic.getTitles());

        bookLogic.updateBook("over the garden wall", "title", "dr cucumber");
        System.out.println(bookLogic.getTitles());

        bookLogic.addBook("lord of the rings", "squirtle", 2020);
        System.out.println(bookLogic.getTitles());

        System.out.print(bookLogic.getBook("author", "squirtle"));
    }
}
