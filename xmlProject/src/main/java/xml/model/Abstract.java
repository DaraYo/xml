//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.26 at 05:59:36 PM CEST 
//


package xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucniRad}defaultAbstract"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/naucniRad}freeAbstract"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "defaultAbstract",
    "freeAbstract"
})
@XmlRootElement(name = "abstract")
public class Abstract {

    protected DefaultAbstract defaultAbstract;
    protected String freeAbstract;

    /**
     * Gets the value of the defaultAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultAbstract }
     *     
     */
    public DefaultAbstract getDefaultAbstract() {
        return defaultAbstract;
    }

    /**
     * Sets the value of the defaultAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultAbstract }
     *     
     */
    public void setDefaultAbstract(DefaultAbstract value) {
        this.defaultAbstract = value;
    }

    /**
     * Gets the value of the freeAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeAbstract() {
        return freeAbstract;
    }

    /**
     * Sets the value of the freeAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeAbstract(String value) {
        this.freeAbstract = value;
    }

}