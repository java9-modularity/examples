package books.api.service;

import books.api.entities.Book;

public interface BooksService {
  Book getBook(int id);
  int createBook(String title, double price);
}
