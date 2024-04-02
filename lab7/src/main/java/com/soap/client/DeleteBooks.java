
package com.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteBooks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteBooks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="books_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteBooks", propOrder = {
    "booksId"
})
public class DeleteBooks {

    @XmlElement(name = "books_id")
    protected String booksId;

    /**
     * Gets the value of the booksId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBooksId() {
        return booksId;
    }

    /**
     * Sets the value of the booksId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBooksId(String value) {
        this.booksId = value;
    }

}
