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

import com.bananealcanws.dao.ImportantDateDao;
import com.bananealcanws.model.ImportantDate;

public class ImportantDateService implements IService<ImportantDate> {

	private static final ImportantDateDao imdateDao = new ImportantDateDao();

	@Override
	@GET
	@Path("/GetById")
	@Produces(MediaType.APPLICATION_JSON)
	public ImportantDate getById(@Context UriInfo params) throws Exception {
		String id = params.getQueryParameters().getFirst("id");
		return imdateDao.getById(id);
	}

	@Override
	public List<ImportantDate> searchByName(@Context UriInfo params) throws Exception {
		return null;
	}

	@Override
	public List<ImportantDate> getAll() throws Exception {
		return null;
	}

	@Override
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(ImportantDate t) throws Exception {
		String result = String.valueOf(imdateDao.create(t));
		return Response.status(201).entity(result).build();
	}

	@Override
	@POST
	@Path("/Remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remove(String idJson) throws Exception {
		JSONObject obj = new JSONObject(idJson);
		String result = String.valueOf(imdateDao.remove(obj.getString("id")));
		return Response.status(200).entity(result).build();
	}

	@Override
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(ImportantDate t) throws Exception {
		String result = String.valueOf(imdateDao.update(t));
		return Response.status(200).entity(result).build();
	}
}
