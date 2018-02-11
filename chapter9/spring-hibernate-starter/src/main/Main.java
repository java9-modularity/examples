package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import books.api.service.BooksService;
import books.api.entities.Book;
import bookstore.api.service.BookstoreService;

public class Main {

  public void start() {
    System.out.println("Starting...");

    ApplicationContext context =
        new ClassPathXmlApplicationContext(new String[] {"classpath:/main.xml"});


    BooksService booksService = context.getBean(BooksService.class);
    BookstoreService store = context.getBean(BookstoreService.class);

    // Create some books
    int id1 = booksService.createBook("Java 9 Modularity", 45.0d);
    int id2 = booksService.createBook("Modular Cloud Apps with OSGi", 40.0d);
    printf("Created books with id [%d, %d]", id1, id2);

    // Retrieve them again
    Book book1 = booksService.getBook(id1);
    Book book2 = booksService.getBook(id2);  
    printf("Retrieved books:\n  %d: %s [%.2f]\n  %d: %s [%.2f]",
        id1, book1.getTitle(), book1.getPrice(), id2, book2.getTitle(), book2.getPrice());

    // Use the other service to calculate a total
    double total = store.calculatePrice(id1, id2);
    printf("Total price (with tax): %.2f", total);

  }

  public static void main(String[] args) {
    new Main().start();
  }

  private void printf(String msg, Object... args) {
    System.out.println(String.format(msg + "\n", args));
  }
}
