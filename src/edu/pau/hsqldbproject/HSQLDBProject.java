package edu.pau.hsqldbproject;
import java.sql.*;
public class HSQLDBProject {
    public static void main(String[] args) {
        DBHandler dbh = null;//DBHandler class to help database operations
        Connection connection = null;//Pure Connection class
        Fonksiyon ins = new Fonksiyon();
        try {
            new GUI().show();
            String sql = "SELECT * FROM Employee";
            String connectionString = "jdbc:hsqldb:file:db/employeedb";

            dbh = new DBHandler(connectionString);
            dbh.executeQuery(sql);
            dbh.printResultSet();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (dbh != null) {
                    dbh.close();
                }
            } catch (SQLException e) {
                System.out.println("Can't close DBHandler object\nReason:" + e.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Can't close Connection object\nReason:" + e.getMessage());
            }
        }
    }
}
