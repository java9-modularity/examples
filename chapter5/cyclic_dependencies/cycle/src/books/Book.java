package books;

import authors.Author;

public class Book {
  private Author author;
  private String title;
  private String text;

  public Book(Author author, String title, String text) {
    this.author = author;
    this.text = text;
    this.title = title;
  }

  public void printBook() {
    System.out.printf("%s, by %s\n\n%s", title, author.getName(), text);
  }
}
