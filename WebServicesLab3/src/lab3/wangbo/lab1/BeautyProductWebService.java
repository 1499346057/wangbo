package lab3.wangbo.lab1;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import lab3.wangbo.exception.EmptyIdentifierException;
import lab3.wangbo.exception.EmptyIdentifierExceptionBean;
import lab3.wangbo.exception.NonKeySpecifiedException;
import lab3.wangbo.exception.NonKeySpecifiedExceptionBean;


/**
 * @author WangBo
 * @date 23.05.2019
 */
@WebService(serviceName = "BeautyProductService")
public class BeautyProductWebService {

	@WebMethod(operationName = "getBeautyProducts")
	public List<BeautyProduct> getBeautyProducts() {
		PostgreSqlDao dao = new PostgreSqlDao();
		List<BeautyProduct> beautyProducts = dao.getBeautyProducts();
		return beautyProducts;
	}

	@WebMethod(operationName = "insertBeautyProduct")
	public Integer insertBeautyProduct(String name, String producingCountry, String vendorCode, String category,
			String price) throws NonKeySpecifiedException {
		if ((name == null || name.isEmpty()) && (producingCountry == null || producingCountry.isEmpty())
				&& (vendorCode == null || vendorCode.isEmpty()) && (category == null || category.isEmpty())
				&& (price == null || price.isEmpty())) {
			NonKeySpecifiedExceptionBean fault = new NonKeySpecifiedExceptionBean();
			throw new NonKeySpecifiedException("No one key is specified.", fault);
		}
		PostgreSqlDao dao = new PostgreSqlDao();
		Integer beautyProductId = dao.insertBeautyProduct(name, producingCountry, vendorCode, category, price);
		return beautyProductId;
	}

	@WebMethod(operationName = "updateBeautyProduct")
	public String updateBeautyProduct(String id, String name, String producingCountry, String vendorCode,
			String category, String price) throws EmptyIdentifierException, NonKeySpecifiedException {
		if (id == null || id.isEmpty()) {
			EmptyIdentifierExceptionBean fault = new EmptyIdentifierExceptionBean();
			throw new EmptyIdentifierException("Product identifier is not specified.", fault);
		}
		if ((name == null || name.isEmpty()) && (producingCountry == null || producingCountry.isEmpty())
				&& (vendorCode == null || vendorCode.isEmpty()) && (category == null || category.isEmpty())
				&& (price == null || price.isEmpty())) {
			NonKeySpecifiedExceptionBean fault = new NonKeySpecifiedExceptionBean();
			throw new NonKeySpecifiedException("No one key is specified.", fault);
		}
		PostgreSqlDao dao = new PostgreSqlDao();
		String status = dao.updateBeautyProduct(id, name, producingCountry, vendorCode, category, price);
		return status;
	}

	@WebMethod(operationName = "deleteBeautyProduct")
	public String deleteBeautyProduct(String id) throws EmptyIdentifierException {
		if (id == null || id.isEmpty()) {
			EmptyIdentifierExceptionBean fault = new EmptyIdentifierExceptionBean();
			throw new EmptyIdentifierException("Product identifier is not specified.", fault);
		}
		PostgreSqlDao dao = new PostgreSqlDao();
		String status = dao.deleteBeautyProduct(id);
		return status;
	}

	@WebMethod(operationName = "findBeautyProduct")
	public List<BeautyProduct> findBeautyProduct(String id, String name, String producingCountry, String vendorCode,
			String category, String price) throws NonKeySpecifiedException {
		if ((name == null || name.isEmpty()) && (producingCountry == null || producingCountry.isEmpty())
				&& (vendorCode == null || vendorCode.isEmpty()) && (category == null || category.isEmpty())
				&& (price == null || price.isEmpty())) {
			NonKeySpecifiedExceptionBean fault = new NonKeySpecifiedExceptionBean();
			throw new NonKeySpecifiedException("No one key is specified.", fault);
		}
		PostgreSqlDao dao = new PostgreSqlDao();
		List<BeautyProduct> beautyProducts = dao.findBeautyProduct(id, name, producingCountry, vendorCode, category,
				price);
		return beautyProducts;
	}

}
