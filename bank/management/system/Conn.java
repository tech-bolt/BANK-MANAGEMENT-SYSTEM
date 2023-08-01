package bank.management.system;

import java.sql.*;
// Register the driver
// Create Connection
// Create Statement
// Execute Query
// Close connection

public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            
            //Class.forName(com.mysql.cj.jdbc.Driver); //driver register //not necessary as it is automatically done by jdbc
            c=DriverManager.getConnection("jdbc:mysql:///bms","root","mysql123"); //create connection string
            s=c.createStatement(); //create statement
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
