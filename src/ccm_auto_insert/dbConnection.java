/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.activation.DataSource;

/**
 *
 * @author Petr
 */
class dbConnection {

    public static Connection dbConnection_dwh(int prostredi) throws SQLException {

//
//String result1 = "success";
//        
//        try {
//            PoolProperties p = new PoolProperties();
//              p.setUrl("jdbc:mysql://localhost:3306/tutorialsdb");
//              p.setDriverClassName("com.mysql.jdbc.Driver");
//              p.setUsername("root");
//              p.setPassword("");
//              p.setJmxEnabled(true);
//              p.setTestWhileIdle(false);
//              p.setTestOnBorrow(true);
//              p.setValidationQuery("select 1");
//              p.setTestOnReturn(false);
//              p.setValidationInterval(30000);
//              p.setTimeBetweenEvictionRunsMillis(30000);
//              p.setMaxActive(100);
//              p.setInitialSize(10);
//              p.setMaxWait(10000);
//              p.setRemoveAbandonedTimeout(60);
//              p.setMinEvictableIdleTimeMillis(30000);
//              p.setMinIdle(10);
//              p.setLogAbandoned(true);
//              p.setRemoveAbandoned(true);
//              p.setJdbcInterceptors(
//                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
//                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
//           datasource = new DataSource() {};
//           datasource.setPoolProperties(p);
//              result1 = "success";
//      } catch (Exception e) {
//             TODO Auto-generated catch block
//            e.printStackTrace();
//            result1 = "failed";
//      }
//      
        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
//			return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {
            if (prostredi == 1) {
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@rztpowb06.cz.tmo:1580/QDTW2.WORLD", "apptest",
                        "ittc");
            } else if (prostredi == 2) {
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@hkpowm03.cz.tmo:1680/Q2DTW2.WORLD", "apptest",
                        "ittc");
            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
//			return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");

        } else {
            System.out.println("Failed to make connection!");
        }

      
        return connection;

    }

    public static Connection dbConnection_qap(int prostredi) throws SQLException {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
//			return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {
            if (prostredi == 1) {
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@rztpowb06.cz.tmo:1584/QAP01.WORLD", "apptest",
                        "ittc");
            } else if (prostredi == 2) {
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@hkpowm03.cz.tmo:1684/Q2AP01.WORLD", "apptest",
                        "ittc");
            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
//			return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");

        } else {
            System.out.println("Failed to make connection!");
        }

        return connection;
    }

    public static Connection dbConnection_clf(int prostredi) throws SQLException {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
//			return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {
            if (prostredi == 1) {
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@rztclt13.cz.tmo:1526/QCLF12.WORLD", "apptest",
                        "ittc");
            } else if (prostredi == 2) {
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@rztclt14.cz.tmo:1626/Q2CLF12.WORLD", "apptest",
                        "ittc");
            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
//			return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");

        } else {
            System.out.println("Failed to make connection!");
        }

        return connection;
    }

    
    
    
    
    
}
