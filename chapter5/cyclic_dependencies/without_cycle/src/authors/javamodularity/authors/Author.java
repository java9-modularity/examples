package javamodularity.authors;

import javamodularity.books.Book;
import javamodularity.books.Named;

import java.util.List;
import java.util.ArrayList;

public class Author implements Named {
  private String name;
  private List<Book> books = new ArrayList<>();

  public Author(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  public void writeBook(String title, String text) {
    this.books.add(new Book(this, title, text));
  }

}
