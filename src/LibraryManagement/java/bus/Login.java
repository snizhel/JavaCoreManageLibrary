package LibraryManagement.java.bus;

import java.util.Scanner;
import LibraryManagement.java.dao.AdminDao;
import LibraryManagement.java.dao.UserDao;
import LibraryManagement.java.model.Admin;
import LibraryManagement.java.model.User;


public class Login {
  UserDao user = new UserDao();
  AdminDao admin;

  public Login() {
    try {
      int choice;
      do {
        System.out.printf("======MENU=======\n");
        System.out.printf("1/Admin \n");
        System.out.printf("2/User \n");
        System.out.printf("------------------\n");
        System.out.printf("Chon chuc nang thuc hien:");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
          case 1:
            loginAdmin();
            break;
          case 2:
            loginUser();
            break;
          default:
            System.out.println("chon sai chuc nang\n");
        }

      } while (choice != 3);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void loginUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Username: ");
    String username1 = scanner.next();
    System.out.print("Password: ");
    String password1 = scanner.next();
    User user = UserDao.Login(username1, password1);
    
    if (user != null) {
      System.out.println("khach hang dang nhap thanh cong ");
      new MenuUser();
    } else
      System.out.println("khach hang dang nhap khong thanh cong ");
    scanner.close();
  }

  public void loginAdmin() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Username: ");
    String username = scanner.next();
    System.out.print("Password: ");
    String password = scanner.next();
    Admin admin = AdminDao.login(username, password);

    if (admin != null) {
      System.out.println("dang nhap thanh cong ");
      loginAdminSuccess();
    } else
      System.out.println("dang nhap khong thanh cong ");
    scanner.close();
  }

  private void loginAdminSuccess() {
    int choose;
    do {
      System.out.printf("======MENU FOR ADMIN=======\n");
      System.out.printf("1/Menu Book \n");
      System.out.printf("2/Menu User \n");
      System.out.printf("3/Menu Borrow voucher \n");
      System.out.printf("4/Exit\n");
      System.out.printf("------------------\n");
      System.out.printf("Chon menu thuc hien:");
      Scanner scanner = new Scanner(System.in);
      choose = scanner.nextInt();
      switch (choose) {
        case 1:
          new MenuAdmin();
          break;
        case 2:
          new MenuManageUser();
          break;
        case 3:
          new MenuPhieuMuon();
          break;
        default:
          System.out.println("chon sai chuc nang\n");

      }
    } while (choose != 4);

  }
}


