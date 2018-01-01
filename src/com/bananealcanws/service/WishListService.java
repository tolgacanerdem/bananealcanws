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

import com.bananealcanws.dao.WishListDao;
import com.bananealcanws.model.WishList;

public class WishListService implements IService<WishList> {

	private static final WishListDao wlDao = new WishListDao();

	@Override
	@GET
	@Path("/GetById")
	@Produces(MediaType.APPLICATION_JSON)
	public WishList getById(@Context UriInfo params) throws Exception {
		String id = params.getQueryParameters().getFirst("id");
		return wlDao.getById(id);
	}

	@Override
	@GET
	@Path("/SearchByName")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WishList> searchByName(@Context UriInfo params) throws Exception {
		String name = params.getQueryParameters().getFirst("name");
		return wlDao.searchByName(name);
	}

	@Override
	@GET
	@Path("/GetAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WishList> getAll() throws Exception {
		return wlDao.getAll();
	}

	@Override
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(WishList t) throws Exception {
		String result = String.valueOf(wlDao.create(t));
		return Response.status(201).entity(result).build();
	}

	@Override
	@POST
	@Path("/Remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remove(String idJson) throws Exception {
		JSONObject obj = new JSONObject(idJson);
		String result = String.valueOf(wlDao.remove(obj.getString("id")));
		return Response.status(200).entity(result).build();
	}

	@Override
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(WishList t) throws Exception {
		String result = String.valueOf(wlDao.update(t));
		return Response.status(200).entity(result).build();
	}

}
