package lab4.wangbo.restee;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;

/**
 * @author WangBo
 * @date 23.05.2019
 */
@RequestScoped
@Path("/beautyProducts")
@Produces({ MediaType.APPLICATION_JSON })
public class BeautyProductResource {

	@Resource(lookup = "jdbc/mvideo")
	private DataSource dataSource;

	@GET
	public List<BeautyProduct> getPersons(@QueryParam("id") String id, @QueryParam("name") String name,
			@QueryParam("producingCountry") String producingCountry, @QueryParam("vendorCode") String vendorCode,
			@QueryParam("category") String category, @QueryParam("price") String price) {
		if ((id == null || id.isEmpty()) && (name == null || name.isEmpty())
				&& (producingCountry == null || producingCountry.isEmpty())
				&& (vendorCode == null || vendorCode.isEmpty()) && (category == null || category.isEmpty())
				&& (price == null || price.isEmpty())) {
			List<BeautyProduct> beautyProducts = new PostgreDao(getConnection()).getBeautyProducts();
			return beautyProducts;
		}

		id = (id == null) ? new String() : id;
		name = (name == null) ? new String() : name;
		producingCountry = (producingCountry == null) ? new String() : producingCountry;
		vendorCode = (vendorCode == null) ? new String() : vendorCode;
		price = (price == null) ? new String() : price;

		List<BeautyProduct> beautyProducts = new PostgreDao(getConnection()).findBeautyProduct(id, name,
				producingCountry, vendorCode, category, price);
		return beautyProducts;
	}

	private Connection getConnection() {
		Connection result = null;
		try {
			result = dataSource.getConnection();
		} catch (SQLException ex) {
			Logger.getLogger(BeautyProductResource.class.getName()).log(Level.SEVERE, null, ex);
		}
		return result;
	}

}
