package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
  public static void main(String[] args) throws SQLException
  {
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String url = "jdbc:mysql://localhost:3306/blockbuster?serverTimezone=EST";
    final String username = "root";
    final String password = "root";

    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Connection conn = DriverManager.getConnection(url, username, password);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM movies");

    System.out.println("Movies in Blockbuster:\n");
    while (rs.next()) {
      String title = rs.getString("title");
      String author = rs.getString("length");
      int copies = rs.getInt("copies");
      int available = rs.getInt("available");

      System.out.println(" --> " + title + " legnth " + author + " (" + available + " of " + copies + ")");
    }
    
    rs.close();
    stmt.close();
    conn.close();
  }
}