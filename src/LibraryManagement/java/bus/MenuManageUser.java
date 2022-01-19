package LibraryManagement.java.bus;

import java.util.Scanner;
import LibraryManagement.java.dao.BookDao;
import LibraryManagement.java.dao.UserDao;
import LibraryManagement.java.model.Book;
import LibraryManagement.java.model.User;

public class MenuManageUser {
  public MenuManageUser() {
    try {
      User newUser = new User();
      int choice;
      do {
        System.out.printf("======MENU=======\n");
        System.out.printf("1/User \n");
        System.out.printf("2/Insert User \n");
        System.out.printf("3/Delete User \n");
        System.out.printf("4/Update User \n");
        System.out.printf("5/Search \n");
        System.out.printf("------------------\n");
        System.out.printf("Chon chuc nang thuc hien:");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
          case 1:
            System.out.println(UserDao.getUser());
            break;
          case 2:
            UserBus.insertUser(newUser);
            break;
          case 3:
            UserBus.deleteUser(newUser);
            break;
          case 4:
            UserBus.editUser(newUser);
            break;
          case 5:
            UserDao.search();
            break;
          default:
            System.out.println("chon sai chuc nang\n");
            break;
        }
      } while (choice != 6);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

