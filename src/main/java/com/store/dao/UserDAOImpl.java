package com.store.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.store.entity.User;

@Stateless
@LocalBean
public class UserDAOImpl implements UserDAO {
@PersistenceContext
private EntityManager em;
 
@Override
public User getUser(String userName) {
	return em.find(User.class, userName);
}

@Override
public List<User> getAllUsers() {
	Query query =em.createQuery(" FROM User u");
	return query.getResultList();
}

@Override
public void addUser(User user) {
	em.persist(user);
	
}

@Override
public void updateUser(User user) {
	em.merge(user);
}

@Override
public void deleteUser(String userName) {
	em.remove(getUser(userName));
	
}



}
