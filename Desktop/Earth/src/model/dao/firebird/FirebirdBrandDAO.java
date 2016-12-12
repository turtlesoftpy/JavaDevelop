/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.firebird;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.DbConnection;
import model.dao.BrandDAO;
import model.dto.Brand;

/**
 *
 * @author José Acuña
 */
public class FirebirdBrandDAO implements BrandDAO {

    static final String ADD = "INSERT INTO brand (id, name, active) VALUES (?, ?, ?)";
    static final String UPDATE = "UPDATE brand SET name = ?, active = ? WHERE id = ?";
    static final String DELETE = "DELETE FROM brand WHERE id = ?";
    static final String GET = "SELECT * FROM brand WHERE id = ?";
    static final String SEARCH = "SELECT * FROM brand WHERE UPPER(name) LIKE ?";
    static final String GETALL = "SELECT * FROM brand";

    private final Connection myConn;

    public FirebirdBrandDAO() {
        // connect to database.
        myConn = new DbConnection().getConnection();
    }

    @Override
    public void addBrand(Brand theBrand) throws SQLException {
        PreparedStatement myStmt = null;

        try {
            // prepare statement.
            myStmt = myConn.prepareStatement(ADD);

            // set params.
            myStmt.setShort(1, theBrand.getId());
            myStmt.setString(2, theBrand.getName());
            myStmt.setString(3, theBrand.getActive() ? "T" : "F");

            // execute SQL.
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    @Override
    public void updateBrand(Brand theBrand) throws SQLException {
        PreparedStatement myStmt = null;

        try {
            // prepare statement.
            myStmt = myConn.prepareStatement(UPDATE);

            // set params.
            myStmt.setString(1, theBrand.getName());
            myStmt.setString(2, theBrand.getActive() ? "T" : "F");
            myStmt.setShort(3, theBrand.getId());

            // execute SQL.
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    @Override
    public void deleteBrand(Short brandId) throws SQLException {
        PreparedStatement myStmt = null;

        try {
            // prepare statement.
            myStmt = myConn.prepareStatement(DELETE);

            // set param.
            myStmt.setShort(1, brandId);

            // execute SQL.
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    @Override
    public Brand getBrand(Short brandId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Brand> searchBrands(String brandName) throws SQLException {
        List<Brand> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            brandName += "%";
            myStmt = myConn.prepareStatement(SEARCH);

            myStmt.setString(1, brandName.toUpperCase());

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                Brand tempBrand = convertRowToBrand(myRs);
                list.add(tempBrand);
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    @Override
    public List<Brand> getAllBrands() throws SQLException {
        List<Brand> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.prepareStatement(GETALL);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                Brand tempBrand = convertRowToBrand(myRs);
                list.add(tempBrand);
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    private Brand convertRowToBrand(ResultSet myRs) throws SQLException {
        Short id = myRs.getShort("id");
        String name = myRs.getString("name");
        Boolean active = myRs.getBoolean("active");

        Brand tempBrand = new Brand(id, name, active);

        return tempBrand;
    }

    private static void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) throws SQLException {
        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(PreparedStatement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    private void close(PreparedStatement myStmt) throws SQLException {
        close(null, myStmt, null);
    }

    /*
    public static void main(String[] args) throws Exception {
        FirebirdBrandDAO dao = new FirebirdBrandDAO();
        System.out.println(dao.searchBrands("st"));
        System.out.println(dao.getAllBrands());
    }
     */
}
