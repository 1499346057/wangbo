package lab4.wangbo.restee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author WangBo
 * @date 23.05.2019
 */
public class PostgreDao {
	private Connection connection;

	public PostgreDao(Connection connection) {
		this.connection = connection;
	}

	public List<BeautyProduct> getBeautyProducts() {
		List<BeautyProduct> beautyProducts = new ArrayList<BeautyProduct>();
		try {
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
			Logger.getLogger(PostgreDao.class.getName()).log(Level.SEVERE, null, ex);
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
		try {
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
			Logger.getLogger(PostgreDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return beautyProducts;
	}
}
