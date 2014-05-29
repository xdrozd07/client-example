package xdrozd07.dt.service;

public class SlaManagementProxy implements xdrozd07.dt.service.SlaManagement {
  private String _endpoint = null;
  private xdrozd07.dt.service.SlaManagement slaManagement = null;
  
  public SlaManagementProxy() {
    _initSlaManagementProxy();
  }
  
  public SlaManagementProxy(String endpoint) {
    _endpoint = endpoint;
    _initSlaManagementProxy();
  }
  
  private void _initSlaManagementProxy() {
    try {
      slaManagement = (new xdrozd07.dt.service.SlaManagementServiceLocator()).getSlaManagement();
      if (slaManagement != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)slaManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)slaManagement)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (slaManagement != null)
      ((javax.xml.rpc.Stub)slaManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public xdrozd07.dt.service.SlaManagement getSlaManagement() {
    if (slaManagement == null)
      _initSlaManagementProxy();
    return slaManagement;
  }
  
  public xdrozd07.dt.domain.Agreement[] getAgreements() throws java.rmi.RemoteException{
    if (slaManagement == null)
      _initSlaManagementProxy();
    return slaManagement.getAgreements();
  }
  
  public void addAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException{
    if (slaManagement == null)
      _initSlaManagementProxy();
    slaManagement.addAgreement(agreement);
  }
  
  public void updateAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException{
    if (slaManagement == null)
      _initSlaManagementProxy();
    slaManagement.updateAgreement(agreement);
  }
  
  public xdrozd07.dt.domain.Agreement[] getAuthorsAgreements(java.lang.String author) throws java.rmi.RemoteException{
    if (slaManagement == null)
      _initSlaManagementProxy();
    return slaManagement.getAuthorsAgreements(author);
  }
  
  public java.lang.String connectionTest(java.lang.String name) throws java.rmi.RemoteException{
    if (slaManagement == null)
      _initSlaManagementProxy();
    return slaManagement.connectionTest(name);
  }
  
  public void deleteAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException{
    if (slaManagement == null)
      _initSlaManagementProxy();
    slaManagement.deleteAgreement(agreement);
  }
  
  
}