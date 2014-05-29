/**
 * MetricValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain.metric;

public class MetricValue  implements java.io.Serializable {
    private java.util.Calendar captured;

    private int id;

    private double value;

    public MetricValue() {
    }

    public MetricValue(
           java.util.Calendar captured,
           int id,
           double value) {
           this.captured = captured;
           this.id = id;
           this.value = value;
    }


    /**
     * Gets the captured value for this MetricValue.
     * 
     * @return captured
     */
    public java.util.Calendar getCaptured() {
        return captured;
    }


    /**
     * Sets the captured value for this MetricValue.
     * 
     * @param captured
     */
    public void setCaptured(java.util.Calendar captured) {
        this.captured = captured;
    }


    /**
     * Gets the id value for this MetricValue.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this MetricValue.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the value value for this MetricValue.
     * 
     * @return value
     */
    public double getValue() {
        return value;
    }


    /**
     * Sets the value value for this MetricValue.
     * 
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MetricValue)) return false;
        MetricValue other = (MetricValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.captured==null && other.getCaptured()==null) || 
             (this.captured!=null &&
              this.captured.equals(other.getCaptured()))) &&
            this.id == other.getId() &&
            this.value == other.getValue();
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
        if (getCaptured() != null) {
            _hashCode += getCaptured().hashCode();
        }
        _hashCode += getId();
        _hashCode += new Double(getValue()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MetricValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "MetricValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("captured");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "captured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
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
