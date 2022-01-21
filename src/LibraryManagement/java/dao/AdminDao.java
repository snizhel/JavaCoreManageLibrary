package LibraryManagement.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import LibraryManagement.java.model.Admin;


public final class AdminDao {
  public static PreparedStatement preparedStatement;
  public static ResultSet resultSet;
  private AdminDao() {
    
  }
  public static Admin Login(String taiKhoan, String pass) {
    Admin admin = null;
    try {
      preparedStatement = DbConnection.getConnection()
          .prepareStatement("SELECT * FROM QUAN_TRI where Ma_Admin = ? and Password=?");
      preparedStatement.setString(1, taiKhoan);
      preparedStatement.setString(2, pass);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        admin = new Admin();


      }
    } catch (Exception e) {
       return null;
    }
    return admin;
  }

  public static ResultSet showTextfield(String sql) {
    try {
      preparedStatement = DbConnection.getConnection().prepareStatement(sql);
      return preparedStatement.executeQuery();
    } catch (Exception e) {
      return null;
    }

  }

  public static boolean UpdateAdmin(Admin admin) {
    try {
      preparedStatement = DbConnection.getConnection()
          .prepareStatement("UPDATE QUAN_TRI SET Password = ? where Ma_Admin = ?");
      preparedStatement.setString(2, admin.getMaAdmin());
      preparedStatement.setString(1, admin.getPassword());
      return preparedStatement.executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }

  public static  boolean DeleteAdmin(String IdAdmin) {
    try {
      preparedStatement =
          DbConnection.getConnection().prepareStatement("DELETE FROM QUAN_TRI WHERE Ma_Admin = ?");
      preparedStatement.setString(1, IdAdmin);
      return preparedStatement.executeUpdate() > 0;
    } catch (Exception e) {
      return false;
    }
  }
}
