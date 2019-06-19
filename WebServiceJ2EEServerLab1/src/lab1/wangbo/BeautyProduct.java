package lab1.wangbo;

/**
 * @author WangBo
 * @date 20.05.2019
 */
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

	public BeautyProduct(String name, String producingCountry, Integer vendorCode, String category, Double price) {
		super();
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


	public String getCategory() {
		return category;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProducingCountry() {
		return producingCountry;
	}

	public void setProducingCountry(String producingCountry) {
		this.producingCountry = producingCountry;
	}

	public Integer getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(Integer vendorCode) {
		this.vendorCode = vendorCode;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
