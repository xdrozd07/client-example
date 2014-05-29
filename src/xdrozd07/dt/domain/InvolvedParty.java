/**
 * InvolvedParty.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain;

public class InvolvedParty  implements java.io.Serializable {
    private xdrozd07.dt.domain.Contact contact;

    private int id;

    private java.lang.String name;

    private java.lang.String role;

    private xdrozd07.dt.domain.Signatory[] signatories;

    public InvolvedParty() {
    }

    public InvolvedParty(
           xdrozd07.dt.domain.Contact contact,
           int id,
           java.lang.String name,
           java.lang.String role,
           xdrozd07.dt.domain.Signatory[] signatories) {
           this.contact = contact;
           this.id = id;
           this.name = name;
           this.role = role;
           this.signatories = signatories;
    }


    /**
     * Gets the contact value for this InvolvedParty.
     * 
     * @return contact
     */
    public xdrozd07.dt.domain.Contact getContact() {
        return contact;
    }


    /**
     * Sets the contact value for this InvolvedParty.
     * 
     * @param contact
     */
    public void setContact(xdrozd07.dt.domain.Contact contact) {
        this.contact = contact;
    }


    /**
     * Gets the id value for this InvolvedParty.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this InvolvedParty.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this InvolvedParty.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this InvolvedParty.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the role value for this InvolvedParty.
     * 
     * @return role
     */
    public java.lang.String getRole() {
        return role;
    }


    /**
     * Sets the role value for this InvolvedParty.
     * 
     * @param role
     */
    public void setRole(java.lang.String role) {
        this.role = role;
    }


    /**
     * Gets the signatories value for this InvolvedParty.
     * 
     * @return signatories
     */
    public xdrozd07.dt.domain.Signatory[] getSignatories() {
        return signatories;
    }


    /**
     * Sets the signatories value for this InvolvedParty.
     * 
     * @param signatories
     */
    public void setSignatories(xdrozd07.dt.domain.Signatory[] signatories) {
        this.signatories = signatories;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InvolvedParty)) return false;
        InvolvedParty other = (InvolvedParty) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contact==null && other.getContact()==null) || 
             (this.contact!=null &&
              this.contact.equals(other.getContact()))) &&
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            ((this.signatories==null && other.getSignatories()==null) || 
             (this.signatories!=null &&
              java.util.Arrays.equals(this.signatories, other.getSignatories())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getContact() != null) {
            _hashCode += getContact().hashCode();
        }
        _hashCode += getId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getSignatories() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSignatories());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSignatories(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InvolvedParty.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "InvolvedParty"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contact");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "contact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Contact"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signatories");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "signatories"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Signatory"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
