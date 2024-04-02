
package com.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for books complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="books">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author_first_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="author_last_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publication_year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "books", propOrder = {
    "authorFirstName",
    "authorLastName",
    "genre",
    "publicationYear",
    "title"
})
public class Books {

    @XmlElement(name = "author_first_name")
    protected String authorFirstName;
    @XmlElement(name = "author_last_name")
    protected String authorLastName;
    protected String genre;
    @XmlElement(name = "publication_year")
    protected int publicationYear;
    protected String title;

    /**
     * Gets the value of the authorFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    /**
     * Sets the value of the authorFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorFirstName(String value) {
        this.authorFirstName = value;
    }

    /**
     * Gets the value of the authorLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorLastName() {
        return authorLastName;
    }

    /**
     * Sets the value of the authorLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorLastName(String value) {
        this.authorLastName = value;
    }

    /**
     * Gets the value of the genre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the publicationYear property.
     * 
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets the value of the publicationYear property.
     * 
     */
    public void setPublicationYear(int value) {
        this.publicationYear = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
