package com.bananealcanws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bananealcanws.model.Member;

public class MemberDao implements IDao<Member> {
	public List<Member> getAllMembers() throws ClassNotFoundException {
		List<Member> members = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from member";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery();) {

			while (rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setMail(rs.getString("mail"));
				m.setName(rs.getString("name"));
				m.setPassword(rs.getString("password"));
				m.setProfileImage(rs.getString("profile_image_url"));
				m.setSurname(rs.getString("surname"));
				m.setUsername(rs.getString("username"));
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	public Member getMemberById(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from member where id = ?";
		Member member = null;
		ResultSet rs = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setProfileImage(rs.getString("profile_image_url"));
				member.setSurname(rs.getString("surname"));
				member.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return member;
	}

	public Member getMemberByName(String name) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from member where name = ?";
		Member member = null;
		ResultSet rs = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, name);
			rs = st.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setProfileImage(rs.getString("profile_image_url"));
				member.setSurname(rs.getString("surname"));
				member.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return member;
	}

	public Member getMemberByMail(String mail) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from member where mail = ?";
		Member member = null;
		ResultSet rs = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, mail);
			rs = st.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setProfileImage(rs.getString("profile_image_url"));
				member.setSurname(rs.getString("surname"));
				member.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return member;
	}

	public List<Member> searchMemberByName(String name) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from member where name like ?";
		List<Member> members = new ArrayList<>();
		ResultSet rs = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, "%" + name + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setProfileImage(rs.getString("profile_image_url"));
				member.setSurname(rs.getString("surname"));
				member.setUsername(rs.getString("username"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return members;
	}

	public boolean addMember(Member member) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "insert into `member` (`name`,`surname`,`username`,`mail`,`password`,`profile_image_url`) values (?,?,?,?,?,?)";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, member.getName());
			st.setString(2, member.getSurname());
			st.setString(3, member.getUsername());
			st.setString(4, member.getMail());
			st.setString(5, member.getPassword());
			st.setString(6, member.getProfileImage());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean removeMember(String id) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "delete from member where id = ? ";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, id);
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateMember(Member member) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "update member set name = ?, surname = ?, username = ?, mail = ?, password = ?, profile_image_url = ? where id = ? ";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, member.getName());
			st.setString(2, member.getSurname());
			st.setString(3, member.getUsername());
			st.setString(4, member.getMail());
			st.setString(5, member.getPassword());
			st.setString(6, member.getProfileImage());
			st.setString(7, member.getId());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Member getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> searchByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Member t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Member t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
