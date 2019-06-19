package lab2.wangbo.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for insertBeautyProductResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="insertBeautyProductResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @author WangBo
 * @date 20.05.2019
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertBeautyProductResponse", propOrder = { "_return" })
public class InsertBeautyProductResponse {

	@XmlElement(name = "return")
	protected Integer _return;

	/**
	 * Gets the value of the return property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getReturn() {
		return _return;
	}

	/**
	 * Sets the value of the return property.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setReturn(Integer value) {
		this._return = value;
	}

}
