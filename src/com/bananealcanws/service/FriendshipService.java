package com.bananealcanws.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.bananealcanws.model.Friendship;

public class FriendshipService implements IService<Friendship> {

	@Override
	@GET
	@Path("/GetById")
	@Produces(MediaType.APPLICATION_JSON)
	public Friendship getById(UriInfo params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friendship> searchByName(UriInfo params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friendship> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response create(Friendship t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response remove(String idJson) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response update(Friendship t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
