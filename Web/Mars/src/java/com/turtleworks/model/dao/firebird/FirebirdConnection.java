/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turtleworks.model.dao.firebird;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author José Acuña
 */
public class FirebirdConnection {

    private Connection myConn;

    public Connection getConnection() {
        return myConn;
    }

    public void establishConnection() {
        //final String HOST = "localhost";
        final String HOST = "192.167.20.1";
        final String PORT = "3050";
        final String DATABASE = "C:/Prometheus/Data/80004234_test2.fdb";
        final String USER = "SYSDBA";
        final String PASSWORD = "masterkey";
        final String URL = "jdbc:firebirdsql://" + HOST + ":" + PORT + "/" + DATABASE + "?encoding=ISO8859_1";

        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            myConn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("An error occurred while attempting to register the database driver.\n" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("An error occurred while attempting to connect to database server.\n" + ex.getMessage());
        }
    }

    protected void terminateConnection() throws SQLException {
        if (myConn != null) {
            if (!myConn.isClosed()) {
                myConn.close();
            }
        }
    }

    protected void terminateConnection(Connection myConn, PreparedStatement myStmt, ResultSet myRs) throws SQLException {
        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            if (!myConn.isClosed()) {
                myConn.close();
            }
        }

        terminateConnection();
    }

    protected void terminateConnection(PreparedStatement myStmt, ResultSet myRs) throws SQLException {
        terminateConnection(null, myStmt, myRs);
    }

    protected void terminateConnection(PreparedStatement myStmt) throws SQLException {
        terminateConnection(null, myStmt, null);
    }
}
