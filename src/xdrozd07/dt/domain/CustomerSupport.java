/**
 * CustomerSupport.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain;

public class CustomerSupport  implements java.io.Serializable {
    private xdrozd07.dt.domain.AccessTime[] accessTimes;

    private xdrozd07.dt.domain.Contact contact;

    private java.lang.String description;

    private int id;

    private java.lang.String note;

    private java.lang.String response;

    private java.util.Date responseTime;

    public CustomerSupport() {
    }

    public CustomerSupport(
           xdrozd07.dt.domain.AccessTime[] accessTimes,
           xdrozd07.dt.domain.Contact contact,
           java.lang.String description,
           int id,
           java.lang.String note,
           java.lang.String response,
           java.util.Date responseTime) {
           this.accessTimes = accessTimes;
           this.contact = contact;
           this.description = description;
           this.id = id;
           this.note = note;
           this.response = response;
           this.responseTime = responseTime;
    }


    /**
     * Gets the accessTimes value for this CustomerSupport.
     * 
     * @return accessTimes
     */
    public xdrozd07.dt.domain.AccessTime[] getAccessTimes() {
        return accessTimes;
    }


    /**
     * Sets the accessTimes value for this CustomerSupport.
     * 
     * @param accessTimes
     */
    public void setAccessTimes(xdrozd07.dt.domain.AccessTime[] accessTimes) {
        this.accessTimes = accessTimes;
    }


    /**
     * Gets the contact value for this CustomerSupport.
     * 
     * @return contact
     */
    public xdrozd07.dt.domain.Contact getContact() {
        return contact;
    }


    /**
     * Sets the contact value for this CustomerSupport.
     * 
     * @param contact
     */
    public void setContact(xdrozd07.dt.domain.Contact contact) {
        this.contact = contact;
    }


    /**
     * Gets the description value for this CustomerSupport.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this CustomerSupport.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the id value for this CustomerSupport.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this CustomerSupport.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the note value for this CustomerSupport.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this CustomerSupport.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the response value for this CustomerSupport.
     * 
     * @return response
     */
    public java.lang.String getResponse() {
        return response;
    }


    /**
     * Sets the response value for this CustomerSupport.
     * 
     * @param response
     */
    public void setResponse(java.lang.String response) {
        this.response = response;
    }


    /**
     * Gets the responseTime value for this CustomerSupport.
     * 
     * @return responseTime
     */
    public java.util.Date getResponseTime() {
        return responseTime;
    }


    /**
     * Sets the responseTime value for this CustomerSupport.
     * 
     * @param responseTime
     */
    public void setResponseTime(java.util.Date responseTime) {
        this.responseTime = responseTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerSupport)) return false;
        CustomerSupport other = (CustomerSupport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accessTimes==null && other.getAccessTimes()==null) || 
             (this.accessTimes!=null &&
              java.util.Arrays.equals(this.accessTimes, other.getAccessTimes()))) &&
            ((this.contact==null && other.getContact()==null) || 
             (this.contact!=null &&
              this.contact.equals(other.getContact()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.id == other.getId() &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.response==null && other.getResponse()==null) || 
             (this.response!=null &&
              this.response.equals(other.getResponse()))) &&
            ((this.responseTime==null && other.getResponseTime()==null) || 
             (this.responseTime!=null &&
              this.responseTime.equals(other.getResponseTime())));
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
        if (getAccessTimes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccessTimes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccessTimes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContact() != null) {
            _hashCode += getContact().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getId();
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getResponse() != null) {
            _hashCode += getResponse().hashCode();
        }
        if (getResponseTime() != null) {
            _hashCode += getResponseTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerSupport.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "CustomerSupport"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "accessTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "AccessTime"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contact");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "contact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Contact"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "response"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "responseTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
