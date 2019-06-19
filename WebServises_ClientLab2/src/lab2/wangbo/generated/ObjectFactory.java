package lab2.wangbo.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.wangbo.generated package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 * @author WangBo
 * @date 20.05.2019
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _GetBeautyProductsResponse_QNAME = new QName("http://lab1.wangbo.com/",
			"getBeautyProductsResponse");
	private final static QName _GetBeautyProducts_QNAME = new QName("http://lab1.wangbo.com/", "getBeautyProducts");
	private final static QName _FindBeautyProductResponse_QNAME = new QName("http://lab1.wangbo.com/",
			"findBeautyProductResponse");
	private final static QName _DeleteBeautyProductResponse_QNAME = new QName("http://lab1.wangbo.com/",
			"deleteBeautyProductResponse");
	private final static QName _InsertBeautyProductResponse_QNAME = new QName("http://lab1.wangbo.com/",
			"insertBeautyProductResponse");
	private final static QName _UpdateBeautyProduct_QNAME = new QName("http://lab1.wangbo.com/",
			"updateBeautyProduct");
	private final static QName _UpdateBeautyProductResponse_QNAME = new QName("http://lab1.wangbo.com/",
			"updateBeautyProductResponse");
	private final static QName _FindBeautyProduct_QNAME = new QName("http://lab1.wangbo.com/", "findBeautyProduct");
	private final static QName _DeleteBeautyProduct_QNAME = new QName("http://lab1.wangbo.com/",
			"deleteBeautyProduct");
	private final static QName _InsertBeautyProduct_QNAME = new QName("http://lab1.wangbo.com/",
			"insertBeautyProduct");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema
	 * derived classes for package: com.wangbo.generated
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link FindBeautyProduct }
	 * 
	 */
	public FindBeautyProduct createFindBeautyProduct() {
		return new FindBeautyProduct();
	}

	/**
	 * Create an instance of {@link UpdateBeautyProduct }
	 * 
	 */
	public UpdateBeautyProduct createUpdateBeautyProduct() {
		return new UpdateBeautyProduct();
	}

	/**
	 * Create an instance of {@link UpdateBeautyProductResponse }
	 * 
	 */
	public UpdateBeautyProductResponse createUpdateBeautyProductResponse() {
		return new UpdateBeautyProductResponse();
	}

	/**
	 * Create an instance of {@link DeleteBeautyProductResponse }
	 * 
	 */
	public DeleteBeautyProductResponse createDeleteBeautyProductResponse() {
		return new DeleteBeautyProductResponse();
	}

	/**
	 * Create an instance of {@link InsertBeautyProductResponse }
	 * 
	 */
	public InsertBeautyProductResponse createInsertBeautyProductResponse() {
		return new InsertBeautyProductResponse();
	}

	/**
	 * Create an instance of {@link DeleteBeautyProduct }
	 * 
	 */
	public DeleteBeautyProduct createDeleteBeautyProduct() {
		return new DeleteBeautyProduct();
	}

	/**
	 * Create an instance of {@link InsertBeautyProduct }
	 * 
	 */
	public InsertBeautyProduct createInsertBeautyProduct() {
		return new InsertBeautyProduct();
	}

	/**
	 * Create an instance of {@link FindBeautyProductResponse }
	 * 
	 */
	public FindBeautyProductResponse createFindBeautyProductResponse() {
		return new FindBeautyProductResponse();
	}

	/**
	 * Create an instance of {@link GetBeautyProducts }
	 * 
	 */
	public GetBeautyProducts createGetBeautyProducts() {
		return new GetBeautyProducts();
	}

	/**
	 * Create an instance of {@link GetBeautyProductsResponse }
	 * 
	 */
	public GetBeautyProductsResponse createGetBeautyProductsResponse() {
		return new GetBeautyProductsResponse();
	}

	/**
	 * Create an instance of {@link BeautyProduct }
	 * 
	 */
	public BeautyProduct createBeautyProduct() {
		return new BeautyProduct();
	}

	/**
	 * Create an instance of {@link JAXBElement
	 * }{@code <}{@link GetBeautyProductsResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "getBeautyProductsResponse")
	public JAXBElement<GetBeautyProductsResponse> createGetBeautyProductsResponse(GetBeautyProductsResponse value) {
		return new JAXBElement<GetBeautyProductsResponse>(_GetBeautyProductsResponse_QNAME,
				GetBeautyProductsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetBeautyProducts
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "getBeautyProducts")
	public JAXBElement<GetBeautyProducts> createGetBeautyProducts(GetBeautyProducts value) {
		return new JAXBElement<GetBeautyProducts>(_GetBeautyProducts_QNAME, GetBeautyProducts.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement
	 * }{@code <}{@link FindBeautyProductResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "findBeautyProductResponse")
	public JAXBElement<FindBeautyProductResponse> createFindBeautyProductResponse(FindBeautyProductResponse value) {
		return new JAXBElement<FindBeautyProductResponse>(_FindBeautyProductResponse_QNAME,
				FindBeautyProductResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement
	 * }{@code <}{@link DeleteBeautyProductResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "deleteBeautyProductResponse")
	public JAXBElement<DeleteBeautyProductResponse> createDeleteBeautyProductResponse(
			DeleteBeautyProductResponse value) {
		return new JAXBElement<DeleteBeautyProductResponse>(_DeleteBeautyProductResponse_QNAME,
				DeleteBeautyProductResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement
	 * }{@code <}{@link InsertBeautyProductResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "insertBeautyProductResponse")
	public JAXBElement<InsertBeautyProductResponse> createInsertBeautyProductResponse(
			InsertBeautyProductResponse value) {
		return new JAXBElement<InsertBeautyProductResponse>(_InsertBeautyProductResponse_QNAME,
				InsertBeautyProductResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBeautyProduct
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "updateBeautyProduct")
	public JAXBElement<UpdateBeautyProduct> createUpdateBeautyProduct(UpdateBeautyProduct value) {
		return new JAXBElement<UpdateBeautyProduct>(_UpdateBeautyProduct_QNAME, UpdateBeautyProduct.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement
	 * }{@code <}{@link UpdateBeautyProductResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "updateBeautyProductResponse")
	public JAXBElement<UpdateBeautyProductResponse> createUpdateBeautyProductResponse(
			UpdateBeautyProductResponse value) {
		return new JAXBElement<UpdateBeautyProductResponse>(_UpdateBeautyProductResponse_QNAME,
				UpdateBeautyProductResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link FindBeautyProduct
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "findBeautyProduct")
	public JAXBElement<FindBeautyProduct> createFindBeautyProduct(FindBeautyProduct value) {
		return new JAXBElement<FindBeautyProduct>(_FindBeautyProduct_QNAME, FindBeautyProduct.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBeautyProduct
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "deleteBeautyProduct")
	public JAXBElement<DeleteBeautyProduct> createDeleteBeautyProduct(DeleteBeautyProduct value) {
		return new JAXBElement<DeleteBeautyProduct>(_DeleteBeautyProduct_QNAME, DeleteBeautyProduct.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link InsertBeautyProduct
	 * }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://lab1.wangbo.com/", name = "insertBeautyProduct")
	public JAXBElement<InsertBeautyProduct> createInsertBeautyProduct(InsertBeautyProduct value) {
		return new JAXBElement<InsertBeautyProduct>(_InsertBeautyProduct_QNAME, InsertBeautyProduct.class, null, value);
	}

}
