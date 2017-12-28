package com.bananealcanws.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.bananealcanws.dao.MemberDao;
import com.bananealcanws.model.Member;

@Path("/MemberService")
public class MemberService {
	MemberDao memberDao = new MemberDao();

	@GET
	@Path("/Members")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getAllMembers() throws ClassNotFoundException {
		return memberDao.getAllMembers();
	}

	@GET
	@Path("/MemberById")
	@Produces(MediaType.APPLICATION_JSON)
	public Member getMemberById(@QueryParam("id") String id) throws ClassNotFoundException, SQLException {
		return memberDao.getMemberById(id);
	}

}
