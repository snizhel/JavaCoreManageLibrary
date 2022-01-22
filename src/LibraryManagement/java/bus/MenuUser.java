package LibraryManagement.java.bus;

import java.util.Scanner;
import LibraryManagement.java.dao.BookDao;

public class MenuUser {
  public MenuUser() {
    try {
      int choice;
      do {
        System.out.printf("======MENU=======\n");
        System.out.printf("1/Sach trong thu vien \n");
        System.out.printf("2/Tim kiem sach \n");
        System.out.printf("3/Thoat\n");
        System.out.printf("------------------\n");
        System.out.printf("Chon chuc nang thuc hien:");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
          case 1:
            System.out.println(BookDao.getBook());
            break;
          case 2:
            BookDao.search();
            break;
          default:
            System.out.println("chon sai chuc nang\n");
            break;
        }
      } while (choice != 3);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
