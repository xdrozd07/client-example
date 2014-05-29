/**
 * Treshold.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain.metric;

public class Treshold  implements java.io.Serializable {
    private int id;

    private xdrozd07.dt.domain.metric.Listener[] listeners;

    private double value;

    public Treshold() {
    }

    public Treshold(
           int id,
           xdrozd07.dt.domain.metric.Listener[] listeners,
           double value) {
           this.id = id;
           this.listeners = listeners;
           this.value = value;
    }


    /**
     * Gets the id value for this Treshold.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Treshold.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the listeners value for this Treshold.
     * 
     * @return listeners
     */
    public xdrozd07.dt.domain.metric.Listener[] getListeners() {
        return listeners;
    }


    /**
     * Sets the listeners value for this Treshold.
     * 
     * @param listeners
     */
    public void setListeners(xdrozd07.dt.domain.metric.Listener[] listeners) {
        this.listeners = listeners;
    }


    /**
     * Gets the value value for this Treshold.
     * 
     * @return value
     */
    public double getValue() {
        return value;
    }


    /**
     * Sets the value value for this Treshold.
     * 
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Treshold)) return false;
        Treshold other = (Treshold) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.listeners==null && other.getListeners()==null) || 
             (this.listeners!=null &&
              java.util.Arrays.equals(this.listeners, other.getListeners()))) &&
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
        _hashCode += getId();
        if (getListeners() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListeners());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListeners(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(getValue()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Treshold.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Treshold"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listeners");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "listeners"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Listener"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
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
