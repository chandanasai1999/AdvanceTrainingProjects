package com.hibernate;

import java.util.List;

import com.hibernate.dao.HibernateProductDao;
import com.hibernate.model.ProductService;

public class App {

	public static void main(String[] args) {
		HibernateProductDao hibernateProductDao = new HibernateProductDao();
		ProductService productService = new ProductService("Rice", 1200, 1);
		hibernateProductDao.saveProduct(productService);
		
		hibernateProductDao.insertProduct();
		
		// update student
		ProductService productService1 = new ProductService("Wheat", 1200, 1);
		hibernateProductDao.updateProduct(productService1);
		
		// get students
		List<ProductService> productService11 = hibernateProductDao.getProducts();
		productService11.forEach(s -> System.out.println(s.getName()));
		
		// get single student
		ProductService productService2 = hibernateProductDao.getProducts(1);
		System.out.println(productService2.getName());
		
		// delete student
		hibernateProductDao.deleteProduct(1);

	}

}
