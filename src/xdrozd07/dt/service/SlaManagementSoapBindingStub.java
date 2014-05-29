/**
 * SlaManagementSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xdrozd07.dt.service;

public class SlaManagementSoapBindingStub extends org.apache.axis.client.Stub implements xdrozd07.dt.service.SlaManagement {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAgreements");
        oper.setReturnType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Agreement"));
        oper.setReturnClass(xdrozd07.dt.domain.Agreement[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "getAgreementsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addAgreement");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "agreement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Agreement"), xdrozd07.dt.domain.Agreement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateAgreement");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "agreement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Agreement"), xdrozd07.dt.domain.Agreement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAuthorsAgreements");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "author"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Agreement"));
        oper.setReturnClass(xdrozd07.dt.domain.Agreement[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "getAuthorsAgreementsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("connectionTest");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "connectionTestReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteAgreement");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "agreement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Agreement"), xdrozd07.dt.domain.Agreement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

    }

    public SlaManagementSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SlaManagementSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SlaManagementSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "AccessTime");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.AccessTime.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Agreement");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Agreement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Availability");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Availability.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "ChangeManagement");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.ChangeManagement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Contact");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Contact.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "CustomerSupport");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.CustomerSupport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Event");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Event.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "InvolvedParty");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.InvolvedParty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Performance");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Performance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Report");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Report.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "ServiceHours");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.ServiceHours.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Signatory");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Signatory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glossary.domain.dt.xdrozd07", "Glossary");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.glossary.Glossary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glossary.domain.dt.xdrozd07", "Term");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.glossary.Term.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Listener");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.metric.Listener.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Metric");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.metric.Metric.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "MetricValue");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.metric.MetricValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Treshold");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.metric.Treshold.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns1_AccessTime");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.AccessTime[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "AccessTime");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns1_Availability");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Availability[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Availability");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns1_Contact");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Contact[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Contact");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns1_Event");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Event[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Event");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns1_InvolvedParty");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.InvolvedParty[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "InvolvedParty");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns1_Report");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Report[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Report");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns1_Signatory");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.Signatory[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://domain.dt.xdrozd07", "Signatory");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns2_Listener");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.metric.Listener[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Listener");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns2_Metric");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.metric.Metric[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Metric");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns2_MetricValue");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.metric.MetricValue[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "MetricValue");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns2_Treshold");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.metric.Treshold[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://metric.domain.dt.xdrozd07", "Treshold");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns3_Glossary");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.glossary.Glossary[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://glossary.domain.dt.xdrozd07", "Glossary");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "ArrayOf_tns3_Term");
            cachedSerQNames.add(qName);
            cls = xdrozd07.dt.domain.glossary.Term[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://glossary.domain.dt.xdrozd07", "Term");
            qName2 = new javax.xml.namespace.QName("http://service.dt.xdrozd07", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public xdrozd07.dt.domain.Agreement[] getAgreements() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "getAgreements"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (xdrozd07.dt.domain.Agreement[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (xdrozd07.dt.domain.Agreement[]) org.apache.axis.utils.JavaUtils.convert(_resp, xdrozd07.dt.domain.Agreement[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "addAgreement"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agreement});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void updateAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "updateAgreement"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agreement});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public xdrozd07.dt.domain.Agreement[] getAuthorsAgreements(java.lang.String author) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "getAuthorsAgreements"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {author});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (xdrozd07.dt.domain.Agreement[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (xdrozd07.dt.domain.Agreement[]) org.apache.axis.utils.JavaUtils.convert(_resp, xdrozd07.dt.domain.Agreement[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String connectionTest(java.lang.String name) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "connectionTest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {name});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void deleteAgreement(xdrozd07.dt.domain.Agreement agreement) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.dt.xdrozd07", "deleteAgreement"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agreement});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
