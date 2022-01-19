package LibraryManagement.java.bus;

import java.util.ArrayList;
import java.util.Scanner;
import LibraryManagement.java.dao.AdminDao;
import LibraryManagement.java.dao.BookDao;
import LibraryManagement.java.dao.UserDao;
import LibraryManagement.java.model.Admin;
import LibraryManagement.java.model.Book;
import LibraryManagement.java.model.User;
import java.sql.ResultSet;

public class MenuAdmin {
  public MenuAdmin() {
    try {
      Book newBook = new Book();
      int choice;        
      Scanner sc = new Scanner(System.in);
      do {
        System.out.printf("======MENU=======\n");
        System.out.printf("1/Book \n");
        System.out.printf("2/Insert Book \n");
        System.out.printf("3/Delete Book \n");
        System.out.printf("4/Update Book \n");
        System.out.printf("5/Search \n");
        System.out.printf("------------------\n");
        System.out.printf("Chon chuc nang thuc hien:");
        choice = sc.nextInt();
        switch (choice) {
          case 1:
            System.out.println(BookDao.getBook());
            break;
          case 2:
            BookBus.insertBook(newBook);
            break;
          case 3:
            BookBus.deleteBook();
            break;
          case 4:
            BookBus.updateBook(newBook);
            break;
          case 5:
            BookDao.search();
            break;
          default:
            System.out.println("chon sai chuc nang\n");
            break;
        }
      } while (choice != 6);
     
      sc.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}


