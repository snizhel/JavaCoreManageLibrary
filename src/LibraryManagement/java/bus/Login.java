package LibraryManagement.java.bus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;
import LibraryManagement.java.dao.AdminDao;
import LibraryManagement.java.dao.DbConnection;
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
            Scanner input = new Scanner(System.in);
            System.out.print("Username: ");
            String username = input.next();
            System.out.print("Password: ");
            String password = input.next();
            Admin admin = AdminDao.Login(username, password);
            if (admin != null) {
              System.out.println("dang nhap thanh cong ");
              int choose;
              do {
                System.out.printf("======MENU FOR ADMIN=======\n");
                System.out.printf("1/Menu Book \n");
                System.out.printf("2/Menu User \n");
                System.out.printf("3/Menu Borrow voucher \n");
                System.out.printf("4/Exit\n");
                System.out.printf("------------------\n");
                System.out.printf("Chon menu thuc hien:");
                Scanner sc1 = new Scanner(System.in);
                choose = sc1.nextInt();
                switch (choose) {
                  case 1:
                    MenuAdmin menu = new MenuAdmin();
                    break;
                  case 2:
                    MenuManageUser menu1 = new MenuManageUser();
                    break;
                  case 3:
                    MenuPhieuMuon menu2 = new MenuPhieuMuon();
                    break;
                  default:
                    System.out.println("chon sai chuc nang\n");

                }
              } while (choose != 4);
            } else
              System.out.println("dang nhap khong thanh cong ");
            break;
          case 2:
            Scanner input1 = new Scanner(System.in);
            System.out.print("Username: ");
            String username1 = input1.next();
            System.out.print("Password: ");
            String password1 = input1.next();
            User user = UserDao.Login(username1, password1);
            if (user != null) {
              System.out.println("khach hang dang nhap thanh cong ");
              MenuUser menu = new MenuUser();
            } else
              System.out.println("khach hang dang nhap khong thanh cong ");
            break;

          default:
            System.out.println("chon sai chuc nang\n");
        }
      } while (choice != 3);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}


