package LibraryManagement.java.bus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import LibraryManagement.java.dao.BookDao;
import LibraryManagement.java.dao.UserDao;
import LibraryManagement.java.model.User;

public class UserBus {
  public static boolean insertUser(User newUser) {
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
        return false;
      }
    }
    dob = new java.sql.Date(apptDay.getTime());
    newUser.setMaKH(id);
    newUser.setName(name);
    newUser.setPass(password);
    newUser.setBirth(dob);
    newUser.setDiaChi(address);
    newUser.setPhone(Phone);
    UserDao.insertUser(newUser);
    System.out.println(newUser);
    return true;
  }

  public static boolean deleteUser(User newUser) {
    Scanner input = new Scanner(System.in);
    System.out.println("ID USER:");
    String idUser = input.nextLine();
    UserDao.deleteUser(idUser);
    System.out.println("Delete successfull");
    return true;
  }

  public static boolean editUser(User newUser) {
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
        return false;
      }
    }
    dob = new java.sql.Date(apptDay.getTime());
    newUser.setMaKH(id);
    newUser.setName(name);
    newUser.setPass(password);
    newUser.setBirth(dob);
    newUser.setDiaChi(address);
    newUser.setPhone(Phone);
    UserDao.updateUser(newUser);
    System.out.println(newUser);
    return true;
  }
}
