package com.bananealcanws.helper;

import javax.ws.rs.core.UriInfo;

import com.bananealcanws.dao.IDao;
import com.bananealcanws.model.Member;

public class DaoHelper {

	public static Member GetMemberById(UriInfo params, IDao<Member> memberDao) throws Exception {
		String id = params.getQueryParameters().getFirst("id");
		return memberDao.getById(id);
	}
}
