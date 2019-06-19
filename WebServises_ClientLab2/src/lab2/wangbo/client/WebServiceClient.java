package lab2.wangbo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import lab2.wangbo.generated.BeautyProduct;
import lab2.wangbo.generated.BeautyProductService;

/**
 * @author WangBo
 * @date 22.05.2019
 */
public class WebServiceClient {

	private static BeautyProductService beautyProductService;

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/BeautyProductService?wsdl");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Choose service type: 1-standalone, 2-J2EE");

		try {
			String serviceType = br.readLine();
			switch (serviceType) {
			case "1":
				beautyProductService = new BeautyProductService(url);
				processQueryToStandalone();
				break;
			case "2":
				beautyProductService = new BeautyProductService(
						new URL("http://localhost:8080/WebServiceJ2EEServer_war_exploded/BeautyProductService?wsdl"));
				processQueryToJ2EE();
				break;
			default:
				System.out.println("Wrong enter!");
				return;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static void processQueryToStandalone() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println(
					"Please, select the type of action: 0 - select all, 1 - select, 2 - insert, 3 - update, 4 - delete, 5 - quit");
			try {
				String actionType = br.readLine();
				try {
					switch (actionType) {
					case "0":
						getAllBeautyProducts();
						break;
					case "1":
						findBeautyProduct(br);
						break;
					case "2":
						insertBeautyProduct(br);
						break;
					case "3":
						updateBeautyProduct(br);
						break;
					case "4":
						deleteBeautyProduct(br);
						break;
					case "5":
						System.exit(0);
						break;
					default:
						System.out.println("Wrong choose");
						break;
					}
				} catch (Exception ex) {
					System.out.println("Received error: " + ex.getMessage());
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	private static void processQueryToJ2EE() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			findBeautyProduct(br);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static void getAllBeautyProducts() {
		List<BeautyProduct> beautyProducts = beautyProductService.getBeautyProductWebServicePort().getBeautyProducts();
		printBeautyProducts(beautyProducts);
	}

	private static void findBeautyProduct(BufferedReader br) throws IOException {
		System.out.println("Please, write your query: key=value, separated by comma.");
		System.out.println("Available keys: id, name, producingСountry, vendorСode, category, price.");

		String userQuery = br.readLine();
		String keysValue[] = userQuery.split(",");
		String id = "", name = "", producingСountry = "", vendorСode = "", category = "", price = "";
		for (int j = 0; j < keysValue.length; j++) {
			String temp[] = keysValue[j].split("=");
			switch (temp[0]) {
			case "id":
				id = temp[1];
				break;
			case "name":
				name = temp[1];
				break;
			case "producingСountry":
				producingСountry = temp[1];
				break;
			case "vendorСode":
				vendorСode = temp[1];
				break;
			case "category":
				category = temp[1];
				break;
			case "price":
				price = temp[1];
				break;
			}
		}

		List<BeautyProduct> beautyProducts = beautyProductService.getBeautyProductWebServicePort().findBeautyProduct(id,
				name, producingСountry, vendorСode, category, price);
		printBeautyProducts(beautyProducts);
	}

	private static void insertBeautyProduct(BufferedReader br) throws IOException {
		System.out.println("Please, write insert query options: key=value, separated by comma.");
		System.out.println("Option keys: name, producingСountry, vendorСode, category, price.");

		String userQuery = br.readLine();
		String keysValue[] = userQuery.split(",");
		String name = "", producingСountry = "", vendorСode = "", category = "", price = "";
		for (int j = 0; j < keysValue.length; j++) {
			String temp[] = keysValue[j].split("=");
			switch (temp[0]) {
			case "name":
				name = temp[1];
				break;
			case "producingСountry":
				producingСountry = temp[1];
				break;
			case "vendorСode":
				vendorСode = temp[1];
				break;
			case "category":
				category = temp[1];
				break;
			case "price":
				price = temp[1];
				break;
			default:
				System.out.println("Wrong key");
				break;
			}
		}

		Integer id = beautyProductService.getBeautyProductWebServicePort().insertBeautyProduct(name, producingСountry,
				vendorСode, category, price);
		if (id >= 0)
			System.out.println("Beauty product has been inserted successfully. Id = " + id);
		else
			System.out.println("Something went wrong while insertion");
	}

	private static void updateBeautyProduct(BufferedReader br) throws IOException {
		System.out.println(
				"Please, enter new fields values and the id of the updated product: key=value, separated by comma.");
		System.out.println("Available keys for update: name, producingСountry, vendorСode, category, price.");

		String userQuery = br.readLine();
		String keysValue[] = userQuery.split(",");
		String id = "", name = "", producingСountry = "", vendorСode = "", category = "", price = "";
		for (int j = 0; j < keysValue.length; j++) {
			String temp[] = keysValue[j].split("=");
			switch (temp[0]) {
			case "id":
				id = temp[1];
				break;
			case "name":
				name = temp[1];
				break;
			case "producingСountry":
				producingСountry = temp[1];
				break;
			case "vendorСode":
				vendorСode = temp[1];
				break;
			case "category":
				category = temp[1];
				break;
			case "price":
				price = temp[1];
				break;
			}
		}

		String status = beautyProductService.getBeautyProductWebServicePort().updateBeautyProduct(id, name,
				producingСountry, vendorСode, category, price);
		System.out.println("Status: " + status);
	}

	private static void deleteBeautyProduct(BufferedReader br) throws IOException {
		System.out.println("Please, enter the id of the product you want to delete.");
		String id = br.readLine();
		String status = beautyProductService.getBeautyProductWebServicePort().deleteBeautyProduct(id);
		System.out.println("Status: " + status);
	}

	private static void printBeautyProducts(List<BeautyProduct> beautyProducts) {
		for (BeautyProduct beautyProduct : beautyProducts) {
			System.out.println("Beauty product{id = " + beautyProduct.getId() + ", name = " + beautyProduct.getName()
					+ ", producingСountry = " + beautyProduct.getProducingCountry() + ", vendorСode = "
					+ beautyProduct.getVendorCode() + ", category = " + beautyProduct.getCategory() + ", price = "
					+ beautyProduct.getPrice() + "}");
		}
		System.out.println("Total beauty products: " + beautyProducts.size());
	}
}
