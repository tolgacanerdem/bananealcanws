package com.bananealcanws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bananealcanws.model.FriendRequest;

public class FriendRequestDao implements IDao<FriendRequest> {

	public List<FriendRequest> getFriendRequestsToMember(String memberId) throws ClassNotFoundException {
		List<FriendRequest> frs = new ArrayList<>();
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from friend_request where to_member = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, memberId);
			rs = st.executeQuery();

			while (rs.next()) {
				FriendRequest fr = new FriendRequest();
				fr.setId(rs.getString("id"));
				fr.setFromMember(rs.getString("from_member"));
				fr.setToMember(rs.getString("to_member"));
				fr.setStatus(rs.getString("status"));
				frs.add(fr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frs;
	}

	public List<FriendRequest> getFriendRequestsFromMember(String memberId) throws ClassNotFoundException {
		List<FriendRequest> frs = new ArrayList<>();
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from friend_request where from_member = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, memberId);
			rs = st.executeQuery();

			while (rs.next()) {
				FriendRequest fr = new FriendRequest();
				fr.setId(rs.getString("id"));
				fr.setFromMember(rs.getString("from_member"));
				fr.setToMember(rs.getString("to_member"));
				fr.setStatus(rs.getString("status"));
				frs.add(fr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frs;
	}

	@Override
	public FriendRequest getById(String id) throws Exception {
		FriendRequest fr = null;
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from friend_request where id = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				fr = new FriendRequest();
				fr.setId(rs.getString("id"));
				fr.setFromMember(rs.getString("from_member"));
				fr.setToMember(rs.getString("to_member"));
				fr.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return fr;
	}

	@Override
	public List<FriendRequest> searchByName(String name) throws Exception {
		return null;
	}

	@Override
	public List<FriendRequest> getAll() throws Exception {
		return null;
	}

	@Override
	public boolean create(FriendRequest fr) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "insert into `friend_request` (`from_member`,`to_member`,`status`) values (?,?,?)";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, fr.getFromMember());
			st.setString(2, fr.getToMember());
			st.setString(3, fr.getStatus());
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
		String query = "delete from friend_request where id = ? ";
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
	public boolean update(FriendRequest fr) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "update friend_request set from_member = ?, to_member = ?, status = ? where id = ? ";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, fr.getFromMember());
			st.setString(2, fr.getToMember());
			st.setString(3, fr.getStatus());
			st.setString(4, fr.getId());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
