package javamodularity.books;

public class Book {
  private Named author;
  private String title;
  private String text;

  public Book(Named author, String title, String text) {
    this.author = author;
    this.text = text;
    this.title = title;
  }

  public void printBook() {
    System.out.printf("%s, by %s\n\n%s", title, author.getName(), text);
  }
}
