/**
 * Report.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain;

public class Report  implements java.io.Serializable {
    private xdrozd07.dt.domain.Contact[] contacts;

    private int day;

    private java.lang.String description;

    private java.lang.String frequency;

    private int hour;

    private int id;

    private xdrozd07.dt.domain.metric.Metric[] metrics;

    private java.lang.String name;

    public Report() {
    }

    public Report(
           xdrozd07.dt.domain.Contact[] contacts,
           int day,
           java.lang.String description,
           java.lang.String frequency,
           int hour,
           int id,
           xdrozd07.dt.domain.metric.Metric[] metrics,
           java.lang.String name) {
           this.contacts = contacts;
           this.day = day;
           this.description = description;
           this.frequency = frequency;
           this.hour = hour;
           this.id = id;
           this.metrics = metrics;
           this.name = name;
    }


    /**
     * Gets the contacts value for this Report.
     * 
     * @return contacts
     */
    public xdrozd07.dt.domain.Contact[] getContacts() {
        return contacts;
    }


    /**
     * Sets the contacts value for this Report.
     * 
     * @param contacts
     */
    public void setContacts(xdrozd07.dt.domain.Contact[] contacts) {
        this.contacts = contacts;
    }


    /**
     * Gets the day value for this Report.
     * 
     * @return day
     */
    public int getDay() {
        return day;
    }


    /**
     * Sets the day value for this Report.
     * 
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }


    /**
     * Gets the description value for this Report.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Report.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the frequency value for this Report.
     * 
     * @return frequency
     */
    public java.lang.String getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency value for this Report.
     * 
     * @param frequency
     */
    public void setFrequency(java.lang.String frequency) {
        this.frequency = frequency;
    }


    /**
     * Gets the hour value for this Report.
     * 
     * @return hour
     */
    public int getHour() {
        return hour;
    }


    /**
     * Sets the hour value for this Report.
     * 
     * @param hour
     */
    public void setHour(int hour) {
        this.hour = hour;
    }


    /**
     * Gets the id value for this Report.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Report.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the metrics value for this Report.
     * 
     * @return metrics
     */
    public xdrozd07.dt.domain.metric.Metric[] getMetrics() {
        return metrics;
    }


    /**
     * Sets the metrics value for this Report.
     * 
     * @param metrics
     */
    public void setMetrics(xdrozd07.dt.domain.metric.Metric[] metrics) {
        this.metrics = metrics;
    }


    /**
     * Gets the name value for this Report.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Report.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Report)) return false;
        Report other = (Report) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contacts==null && other.getContacts()==null) || 
             (this.contacts!=null &&
              java.util.Arrays.equals(this.contacts, other.getContacts()))) &&
            this.day == other.getDay() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.frequency==null && other.getFrequency()==null) || 
             (this.frequency!=null &&
              this.frequency.equals(other.getFrequency()))) &&
            this.hour == other.getHour() &&
            this.id == other.getId() &&
            ((this.metrics==null && other.getMetrics()==null) || 
             (this.metrics!=null &&
              java.util.Arrays.equals(this.metrics, other.getMetrics()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        if (getContacts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContacts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContacts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getDay();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getFrequency() != null) {
            _hashCode += getFrequency().hashCode();
        }
        _hashCode += getHour();
        _hashCode += getId();
        if (getMetrics() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMetrics());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMetrics(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Report.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Report"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contacts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "contacts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Contact"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "frequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hour");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "hour"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metrics");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "metrics"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Metric"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
