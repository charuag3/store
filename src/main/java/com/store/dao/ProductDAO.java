package com.store.dao;

import java.util.List;

import com.store.entity.Product;

public interface ProductDAO {
	
	Product getProduct(int id);
	List<Product> getAllProducts();
	void addProduct(Product product);
	boolean updateProduct(Product product);
	void deleteProduct(int id);
	

}
