package com.hcl.dao;

import com.hcl.pojo.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductCrudImpl {
    public int addProduct(Product product) throws ClassNotFoundException, SQLException;
    public List<Product> selectProduct() throws ClassNotFoundException, SQLException;
    public int updateProductName(int id, String name) throws ClassNotFoundException, SQLException;
    public int deleteProduct(int id) throws ClassNotFoundException, SQLException;
}
