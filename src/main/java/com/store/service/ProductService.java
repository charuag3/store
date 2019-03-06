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
import com.store.entity.Product;

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
		System.out.println(product);
		if(product==null) {
			return Response.status(404).entity("{\"error\": \"No user found for given ID.\"}").build();
		}else {
			return Response.status(200).entity(product).build();
		}
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
	@Produces({MediaType.APPLICATION_JSON})
	
	public Response addProduct(Product product) {
	
		System.out.println("adding a product : "+product);
		productDao.addProduct(product);
		return Response.status(201).entity("product has been successfully added....").build();	
	}
	
	@PUT
	@Path("{id}")
	@Consumes("application/json")
		@Produces({MediaType.APPLICATION_JSON})
	public Response updateProduct(Product product)
	{
		boolean isUpdated = productDao.updateProduct(product);;
		if(isUpdated) {
			return Response.status(200).entity(product).build();
		}else {
			return Response.status(404).entity("{\"error\": \"No product found for given ID.\"}").build();
		}
		
		
	}
	@DELETE
	@Path("{id}")
	public Response deleteProduct(@PathParam("id") int id)
	{
		Product product=productDao.getProduct(id);
		if(product==null) {
			return Response.status(404).entity("{\"error\": \"No product found for given ID.\"}").build();
		}else {
			productDao.deleteProduct(id);
			return Response.status(204).build();
		}
		
		
		
	
	
}}

