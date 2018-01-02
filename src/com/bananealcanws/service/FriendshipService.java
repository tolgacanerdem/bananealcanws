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

import com.bananealcanws.dao.FriendshipDao;
import com.bananealcanws.model.Friendship;
import com.bananealcanws.model.Member;

public class FriendshipService implements IService<Friendship> {

	private static final FriendshipDao fsDao = new FriendshipDao();

	@Override
	@GET
	@Path("/GetById")
	@Produces(MediaType.APPLICATION_JSON)
	public Friendship getById(@Context UriInfo params) throws Exception {
		String id = params.getQueryParameters().getFirst("id");
		return fsDao.getById(id);
	}

	@Override
	public List<Friendship> searchByName(@Context UriInfo params) throws Exception {
		return null;
	}

	@Override
	public List<Friendship> getAll() throws Exception {
		return null;
	}

	@Override
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Friendship t) throws Exception {
		String res = String.valueOf(fsDao.create(t));
		return Response.status(200).entity(res).build();
	}

	@Override
	@POST
	@Path("/Remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remove(String idJson) throws Exception {
		JSONObject obj = new JSONObject(idJson);
		String result = String.valueOf(fsDao.remove(obj.getString("id")));
		return Response.status(200).entity(result).build();
	}

	@Override
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Friendship t) throws Exception {
		String result = String.valueOf(fsDao.update(t));
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/GetFriends")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getFriends(String memberId) throws Exception {
		List<Member> result = fsDao.getFriends(memberId);
		return Response.status(200).entity(result).build();
	}

}
