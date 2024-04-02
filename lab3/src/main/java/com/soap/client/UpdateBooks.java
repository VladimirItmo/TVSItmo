
package com.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateBooks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateBooks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="books_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="booksTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="booksAuthorfirst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="booksAuthorlast" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="booksGenre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookPush" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateBooks", propOrder = {
    "booksId",
    "booksTitle",
    "booksAuthorfirst",
    "booksAuthorlast",
    "booksGenre",
    "bookPush"
})
public class UpdateBooks {

    @XmlElement(name = "books_id")
    protected String booksId;
    protected String booksTitle;
    protected String booksAuthorfirst;
    protected String booksAuthorlast;
    protected String booksGenre;
    protected String bookPush;

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

    /**
     * Gets the value of the booksTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBooksTitle() {
        return booksTitle;
    }

    /**
     * Sets the value of the booksTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBooksTitle(String value) {
        this.booksTitle = value;
    }

    /**
     * Gets the value of the booksAuthorfirst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBooksAuthorfirst() {
        return booksAuthorfirst;
    }

    /**
     * Sets the value of the booksAuthorfirst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBooksAuthorfirst(String value) {
        this.booksAuthorfirst = value;
    }

    /**
     * Gets the value of the booksAuthorlast property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBooksAuthorlast() {
        return booksAuthorlast;
    }

    /**
     * Sets the value of the booksAuthorlast property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBooksAuthorlast(String value) {
        this.booksAuthorlast = value;
    }

    /**
     * Gets the value of the booksGenre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBooksGenre() {
        return booksGenre;
    }

    /**
     * Sets the value of the booksGenre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBooksGenre(String value) {
        this.booksGenre = value;
    }

    /**
     * Gets the value of the bookPush property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookPush() {
        return bookPush;
    }

    /**
     * Sets the value of the bookPush property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookPush(String value) {
        this.bookPush = value;
    }

}
