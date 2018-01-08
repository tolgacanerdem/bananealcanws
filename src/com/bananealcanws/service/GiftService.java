package com.bananealcanws.service;

import java.sql.SQLException;
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

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bananealcanws.dao.GiftDao;
import com.bananealcanws.model.Gift;

@Path("/GiftService")
public class GiftService implements IService<Gift> {

	private static final GiftDao giftDao = new GiftDao();

	@Override
	@GET
	@Path("/GetAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gift> getAll() throws ClassNotFoundException {
		return giftDao.getAll();
	}

	@Override
	@GET
	@Path("/GetById")
	@Produces(MediaType.APPLICATION_JSON)
	public Gift getById(@Context UriInfo params) throws ClassNotFoundException, SQLException {
		String id = params.getQueryParameters().getFirst("id");
		return giftDao.getById(id);
	}

	@Override
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Gift gift) throws Exception {
		String result = String.valueOf(giftDao.create(gift));
		return Response.status(201).entity(result).build();
	}

	@Override
	@GET
	@Path("/SearchByName")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gift> searchByName(@Context UriInfo params) throws ClassNotFoundException, SQLException {
		String name = params.getQueryParameters().getFirst("name");
		return giftDao.searchByName(name);
	}

	@Override
	@POST
	@Path("/Remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(String idJson) throws ClassNotFoundException, SQLException, JSONException {
		JSONObject obj = new JSONObject(idJson);
		String result = String.valueOf(giftDao.remove(obj.getString("id")));
		return Response.status(200).entity(result).build();
	}

	@Override
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Gift gift) throws ClassNotFoundException, SQLException, JSONException {
		String result = String.valueOf(giftDao.update(gift));
		return Response.status(200).entity(result).build();
	}
}
