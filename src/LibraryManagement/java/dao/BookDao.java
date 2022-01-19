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
      preparedStatement = DbConnection.getConnect().prepareStatement(sql);
      return preparedStatement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }

  public static void insertSach(Book book) {
    String sql = "insert into SACH values(?,?,?,?,?,?,null)";
    try {
      preparedStatement = DbConnection.getConnect().prepareStatement(sql);
      System.out.println(preparedStatement);
      preparedStatement.setString(1, book.getMaSach());
      preparedStatement.setString(2, book.getTenSach());
      preparedStatement.setString(3, book.getTenTacGia());
      preparedStatement.setString(4, book.getNhaXB());
      preparedStatement.setInt(5, book.getGiaTien());
      preparedStatement.setInt(6, book.getSoLuong());
      preparedStatement.execute();
      System.out.println("them thanh cong");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static boolean updateSach(Book s) {
    try {
      preparedStatement = DbConnection.getConnect()
          .prepareStatement("UPDATE SACH SET  Ten_Sach = ?, Ten_Tac_gia = ?,"
              + "Nha_xb = ?, Gia_tien = ?, So_luong = ? where Ma_Sach = ?");
      preparedStatement.setString(6, s.getMaSach());
      preparedStatement.setString(1, s.getTenSach());
      preparedStatement.setString(2, s.getTenTacGia());
      preparedStatement.setString(3, s.getNhaXB());
      preparedStatement.setInt(4, s.getGiaTien());
      preparedStatement.setInt(5, s.getSoLuong());
      return preparedStatement.executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean deleteSach(String ms) {
    try {
      preparedStatement =
          DbConnection.getConnect().prepareStatement("DELETE FROM SACH WHERE Ma_Sach = ?");
      preparedStatement.setString(1, ms);
      return preparedStatement.executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static List<Book> getBook() {
    try {
      List<Book> listBook = new ArrayList<Book>();
      PreparedStatement pstmt = DbConnection.getConnect().prepareStatement("SELECT * from SACH");
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
      Statement smt = DbConnection.getConnect().createStatement();
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

