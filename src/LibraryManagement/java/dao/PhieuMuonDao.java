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
import LibraryManagement.java.model.PhieuMuon;


public class PhieuMuonDao {
  public static PreparedStatement preparedStatement;
  public static ResultSet resultSet;

  public static ResultSet showTextfield(String sql) {
    try {
      preparedStatement = DbConnection.getConnection().prepareStatement(sql);
      return preparedStatement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }

  public static void insertPhieu(PhieuMuon phieuMuon) {
    String sql = "insert into PHIEU_MUON values(?,?,?,?,?,null,null,null)";
    List<Object> listParam = new ArrayList<>();
    try {
      listParam.add(phieuMuon.getMaMuon());
      listParam.add(phieuMuon.getMaKhach());
      listParam.add(phieuMuon.getSach());
      listParam.add(phieuMuon.getNgayMuon());
      listParam.add(phieuMuon.getHanTra());
      DbConnection.prepareSQL(sql, listParam).execute();
      System.out.println("them thanh cong");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static boolean updatePhieu(PhieuMuon phieuMuon) {
    try {
      String sql = "UPDATE PHIEU_MUON SET  Ma_Khach_hang = ?, Ma_Sach = ?,"
          + "Ngay_muon = ?, Han_tra = ? where Ma_Phieu_muon = ?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(phieuMuon.getMaMuon());
      listParam.add(phieuMuon.getMaKhach());
      listParam.add(phieuMuon.getSach());
      listParam.add(phieuMuon.getNgayMuon());
      listParam.add(phieuMuon.getHanTra());
      return DbConnection.prepareSQL(sql, listParam).executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean deletePhieu(String maMuon) {
    try {
      String sql = "DELETE FROM PHIEU_MUON WHERE Ma_Phieu_muon = ?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(maMuon);
      return DbConnection.prepareSQL(sql, listParam).executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static List<PhieuMuon> getPhieuMuon() {
    try {
      List<PhieuMuon> listPhieuMuon = new ArrayList<PhieuMuon>();
      PreparedStatement pstmt =
          DbConnection.getConnection().prepareStatement("SELECT * from PHIEU_MUON");
      ResultSet resultSet = pstmt.executeQuery();
      while (resultSet.next()) {
        PhieuMuon PhieuMuon = new PhieuMuon();
        PhieuMuon.setMaMuon(resultSet.getObject("ma_phieu_muon", String.class));
        PhieuMuon.setMaKhach(resultSet.getObject("ma_khach_hang", String.class));
        PhieuMuon.setMaSach(resultSet.getObject("ma_sach", String.class));
        PhieuMuon.setNgayMuon(resultSet.getObject("ngay_muon", Date.class));
        PhieuMuon.setHanTra(resultSet.getObject("han_tra", Date.class));
        listPhieuMuon.add(PhieuMuon);
      }
      return listPhieuMuon;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return Collections.emptyList();
  }

  public static void search() {
    try {
      List<PhieuMuon> listPhieuMuon = new ArrayList<PhieuMuon>();
      Scanner input = new Scanner(System.in);
      System.out.print("Search: ");
      Statement smt = DbConnection.getConnection().createStatement();
      String sql = "SELECT * from PHIEU_MUON WHERE Ma_Phieu_Muon like N'%" + input.next() + "%'";
      ResultSet resultSet = smt.executeQuery(sql);
      while (resultSet.next()) {
        PhieuMuon PhieuMuon = new PhieuMuon();
        PhieuMuon.setMaMuon(resultSet.getObject("ma_phieu_muon", String.class));
        PhieuMuon.setMaKhach(resultSet.getObject("ma_khach_hang", String.class));
        PhieuMuon.setMaSach(resultSet.getObject("ma_sach", String.class));
        PhieuMuon.setNgayMuon(resultSet.getObject("ngay_muon", Date.class));
        PhieuMuon.setHanTra(resultSet.getObject("han_tra", Date.class));
        listPhieuMuon.add(PhieuMuon);
      }
      System.out.println(listPhieuMuon);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
