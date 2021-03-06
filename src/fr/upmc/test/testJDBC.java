package fr.upmc.test;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import java.sql.*;

public class testJDBC {


 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 static final String DB_URL = "jdbc:mysql://localhost:3307/test";

 static final String USER = "root";
 static final String PASS = "***";
 
 public static void main(String[] args) {
 Connection conn = null;
 Statement stmt = null;
 
 try{
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(DB_URL,USER,PASS);
    stmt = conn.createStatement();
    String sql;
    sql = "SELECT * FROM Transport";
    ResultSet rs = stmt.executeQuery(sql);
    
    while(rs.next()){
    	int id  = rs.getInt("ID");
       

       System.out.print("ID: " + id);
      
    }
    rs.close();
    stmt.close();
    conn.close();
 }catch(SQLException se){
    se.printStackTrace();
 }catch(Exception e){
    e.printStackTrace();
 }finally{
    try{
       if(stmt!=null)
          stmt.close();
    }catch(SQLException se2){
    }
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){
       se.printStackTrace();
    }
 }
}

}