package com.bananealcanws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bananealcanws.model.Gift;

public class GiftDao implements IDao<Gift> {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Gift gift = new Gift();
		// gift.setName("test1");
		// gift.setDetail("test1");
		// gift.setWishListId("2");
		// gift.setId("5");
		// new GiftDao().updateGift(gift);

		// new GiftDao().removeGift("4");

		// Gift gift = new Gift();
		// gift.setName("test");
		// gift.setDetail("test");
		// gift.setWishListId("1");
		// new GiftDao().addGift(gift);

		// List<Gift> gifts = new GiftDao().getAll();
		//
		// for (Gift gift : gifts) {
		// System.out.println(gift.getId());
		// System.out.println(gift.getName());
		// System.out.println(gift.getDetail());
		// System.out.println(gift.getWishListId());
		// }

		// List<Gift> gifts = new GiftDao().searchGiftsByName("a");
		//
		// for (Gift gift : gifts) {
		// System.out.println(gift.getId());
		// System.out.println(gift.getName());
		// System.out.println(gift.getDetail());
		// System.out.println(gift.getWishListId());
		// }
	}

	@Override
	public Gift getById(String id) throws ClassNotFoundException, SQLException {
		Gift g = null;
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from gift where id = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				g = new Gift();
				g.setId(rs.getString("id"));
				g.setName(rs.getString("name"));
				g.setDetail(rs.getString("description"));
				g.setWishListId(rs.getString("wishlist_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return g;
	}

	@Override
	public List<Gift> searchByName(String name) throws ClassNotFoundException, SQLException {
		List<Gift> gifts = new ArrayList<>();
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from gift where name like ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, "%" + name + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				Gift g = new Gift();
				g.setId(rs.getString("id"));
				g.setName(rs.getString("name"));
				g.setDetail(rs.getString("description"));
				g.setWishListId(rs.getString("wishlist_id"));
				gifts.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return gifts;
	}

	@Override
	public List<Gift> getAll() throws ClassNotFoundException {
		List<Gift> gifts = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from gift";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcandb", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery();) {

			while (rs.next()) {
				Gift g = new Gift();
				g.setId(rs.getString("id"));
				g.setName(rs.getString("name"));
				g.setDetail(rs.getString("description"));
				g.setWishListId(rs.getString("wishlist_id"));
				gifts.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gifts;
	}

	@Override
	public boolean create(Gift gift) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "insert into `gift` (`name`,`description`,`wishlist_id`) values (?,?,?)";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, gift.getName());
			st.setString(2, gift.getDetail());
			st.setString(3, gift.getWishListId());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(String id) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "delete from gift where id = ? ";
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
	public boolean update(Gift gift) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "update gift set name = ?, description = ?, wishlist_id = ? where id = ? ";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, gift.getName());
			st.setString(2, gift.getDetail());
			st.setString(3, gift.getWishListId());
			st.setString(4, gift.getId());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
