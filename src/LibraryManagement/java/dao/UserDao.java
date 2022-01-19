package LibraryManagement.java.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import LibraryManagement.java.model.Book;
import LibraryManagement.java.model.User;


public class UserDao {
  public static PreparedStatement peparedStatement;
  public static ResultSet resultSet;

  public static User Login(String taiKhoan, String pass) {
    User user = null;
    try {
      peparedStatement = DbConnection.getConnect()
          .prepareStatement("SELECT * FROM KHACH_HANG where Ma_Khach_hang = ? and Password=?");
      peparedStatement.setString(1, taiKhoan);
      peparedStatement.setString(2, pass);
      resultSet = peparedStatement.executeQuery();
      while (resultSet.next()) {
        user = new User();

        user.setBirth(resultSet.getDate("Ngay_sinh"));
        user.setName(resultSet.getString("Ten_Khach_hang"));
        user.setDiaChi(resultSet.getString("Dia_chi"));
        user.setPhone(resultSet.getString("Phone"));
      }
    } catch (Exception e) {
      return user = null;
    }
    return user;
  }


  public static ResultSet showTextfield(String sql) {
    try {
      peparedStatement = DbConnection.getConnect().prepareStatement(sql);
      return peparedStatement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }

  public static void insertUser(User kh) {
    String sql = "insert into KHACH_HANG values(?,?,?,?,?,?,null)";
    try {
      peparedStatement = DbConnection.getConnect().prepareStatement(sql);
      peparedStatement.setString(1, kh.getMaKH());
      peparedStatement.setString(2, kh.getPass());
      peparedStatement.setString(3, kh.getName());
      peparedStatement.setDate(4, kh.getBirth());
      peparedStatement.setString(5, kh.getDiaChi());
      peparedStatement.setString(6, kh.getPhone());

      peparedStatement.execute();
      System.out.println("Them khach hang thanh cong");
    } catch (Exception e) {
      System.out.println("Them khach hang khong thanh cong");
    }
  }

  public static boolean updateUser(User kh) {
    try {
      peparedStatement = DbConnection.getConnect()
          .prepareStatement("UPDATE KHACH_HANG SET Password = ?, Ten_Khach_hang = ?,"
              + "Ngay_sinh = ?, Dia_chi = ?, Phone = ? where Ma_Khach_hang = ?");
      peparedStatement.setString(6, kh.getMaKH());
      peparedStatement.setString(1, kh.getPass());
      peparedStatement.setString(2, kh.getName());
      peparedStatement.setDate(3, kh.getBirth());
      peparedStatement.setString(4, kh.getDiaChi());
      peparedStatement.setString(5, kh.getPhone());
      return peparedStatement.executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean deleteUser(String maKH) {
    try {
      peparedStatement = DbConnection.getConnect()
          .prepareStatement("DELETE FROM KHACH_HANG WHERE Ma_Khach_hang = ?");
      peparedStatement.setString(1, maKH);
      return peparedStatement.executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static List<User> getUser() {
    try {
      List<User> listUser = new ArrayList<User>();
      PreparedStatement pstmt =
          DbConnection.getConnect().prepareStatement("SELECT * from KHACH_HANG");
      ResultSet resultSet = pstmt.executeQuery();
      while (resultSet.next()) {
        User user = new User();
        user.setMaKH(resultSet.getObject("ma_khach_hang", String.class));
        user.setName(resultSet.getObject("ten_khach_hang", String.class));
        user.setPass(resultSet.getObject("password", String.class));
        user.setDiaChi(resultSet.getObject("dia_chi", String.class));
        user.setBirth(resultSet.getObject("ngay_sinh", Date.class));
        user.setPhone(resultSet.getObject("phone", String.class));
        listUser.add(user);
      }
      return listUser;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return Collections.emptyList();
  }
  public static void search() {
    try {
      List<User> listUser = new ArrayList<User>();
      Scanner input = new Scanner(System.in);
      System.out.print("Search: ");
      Statement smt = DbConnection.getConnect().createStatement();
      String sql = "SELECT * from KHACH_HANG WHERE Ma_Khach_Hang like N'%" + input.next() + "%'";
      ResultSet resultSet = smt.executeQuery(sql);
      while (resultSet.next()) {
        User user = new User();
        user.setMaKH(resultSet.getObject("ma_khach_hang", String.class));
        user.setName(resultSet.getObject("ten_khach_hang", String.class));
        user.setPass(resultSet.getObject("password", String.class));
        user.setDiaChi(resultSet.getObject("dia_chi", String.class));
        user.setBirth(resultSet.getObject("ngay_sinh", Date.class));
        user.setPhone(resultSet.getObject("phone", String.class));
        listUser.add(user);
      }
      System.out.println(listUser);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }


}

