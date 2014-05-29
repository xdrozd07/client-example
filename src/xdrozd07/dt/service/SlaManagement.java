/**
 * SlaManagement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.service;

public interface SlaManagement extends java.rmi.Remote {
    public xdrozd07.dt.domain.Agreement[] getAgreements() throws java.rmi.RemoteException;
    public void addAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException;
    public void updateAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException;
    public xdrozd07.dt.domain.Agreement[] getAuthorsAgreements(java.lang.String author) throws java.rmi.RemoteException;
    public java.lang.String connectionTest(java.lang.String name) throws java.rmi.RemoteException;
    public void deleteAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException;
}
