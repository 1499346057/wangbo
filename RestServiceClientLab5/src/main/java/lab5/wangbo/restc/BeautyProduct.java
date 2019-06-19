package lab5.wangbo.restc;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author WangBo
 * @date 24.05.2019
 */
@XmlRootElement
public class BeautyProduct {
	private Integer id;
	private String name;
	private String producingCountry;
	private Integer vendorCode;
	private String category;
	private Double price;

	public BeautyProduct() {
	}

	public BeautyProduct(Integer id, String name, String producingCountry, Integer vendorCode, String category,
			Double price) {
		this.id = id;
		this.name = name;
		this.producingCountry = producingCountry;
		this.vendorCode = vendorCode;
		this.category = category;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProducingCountry() {
		return producingCountry;
	}

	public Integer getVendorCode() {
		return vendorCode;
	}

	public String getCategory() {
		return category;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducingCountry(String producingCountry) {
		this.producingCountry = producingCountry;
	}

	public void setVendorCode(Integer vendorCode) {
		this.vendorCode = vendorCode;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BeautyProduct{ id = " + id + ", name = " + name + ", vendor code = " + vendorCode
				+ ", producing country = " + producingCountry + ", category = " + category + ", price = " + price + '}';
	}
}
