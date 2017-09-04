package bookstore.api.service;

import books.api.service.BooksService;

public interface BookstoreService {
  double calculatePrice(int... bookIds);
}
