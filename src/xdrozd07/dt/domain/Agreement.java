/**
 * Agreement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.domain;

public class Agreement  implements java.io.Serializable {
    private java.lang.String author;

    private xdrozd07.dt.domain.Availability[] availability;

    private xdrozd07.dt.domain.ChangeManagement changemanagement;

    private xdrozd07.dt.domain.CustomerSupport customerSupport;

    private xdrozd07.dt.domain.glossary.Glossary[] glossaries;

    private int id;

    private xdrozd07.dt.domain.InvolvedParty[] involvedParties;

    private java.lang.String name;

    private xdrozd07.dt.domain.Performance performance;

    private xdrozd07.dt.domain.Agreement predecessor;

    private xdrozd07.dt.domain.Report[] reports;

    private java.lang.String securityDescription;

    private java.lang.String serviceDescription;

    private java.lang.String serviceDescritption;

    private xdrozd07.dt.domain.ServiceHours serviceHours;

    private java.lang.String slaDescription;

    private java.lang.String type;

    private java.util.Date validFrom;

    private java.util.Date validTo;

    public Agreement() {
    }

    public Agreement(
           java.lang.String author,
           xdrozd07.dt.domain.Availability[] availability,
           xdrozd07.dt.domain.ChangeManagement changemanagement,
           xdrozd07.dt.domain.CustomerSupport customerSupport,
           xdrozd07.dt.domain.glossary.Glossary[] glossaries,
           int id,
           xdrozd07.dt.domain.InvolvedParty[] involvedParties,
           java.lang.String name,
           xdrozd07.dt.domain.Performance performance,
           xdrozd07.dt.domain.Agreement predecessor,
           xdrozd07.dt.domain.Report[] reports,
           java.lang.String securityDescription,
           java.lang.String serviceDescription,
           java.lang.String serviceDescritption,
           xdrozd07.dt.domain.ServiceHours serviceHours,
           java.lang.String slaDescription,
           java.lang.String type,
           java.util.Date validFrom,
           java.util.Date validTo) {
           this.author = author;
           this.availability = availability;
           this.changemanagement = changemanagement;
           this.customerSupport = customerSupport;
           this.glossaries = glossaries;
           this.id = id;
           this.involvedParties = involvedParties;
           this.name = name;
           this.performance = performance;
           this.predecessor = predecessor;
           this.reports = reports;
           this.securityDescription = securityDescription;
           this.serviceDescription = serviceDescription;
           this.serviceDescritption = serviceDescritption;
           this.serviceHours = serviceHours;
           this.slaDescription = slaDescription;
           this.type = type;
           this.validFrom = validFrom;
           this.validTo = validTo;
    }


    /**
     * Gets the author value for this Agreement.
     * 
     * @return author
     */
    public java.lang.String getAuthor() {
        return author;
    }


    /**
     * Sets the author value for this Agreement.
     * 
     * @param author
     */
    public void setAuthor(java.lang.String author) {
        this.author = author;
    }


    /**
     * Gets the availability value for this Agreement.
     * 
     * @return availability
     */
    public xdrozd07.dt.domain.Availability[] getAvailability() {
        return availability;
    }


    /**
     * Sets the availability value for this Agreement.
     * 
     * @param availability
     */
    public void setAvailability(xdrozd07.dt.domain.Availability[] availability) {
        this.availability = availability;
    }


    /**
     * Gets the changemanagement value for this Agreement.
     * 
     * @return changemanagement
     */
    public xdrozd07.dt.domain.ChangeManagement getChangemanagement() {
        return changemanagement;
    }


    /**
     * Sets the changemanagement value for this Agreement.
     * 
     * @param changemanagement
     */
    public void setChangemanagement(xdrozd07.dt.domain.ChangeManagement changemanagement) {
        this.changemanagement = changemanagement;
    }


    /**
     * Gets the customerSupport value for this Agreement.
     * 
     * @return customerSupport
     */
    public xdrozd07.dt.domain.CustomerSupport getCustomerSupport() {
        return customerSupport;
    }


    /**
     * Sets the customerSupport value for this Agreement.
     * 
     * @param customerSupport
     */
    public void setCustomerSupport(xdrozd07.dt.domain.CustomerSupport customerSupport) {
        this.customerSupport = customerSupport;
    }


    /**
     * Gets the glossaries value for this Agreement.
     * 
     * @return glossaries
     */
    public xdrozd07.dt.domain.glossary.Glossary[] getGlossaries() {
        return glossaries;
    }


    /**
     * Sets the glossaries value for this Agreement.
     * 
     * @param glossaries
     */
    public void setGlossaries(xdrozd07.dt.domain.glossary.Glossary[] glossaries) {
        this.glossaries = glossaries;
    }


    /**
     * Gets the id value for this Agreement.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Agreement.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the involvedParties value for this Agreement.
     * 
     * @return involvedParties
     */
    public xdrozd07.dt.domain.InvolvedParty[] getInvolvedParties() {
        return involvedParties;
    }


    /**
     * Sets the involvedParties value for this Agreement.
     * 
     * @param involvedParties
     */
    public void setInvolvedParties(xdrozd07.dt.domain.InvolvedParty[] involvedParties) {
        this.involvedParties = involvedParties;
    }


    /**
     * Gets the name value for this Agreement.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Agreement.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the performance value for this Agreement.
     * 
     * @return performance
     */
    public xdrozd07.dt.domain.Performance getPerformance() {
        return performance;
    }


    /**
     * Sets the performance value for this Agreement.
     * 
     * @param performance
     */
    public void setPerformance(xdrozd07.dt.domain.Performance performance) {
        this.performance = performance;
    }


    /**
     * Gets the predecessor value for this Agreement.
     * 
     * @return predecessor
     */
    public xdrozd07.dt.domain.Agreement getPredecessor() {
        return predecessor;
    }


    /**
     * Sets the predecessor value for this Agreement.
     * 
     * @param predecessor
     */
    public void setPredecessor(xdrozd07.dt.domain.Agreement predecessor) {
        this.predecessor = predecessor;
    }


    /**
     * Gets the reports value for this Agreement.
     * 
     * @return reports
     */
    public xdrozd07.dt.domain.Report[] getReports() {
        return reports;
    }


    /**
     * Sets the reports value for this Agreement.
     * 
     * @param reports
     */
    public void setReports(xdrozd07.dt.domain.Report[] reports) {
        this.reports = reports;
    }


    /**
     * Gets the securityDescription value for this Agreement.
     * 
     * @return securityDescription
     */
    public java.lang.String getSecurityDescription() {
        return securityDescription;
    }


    /**
     * Sets the securityDescription value for this Agreement.
     * 
     * @param securityDescription
     */
    public void setSecurityDescription(java.lang.String securityDescription) {
        this.securityDescription = securityDescription;
    }


    /**
     * Gets the serviceDescription value for this Agreement.
     * 
     * @return serviceDescription
     */
    public java.lang.String getServiceDescription() {
        return serviceDescription;
    }


    /**
     * Sets the serviceDescription value for this Agreement.
     * 
     * @param serviceDescription
     */
    public void setServiceDescription(java.lang.String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }


    /**
     * Gets the serviceDescritption value for this Agreement.
     * 
     * @return serviceDescritption
     */
    public java.lang.String getServiceDescritption() {
        return serviceDescritption;
    }


    /**
     * Sets the serviceDescritption value for this Agreement.
     * 
     * @param serviceDescritption
     */
    public void setServiceDescritption(java.lang.String serviceDescritption) {
        this.serviceDescritption = serviceDescritption;
    }


    /**
     * Gets the serviceHours value for this Agreement.
     * 
     * @return serviceHours
     */
    public xdrozd07.dt.domain.ServiceHours getServiceHours() {
        return serviceHours;
    }


    /**
     * Sets the serviceHours value for this Agreement.
     * 
     * @param serviceHours
     */
    public void setServiceHours(xdrozd07.dt.domain.ServiceHours serviceHours) {
        this.serviceHours = serviceHours;
    }


    /**
     * Gets the slaDescription value for this Agreement.
     * 
     * @return slaDescription
     */
    public java.lang.String getSlaDescription() {
        return slaDescription;
    }


    /**
     * Sets the slaDescription value for this Agreement.
     * 
     * @param slaDescription
     */
    public void setSlaDescription(java.lang.String slaDescription) {
        this.slaDescription = slaDescription;
    }


    /**
     * Gets the type value for this Agreement.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Agreement.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the validFrom value for this Agreement.
     * 
     * @return validFrom
     */
    public java.util.Date getValidFrom() {
        return validFrom;
    }


    /**
     * Sets the validFrom value for this Agreement.
     * 
     * @param validFrom
     */
    public void setValidFrom(java.util.Date validFrom) {
        this.validFrom = validFrom;
    }


    /**
     * Gets the validTo value for this Agreement.
     * 
     * @return validTo
     */
    public java.util.Date getValidTo() {
        return validTo;
    }


    /**
     * Sets the validTo value for this Agreement.
     * 
     * @param validTo
     */
    public void setValidTo(java.util.Date validTo) {
        this.validTo = validTo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Agreement)) return false;
        Agreement other = (Agreement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.author==null && other.getAuthor()==null) || 
             (this.author!=null &&
              this.author.equals(other.getAuthor()))) &&
            ((this.availability==null && other.getAvailability()==null) || 
             (this.availability!=null &&
              java.util.Arrays.equals(this.availability, other.getAvailability()))) &&
            ((this.changemanagement==null && other.getChangemanagement()==null) || 
             (this.changemanagement!=null &&
              this.changemanagement.equals(other.getChangemanagement()))) &&
            ((this.customerSupport==null && other.getCustomerSupport()==null) || 
             (this.customerSupport!=null &&
              this.customerSupport.equals(other.getCustomerSupport()))) &&
            ((this.glossaries==null && other.getGlossaries()==null) || 
             (this.glossaries!=null &&
              java.util.Arrays.equals(this.glossaries, other.getGlossaries()))) &&
            this.id == other.getId() &&
            ((this.involvedParties==null && other.getInvolvedParties()==null) || 
             (this.involvedParties!=null &&
              java.util.Arrays.equals(this.involvedParties, other.getInvolvedParties()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.performance==null && other.getPerformance()==null) || 
             (this.performance!=null &&
              this.performance.equals(other.getPerformance()))) &&
            ((this.predecessor==null && other.getPredecessor()==null) || 
             (this.predecessor!=null &&
              this.predecessor.equals(other.getPredecessor()))) &&
            ((this.reports==null && other.getReports()==null) || 
             (this.reports!=null &&
              java.util.Arrays.equals(this.reports, other.getReports()))) &&
            ((this.securityDescription==null && other.getSecurityDescription()==null) || 
             (this.securityDescription!=null &&
              this.securityDescription.equals(other.getSecurityDescription()))) &&
            ((this.serviceDescription==null && other.getServiceDescription()==null) || 
             (this.serviceDescription!=null &&
              this.serviceDescription.equals(other.getServiceDescription()))) &&
            ((this.serviceDescritption==null && other.getServiceDescritption()==null) || 
             (this.serviceDescritption!=null &&
              this.serviceDescritption.equals(other.getServiceDescritption()))) &&
            ((this.serviceHours==null && other.getServiceHours()==null) || 
             (this.serviceHours!=null &&
              this.serviceHours.equals(other.getServiceHours()))) &&
            ((this.slaDescription==null && other.getSlaDescription()==null) || 
             (this.slaDescription!=null &&
              this.slaDescription.equals(other.getSlaDescription()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.validFrom==null && other.getValidFrom()==null) || 
             (this.validFrom!=null &&
              this.validFrom.equals(other.getValidFrom()))) &&
            ((this.validTo==null && other.getValidTo()==null) || 
             (this.validTo!=null &&
              this.validTo.equals(other.getValidTo())));
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
        if (getAuthor() != null) {
            _hashCode += getAuthor().hashCode();
        }
        if (getAvailability() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAvailability());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAvailability(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getChangemanagement() != null) {
            _hashCode += getChangemanagement().hashCode();
        }
        if (getCustomerSupport() != null) {
            _hashCode += getCustomerSupport().hashCode();
        }
        if (getGlossaries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGlossaries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGlossaries(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getId();
        if (getInvolvedParties() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInvolvedParties());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInvolvedParties(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPerformance() != null) {
            _hashCode += getPerformance().hashCode();
        }
        if (getPredecessor() != null) {
            _hashCode += getPredecessor().hashCode();
        }
        if (getReports() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReports());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReports(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSecurityDescription() != null) {
            _hashCode += getSecurityDescription().hashCode();
        }
        if (getServiceDescription() != null) {
            _hashCode += getServiceDescription().hashCode();
        }
        if (getServiceDescritption() != null) {
            _hashCode += getServiceDescritption().hashCode();
        }
        if (getServiceHours() != null) {
            _hashCode += getServiceHours().hashCode();
        }
        if (getSlaDescription() != null) {
            _hashCode += getSlaDescription().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getValidFrom() != null) {
            _hashCode += getValidFrom().hashCode();
        }
        if (getValidTo() != null) {
            _hashCode += getValidTo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Agreement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Agreement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("author");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "author"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("availability");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "availability"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Availability"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changemanagement");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "changemanagement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "ChangeManagement"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerSupport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "customerSupport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "CustomerSupport"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("glossaries");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "glossaries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://glossary.domain.dt.xdrozd07", "Glossary"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("involvedParties");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "involvedParties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "InvolvedParty"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("performance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "performance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Performance"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("predecessor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "predecessor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Agreement"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reports");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "reports"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Report"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "securityDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "serviceDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceDescritption");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "serviceDescritption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceHours");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "serviceHours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "ServiceHours"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("slaDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "slaDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "validFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "validTo"));
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
