/**
 * ServiceHours.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain;

public class ServiceHours  implements java.io.Serializable {
    private xdrozd07.dt.domain.AccessTime[] accessTimes;

    private java.lang.String description;

    private xdrozd07.dt.domain.Event[] events;

    private int id;

    public ServiceHours() {
    }

    public ServiceHours(
           xdrozd07.dt.domain.AccessTime[] accessTimes,
           java.lang.String description,
           xdrozd07.dt.domain.Event[] events,
           int id) {
           this.accessTimes = accessTimes;
           this.description = description;
           this.events = events;
           this.id = id;
    }


    /**
     * Gets the accessTimes value for this ServiceHours.
     * 
     * @return accessTimes
     */
    public xdrozd07.dt.domain.AccessTime[] getAccessTimes() {
        return accessTimes;
    }


    /**
     * Sets the accessTimes value for this ServiceHours.
     * 
     * @param accessTimes
     */
    public void setAccessTimes(xdrozd07.dt.domain.AccessTime[] accessTimes) {
        this.accessTimes = accessTimes;
    }


    /**
     * Gets the description value for this ServiceHours.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ServiceHours.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the events value for this ServiceHours.
     * 
     * @return events
     */
    public xdrozd07.dt.domain.Event[] getEvents() {
        return events;
    }


    /**
     * Sets the events value for this ServiceHours.
     * 
     * @param events
     */
    public void setEvents(xdrozd07.dt.domain.Event[] events) {
        this.events = events;
    }


    /**
     * Gets the id value for this ServiceHours.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this ServiceHours.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceHours)) return false;
        ServiceHours other = (ServiceHours) obj;
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
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.events==null && other.getEvents()==null) || 
             (this.events!=null &&
              java.util.Arrays.equals(this.events, other.getEvents()))) &&
            this.id == other.getId();
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEvents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEvents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEvents(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getId();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceHours.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "ServiceHours"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accessTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "accessTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "AccessTime"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("events");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "events"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Event"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
