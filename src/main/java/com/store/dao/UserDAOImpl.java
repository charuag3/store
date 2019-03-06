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
public boolean updateUser(User user) {
	User user1 = em.find(User.class, user.getUserName());
	if(user1!=null) {
		em.merge(user);
		return true;
	}
	else {
		return false;
	}
}

@Override
public void deleteUser(String userName) {
	em.remove(getUser(userName));
	
}



}
