package LibraryManagement.java.bus;

import java.util.Scanner;
import LibraryManagement.java.dao.BookDao;
import LibraryManagement.java.model.Book;

public class BookBus {
  private BookBus() {}

  public static boolean insertBook(Book newBook) {
    System.out.println(newBook);
    BookDao.insertSach(newBook);
    return true;
  }

  public static boolean updateBook(Book newBook) {
    System.out.println(newBook);
    BookDao.updateSach(newBook);
    return true;
  }
}
