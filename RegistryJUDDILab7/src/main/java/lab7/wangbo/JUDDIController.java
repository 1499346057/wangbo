package lab7.wangbo;

import org.apache.juddi.v3.client.UDDIConstants;
import org.apache.juddi.v3.client.transport.Transport;
import org.uddi.api_v3.*;
import org.apache.juddi.api_v3.*;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.uddi.v3_service.UDDIPublicationPortType;
import org.uddi.v3_service.UDDISecurityPortType;
import org.uddi.v3_service.UDDIInquiryPortType;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author WangBo
 * @date 26.05.2019
 */
public class JUDDIController {

	private AuthToken authToken;
	private String pathToUddiSettings = null;
	private UDDISecurityPortType security = null;
	private UDDIPublicationPortType publish = null;
	private UDDIInquiryPortType inquiry = null;

	public JUDDIController(String pathToUddiSettings) {
		try {
			if (pathToUddiSettings == null || pathToUddiSettings.isEmpty())
				throw new Exception("Path to settings is not set!");
			this.pathToUddiSettings = pathToUddiSettings;

			// create a client and read the config in the archive;
			UDDIClient uddiClient = new UDDIClient(this.pathToUddiSettings);
			Transport transport = uddiClient.getTransport("default");
			// Now you create a reference to the UDDI API
			security = transport.getUDDISecurityService();
			publish = transport.getUDDIPublishService();
			inquiry = transport.getUDDIInquiryService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAuthenticate(String login, String passwd) throws RemoteException {
		GetAuthToken getAuthTokenMyPub = new GetAuthToken();
		getAuthTokenMyPub.setUserID(login);
		getAuthTokenMyPub.setCred(passwd);
		this.authToken = security.getAuthToken(getAuthTokenMyPub);
	}

	public ServiceDetail publish(String businessKey, String serviceName, String wsdlUrl) {
		ServiceDetail sd = new ServiceDetail();
		try {
			// Creating the parent business entity that will contain our service.
			String myBusKey = registerBusiness(businessKey);
			// Creating a service to save.
			sd = registerService(myBusKey, serviceName, wsdlUrl);
			System.out.println("Success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sd;
	}

	public ServiceDetail findServiceByName(String serviceName) throws RemoteException {
		FindService findService = new FindService();
		findService.setAuthInfo(authToken.getAuthInfo());
		FindQualifiers findQualifiers = new FindQualifiers();
		findQualifiers.getFindQualifier().add(UDDIConstants.APPROXIMATE_MATCH);
		findService.setFindQualifiers(findQualifiers);
		Name searchName = new Name();
		searchName.setValue("%" + serviceName + "%");
		findService.getName().add(searchName);
		ServiceList serviceList = inquiry.findService(findService);
		GetServiceDetail gsd = new GetServiceDetail();
		for (int i = 0; i < serviceList.getServiceInfos().getServiceInfo().size(); i++) {
			gsd.getServiceKey().add(serviceList.getServiceInfos().getServiceInfo().get(i).getServiceKey());
		}
		ServiceDetail serviceDetail = inquiry.getServiceDetail(gsd);
		return serviceDetail;
	}

	public void useService(String skey) throws IOException {
		GetServiceDetail gsd = new GetServiceDetail();
		gsd.setAuthInfo(authToken.getAuthInfo());
		gsd.getServiceKey().add(skey);
		ServiceDetail serviceDetail = inquiry.getServiceDetail(gsd);
		if ((serviceDetail == null) || (serviceDetail.getBusinessService() == null)
				|| serviceDetail.getBusinessService().isEmpty()) {
			System.out.println("Can not find service with key " + skey);
			return;
		}
		List<BusinessService> services = serviceDetail.getBusinessService();
		BusinessService businessService = services.get(0);
		BindingTemplates bindingTemplates = businessService.getBindingTemplates();
		if (bindingTemplates == null || bindingTemplates.getBindingTemplate().isEmpty()) {
			System.out.println("No binding template for service with key " + skey);
			return;
		}
		for (BindingTemplate bindingTemplate : bindingTemplates.getBindingTemplate()) {
			AccessPoint accessPoint = bindingTemplate.getAccessPoint();
			System.out.println(accessPoint.getValue());
		}
	}

	private String registerBusiness(String businessKey) throws Exception {
		BusinessEntity myBusEntity = new BusinessEntity();
		Name myBusName = new Name();
		myBusName.setValue(businessKey);
		myBusEntity.getName().add(myBusName);
		// Adding the business entity to the "save" structure, using our publisher's
		// authentication info and saving away.
		SaveBusiness sb = new SaveBusiness();
		sb.getBusinessEntity().add(myBusEntity);
		sb.setAuthInfo(authToken.getAuthInfo());
		BusinessDetail bd = publish.saveBusiness(sb);
		String myBusKey = bd.getBusinessEntity().get(0).getBusinessKey();
		System.out.println("myBusiness key:  " + myBusKey);
		return myBusKey;
	}

	private ServiceDetail registerService(String myBusKey, String serviceName, String wsdlUrl) throws Exception {
		BusinessService myService = new BusinessService();
		myService.setBusinessKey(myBusKey);
		Name myServName = new Name();
		myServName.setValue(serviceName);
		myService.getName().add(myServName);
		// Add binding templates, etc...
		BindingTemplate myBindingTemplate = new BindingTemplate();
		AccessPoint accessPoint = new AccessPoint();
		accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
		accessPoint.setValue(wsdlUrl);
		myBindingTemplate.setAccessPoint(accessPoint);
		BindingTemplates myBindingTemplates = new BindingTemplates();

		// optional but recommended step, this annotations our binding with all the
		// standard SOAP tModel instance infos
		myBindingTemplate = UDDIClient.addSOAPtModels(myBindingTemplate);
		myBindingTemplates.getBindingTemplate().add(myBindingTemplate);
		myService.setBindingTemplates(myBindingTemplates);

		// Adding the service to the "save" structure, using our publisher's
		// authentication info and saving away.
		SaveService ss = new SaveService();
		ss.getBusinessService().add(myService);
		ss.setAuthInfo(authToken.getAuthInfo());
		ServiceDetail sd;
		sd = publish.saveService(ss);
		return sd;
	}
}
