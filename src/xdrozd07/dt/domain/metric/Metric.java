/**
 * Metric.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain.metric;

public class Metric  implements java.io.Serializable {
    private int id;

    private java.lang.String inputAddress;

    private java.lang.String inputFormat;

    private java.lang.String inputType;

    private java.lang.String name;

    private xdrozd07.dt.domain.metric.Treshold[] tresholds;

    private xdrozd07.dt.domain.metric.MetricValue[] values;

    public Metric() {
    }

    public Metric(
           int id,
           java.lang.String inputAddress,
           java.lang.String inputFormat,
           java.lang.String inputType,
           java.lang.String name,
           xdrozd07.dt.domain.metric.Treshold[] tresholds,
           xdrozd07.dt.domain.metric.MetricValue[] values) {
           this.id = id;
           this.inputAddress = inputAddress;
           this.inputFormat = inputFormat;
           this.inputType = inputType;
           this.name = name;
           this.tresholds = tresholds;
           this.values = values;
    }


    /**
     * Gets the id value for this Metric.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Metric.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the inputAddress value for this Metric.
     * 
     * @return inputAddress
     */
    public java.lang.String getInputAddress() {
        return inputAddress;
    }


    /**
     * Sets the inputAddress value for this Metric.
     * 
     * @param inputAddress
     */
    public void setInputAddress(java.lang.String inputAddress) {
        this.inputAddress = inputAddress;
    }


    /**
     * Gets the inputFormat value for this Metric.
     * 
     * @return inputFormat
     */
    public java.lang.String getInputFormat() {
        return inputFormat;
    }


    /**
     * Sets the inputFormat value for this Metric.
     * 
     * @param inputFormat
     */
    public void setInputFormat(java.lang.String inputFormat) {
        this.inputFormat = inputFormat;
    }


    /**
     * Gets the inputType value for this Metric.
     * 
     * @return inputType
     */
    public java.lang.String getInputType() {
        return inputType;
    }


    /**
     * Sets the inputType value for this Metric.
     * 
     * @param inputType
     */
    public void setInputType(java.lang.String inputType) {
        this.inputType = inputType;
    }


    /**
     * Gets the name value for this Metric.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Metric.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the tresholds value for this Metric.
     * 
     * @return tresholds
     */
    public xdrozd07.dt.domain.metric.Treshold[] getTresholds() {
        return tresholds;
    }


    /**
     * Sets the tresholds value for this Metric.
     * 
     * @param tresholds
     */
    public void setTresholds(xdrozd07.dt.domain.metric.Treshold[] tresholds) {
        this.tresholds = tresholds;
    }


    /**
     * Gets the values value for this Metric.
     * 
     * @return values
     */
    public xdrozd07.dt.domain.metric.MetricValue[] getValues() {
        return values;
    }


    /**
     * Sets the values value for this Metric.
     * 
     * @param values
     */
    public void setValues(xdrozd07.dt.domain.metric.MetricValue[] values) {
        this.values = values;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Metric)) return false;
        Metric other = (Metric) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.inputAddress==null && other.getInputAddress()==null) || 
             (this.inputAddress!=null &&
              this.inputAddress.equals(other.getInputAddress()))) &&
            ((this.inputFormat==null && other.getInputFormat()==null) || 
             (this.inputFormat!=null &&
              this.inputFormat.equals(other.getInputFormat()))) &&
            ((this.inputType==null && other.getInputType()==null) || 
             (this.inputType!=null &&
              this.inputType.equals(other.getInputType()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.tresholds==null && other.getTresholds()==null) || 
             (this.tresholds!=null &&
              java.util.Arrays.equals(this.tresholds, other.getTresholds()))) &&
            ((this.values==null && other.getValues()==null) || 
             (this.values!=null &&
              java.util.Arrays.equals(this.values, other.getValues())));
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
        if (getInputAddress() != null) {
            _hashCode += getInputAddress().hashCode();
        }
        if (getInputFormat() != null) {
            _hashCode += getInputFormat().hashCode();
        }
        if (getInputType() != null) {
            _hashCode += getInputType().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getTresholds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTresholds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTresholds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValues(), i);
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
        new org.apache.axis.description.TypeDesc(Metric.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Metric"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "inputAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "inputFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "inputType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tresholds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "tresholds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Treshold"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("values");
        elemField.setXmlName(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "values"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "MetricValue"));
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
