
package com.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateBooksResponse_QNAME = new QName("http://soap.com/", "createBooksResponse");
    private final static QName _UpdateBooksResponse_QNAME = new QName("http://soap.com/", "updateBooksResponse");
    private final static QName _IdNotExistsException_QNAME = new QName("http://soap.com/", "IdNotExistsException");
    private final static QName _CreateBooks_QNAME = new QName("http://soap.com/", "createBooks");
    private final static QName _UpdateBooks_QNAME = new QName("http://soap.com/", "updateBooks");
    private final static QName _ForIntException_QNAME = new QName("http://soap.com/", "ForIntException");
    private final static QName _GetBooks_QNAME = new QName("http://soap.com/", "getBooks");
    private final static QName _EmptyFieldException_QNAME = new QName("http://soap.com/", "EmptyFieldException");
    private final static QName _GetBooksResponse_QNAME = new QName("http://soap.com/", "getBooksResponse");
    private final static QName _DeleteBooks_QNAME = new QName("http://soap.com/", "deleteBooks");
    private final static QName _DeleteBooksResponse_QNAME = new QName("http://soap.com/", "deleteBooksResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ForIntFault }
     * 
     */
    public ForIntFault createForIntFault() {
        return new ForIntFault();
    }

    /**
     * Create an instance of {@link GetBooks }
     * 
     */
    public GetBooks createGetBooks() {
        return new GetBooks();
    }

    /**
     * Create an instance of {@link CreateBooksResponse }
     * 
     */
    public CreateBooksResponse createCreateBooksResponse() {
        return new CreateBooksResponse();
    }

    /**
     * Create an instance of {@link UpdateBooksResponse }
     * 
     */
    public UpdateBooksResponse createUpdateBooksResponse() {
        return new UpdateBooksResponse();
    }

    /**
     * Create an instance of {@link UpdateBooks }
     * 
     */
    public UpdateBooks createUpdateBooks() {
        return new UpdateBooks();
    }

    /**
     * Create an instance of {@link IdNotExistsFault }
     * 
     */
    public IdNotExistsFault createIdNotExistsFault() {
        return new IdNotExistsFault();
    }

    /**
     * Create an instance of {@link CreateBooks }
     * 
     */
    public CreateBooks createCreateBooks() {
        return new CreateBooks();
    }

    /**
     * Create an instance of {@link DeleteBooks }
     * 
     */
    public DeleteBooks createDeleteBooks() {
        return new DeleteBooks();
    }

    /**
     * Create an instance of {@link DeleteBooksResponse }
     * 
     */
    public DeleteBooksResponse createDeleteBooksResponse() {
        return new DeleteBooksResponse();
    }

    /**
     * Create an instance of {@link EmptyFieldFault }
     * 
     */
    public EmptyFieldFault createEmptyFieldFault() {
        return new EmptyFieldFault();
    }

    /**
     * Create an instance of {@link GetBooksResponse }
     * 
     */
    public GetBooksResponse createGetBooksResponse() {
        return new GetBooksResponse();
    }

    /**
     * Create an instance of {@link Books }
     * 
     */
    public Books createBooks() {
        return new Books();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "createBooksResponse")
    public JAXBElement<CreateBooksResponse> createCreateBooksResponse(CreateBooksResponse value) {
        return new JAXBElement<CreateBooksResponse>(_CreateBooksResponse_QNAME, CreateBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "updateBooksResponse")
    public JAXBElement<UpdateBooksResponse> createUpdateBooksResponse(UpdateBooksResponse value) {
        return new JAXBElement<UpdateBooksResponse>(_UpdateBooksResponse_QNAME, UpdateBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdNotExistsFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "IdNotExistsException")
    public JAXBElement<IdNotExistsFault> createIdNotExistsException(IdNotExistsFault value) {
        return new JAXBElement<IdNotExistsFault>(_IdNotExistsException_QNAME, IdNotExistsFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "createBooks")
    public JAXBElement<CreateBooks> createCreateBooks(CreateBooks value) {
        return new JAXBElement<CreateBooks>(_CreateBooks_QNAME, CreateBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "updateBooks")
    public JAXBElement<UpdateBooks> createUpdateBooks(UpdateBooks value) {
        return new JAXBElement<UpdateBooks>(_UpdateBooks_QNAME, UpdateBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForIntFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "ForIntException")
    public JAXBElement<ForIntFault> createForIntException(ForIntFault value) {
        return new JAXBElement<ForIntFault>(_ForIntException_QNAME, ForIntFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "getBooks")
    public JAXBElement<GetBooks> createGetBooks(GetBooks value) {
        return new JAXBElement<GetBooks>(_GetBooks_QNAME, GetBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyFieldFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "EmptyFieldException")
    public JAXBElement<EmptyFieldFault> createEmptyFieldException(EmptyFieldFault value) {
        return new JAXBElement<EmptyFieldFault>(_EmptyFieldException_QNAME, EmptyFieldFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "getBooksResponse")
    public JAXBElement<GetBooksResponse> createGetBooksResponse(GetBooksResponse value) {
        return new JAXBElement<GetBooksResponse>(_GetBooksResponse_QNAME, GetBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "deleteBooks")
    public JAXBElement<DeleteBooks> createDeleteBooks(DeleteBooks value) {
        return new JAXBElement<DeleteBooks>(_DeleteBooks_QNAME, DeleteBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.com/", name = "deleteBooksResponse")
    public JAXBElement<DeleteBooksResponse> createDeleteBooksResponse(DeleteBooksResponse value) {
        return new JAXBElement<DeleteBooksResponse>(_DeleteBooksResponse_QNAME, DeleteBooksResponse.class, null, value);
    }

}
