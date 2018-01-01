package com.bananealcanws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONObject;

import com.bananealcanws.dao.CategoryDao;
import com.bananealcanws.model.Category;

public class CategoryService implements IService<Category> {

	private static final CategoryDao catDao = new CategoryDao();

	@Override
	@GET
	@Path("/GetById")
	@Produces(MediaType.APPLICATION_JSON)
	public Category getById(@Context UriInfo params) throws Exception {
		String id = params.getQueryParameters().getFirst("id");
		return catDao.getById(id);
	}

	@Override
	public List<Category> searchByName(@Context UriInfo params) throws Exception {
		return null;
	}

	@Override
	@GET
	@Path("/GetAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAll() throws Exception {
		return catDao.getAll();
	}

	@Override
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Category t) throws Exception {
		String result = String.valueOf(catDao.create(t));
		return Response.status(201).entity(result).build();
	}

	@Override
	@POST
	@Path("/Remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remove(String idJson) throws Exception {
		JSONObject obj = new JSONObject(idJson);
		String result = String.valueOf(catDao.remove(obj.getString("id")));
		return Response.status(200).entity(result).build();
	}

	@Override
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Category t) throws Exception {
		String result = String.valueOf(catDao.update(t));
		return Response.status(200).entity(result).build();
	}

}
