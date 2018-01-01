package com.bananealcanws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bananealcanws.model.WishList;

public class WishListDao implements IDao<WishList> {

	@Override
	public WishList getById(String id) throws Exception {
		WishList wishList = null;
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from wishlist where id = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				wishList = new WishList();
				wishList.setId(rs.getString("id"));
				wishList.setId(rs.getString("member_id"));
				wishList.setCategoryId(rs.getString("category_id"));
				wishList.setName(rs.getString("name"));
				wishList.setDetail(rs.getString("detail"));
				wishList.setCreationDate(rs.getDate("creation_date"));
				wishList.setLastUpdateDate(rs.getDate("last_update_date"));
				wishList.setPublicUrl(rs.getString("url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return wishList;
	}

	@Override
	public List<WishList> searchByName(String name) throws Exception {
		List<WishList> wishLists = new ArrayList<>();
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from wishlist where name like ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, "%" + name + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				WishList wishList = new WishList();
				wishList.setId(rs.getString("id"));
				wishList.setId(rs.getString("member_id"));
				wishList.setCategoryId(rs.getString("category_id"));
				wishList.setName(rs.getString("name"));
				wishList.setDetail(rs.getString("detail"));
				wishList.setCreationDate(rs.getDate("creation_date"));
				wishList.setLastUpdateDate(rs.getDate("last_update_date"));
				wishList.setPublicUrl(rs.getString("url"));
				wishLists.add(wishList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return wishLists;
	}

	@Override
	public List<WishList> getAll() throws Exception {
		List<WishList> wishLists = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from wishlist";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery();) {

			while (rs.next()) {
				WishList wishList = new WishList();
				wishList.setId(rs.getString("id"));
				wishList.setId(rs.getString("member_id"));
				wishList.setCategoryId(rs.getString("category_id"));
				wishList.setName(rs.getString("name"));
				wishList.setDetail(rs.getString("detail"));
				wishList.setCreationDate(rs.getDate("creation_date"));
				wishList.setLastUpdateDate(rs.getDate("last_update_date"));
				wishList.setPublicUrl(rs.getString("url"));
				wishLists.add(wishList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wishLists;
	}

	@Override
	public boolean create(WishList wl) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "insert into `wishlist` (`member_id`,`category_id`,`name`,`detail`,`creation_date`,`last_update_date`,`url`) values (?,?,?,?,?,?,?)";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, wl.getMemberId());
			st.setString(2, wl.getCategoryId());
			st.setString(3, wl.getName());
			st.setString(4, wl.getDetail());
			st.setDate(5, wl.getCreationDate());
			st.setDate(6, wl.getLastUpdateDate());
			st.setString(7, wl.getPublicUrl());
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
		String query = "delete from wishlist where id = ? ";
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
	public boolean update(WishList wl) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "update wishlist set member_id = ?, category_id = ?, name = ?, detail = ?, creation_date = ?, last_update_date = ?, url = ? where id = ? ";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, wl.getMemberId());
			st.setString(2, wl.getCategoryId());
			st.setString(3, wl.getName());
			st.setString(4, wl.getDetail());
			st.setDate(5, wl.getCreationDate());
			st.setDate(6, wl.getLastUpdateDate());
			st.setString(7, wl.getPublicUrl());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
