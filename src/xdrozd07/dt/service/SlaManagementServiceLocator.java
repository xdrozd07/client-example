/**
 * SlaManagementServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.service;

public class SlaManagementServiceLocator extends org.apache.axis.client.Service implements xdrozd07.dt.service.SlaManagementService {

    public SlaManagementServiceLocator() {
    }


    public SlaManagementServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SlaManagementServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SlaManagement
    private java.lang.String SlaManagement_address = "http://localhost:8080/dip/services/SlaManagement";

    public java.lang.String getSlaManagementAddress() {
        return SlaManagement_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SlaManagementWSDDServiceName = "SlaManagement";

    public java.lang.String getSlaManagementWSDDServiceName() {
        return SlaManagementWSDDServiceName;
    }

    public void setSlaManagementWSDDServiceName(java.lang.String name) {
        SlaManagementWSDDServiceName = name;
    }

    public xdrozd07.dt.service.SlaManagement getSlaManagement() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SlaManagement_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSlaManagement(endpoint);
    }

    public xdrozd07.dt.service.SlaManagement getSlaManagement(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            xdrozd07.dt.service.SlaManagementSoapBindingStub _stub = new xdrozd07.dt.service.SlaManagementSoapBindingStub(portAddress, this);
            _stub.setPortName(getSlaManagementWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSlaManagementEndpointAddress(java.lang.String address) {
        SlaManagement_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (xdrozd07.dt.service.SlaManagement.class.isAssignableFrom(serviceEndpointInterface)) {
                xdrozd07.dt.service.SlaManagementSoapBindingStub _stub = new xdrozd07.dt.service.SlaManagementSoapBindingStub(new java.net.URL(SlaManagement_address), this);
                _stub.setPortName(getSlaManagementWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SlaManagement".equals(inputPortName)) {
            return getSlaManagement();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.dt.xdrozd07", "SlaManagementService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "SlaManagement"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SlaManagement".equals(portName)) {
            setSlaManagementEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
