package lab6.wangbo.rest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author WangBo
 * @date 26.05.2019
 */
public class PostgreSQLDAO {

	public List<BeautyProduct> getBeautyProducts() {
		List<BeautyProduct> beautyProducts = new ArrayList<BeautyProduct>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from \"BeautyProducts\"");

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String producingCountry = rs.getString("producingCountry");
				Integer vendorCode = rs.getInt("vendorCode");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				BeautyProduct beautyProduct = new BeautyProduct(id, name, producingCountry, vendorCode, category,
						price);
				beautyProducts.add(beautyProduct);
			}
		} catch (SQLException ex) {
			Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return beautyProducts;
	}

	public List<BeautyProduct> findBeautyProduct(String id, String name, String producingCountry, String vendorCode,
			String category, String price) {
		System.out.println("Debug findBeautyProduct params: " + id + " " + name + " " + producingCountry + " "
				+ vendorCode + " " + price);

		ArrayList<String> query_where = new ArrayList<String>();
		if ((id != null) && !id.isEmpty())
			query_where.add("id=" + id + "");
		if ((name != null) && !name.isEmpty())
			query_where.add("name='" + name + "'");
		if ((producingCountry != null) && !producingCountry.isEmpty())
			query_where.add("producingCountry='" + producingCountry + "'");
		if ((vendorCode != null) && !vendorCode.isEmpty())
			query_where.add("vendorCode='" + vendorCode + "'");
		if ((category != null) && !category.isEmpty())
			query_where.add("category=" + category + "");
		if ((price != null) && !price.isEmpty())
			query_where.add("price=" + price + "");

		String query = new String();
		if (query_where.size() > 0)
			query = "select * from \"BeautyProducts\" where " + String.join(" and ", query_where);
		System.out.println("Debug findBeautyProduct query: " + query);

		List<BeautyProduct> beautyProducts = findBeautyProduct(query);
		return beautyProducts;
	}

	public List<BeautyProduct> findBeautyProduct(String query) {
		List<BeautyProduct> beautyProducts = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String producingCountry = rs.getString("producingCountry");
				String vendorCode = rs.getString("vendorCode");
				String category = rs.getString("category");
				String price = rs.getString("price");

				BeautyProduct beautyProduct = new BeautyProduct(id, name, producingCountry,
						Integer.parseInt(vendorCode), category, Double.parseDouble(price));
				beautyProducts.add(beautyProduct);
				System.out.println("get beautyProduct");
			}
		} catch (SQLException ex) {
			Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return beautyProducts;
	}

	public Integer insertBeautyProduct(String name, String producingCountry, String vendorCode, String category,
			String price) {
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		if ((name != null) && !name.isEmpty()) {
			keys.add("name");
			values.add("?");
		}
		if ((vendorCode != null) && !vendorCode.isEmpty()) {
			keys.add("vendorCode");
			values.add("?");
		}
		if ((producingCountry != null) && !producingCountry.isEmpty()) {
			keys.add("producingCountry");
			values.add("?");
		}
		if ((category != null) && !category.isEmpty()) {
			keys.add("category");
			values.add("?");
		}
		if ((price != null) && !price.isEmpty()) {
			keys.add("price");
			values.add("?");
		}

		String query = "INSERT INTO \"BeautyProducts\"(" + String.join(", ", keys) + ") VALUES ("
				+ String.join(", ", values) + ")";
		System.out.println(query);

		Integer id = -1;
		try (Connection connection = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			int index = 1;
			if ((name != null) && !name.isEmpty()) {
				stmt.setString(index, name);
				++index;
			}
			if ((vendorCode != null) && !vendorCode.isEmpty()) {
				stmt.setInt(index, Integer.parseInt(vendorCode));
				++index;
			}
			if ((producingCountry != null) && !producingCountry.isEmpty()) {
				stmt.setString(index, producingCountry);
				++index;
			}
			if ((category != null) && !category.isEmpty()) {
				stmt.setString(index, category);
				++index;
			}
			if ((price != null) && !price.isEmpty()) {
				stmt.setDouble(index, Double.parseDouble(price));
			}

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
				System.out.println("Insert row with id = " + id);
			}
		} catch (SQLException ex) {
			Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return id;
	}

	public String updateBeautyProduct(String id, String name, String producingCountry, String vendorCode,
			String category, String price) {
		if (id.isEmpty())
			return "Wrong query: Id is empty";

		ArrayList<String> keys = new ArrayList<String>();
		if ((name != null) && !name.isEmpty()) {
			keys.add("name=?");
		}
		if ((vendorCode != null) && !vendorCode.isEmpty()) {
			keys.add("vendorCode=?");
		}
		if ((producingCountry != null) && !producingCountry.isEmpty()) {
			keys.add("producingCountry=?");
		}
		if ((category != null) && !category.isEmpty()) {
			keys.add("category=?");
		}
		if ((price != null) && !price.isEmpty()) {
			keys.add("price=?");
		}

		String query = "UPDATE \"BeautyProducts\" SET " + String.join(", ", keys) + " WHERE id=?";
		System.out.println(query);

		String status;
		try (Connection connection = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(query);

			int index = 1;
			if ((name != null) && !name.isEmpty()) {
				stmt.setString(index, name);
				++index;
			}
			if ((vendorCode != null) && !vendorCode.isEmpty()) {
				stmt.setInt(index, Integer.parseInt(vendorCode));
				++index;
			}
			if ((producingCountry != null) && !producingCountry.isEmpty()) {
				stmt.setString(index, producingCountry);
				++index;
			}
			if ((category != null) && !category.isEmpty()) {
				stmt.setString(index, category);
				++index;
			}
			if ((price != null) && !price.isEmpty()) {
				stmt.setDouble(index, Double.parseDouble(price));
				++index;
			}
			stmt.setInt(index, Integer.parseInt(id));

			int count_row = stmt.executeUpdate();
			status = (count_row > 0) ? ("Updated " + count_row + " row") : "No updated row";
		} catch (SQLException ex) {
			status = "Error:" + ex.toString();
			Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return status;
	}

	public String deleteBeautyProduct(String id) {
		if (id.isEmpty())
			return "Wrong query: Id is empty";

		String status;
		try (Connection connection = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement("DELETE from \"BeautyProducts\" where id=?");
			stmt.setInt(1, Integer.parseInt(id));
			int count_row = stmt.executeUpdate();
			status = (count_row > 0) ? ("Deleted " + count_row + " row") : "No deleted row";
		} catch (SQLException ex) {
			status = "Error:" + ex.toString();
			Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return status;
	}

}
