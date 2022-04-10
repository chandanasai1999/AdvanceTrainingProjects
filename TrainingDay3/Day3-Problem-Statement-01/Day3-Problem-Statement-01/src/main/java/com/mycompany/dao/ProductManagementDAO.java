package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.dbutil.DBUtil;
import com.mycompany.domain.Product;

public class ProductManagementDAO {
	
    public List<Product> getAllProducts()
    {
        List<Product> productList = new ArrayList<Product>();
        try
        {
            //typical jdbc coding
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product");
            while(rs.next())
            {
                Product product = new Product(rs.getString("productId"), rs.getString("productName"), rs.getInt("productPrice"));
                productList.add(product);
            }
            DBUtil.closeConnection(conn);  //close connection
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return productList;
    }

    //different query
    public Product getProductByid(String productId)
    {
        Product product = null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE productId = ?");
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            //iterate through result
            while(rs.next())
            {
                product = new Product(rs.getString("productId"), rs.getString("productName"), rs.getInt("productPrice"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return product;
    }

    public int addProduct(Product product)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO product VALUES(?,?,?)");
            //set parameters of query here but using the values for the product object
            ps.setString(1, product.getProductid());
            ps.setString(2, product.getProductName());
            ps.setInt(3, product.getProductPrice());
            status = ps.executeUpdate();  //if successful status should return 1
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    //updates a product already in the table
    public int updateProduct(Product product)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE product SET productName=?, productPrice=? WHERE productId=?");
            //set parameters of query here but using the values for the product object
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getProductPrice());
            ps.setString(3, product.getProductid());
            status = ps.executeUpdate();  //if successful status should return 1
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    //deltes product already in the table
    public int deleteProduct(String productId)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM product where productId = ?");
            //set parameters of query here but using the values for the product object
            ps.setString(1, productId);
            status = ps.executeUpdate();  //if successful status should return 1

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}
