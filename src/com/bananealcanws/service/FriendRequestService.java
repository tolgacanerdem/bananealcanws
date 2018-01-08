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

import com.bananealcanws.dao.FriendRequestDao;
import com.bananealcanws.model.FriendRequest;

@Path("/FriendRequestService")
public class FriendRequestService implements IService<FriendRequest> {

	private static final FriendRequestDao frDao = new FriendRequestDao();

	@POST
	@Path("/GetFriendRequestsToMember")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFriendRequestsToMember(String memberIdJson) throws Exception {
		JSONObject obj = new JSONObject(memberIdJson);
		List<FriendRequest> result = frDao.getFriendRequestsToMember(obj.getString("memberId"));
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/GetFriendRequestsFromMember")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFriendRequestsFromMember(String memberIdJson) throws Exception {
		JSONObject obj = new JSONObject(memberIdJson);
		List<FriendRequest> result = frDao.getFriendRequestsFromMember(obj.getString("memberId"));
		return Response.status(200).entity(result).build();
	}

	@Override
	@GET
	@Path("/GetById")
	@Produces(MediaType.APPLICATION_JSON)
	public FriendRequest getById(@Context UriInfo params) throws Exception {
		String id = params.getQueryParameters().getFirst("id");
		return frDao.getById(id);
	}

	@Override
	public List<FriendRequest> searchByName(@Context UriInfo params) throws Exception {
		return null;
	}

	@Override
	public List<FriendRequest> getAll() throws Exception {
		return null;
	}

	@Override
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(FriendRequest t) throws Exception {
		return Response.status(201).entity(frDao.create(t)).build();
	}

	@Override
	@POST
	@Path("/Remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(String idJson) throws Exception {
		JSONObject obj = new JSONObject(idJson);
		return Response.status(200).entity(frDao.remove(obj.getString("id"))).build();
	}

	@Override
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(FriendRequest t) throws Exception {
		return Response.status(200).entity(frDao.update(t)).build();
	}

}
