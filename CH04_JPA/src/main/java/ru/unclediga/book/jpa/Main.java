package ru.unclediga.book.jpa;

import java.sql.Connection;

public class Main{
  public static void main(String[] args){
    System.out.println("Hello from JPA!");

    
    Connection conn = JDBCConnectionProducer.createHsqlConnection();
    System.out.println("Ping result is " + (JDBCConnectionProducer.pingHsql(conn) ? "Good!" : "Error"));
    JDBCConnectionProducer.closeHsqlConnection(conn);
    // Connection conn = JDBCConnectionProducer.createDerbyConnection();
    // System.out.println("Ping result is " + (JDBCConnectionProducer.pingDerby(conn) ? "Good!" : "Error"));
    // JDBCConnectionProducer.closeDerbyConnection(conn);
  }
}