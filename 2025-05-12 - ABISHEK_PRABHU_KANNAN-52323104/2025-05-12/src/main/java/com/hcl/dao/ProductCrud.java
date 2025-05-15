package com.hcl.dao;

import com.hcl.dbUtil.dbUtil;
import com.hcl.pojo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductCrud implements ProductCrudImpl{

    public int addProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection con = dbUtil.getConn();
        // Create a table if not exists
        if(con == null)
            System.out.println("Connection failed");
        else
            System.out.println("Connection is successfully established");
        assert con != null;
        Statement statement = con.createStatement();
        String createTableSQL = "CREATE TABLE IF NOT EXISTS product (pid SERIAL PRIMARY KEY, pName VARCHAR(50), cost INTEGER)";
        statement.execute(createTableSQL);
        System.out.println("Table 'product' created!");


        String sql = "insert into product values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,product.getPid());
        ps.setString(2,product.getpName());
        ps.setInt(3,product.getCost());


        return (int) ps.executeUpdate();
    }

    public int deleteProduct(int id) throws SQLException, ClassNotFoundException {
        Connection con = dbUtil.getConn();
        if(con == null)
            System.out.println("Connection failed");
        else
            System.out.println("Connection is successfully established");
        String sql = "delete from product where pid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
//		System.out.println(sql);
        //insert, update ,delete -->return int
        int rows=ps.executeUpdate();
        return rows;
    }
    public List<Product> selectProduct() throws ClassNotFoundException, SQLException {
        Connection con=dbUtil.getConn();
        if(con==null) {
            System.out.println("connection failed");
        }
        else {
            System.out.println("connection is successfully established ....!!!");
        }
//		Statement st=con.createStatement();
//		String sql="select * from product";

        String sql = "select * from product";
        PreparedStatement ps = con.prepareStatement(sql);
//		//table address is stored in rs obj
        ResultSet rs=ps.executeQuery();
        List<Product> list=new ArrayList<Product>();
        //row 1
        while(rs.next()) {
            Product product=new Product();
            product.setPid(rs.getInt("pid"));
            product.setpName(rs.getString("pName"));
            product.setCost(rs.getInt("cost"));
            list.add(product);
        }
        return list;

    }

    @Override
    public int updateProductName(int id,String name) throws ClassNotFoundException, SQLException {
        Connection con= dbUtil.getConn();
        if(con==null) {
            System.out.println("connection failed");
        }
        else {
            System.out.println("connection is successfully established ....!!!");
        }
//		Statement st=con.createStatement();

//		String sql="update product set pName='"+name+"' where pid="+id;
        String sql="update product set pName=? where pid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setInt(2, id);
        //		System.out.println(sql);
        //insert, update ,delete -->return int
        int rows=ps.executeUpdate();
        return rows;
    }

}
