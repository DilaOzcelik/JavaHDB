
package edu.pau.hsqldbproject;
import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Fonksiyon 
{
    Scanner input=new Scanner(System.in);
    public String firstName;
    public String lastName;
    public String eMail;
    public String department;
    public String title;
    public int id;
    public void insert()
    {
        DBHandler dbh = null;//DBHandler class to help database operations
        Connection connection = null;//Pure Connection class
        System.out.println("Firstname");
        firstName=input.next();
        System.out.println("Lastname");
        lastName=input.next();
        System.out.println("Email");
        eMail=input.next();
        System.out.println("Department");
        department=input.next();
        System.out.println("Title");
        title=input.next();
        try {
            String sql ="INSERT INTO Employee (FIRSTNAME, LASTNAME, EMAIL, DEPARTMENT, TITLE) VALUES('"+firstName+"', '"+lastName+"','"+eMail+"','"+department+"','"+title+"')";
            String connectionString = "jdbc:hsqldb:file:db/employeedb";

            dbh = new DBHandler(connectionString);
            dbh.executeQuery(sql);
            dbh.printResultSet();
            System.out.println("eklendi.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }  
    
    public void delete()
    {
        DBHandler dbh = null;//DBHandler class to help database operations
        Connection connection = null;//Pure Connection class
        System.out.println("Kaçıncı Kisiyi silmek istiyorsunuz?");
        id=input.nextInt();
         try {
            String sql = "DELETE FROM Employee WHERE ID=" +id;
            String connectionString = "jdbc:hsqldb:file:db/employeedb";

            dbh = new DBHandler(connectionString);
            dbh.executeQuery(sql);
            dbh.printResultSet();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void güncelle()
    {
        DBHandler dbh = null;//DBHandler class to help database operations
        Connection connection = null;//Pure Connection class
        System.out.println("Kacinci id li kisiyi guncellemek istiyorsunuz?");
        id=input.nextInt();
        String firstname,lastname,email,Department,Title,alan=null;//alan=degistirmek istedigimiz yer firstname
        System.out.println("Guncellemek istediğiniz alanı seciniz...");
        System.out.println("1-Ad \n2-Soyad\n3-Mail\n4-Bölüm\n5-Title");
        int secim=input.nextInt();
        switch(secim)
        {
            case 1:
                alan="FIRSTNAME";break;
            case 2:
                alan="LASTNAME";break;
            case 3:
                alan="EMAIL";break;
            case 4:
                alan="DEPARTMENT";break;    
            case 5:
                alan="TITLE";break;
            default:
                System.out.println("yanlis girdiniz...");break;
        }
        System.out.printf("%s:",alan);
        String degisim=input.next();//degistirmek istedigimiz özellik dila
         try {
            String sql = "UPDATE Employee SET "+alan+"='"+degisim+"' WHERE ID="+id+"";
            String connectionString = "jdbc:hsqldb:file:db/employeedb";

            dbh = new DBHandler(connectionString);
            dbh.executeQuery(sql);
            dbh.printResultSet();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void findLastName()
    {
        System.out.println("lastname");
        String lasstname=input.next();
        DBHandler dbh = null;//DBHandler class to help database operations
        Connection connection = null;//Pure Connection class
        try{
        String sql =" SELECT * FROM Employee WHERE LASTNAME like '"+lasstname+"%'";
        String connectionString = "jdbc:hsqldb:file:db/employeedb";
        
        dbh = new DBHandler(connectionString);
        dbh.executeQuery(sql);
        dbh.printResultSet();
       } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void findDepartment()
    {
        System.out.println("department:");
        String Departmeent=input.next();
        DBHandler dbh = null;//DBHandler class to help database operations
        Connection connection = null;//Pure Connection class
        try{
        String sql =" SELECT * FROM Employee WHERE LASTNAME like '"+Departmeent+"%'";
        String connectionString = "jdbc:hsqldb:file:db/employeedb";
        
        dbh = new DBHandler(connectionString);
        dbh.executeQuery(sql);
        dbh.printResultSet();
       } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void findTitle()
    {
        System.out.println("Title:");
        String Tittle=input.next();
        DBHandler dbh = null;//DBHandler class to help database operations
        Connection connection = null;//Pure Connection class
        try{
        String sql =" SELECT * FROM Employee WHERE LASTNAME like '"+Tittle+"%'";
        String connectionString = "jdbc:hsqldb:file:db/employeedb";
        
        dbh = new DBHandler(connectionString);
        dbh.executeQuery(sql);
        dbh.printResultSet();
       } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void browse()
    {
        DBHandler dbh = null;//DBHandler class to help database operations
        Connection connection = null;//Pure Connection class
        try{
             String sql = "SELECT * FROM Employee WHERE ID = 1";
             String connectionString = "jdbc:hsqldb:file:db/employeedb";

             dbh = new DBHandler(connectionString);
             dbh.executeQuery(sql);
             dbh.printResultSet();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }      
}
