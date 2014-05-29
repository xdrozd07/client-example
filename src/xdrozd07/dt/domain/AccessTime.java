/**
 * AccessTime.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain;

public class AccessTime  implements java.io.Serializable {
    private java.util.Date close;

    private java.lang.String day;

    private int id;

    private java.util.Date open;

    public AccessTime() {
    }

    public AccessTime(
           java.util.Date close,
           java.lang.String day,
           int id,
           java.util.Date open) {
           this.close = close;
           this.day = day;
           this.id = id;
           this.open = open;
    }


    /**
     * Gets the close value for this AccessTime.
     * 
     * @return close
     */
    public java.util.Date getClose() {
        return close;
    }


    /**
     * Sets the close value for this AccessTime.
     * 
     * @param close
     */
    public void setClose(java.util.Date close) {
        this.close = close;
    }


    /**
     * Gets the day value for this AccessTime.
     * 
     * @return day
     */
    public java.lang.String getDay() {
        return day;
    }


    /**
     * Sets the day value for this AccessTime.
     * 
     * @param day
     */
    public void setDay(java.lang.String day) {
        this.day = day;
    }


    /**
     * Gets the id value for this AccessTime.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this AccessTime.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the open value for this AccessTime.
     * 
     * @return open
     */
    public java.util.Date getOpen() {
        return open;
    }


    /**
     * Sets the open value for this AccessTime.
     * 
     * @param open
     */
    public void setOpen(java.util.Date open) {
        this.open = open;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccessTime)) return false;
        AccessTime other = (AccessTime) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.close==null && other.getClose()==null) || 
             (this.close!=null &&
              this.close.equals(other.getClose()))) &&
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
            this.id == other.getId() &&
            ((this.open==null && other.getOpen()==null) || 
             (this.open!=null &&
              this.open.equals(other.getOpen())));
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
        if (getClose() != null) {
            _hashCode += getClose().hashCode();
        }
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        _hashCode += getId();
        if (getOpen() != null) {
            _hashCode += getOpen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccessTime.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "AccessTime"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("close");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "close"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "day"));
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
        elemField.setFieldName("open");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "open"));
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
