package com.bananealcanws.dao;

import java.util.ArrayList;
import java.util.List;

import com.bananealcanws.model.Member;

public class MemberDao {
	public List<Member> getAllMembers() {
		List<Member> members = new ArrayList<>();
		members.add(new Member("1", "tolga", "musician", "username1", "tolga@gmail.com", "pass1"));
		members.add(new Member("2", "tolga", "musician", "username1", "tolga@gmail.com", "pass1"));
		members.add(new Member("3", "tolga", "musician", "username1", "tolga@gmail.com", "pass1"));
		return members;
	}

	public Member getMemberById(String id) {
		// search db by id
		return new Member();
	}

	public Member getMemberByName(String name) {
		// search db by name
		return new Member();
	}

	public Member getMemberByMail(String mail) {
		return new Member();
	}

	public List<Member> searchMemberByName(String name) {
		// search like
		return new ArrayList<>();
	}

	public boolean addMember(Member member) {
		return true;
	}

	public boolean removeMember(String id) {
		// passivate member at db
		return true;
	}

	public boolean updateMember(Member member) {
		return true;
	}
}
