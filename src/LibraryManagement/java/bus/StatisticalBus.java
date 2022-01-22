package LibraryManagement.java.bus;


import java.sql.ResultSet;
import LibraryManagement.java.dao.DbConnection;


public class StatisticalBus {
  public static void statistical() {
    try {
      String sql1 = "SELECT SUM(So_luong) as sach FROM SACH";
      String sql2 = "SELECT COUNT(Ma_Khach_hang) as khachhang FROM KHACH_HANG";
      String sql3 = "SELECT COUNT(Ma_Phieu_muon) as phieumuon FROM PHIEU_MUON";
      String sql4 = "SELECT COUNT(DISTINCT Ma_Khach_hang) as khachmuon FROM PHIEU_MUON";
      String sql5 =
          "SELECT COUNT(Ma_Phieu_muon) as phieumuon FROM PHIEU_MUON where (Han_tra < (select CURDATE()) and NgayTra IS NULL)";
      ResultSet rs1 = DbConnection.prepareSQL(sql1).executeQuery();
      ResultSet rs2 = DbConnection.prepareSQL(sql2).executeQuery();
      ResultSet rs3 = DbConnection.prepareSQL(sql3).executeQuery();
      ResultSet rs4 = DbConnection.prepareSQL(sql4).executeQuery();
      ResultSet rs5 = DbConnection.prepareSQL(sql5).executeQuery();
      if (rs1.next())
        System.out.println("Tong so sach :" + Integer.toString(rs1.getInt("sach")));
      if (rs2.next())
        System.out.println("Tong khach hang: " + Integer.toString(rs2.getInt("khachhang")));
      if (rs3.next())
        System.out.println("Tong so phieu muon: " + Integer.toString(rs3.getInt("phieumuon")));
      if (rs4.next())
        System.out.println(
            "Tong so khach hang dang muon sach: " + Integer.toString(rs4.getInt("khachmuon")));
      if (rs5.next())
        System.out.println(
            "Tong so phieu muon qua han tra: " + Integer.toString(rs5.getInt("phieumuon")));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
