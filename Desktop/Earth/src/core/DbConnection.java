/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author José Acuña
 */
public class DbConnection {

    public Connection getConnection() {
        final String HOST = "localhost";
        final String PORT = "3050";
        final String DATABASE = "C:/Prometheus/Data/80004234_test2.fdb";
        final String USER = "SYSDBA";
        final String PASSWORD = "masterkey";
        final String URL = "jdbc:firebirdsql://" + HOST + ":" + PORT + "/" + DATABASE + "?encoding=ISO8859_1";
        Connection myConn = null;

        try {
            myConn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("An error occurred while attempting to connect to database server.\n" + ex.getMessage());
        }

        return myConn;
    }

}
