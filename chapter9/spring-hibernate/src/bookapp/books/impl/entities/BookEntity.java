package books.impl.entities;

import books.api.entities.Book;
import javax.persistence.*;

@Entity
public class BookEntity implements Book {
  @Id @GeneratedValue
  private int id;
  private String title;
  private double price;

  public BookEntity() {}

  public BookEntity(String title, double price) {
    this.title = title;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
  
  public double getPrice() {
    return price;
  }

}
