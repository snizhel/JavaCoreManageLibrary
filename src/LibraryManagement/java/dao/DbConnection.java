package LibraryManagement.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
  private DbConnection() {}
  public static Connection getConnect() {
    try {
      return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qltv", "root", "admin");
    } catch (Exception e) {
      System.out.println("connect failed");
      e.printStackTrace();
      return null;
    }
  }
}
