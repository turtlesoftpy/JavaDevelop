/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turtleworks.model.bean;

import com.turtleworks.model.dao.firebird.FirebirdBrandDAO;
import com.turtleworks.model.dto.Brand;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author José Acuña
 */
@ManagedBean
@RequestScoped
public class BrandBean {

    private Brand brand = new Brand();
    private List<Brand> brandList = new ArrayList();

    /**
     * Creates a new instance of BrandBean
     */
    public BrandBean() {
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public void add() {
        FirebirdBrandDAO brandDAO;

        try {
            brandDAO = new FirebirdBrandDAO();
            brandDAO.addBrand(brand);
        } catch (SQLException ex) {
            System.out.println("An error occurred while attempting to add data.\n" + ex.getMessage());
        }
    }

    public void getAllBrands() {
        FirebirdBrandDAO brandDAO;

        try {
            brandDAO = new FirebirdBrandDAO();
            brandList = brandDAO.getAllBrands();
            
            if (brandList == null) {
                System.out.println("La lista está nula");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while attempting to add data.\n" + ex.getMessage());
        }
    }
}
