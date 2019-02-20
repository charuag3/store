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

import com.store.dao.ProductDAOImpl;
import com.store.dao.UserDAOImpl;
import com.store.entity.Product;
import com.store.entity.User;

@Path("/product")
@Stateless
@LocalBean
public class ProductService {
	@EJB
	
	private ProductDAOImpl productDao;
	

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getProduct(@PathParam("id") int id) {
		System.out.println("get a product");
		Product product=productDao.getProduct(id);
		return Response.status(200).entity(product).build();

	}

	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllProducts() {
		System.out.println("get all products");
		List<Product> products=productDao.getAllProducts();
		return Response.status(200).entity(products).build();
	}
	
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Produces({MediaType.TEXT_HTML})
	public Response addProduct(Product product) {
		System.out.println("adding a product");
		productDao.addProduct(product);
		return Response.status(201).entity("product has been successfully added....").build();	
	}
	
	@PUT
	@Path("{id}")
	@Consumes("application/json")
		@Produces({MediaType.APPLICATION_JSON})
	public Response updateProduct(Product product)
	{
		productDao.updateProduct(product);
		return Response.status(200).entity(product).build();
	}
	@DELETE
	@Path("{id}")
	public Response deleteProduct(@PathParam("id") int id)
	{
		productDao.deleteProduct(id);
		return Response.status(204).build();
	
}}

