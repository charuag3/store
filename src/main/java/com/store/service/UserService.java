package com.store.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.store.dao.UserDAOImpl;
import com.store.entity.User;

@Path("/user")
@Stateless
@LocalBean
public class UserService {

	@EJB
	private UserDAOImpl userDao;

	@GET
	@Path("/{userName}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getUser(@PathParam("userName") String userName) {
		System.out.println("get  user");
		User user=userDao.getUser(userName);
		return Response.status(200).entity(user).build();

	}

	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllUsers() {
		System.out.println("get all users");
		List<User> users=userDao.getAllUsers();
		return Response.status(200).entity(users).build();
	}
	
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Produces({MediaType.TEXT_HTML})
	public Response addUser(User user) {
		System.out.println("adding a user");
		userDao.addUser(user);
		return Response.status(201).entity("user has been successfully created....").build();	
	}
	
	@PUT
	@Path("{userName}")
	@Consumes("application/json")
		@Produces({MediaType.APPLICATION_JSON})
	public Response updateUser(User user)
	{
		userDao.updateUser(user);
		return Response.status(200).entity(user).build();
	}
	@DELETE
	@Path("{userName}")
	public Response deleteUser(@PathParam("userName") String userName)
	{
		userDao.deleteUser(userName);
		return Response.status(204).build();
	}
}
