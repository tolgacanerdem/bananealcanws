package com.bananealcanws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bananealcanws.model.Friendship;
import com.bananealcanws.model.Member;

public class FriendshipDao implements IDao<Friendship> {

	@Override
	public Friendship getById(String id) throws Exception {
		Friendship friendList = null;
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from friendship where id = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				friendList = new Friendship();
				friendList.setId(rs.getString("id"));
				friendList.setId(rs.getString("member_id"));
				friendList.setFriend_id(rs.getString("friend_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return friendList;
	}

	@Override
	public List<Friendship> searchByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friendship> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Friendship t) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "insert into `friendship` (`member_id`,`friend_id`) values (?,?)";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, t.getMember_id());
			st.setString(2, t.getFriend_id());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "delete from friendship where id = ? ";
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

	@Override
	public boolean update(Friendship t) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "update friendship set member_id = ?, friend_id = ? where id = ? ";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, t.getMember_id());
			st.setString(2, t.getFriend_id());
			st.setString(3, t.getId());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removeFriend(String memberId, String friendId) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "delete from friendship where member_id = ? and friend_id = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, memberId);
			st.setString(2, friendId);
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Member> getFriends(String memberId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from member where where id in ( select friend_id from friendship where member_id = ? )";
		List<Member> friends = new ArrayList<>();
		ResultSet rs = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, memberId);
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
				friends.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return friends;
	}

}
