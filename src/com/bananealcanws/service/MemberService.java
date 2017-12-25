package com.bananealcanws.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bananealcanws.dao.MemberDao;
import com.bananealcanws.model.Member;

@Path("/MemberService")
public class MemberService {
	MemberDao memberDao = new MemberDao();

	@GET
	@Path("/members")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getAllMembers() {
		return memberDao.getAllMembers();
	}

}
