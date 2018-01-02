package com.bananealcanws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bananealcanws.model.ImportantDate;

public class ImportantDateDao implements IDao<ImportantDate> {

	@Override
	public ImportantDate getById(String id) throws Exception {
		ImportantDate imdate = null;
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from important_date where id = ?";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {

			st.setString(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				imdate = new ImportantDate();
				imdate.setId(rs.getString("id"));
				imdate.setMemberId(rs.getString("member_id"));
				imdate.setDateName(rs.getString("date_name"));
				imdate.setDateDescription(rs.getString("date_description"));
				imdate.setImportantDate(rs.getDate("important_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return imdate;
	}

	@Override
	public List<ImportantDate> searchByName(String name) throws Exception {
		return null;
	}

	@Override
	public List<ImportantDate> getAll() throws Exception {
		return null;
	}

	@Override
	public boolean create(ImportantDate imdate) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "insert into `important_date` (`member_id`,`date_name`,`date_description`,`important_date`) values (?,?,?,?)";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, imdate.getMemberId());
			st.setString(2, imdate.getDateName());
			st.setString(3, imdate.getDateDescription());
			st.setDate(4, imdate.getImportantDate());
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
		String query = "delete from important_date where id = ? ";
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
	public boolean update(ImportantDate imdate) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String query = "update important_date set member_id = ?, date_name = ?, date_description = ?, important_date = ? where id = ? ";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://185.141.33.102:3306/bananealcanDB", "bnauser",
				"bnauser"); PreparedStatement st = con.prepareStatement(query);) {
			st.setString(1, imdate.getMemberId());
			st.setString(2, imdate.getDateName());
			st.setString(3, imdate.getDateDescription());
			st.setDate(4, imdate.getImportantDate());
			st.setString(5, imdate.getId());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
