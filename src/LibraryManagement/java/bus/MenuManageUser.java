package LibraryManagement.java.bus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import LibraryManagement.java.dao.BookDao;
import LibraryManagement.java.dao.UserDao;
import LibraryManagement.java.model.Book;
import LibraryManagement.java.model.User;

public class MenuManageUser {
  public MenuManageUser() {
    try {

      int choice;
      do {
        System.out.printf("======MENU=======\n");
        System.out.printf("1/Danh sach khach hang \n");
        System.out.printf("2/Dang ky khach hang \n");
        System.out.printf("3/Xoa khach hang \n");
        System.out.printf("4/Cap nhat khach hang \n");
        System.out.printf("5/Tim kiem khach hang \n");
        System.out.printf("6/Thoat\n");
        System.out.printf("------------------\n");
        System.out.printf("Chon chuc nang thuc hien:");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
          case 1:
            System.out.println(UserDao.getUser());
            break;
          case 2:
            insertUser();
            break;
          case 3:
            deleteUser();
            break;
          case 4:
            editUser();
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

  private boolean deleteUser() {
    Scanner input = new Scanner(System.in);
    System.out.println("ID USER:");
    String idUser = input.nextLine();
    UserDao.deleteUser(idUser);
    System.out.println("Delete successfull");
    return true;
    

  }

  private void editUser() {
    User newUser = new User();
    Scanner input = new Scanner(System.in);
    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    java.sql.Date dob;
    Date apptDay = null;
    System.out.println("ID User:");
    String id = input.nextLine();
    System.out.println("Name:");
    String name = input.nextLine();
    System.out.println("Password:");
    String password = input.nextLine();
    System.out.println("Address:");
    String address = input.nextLine();
    System.out.println("Phone:");
    String Phone = input.nextLine();
    System.out.println("Birth(dd-MM-yyyy):");
    while (apptDay == null) {
      try {
        String birth = input.nextLine();
        apptDay = (Date) format.parse(birth);
      } catch (ParseException e) {
        System.out.println("Please enter a valid date! Format is yyyy/mm/dd");

      }
    }
    dob = new java.sql.Date(apptDay.getTime());
    newUser.setMaKH(id);
    newUser.setName(name);
    newUser.setPass(password);
    newUser.setBirth(dob);
    newUser.setDiaChi(address);
    newUser.setPhone(Phone);
    UserBus.editUser(newUser);
    
  }

  private void insertUser() {
    User newUser = new User();
    Scanner input = new Scanner(System.in);
    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    java.sql.Date dob;
    Date apptDay = null;
    System.out.println("ID User:");
    String id = input.nextLine();
    System.out.println("Name:");
    String name = input.nextLine();
    System.out.println("Password:");
    String password = input.nextLine();
    System.out.println("Address:");
    String address = input.nextLine();
    System.out.println("Phone:");
    String Phone = input.nextLine();
    System.out.println("Birth(dd-MM-yyyy):");
    while (apptDay == null) {
      try {
        String birth = input.nextLine();
        apptDay = (Date) format.parse(birth);
      } catch (ParseException e) {
        System.out.println("Please enter a valid date! Format is yyyy/mm/dd");
      }
    }
    dob = new java.sql.Date(apptDay.getTime());
    newUser.setMaKH(id);
    newUser.setName(name);
    newUser.setPass(password);
    newUser.setBirth(dob);
    newUser.setDiaChi(address);
    newUser.setPhone(Phone);
    UserBus.insertUser(newUser);
    
  }
}

