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

import com.bananealcanws.dao.IDao;
import com.bananealcanws.dao.MemberDao;
import com.bananealcanws.helper.DaoHelper;
import com.bananealcanws.model.Member;

@Path("/MemberService")
public class MemberService implements IService<Member> {

	private static final IDao<Member> memberDao = new MemberDao();

	@Override
	@GET
	@Path("/GetById")
	@Produces(MediaType.APPLICATION_JSON)
	public Member getById(@Context UriInfo params) throws Exception {
		return DaoHelper.GetMemberById(params, memberDao);
	}

	@GET
	@Path("/SearchByName")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Member> searchByName(UriInfo params) throws Exception {
		String name = params.getQueryParameters().getFirst("name");
		return memberDao.searchByName(name);
	}

	@Override
	@GET
	@Path("/GetAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getAll() throws Exception {
		return memberDao.getAll();
	}

	@Override
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Member member) throws Exception {
		String result = String.valueOf(memberDao.create(member));
		return Response.status(201).entity(result).build();
	}

	@Override
	@POST
	@Path("/Remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(String idJson) throws Exception {
		JSONObject obj = new JSONObject(idJson);
		String result = String.valueOf(memberDao.remove(obj.getString("id")));
		return Response.status(200).entity(result).build();
	}

	@Override
	@POST
	@Path("/Update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Member member) throws Exception {
		String result = String.valueOf(memberDao.update(member));
		return Response.status(200).entity(result).build();
	}

}
