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
       conn = JDBCConnectionProducer.createDerbyConnection();
    }

    @AfterClass
    public static void close(){
       JDBCConnectionProducer.closeConnection(conn);
    }

    // @Test
    // public void HSQLPingTest(){
    //     logger.info("running HSQLPingTest()");
    //     PingService service = container.instance().select(HSQLPingService.class).get();
    //     assertTrue("ping() must return true", service.ping());
    // }

    @Test
    public void DerbyPingTest(){
        System.err.println("running DerbyPingTest()");
        assertTrue("ping() must return true", JDBCConnectionProducer.pingDerby(conn));
    }
}