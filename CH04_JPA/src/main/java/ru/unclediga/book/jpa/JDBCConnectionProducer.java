package ru.unclediga.book.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


public class JDBCConnectionProducer {

    private static Logger logger = Logger.getLogger("JDBCConnectionProducer");

    public static Connection createHsqlConnection(){
        logger.info("create connection for HSQL...");
        Connection conn = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:mem:test", "sys", "");
            logger.info("Connection for HSQL created!");
        } catch(ClassNotFoundException | SQLException e){
            logger.warning("Exception while HSQL connection creating!");
            e.printStackTrace();
        }
        return conn;
    }

    
    public static void closeDerbyConnection(Connection conn) {
        logger.info("close connection...");

        try{
         if(conn != null && !conn.isClosed()){

               conn.close();
           }
        }catch(SQLException e){
            e.printStackTrace();
        }
   }

    public static void closeHsqlConnection(Connection conn) {
        logger.info("close connection...");

        try{
          if(conn != null && !conn.isClosed()){

               conn.close();
           }
        }catch(SQLException e){
            e.printStackTrace();
        }
   }

    public static Connection createDerbyConnection(){

        logger.info("create connection for Derby");
        Connection conn = null;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby:memory:chapter02DB;create=true", "APP", "APP");
            logger.info("Connection for Derby created!");
        } catch(ClassNotFoundException | SQLException e){
            logger.warning("Exception while Derby connection creating!");
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean pingHsql(Connection conn) {
        logger.info("pinging connection HSQL...");
        try{
            conn.createStatement().executeQuery("select 1 from information_schema.system_users limit 1");
        }catch(SQLException e){
            return false;
        }
        return true;
    }

    public static boolean pingDerby(Connection conn) {
        logger.info("pinging connection Derby...");
        try{
            conn.createStatement().executeQuery("SELECT 1 FROM \"INFORMATION_SCHEMA\".\"SYSTEM_TABLES\" LIMIT 1");
        }catch(SQLException e){
            return false;
        }
        return true;
    }
    
}
