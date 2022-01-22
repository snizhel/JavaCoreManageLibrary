package LibraryManagement.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import LibraryManagement.java.model.Admin;


public final class AdminDao {
  public static PreparedStatement preparedStatement;
  public static ResultSet resultSet;

  private AdminDao() {

  }

  public static Admin login(String taiKhoan, String pass) {
    Admin admin = null;
    try {
      String sql = "SELECT * FROM QUAN_TRI where Ma_Admin = ? and Password=?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(taiKhoan);
      listParam.add(pass);
      resultSet = DbConnection.prepareSQL(sql, listParam).executeQuery();
      while (resultSet.next()) {
        admin = new Admin();
      }
    } catch (Exception e) {
      return null;
    }
    return admin;
  }



  public static boolean updateAdmin(Admin admin) {
    try {
      List<Object> listParam = new ArrayList<>();
      String sql = "UPDATE QUAN_TRI SET Password = ? where Ma_Admin = ?";
      listParam.add(admin.getPassword());
      listParam.add(admin.getMaAdmin());
      return DbConnection.prepareSQL(sql, listParam).executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean deleteAdmin(String IdAdmin) {
    try {
      String sql = "DELETE FROM QUAN_TRI WHERE Ma_Admin = ?";
      List<Object> listParam = new ArrayList<>();
      listParam.add(IdAdmin);
      return DbConnection.prepareSQL(sql, listParam).executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }
}
