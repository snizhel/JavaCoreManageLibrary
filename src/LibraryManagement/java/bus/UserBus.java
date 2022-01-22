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
    UserDao.insertUser(newUser);
    System.out.println(newUser);
    return true;
  }

  public static boolean editUser(User newUser) {
    UserDao.updateUser(newUser);
    System.out.println(newUser);
    return true;
  }
}
