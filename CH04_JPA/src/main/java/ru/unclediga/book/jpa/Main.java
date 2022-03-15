package ru.unclediga.book.jpa;

import java.sql.Connection;

public class Main{
  public static void main(String[] args){
    System.out.println("Hello from JPA!");

    
    Connection conn = JDBCConnectionProducer.createDerbyConnection();
    System.out.println("Ping result is " + (JDBCConnectionProducer.pingDerby(conn) ? "Good!" : "Error"));
    JDBCConnectionProducer.closeConnection(conn);
  }
}