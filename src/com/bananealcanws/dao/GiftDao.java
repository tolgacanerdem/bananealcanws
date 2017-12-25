package com.bananealcanws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bananealcanws.model.Gift;

public class GiftDao {

	public List<Gift> getAllGifts() throws ClassNotFoundException {
		List<Gift> gifts = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Connection");
		String query = "select * from gift";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "root",
				"..tolga20"); PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery();) {

			while (rs.next()) {
				Gift g = new Gift();
				g.setId(rs.getString("id"));
				g.setName(rs.getString("name"));
				g.setDetail(rs.getString("description"));
				gifts.add(g);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gifts;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		List<Gift> gifts = new GiftDao().getAllGifts();

		for (Gift gift : gifts) {
			System.out.println(gift.getId());
			System.out.println(gift.getName());
			System.out.println(gift.getDetail());
		}
	}
}
