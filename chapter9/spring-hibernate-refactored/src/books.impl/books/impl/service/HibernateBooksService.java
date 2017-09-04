package books.impl.service;

import books.api.entities.Book;
import books.api.service.BooksService;
import books.impl.entities.BookEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import javax.inject.Inject;

@Repository
@Transactional
public class HibernateBooksService implements BooksService {

  @Inject
  private SessionFactory sessionFactory;  

  public Book getBook(int id) {
    return sessionFactory.getCurrentSession().get(BookEntity.class, id);
  }

  public int createBook(String title, double price) {

    BookEntity entity = new BookEntity(title, price);
    sessionFactory.getCurrentSession().saveOrUpdate(entity);

    return entity.getId();
  }

}
