/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.dto.Brand;

/**
 *
 * @author José Acuña
 */
public interface BrandDAO {

    public void addBrand(Brand theBrand) throws SQLException;

    public void updateBrand(Brand theBrand) throws SQLException;

    public void deleteBrand(Short brandId) throws SQLException;

    public Brand getBrand(Short brandId) throws SQLException;

    public List<Brand> searchBrands(String brandName) throws SQLException;

    public List<Brand> getAllBrands() throws SQLException;

}
