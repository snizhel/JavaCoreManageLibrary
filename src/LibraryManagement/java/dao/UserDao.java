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



  public static User Login(String taiKhoan, String pass) {
    User user = null;
    try {
      String sql = "SELECT * FROM KHACH_HANG where Ma_Khach_hang = ? and Password=?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(taiKhoan);
      listParam.add(pass);
      ResultSet resultSet = DbConnection.prepareSQL(sql, listParam).executeQuery();
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



  public static void insertUser(User user) {
    String sql = "insert into KHACH_HANG values(?,?,?,?,?,?,null)";
    List<Object> listParam = new ArrayList<>();
    try {
      listParam.add(user.getMaKH());
      listParam.add(user.getPass());
      listParam.add(user.getName());
      listParam.add(user.getBirth());
      listParam.add(user.getDiaChi());
      listParam.add(user.getPhone());
      DbConnection.prepareSQL(sql, listParam).execute();
      System.out.println("Them khach hang thanh cong");
    } catch (Exception e) {
      System.out.println("Them khach hang khong thanh cong");
    }
  }

  public static boolean updateUser(User user) {
    try {
      String sql = "UPDATE KHACH_HANG SET Password = ?, Ten_Khach_hang = ?,"
          + "Ngay_sinh = ?, Dia_chi = ?, Phone = ? where Ma_Khach_hang = ?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(user.getPass());
      listParam.add(user.getName());
      listParam.add(user.getBirth());
      listParam.add(user.getDiaChi());
      listParam.add(user.getPhone());
      listParam.add(user.getMaKH());
      return DbConnection.prepareSQL(sql, listParam).executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean deleteUser(String maKH) {
    try {
      String sql = "DELETE FROM KHACH_HANG WHERE Ma_Khach_hang = ?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(maKH);
      return DbConnection.prepareSQL(sql, listParam).executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static List<Object> getUser() {
    try {
      List<Object> listParam = new ArrayList<>();
      String sql = "SELECT * from KHACH_HANG";
      ResultSet resultSet = DbConnection.prepareSQL(sql, listParam).executeQuery();
      while (resultSet.next()) {
        User user = new User();
        user.setMaKH(resultSet.getObject("ma_khach_hang", String.class));
        user.setName(resultSet.getObject("ten_khach_hang", String.class));
        user.setPass(resultSet.getObject("password", String.class));
        user.setDiaChi(resultSet.getObject("dia_chi", String.class));
        user.setBirth(resultSet.getObject("ngay_sinh", Date.class));
        user.setPhone(resultSet.getObject("phone", String.class));
        listParam.add(user);
      }
      return listParam;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }

  public static void search() {
    try {
      List<Object> listParam = new ArrayList<>();
      Scanner input = new Scanner(System.in);
      System.out.print("Search: ");
      String sql = "SELECT * from KHACH_HANG WHERE Ma_Khach_Hang like N'%" + input.next() + "%'";
      ResultSet resultSet = DbConnection.prepareSQL(sql, listParam).executeQuery(sql);
      while (resultSet.next()) {
        User user = new User();
        user.setMaKH(resultSet.getObject("ma_khach_hang", String.class));
        user.setName(resultSet.getObject("ten_khach_hang", String.class));
        user.setPass(resultSet.getObject("password", String.class));
        user.setDiaChi(resultSet.getObject("dia_chi", String.class));
        user.setBirth(resultSet.getObject("ngay_sinh", Date.class));
        user.setPhone(resultSet.getObject("phone", String.class));
        listParam.add(user);
      }
      System.out.println(listParam);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


}

