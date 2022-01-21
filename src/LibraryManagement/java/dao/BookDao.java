package LibraryManagement.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import LibraryManagement.java.model.Book;


public class BookDao {
  public static PreparedStatement preparedStatement;
  public static ResultSet resultSet;

  private BookDao() {}

  public static ResultSet showTextfield(String sql) {
    try {
      preparedStatement = DbConnection.getConnection().prepareStatement(sql);
      return preparedStatement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }

  public static void insertSach(Book book) {
    String sql = "insert into SACH values(?,?,?,?,?,?,null)";
    try {
      List<Object> listParam = new ArrayList<>();
      listParam.add(book.getMaSach());
      listParam.add(book.getTenSach());
      listParam.add(book.getTenTacGia());
      listParam.add(book.getNhaXB());
      listParam.add(book.getGiaTien());
      listParam.add(book.getSoLuong());
      DbConnection.prepareSQL(sql, listParam).execute();
      System.out.println("them thanh cong");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static boolean updateSach(Book s) {
    try {
      String sql = "UPDATE SACH SET  Ten_Sach = ?, Ten_Tac_gia = ?,"
          + "Nha_xb = ?, Gia_tien = ?, So_luong = ? where Ma_Sach = ?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(s.getTenSach());
      listParam.add(s.getTenTacGia());
      listParam.add(s.getNhaXB());
      listParam.add(s.getGiaTien());
      listParam.add(s.getSoLuong());
      listParam.add(s.getMaSach());
      preparedStatement = DbConnection.prepareSQL(sql, listParam);
      int result = preparedStatement.executeUpdate();
      return result > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean deleteSach(String idBook) {
    try {
      String sql = "DELETE FROM SACH WHERE Ma_Sach = ?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(idBook);
      return DbConnection.prepareSQL(sql, listParam).executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static List<Book> getBook() {
    try {
      List<Book> listBook = new ArrayList<>();
      PreparedStatement pstmt = DbConnection.prepareSQL("SELECT * from SACH");
      ResultSet resultSet = pstmt.executeQuery();
      while (resultSet.next()) {
        Book book = new Book();
        book.setGiaTien(resultSet.getObject("gia_tien", Integer.class));
        book.setMaSach(resultSet.getObject("ma_sach", String.class));
        book.setNhaXB(resultSet.getObject("nha_xb", String.class));
        book.setSoLuong(resultSet.getObject("so_luong", Integer.class));
        book.setTenSach(resultSet.getObject("ten_sach", String.class));
        book.setTenTacGia(resultSet.getObject("ten_tac_gia", String.class));
        listBook.add(book);
      }
      return listBook;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return Collections.emptyList();
  }

  public static void search() {
    try {
      List<Book> listBook = new ArrayList<Book>();
      Scanner input = new Scanner(System.in);
      System.out.print("Search: ");
      Statement smt = DbConnection.getConnection().createStatement();
      String sql = "SELECT * from SACH WHERE Ma_Sach like N'%" + input.next() + "%'";
      ResultSet resultSet = smt.executeQuery(sql);
      while (resultSet.next()) {
        Book book = new Book();
        book.setGiaTien(resultSet.getObject("gia_tien", Integer.class));
        book.setMaSach(resultSet.getObject("ma_sach", String.class));
        book.setNhaXB(resultSet.getObject("nha_xb", String.class));
        book.setSoLuong(resultSet.getObject("so_luong", Integer.class));
        book.setTenSach(resultSet.getObject("ten_sach", String.class));
        book.setTenTacGia(resultSet.getObject("ten_tac_gia", String.class));
        listBook.add(book);
      }
      System.out.println(listBook);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}

