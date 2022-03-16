package ru.unclediga.book.jpa;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.sql.Connection;

import static org.junit.Assert.assertTrue;

public class DBPingTest{
    private Logger logger = Logger.getLogger(DBPingTest.class.getName());
    
    private static Connection conn;
 
    @BeforeClass
    public static void init(){
       conn = JDBCConnectionProducer.createHsqlConnection();
    }

    @AfterClass
    public static void close(){
       JDBCConnectionProducer.closeHsqlConnection(conn);
    }

    //@Test
    public void HsqlPingTest(){
        System.err.println("running HSQLPingTest()");
        assertTrue("ping() must return true", JDBCConnectionProducer.pingHsql(conn));
    }

    //@Test
    public void DerbyPingTest(){
        System.err.println("running DerbyPingTest()");
        assertTrue("ping() must return true", JDBCConnectionProducer.pingDerby(conn));
    }
}