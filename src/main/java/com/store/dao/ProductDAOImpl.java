package com.store.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.store.entity.Product;
import com.store.entity.User;

@Stateless
@LocalBean
public class ProductDAOImpl implements ProductDAO{
	@PersistenceContext
	private EntityManager em;
	@Override
	public Product getProduct(int id) {
		return em.find(Product.class, id);
		
	}
	

	@Override
	public List<Product> getAllProducts() {
		Query query =em.createQuery("FROM Product p");
		return query.getResultList();
	}

	@Override
	public void addProduct(Product product) {
		System.out.println("product is : "+product);
		em.persist(product);
		//em.getTransaction().commit();
		//em.close();
	}

	@Override
	public boolean updateProduct(Product product) {
		Product product1 = em.find(Product.class, product.getId());
		if(product1!=null) {
			em.merge(product);
			return true;
		}
		else {
			return false;
		}
	}
		
	

	@Override
	public void deleteProduct(int id) {
		em.remove(getProduct(id));		
	}

	

}
