package LibraryManagement.java.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import LibraryManagement.java.model.Book;
import LibraryManagement.java.model.PhieuMuon;


public class PhieuMuonDao {
  public static PreparedStatement preparedStatement;
  public static ResultSet resultSet;

  public static ResultSet showTextfield(String sql) {
    try {
      preparedStatement = DbConnection.getConnect().prepareStatement(sql);
      return preparedStatement.executeQuery();
    } catch (Exception e) {
      return null;
    }
  }

  public static void insertPhieu(PhieuMuon p) {
    String sql = "insert into PHIEU_MUON values(?,?,?,?,?,?,?)";
    try {
      preparedStatement = DbConnection.getConnect().prepareStatement(sql);
      preparedStatement.setString(1, p.getMaMuon());
      preparedStatement.setString(2, p.getMaKhach());
      preparedStatement.setString(3, p.getSach());
      preparedStatement.setDate(4, p.getNgayMuon());
      preparedStatement.setDate(5, p.getHanTra());

      preparedStatement.execute();
      JOptionPane.showMessageDialog(null, "Them phieu thanh cong!", "Thong bao", 1);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Failed", "Thong bao", 1);
    }
  }

  public boolean updatePhieu(PhieuMuon p) {
    try {
      preparedStatement = DbConnection.getConnect()
          .prepareStatement("UPDATE PHIEU_MUON SET  Ma_Khach_hang = ?, Ma_Sach = ?,"
              + "Ngay_muon = ?, Han_tra = ? where Ma_Phieu_muon = ?");
      preparedStatement.setString(5, p.getMaMuon());
      preparedStatement.setString(1, p.getMaKhach());
      preparedStatement.setString(2, p.getSach());
      preparedStatement.setDate(3, p.getNgayMuon());
      preparedStatement.setDate(4, p.getHanTra());
      return preparedStatement.executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean deletePhieu(String ms) {
    try {
      preparedStatement = DbConnection.getConnect()
          .prepareStatement("DELETE FROM PHIEU_MUON WHERE Ma_Phieu_muon = ?");
      preparedStatement.setString(1, ms);
      return preparedStatement.executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static List<PhieuMuon> getPhieuMuon() {
    try {
      List<PhieuMuon> listPhieuMuon = new ArrayList<PhieuMuon>();
      PreparedStatement pstmt =
          DbConnection.getConnect().prepareStatement("SELECT * from PHIEU_MUON");
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
}
