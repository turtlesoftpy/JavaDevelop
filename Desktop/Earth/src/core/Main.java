/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.dao.firebird.FirebirdBrandDAO;
import model.dto.Brand;
import view.DlgSearch;
import controller.BrandController;

/**
 *
 * @author José Acuña
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        Connection myConn = new DbConnection().getConnection();
        //System.out.println(myConn);
        try { 
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
/*        DlgSearch frmSearchBrand = new DlgSearch();
        frmSearchBrand.setLocationRelativeTo(null);
        frmSearchBrand.setVisible(true);
        
        FirebirdBrandDAO dao = new FirebirdBrandDAO();
        System.out.println(dao.searchBrands("st"));
        Brand brand = new Brand((short) 300, "NOMBRE 300 modified", Boolean.TRUE);
        Brand brand2 = new Brand((short) 302, "NOMBRE 302 added", Boolean.TRUE);
        dao.updateBrand(brand);
        //dao.addBrand(brand2);
        dao.deleteBrand((short) 302);*/
//        System.out.println(dao.getAllBrands());
        
        
        
        DlgSearch frmSearchBrand = new DlgSearch();
        new BrandController(frmSearchBrand);
        frmSearchBrand.setLocationRelativeTo(null);
        frmSearchBrand.setVisible(true);
        
    }

}
