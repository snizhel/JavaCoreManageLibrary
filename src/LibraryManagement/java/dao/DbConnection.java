package LibraryManagement.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DbConnection {

  private static Connection connection;

  private DbConnection() {}

  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV;Username=sa;Password =1");
    }
    return connection;
  }

  public static PreparedStatement prepareSQL(String sql) {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = getConnection().prepareStatement(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return preparedStatement;
  }

  public static PreparedStatement prepareSQL(String sql, List<Object> listParam) {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = getConnection().prepareStatement(sql);
      for (int i = 0; i < listParam.size(); i++) {
        if (listParam.get(i) instanceof String) {
          preparedStatement.setString(i + 1, (String) listParam.get(i));
        }
        if (listParam.get(i) instanceof Integer) {
          preparedStatement.setInt(i + 1, (Integer) listParam.get(i));
        }
        if (listParam.get(i) instanceof Date) {
          preparedStatement.setDate(i + 1, (Date) listParam.get(i));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return preparedStatement;
  }
}
