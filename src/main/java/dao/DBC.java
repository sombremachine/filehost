package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBC {
    public static Connection dbConnection() throws NamingException {
        Context initContext;
        DataSource ds = null;
        Connection conn = null;
        try {
            initContext = new InitialContext();

            initContext = new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");

//            Context envContext = (Context) initContext.lookup("java:comp/env");
//            ds = (DataSource) envContext.lookup("java:comp/env/jdbc/appname");
            conn = ds.getConnection();
        }catch (SQLException ex){
           // logger.error("SQLException Occurred in DAO.dbConnection() Method, Exception Message is: " + ex.getMessage(), ex);
        }
        catch (RuntimeException er){
           // logger.fatal("SQLException Occurred in DAO.dbConnection() Method, Exception Message is: " + er.getMessage(), er);
        }catch(Exception rt){
           // logger.fatal("Exception Occurred in DAO.dbConnection() Method, Exception Message is: " + er.getMessage(), er);
        }
        return conn;
    }
}
