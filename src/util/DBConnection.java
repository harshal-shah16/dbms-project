package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  public static Connection getCon() throws ClassNotFoundException, SQLException {
    Connection con = null;
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("this too was executed");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_trial", "root","Harshal123");
    return con;
  }



}
