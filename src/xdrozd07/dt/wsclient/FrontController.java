package xdrozd07.dt.wsclient;

/**
 * Front module controller
 * @author Radek Drozd
 */


import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xdrozd07.dt.domain.Agreement;
import xdrozd07.dt.domain.Availability;
import xdrozd07.dt.domain.ChangeManagement;
import xdrozd07.dt.domain.Contact;
import xdrozd07.dt.domain.CustomerSupport;
import xdrozd07.dt.domain.InvolvedParty;
import xdrozd07.dt.domain.Performance;
import xdrozd07.dt.domain.Report;
import xdrozd07.dt.domain.ServiceHours;
import xdrozd07.dt.domain.glossary.Term;
import xdrozd07.dt.domain.metric.Listener;
import xdrozd07.dt.domain.metric.Metric;
import xdrozd07.dt.domain.metric.Treshold;
import xdrozd07.dt.logger.LoggerUtil;
import xdrozd07.dt.service.SlaManagementProxy;
import xdrozd07.dt.wsclient.domain.ExtendedAccessTime;
import xdrozd07.dt.wsclient.domain.ExtendedAgreement;
import xdrozd07.dt.wsclient.domain.ExtendedChangeManagement;
import xdrozd07.dt.wsclient.domain.ExtendedCustomerSupport;
import xdrozd07.dt.wsclient.domain.ExtendedEvent;
import xdrozd07.dt.wsclient.domain.ExtendedGlossary;
import xdrozd07.dt.wsclient.domain.ExtendedInvolvedParty;
import xdrozd07.dt.wsclient.domain.ExtendedPerformance;
import xdrozd07.dt.wsclient.domain.ExtendedReport;
import xdrozd07.dt.wsclient.domain.ExtendedServiceHours;
import xdrozd07.dt.wsclient.domain.ExtendedSignatory;
import xdrozd07.dt.wsclient.domain.MetricIndex;
import xdrozd07.dt.wsclient.authentication.IAuthenticator;
import xdrozd07.dt.wsclient.authentication.SimpleAuthenticator;
import xdrozd07.dt.wsclient.authentication.User;
import xdrozd07.dt.wsclient.domain.metric.ExtendedMetric;
import xdrozd07.dt.wsclient.domain.metric.ExtendedThreshold;




@Controller
@Scope("session")
public class FrontController {
	
	// important fields
	private User user = null;
	private SlaManagementProxy serviceProxy;
	private IAuthenticator authenticator;
	
	
	// temporary session fields
	private List<Agreement> agreements = null;
	private ExtendedAgreement current = null;
	private boolean edit;
	private ExtendedInvolvedParty currentParty = null;
	private int currentPartyIndex;
	private ExtendedServiceHours currentSh = null;
	private ExtendedGlossary currentGlossary= null;
	private int currentGlossaryIndex;
	private int currentMetricIndex;
	private ExtendedMetric currentMetric;
	private ExtendedThreshold currentThreshold;
	private int currentThresholdIndex;
	private int currentAvailabilityIndex;
	private Availability currentAvailability;
	private ExtendedReport currentReport;
	private int currentReportIndex;
	
	private boolean metricChangedFlag = false;
	
	
	
	
	
	/**
	 * service proxy singleton
	 * @return
	 */
	private SlaManagementProxy getServiceProxy(){
		if(this.serviceProxy == null){
			this.serviceProxy = new SlaManagementProxy();
		}
		return this.serviceProxy;
	}
	
	/**
	 * Authenticator singleton
	 * @return
	 */
	private IAuthenticator getAuthenticator(){
		if(this.authenticator == null){
			this.authenticator = new SimpleAuthenticator();
		}
		return this.authenticator;
	}
	
	
	/**
	 * login page view
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView defaultView(ModelMap model)
	{
		User user = new User();
		user.setLogin("Rada");
		return new ModelAndView("index", "command", user);
	}
	
	
	/**
	 * login action
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("wsclient")User user, ModelMap model, HttpSession session)
	{
		ModelAndView m = null;
		
		if(this.getAuthenticator().authenticate(user)){
			this.user = user;
			session.setAttribute("user", user);
			session.setAttribute("message", null);
			
			m = new ModelAndView("redirect:/agreement/list");
		}else{
			this.user = null;
			
			session.setAttribute("message", "Wrong user login or password.");
			
			m = new ModelAndView("redirect:/");
		}
		

		return m;
		
	}
	
	/**
	 * logout action
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model)
	{
		this.user = null;
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * delete agreement action
	 * @param index
	 * @param model
	 * @return
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/delete", method = RequestMethod.GET, params = {"index"})
	public ModelAndView deleteAgreement(@RequestParam(value = "index") int index, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		try {
			this.getServiceProxy().deleteAgreement(this.agreements.get(index));
		} catch (RemoteException e) {
			LoggerUtil.log(e);
		}
		
		
		return new ModelAndView("redirect:/agreement/list");
	}
	
	/**
	 * list of agreements view
	 * @param model
	 * @param session
	 * @return
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/list", method = RequestMethod.GET)
	public ModelAndView listView(ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		SlaManagementProxy proxy = this.getServiceProxy();

		this.agreements = null; 

		if(this.user != null){
			try {
				//this.agreements = new ArrayList<Agreement>(Arrays.asList(proxy.getAuthorsAgreements(this.user.getLogin())));
				
				Agreement[] agrs = proxy.getAuthorsAgreements(this.user.getLogin());
				this.agreements = new ArrayList<Agreement>();
				if(agrs != null){
					for(Agreement a : agrs){
						this.agreements.add(a);
					}
				}
				
				agrs = null;
				
			} catch (RemoteException e) {
				LoggerUtil.log(e);
			}
		}

		
		session.setAttribute("agreements", this.agreements);
		session.setAttribute("user", user);

		return new ModelAndView("list", "command", this.user);
	}	
	
	
	/**
	 * New agreement view
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/new", method = RequestMethod.GET)
	public ModelAndView newAgreementView(ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		if(this.current == null){
			this.edit = false;
			this.current = new ExtendedAgreement();
			this.current.setPredecessorIndex(-1);	
		}
		
		System.out.println("predecessor index: " + this.current.getPredecessorIndex());
		
		Map<Integer, String> predecessors = new LinkedHashMap<Integer,String>();
		
		int i = 0;
		for(Agreement p : this.agreements){
			predecessors.put(i, p.getName());
			i++;
		}		
		model.addAttribute("predecessors", predecessors);
		
		Map<String, String> types = new LinkedHashMap<String,String>();
		types.put("sla", "Service Level Agreement");
		types.put("ola", "Organisation Level Agreement");
		types.put("uc", "Underpinning Contract");

		model.addAttribute("types", types);
		
		return  new ModelAndView("agreement/basicInformations", "command", this.current) ;
	}
	
	/**
	 * sets the agreement to be edited and than starts editing
	 * @param index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/edit", method = RequestMethod.GET, params = {"index"})
	public ModelAndView editAgreement(@RequestParam(value = "index") int index, ModelMap model)
	{
		ModelAndView m ;
		if(!this.isAllowed("user")){
			m = new ModelAndView("redirect:/");
		}else{
			if(index < this.agreements.size()){
				this.edit = true;
				this.current = new ExtendedAgreement(this.agreements.get(index));
				//this.current.setPredecessorIndex(this.cur);
				
				System.out.println("edit ID: "+this.current.getId());
				this.current.setPredecessorIndex(this.getIndexOfPredecessor(this.current));
				
				Map<Integer ,String> predecessors = new LinkedHashMap<Integer,String>();
				
				int i = 0;
				for(Agreement p : this.agreements){
					if(p.getId() != this.current.getId())
						predecessors.put(i, p.getName());
					
					i++;
				}
				model.addAttribute("predecessors", predecessors);
				
				Map<String, String> types = new LinkedHashMap<String,String>();
				types.put("sla", "Service Level Agreement");
				types.put("ola", "Organisation Level Agreement");
				types.put("uc", "Underpinning Contract");

				model.addAttribute("types", types);
				
				m = new ModelAndView("agreement/basicInformations", "command", this.current) ;
			}else{
				m = new ModelAndView("agreement/list") ;
			}
		}
		
		
		

		return  m;
	}
	
	/**
	 * Save agreement action
	 * saves agreement to database
	 * @param model
	 * @return
	 * @throws ParseException 
	 * @throws RemoteException 
	 */
	@RequestMapping(value = "/agreement/save", method = { RequestMethod.POST, RequestMethod.GET } )
	public ModelAndView saveAgreementAction(ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		Agreement a;
		
		
	
		
		try {
			a = this.current.getAgreement();
			
			
			if(a.getAuthor() == null){
				a.setAuthor(this.user.getLogin());
			}
			
			if(this.edit){
				// if we are editing agreement, we just update
				this.getServiceProxy().updateAgreement(a);
			}else{
				// if we are making new agreement, add it
				System.err.println("delam novou");
				this.getServiceProxy().addAgreement(a);
			}
			
			this.metricChangedFlag = false;
			this.current = null;
			
		} catch (ParseException | RemoteException e) {
			
			LoggerUtil.log(e);
		}

		
		return new ModelAndView("redirect:/agreement/list");
	}
	
	/* agreement definition below */
	
	/**
	 * views form for basic information settings
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-basic-informations", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView actionAddBasicInfromations(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		this.current.setName(extendedAgreement.getName());
		this.current.setValidFromString(extendedAgreement.getValidFromString());
		this.current.setValidToString(extendedAgreement.getValidToString());
		this.current.setServiceDescription(extendedAgreement.getServiceDescription());
		this.current.setSlaDescription(extendedAgreement.getSlaDescription());
		this.current.setSecurityDescription(extendedAgreement.getSecurityDescription());
		this.current.setPredecessorIndex(extendedAgreement.getPredecessorIndex());
		this.current.setType(extendedAgreement.getType());
		
		
		
		if(this.agreements.size() > extendedAgreement.getPredecessorIndex() && extendedAgreement.getPredecessorIndex() > -1){
			this.current.setPredecessor(this.agreements.get(extendedAgreement.getPredecessorIndex()));
	
		}else if(extendedAgreement.getPredecessorIndex() == -1){
			this.current.setPredecessor(null);
		}
		
		
		this.current.setAuthor(this.user.getLogin());
		
		return new ModelAndView("redirect:/agreement/new");
	}
	
	/**
	 * New agreement view
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/view", method = RequestMethod.GET, params = {"index"})
	public ModelAndView viewAgreement(@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		

		if(this.agreements.size() <= index){
			return new ModelAndView("redirect:/list");
		}
			
		session.setAttribute("agreement", this.agreements.get(index));
		
		return  new ModelAndView("agreement/view") ;
	}
	
	
	/**
	 * Add agreement action
	 * @param model
	 * @return
	 * @throws ParseException 
	 * @throws RemoteException 
	 */
	@RequestMapping(value = "/agreement/involved-parties", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewInvolvedParties(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current != null )
			session.setAttribute("parties", this.current.getInvolvedPartiesList());
		
		
		Map<String,String> roles = new LinkedHashMap<String,String>();
		roles.put("customer", "Customer");
		roles.put("provider", "Provider");
		roles.put("third", "Third party");
		
		model.addAttribute("roles", roles);
		
		return  new ModelAndView("agreement/involvedParties", "command", new ExtendedInvolvedParty()) ;
	}
	
	
	/**
	 * 
	 * @param party
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-involved-party", method = RequestMethod.POST)
	public ModelAndView actionAddInvolvedParty(@ModelAttribute("wsclient")ExtendedInvolvedParty party, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		// check if contact was filled
		
		
		this.current.addInvolvedParty(party.getInvolvedParty());
		
		session.setAttribute("parties", this.current.getInvolvedPartiesList().toArray());
		
		
		return new ModelAndView("redirect:/agreement/involved-parties");
	}
	
	/**
	 * Deletes involved party
	 * @param party
	 * @param model
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value = "/agreement/delete-involved-party", method = RequestMethod.GET, params = {"index"})
	public ModelAndView actionDeleteInvolvedParty(@RequestParam(value = "index") int index, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		this.current.deleteInvolvedParty(index);
		
		
		
		
		return new ModelAndView("redirect:/agreement/involved-parties");
	}
	
	
	/**
	 * shows all signatories of involved party specified by index
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	
	@RequestMapping(value = "/agreement/signatories", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewSignatures(@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.current != null ){
			this.currentParty = new ExtendedInvolvedParty(this.current.getInvolvedPartiesList().get(index));
			this.currentPartyIndex = index;
			

			session.setAttribute("signatories", this.current.getInvolvedPartiesList().get(index).getSignatories());
		}
			
		

		return  new ModelAndView("agreement/signatories", "command", new ExtendedSignatory()) ;
	}
	
	
	
	
	/**
	 * Adds signature to current party
	 * @param party
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-signatory", method = RequestMethod.POST)
	public ModelAndView actionAddSignatory(@ModelAttribute("wsclient")ExtendedSignatory s, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		this.currentParty.addSignature(s.getSignatory());
		
		this.current.getInvolvedPartiesList().remove(this.currentPartyIndex);
		this.current.getInvolvedPartiesList().add(this.currentPartyIndex, this.currentParty.getInvolvedParty());
		

		
		return new ModelAndView("redirect:/agreement/signatories?index="+this.currentPartyIndex);
	}
	
	/**
	 * delete signature specified by an index
	 * @param index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-signatory", method = RequestMethod.GET	)
	public ModelAndView actionDeleteISignatory(@RequestParam(value = "index") int index, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		this.currentParty.deleteSignature(index);
		
		this.current.getInvolvedPartiesList().remove(this.currentPartyIndex);
		this.current.getInvolvedPartiesList().add(this.currentPartyIndex, this.currentParty.getInvolvedParty());
		
		return new ModelAndView("redirect:/agreement/signatories?index="+this.currentPartyIndex);
	}
	
	
	/**
	 * add service hours
	 * @param model
	 * @return
	 * @throws ParseException 
	 * @throws RemoteException 
	 */
	@RequestMapping(value = "/agreement/service-hours", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewServiceHours(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current != null && this.current.getServiceHours() != null){
			session.setAttribute("accessTimes", this.current.getServiceHours().getAccessTimes());
			session.setAttribute("events", this.current.getServiceHours().getEvents());
		}
		
		ServiceHours sh;
		if(this.current != null && this.current.getServiceHours() != null)
			sh = this.current.getServiceHours();
		else
			sh = new ServiceHours();
		

		
		return  new ModelAndView("agreement/serviceHours", "command", sh) ;
	}
	
	/**
	 * Saves service hours
	 * @param party
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-service-hours", method = RequestMethod.POST)
	public ModelAndView actionAddServiceHours(@ModelAttribute("wsclient")ServiceHours sh, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.currentSh == null){
			this.currentSh = new ExtendedServiceHours(sh);
		}else{
			this.currentSh.setDescription(sh.getDescription());
		}
		
		this.current.setServiceHours(this.currentSh.getServiceHours());
		
		return new ModelAndView("redirect:/agreement/service-hours");
	}
	
	
	/**
	 * adds access time to service hours
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/service-hours-access-time", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewServiceHoursAccessTime(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		Map<String,String> days = new LinkedHashMap<String,String>();
		days.put("mon", "Monday");
		days.put("tue", "Tuesday");
		days.put("wed", "Wednesday");
		days.put("thu", "Thursday");
		days.put("fri", "Friday");
		days.put("sat", "Saturday");
		days.put("sun", "Sunday");
		
		model.addAttribute("days", days);

		
		return  new ModelAndView("agreement/shAccessTime", "command", new ExtendedAccessTime()) ;
	}
	
	
	/**
	 * adds accessTime to service hours
	 * @param party
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/service-hours-add-access-time", method = RequestMethod.POST)
	public ModelAndView actionAddShAccessTime(@ModelAttribute("wsclient")ExtendedAccessTime at, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.currentSh == null){
			this.currentSh = new ExtendedServiceHours(this.current.getServiceHours());
		}
		

		this.currentSh.addAccessTime( at.getAccessTime());
		
		this.current.setServiceHours(this.currentSh.getServiceHours());
		
		return new ModelAndView("redirect:/agreement/service-hours");
	}
	
	/**
	 * delete access time specified by an index
	 * @param index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/service-hours-delete-access-time", method = RequestMethod.GET	)
	public ModelAndView actionShAccessTime(@RequestParam(value = "index") int index, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		this.currentSh.deleteAccessTime(index);
		
		this.current.setServiceHours(this.currentSh.getServiceHours());
		
		return new ModelAndView("redirect:/agreement/service-hours");
	}
	
	
	/**
	 * adds access time to service hours
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/event", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewEvent(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		Map<String,String> types = new LinkedHashMap<String,String>();
		types.put("maintenance", "Maintenance");
		types.put("Shutdown", "Shutdown");
		types.put("other", "Other");
		
		model.addAttribute("types", types);

		
		return  new ModelAndView("agreement/event", "command", new ExtendedEvent() ) ;
	}
	
	/**
	 * adds event to service hours
	 * @param ev
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-event", method = RequestMethod.POST)
	public ModelAndView actionAddEvent(@ModelAttribute("wsclient")ExtendedEvent ev, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.currentSh == null){
			this.currentSh = new ExtendedServiceHours(this.current.getServiceHours());
		}
		

		this.currentSh.addEvent(ev.getEvent());
		
		this.current.setServiceHours(this.currentSh.getServiceHours());
		
		return new ModelAndView("redirect:/agreement/service-hours");
	}
	
	/**
	 * deletes event specified by index if exists
	 * @param index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-event", method = RequestMethod.GET	)
	public ModelAndView actionDeleteEvent(@RequestParam(value = "index") int index, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		this.currentSh.deleteEvent(index);
		
		this.current.setServiceHours(this.currentSh.getServiceHours());
		
		return new ModelAndView("redirect:/agreement/service-hours");
	}
	
	/**
	 * customer support definition
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/customer-support", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewCustomerSupport(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		if(this.current.getCustomerSupport() != null){
			session.setAttribute("accessTimes", this.current.getCustomerSupport().getAccessTimes());
		}
			
		Map<String,String> hours = new LinkedHashMap<String,String>();
		for(int i = 0; i < 24; i++){
			hours.put(Integer.toString(i), Integer.toString(i));
		}
		
		model.addAttribute("hours", hours);

		
		return  new ModelAndView("agreement/customerSupport", "command", new ExtendedCustomerSupport(this.current.getCustomerSupport()) ) ;
	}
	
	
	/**
	 * adds customer support to current SLA
	 * @param cs
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-customer-support", method = RequestMethod.POST)
	public ModelAndView actionAddAddCustomerSupprot(@ModelAttribute("wsclient")ExtendedCustomerSupport cs, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}


		this.current.setCustomerSupport(cs.getCustomerSupport());
		
		
		return new ModelAndView("redirect:/agreement/customer-support");
	}
	
	/**
	 * adds AT to current SLA custommer support
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/customer-support-access-time", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewCustomerSupportAccessTime(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		Map<String,String> days = new LinkedHashMap<String,String>();
		days.put("mon", "Monday");
		days.put("tue", "Tuesday");
		days.put("wed", "Wednesday");
		days.put("thu", "Thursday");
		days.put("fri", "Friday");
		days.put("sat", "Saturday");
		days.put("sun", "Sunday");
		
		model.addAttribute("days", days);

		
		return  new ModelAndView("agreement/csAccessTime", "command", new ExtendedAccessTime()) ;
	}
	
	
	/**
	 * Adds access time to customer support
	 * @param at
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/customer-support-add-access-time", method = RequestMethod.POST)
	public ModelAndView actionAddCsAccessTime(@ModelAttribute("wsclient")ExtendedAccessTime at, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current.getCustomerSupport() == null){
			this.current.setCustomerSupport(new CustomerSupport());
		}
		
		ExtendedCustomerSupport ecs = new ExtendedCustomerSupport(this.current.getCustomerSupport());
		ecs.addAccessTime(at.getAccessTime());
		
		this.current.setCustomerSupport(ecs.getCustomerSupport());

		
		return new ModelAndView("redirect:/agreement/customer-support");
	}
	
	/**
	 * removes access time from custommes supports list
	 * @param index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/customer-support-delete-access-time", method = RequestMethod.GET	)
	public ModelAndView actionDeleteCsAccessTime(@RequestParam(value = "index") int index, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		ExtendedCustomerSupport ecs = new ExtendedCustomerSupport(this.current.getCustomerSupport());

		ecs.deleteAccessTime(index);
		
		this.current.setCustomerSupport(ecs.getCustomerSupport());
		
		return new ModelAndView("redirect:/agreement/customer-support");
	}
	
	/**
	 * change managemnet definition
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/change-management", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewChangeManagement(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		

		return  new ModelAndView("agreement/changeManagement", "command", new ExtendedChangeManagement(this.current.getChangemanagement())  ) ;
	}
	
	
	/**
	 * Adds change managemetn to current SLA
	 * @param at
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-change-management", method = RequestMethod.POST)
	public ModelAndView actionAddChangeManagement(@ModelAttribute("wsclient")ExtendedChangeManagement chm, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		this.current.setChangemanagement(chm.getChangeManagement());
		
		return new ModelAndView("redirect:/agreement/change-management");
	}
	
	/**
	 * Show glossaries
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/glossaries", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewGlossaries(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		if(this.current.getGloassariesList()!= null){
			session.setAttribute("glossaries", this.current.getGloassariesList());
		}

		
		return  new ModelAndView("agreement/glossaries", "command", new ExtendedGlossary() ) ;
	}
	

	
	/**
	 * removes glossary from current SLA
	 * @param index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-glossary", method = RequestMethod.GET	)
	public ModelAndView actionDeletwGlossary(@RequestParam(value = "index") int index, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current != null){
			this.current.deleteGlossary(index);
		}
		return new ModelAndView("redirect:/agreement/glossaries");
	}
	

	
	@RequestMapping(value = "/agreement/add-glossary", method = RequestMethod.POST)
	public ModelAndView actionAddGlossary(@ModelAttribute("wsclient")ExtendedGlossary g, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		this.current.addGlossary(g.getGlossary());
		
		return new ModelAndView("redirect:/agreement/glossaries");
	}
	
	/**
	 * shows terms in glossary
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/terms", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewTerms(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		if(this.current.getGloassariesList() == null){
			return  new ModelAndView("agreement/glossaries", "command", new ExtendedGlossary() ) ;
		}
		
		this.currentGlossary = new ExtendedGlossary(this.current.getGloassariesList().get(index));
		
		if(this.currentGlossary.getTermsList() != null){
			session.setAttribute("terms", this.currentGlossary.getTermsList());
		}
		
		
		return  new ModelAndView("agreement/terms", "command", new Term() ) ;
	}
	
	/**
	 * adds term to glossary
	 * @param t
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-term", method = RequestMethod.POST)
	public ModelAndView actionAddTerm(@ModelAttribute("wsclient")Term t, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current == null){
			return new ModelAndView("redirect:/agreement/glossaries");
		}
		
		this.currentGlossary.addTerm(t);
		
		this.current.getGloassariesList().remove(this.currentGlossaryIndex);
		this.current.getGloassariesList().add(this.currentGlossaryIndex, this.currentGlossary.getGlossary());
		
		return new ModelAndView("redirect:/agreement/terms?index="+this.currentGlossaryIndex);
	}
	
	/**
	 * deletes term from current glossary
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/delete-term", method =  RequestMethod.GET )
	public ModelAndView actionDeleteTerm(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentGlossary == null){
			return  new ModelAndView("agreement/glossaries", "command", new ExtendedGlossary() ) ;
		}
		
		
		this.currentGlossary.deleteTerm(index);
		
		this.current.getGloassariesList().remove(this.currentGlossaryIndex);
		this.current.getGloassariesList().add(this.currentGlossaryIndex, this.currentGlossary.getGlossary());
		
		
		return new ModelAndView("redirect:/agreement/terms?index="+this.currentGlossaryIndex);
	}
	
	/**
	 * 
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/performance", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewPerformance(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		if(this.current.getPerformance() == null){
			this.current.setPerformance(new Performance());
		}else{
			session.setAttribute("metrics", this.current.getPerformance().getMetrics());
		}

		
		return  new ModelAndView("agreement/performance", "command", this.current.getPerformance() ) ;
	}
	
	/**
	 * saves data from performance from to context
	 * @param p
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/save-performance", method = RequestMethod.POST)
	public ModelAndView actionSavePerformance(@ModelAttribute("wsclient")Performance p, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		if(this.current.getPerformance() == null){
			this.current.setPerformance(p);
		}else{
			this.current.getPerformance().setDescription(p.getDescription());
		}
		
		return new ModelAndView("redirect:/agreement/performance");
	}
	
	/**
	 * adds metric to performance
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/performance-metric", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewPerformanceMetric(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		//'csv', 'xml', 'json'

		Map<String,String> types = new LinkedHashMap<String,String>();
		types.put("csv", "CSV");
		types.put("xml", "XML");
		types.put("json", "JSON");
		
		model.addAttribute("types", types);
		
		return  new ModelAndView("agreement/performanceMetric", "command", new Metric()) ;
	}
	
	
	/**
	 * adds metric to performance
	 * @param p
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-performance-metric", method = RequestMethod.POST)
	public ModelAndView actionAddPerformanceMetric(@ModelAttribute("wsclient")Metric m, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		ExtendedPerformance p = new ExtendedPerformance(this.current.getPerformance());
		p.addMetric(m);
		this.current.setPerformance(p.getPerformance());
		this.metricChangedFlag = true;
		
		return new ModelAndView("redirect:/agreement/performance");
	}
	
	/**
	 * deletes metric from performance
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 * @throws RemoteException
	 */
	@RequestMapping(value = "/agreement/delete-performance-metric", method =  RequestMethod.GET )
	public ModelAndView actionDeletePerformanceMetric(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		ExtendedPerformance p = new ExtendedPerformance(this.current.getPerformance());
		p.deleteMetrics(index);
		this.current.setPerformance(p.getPerformance());
		

		return new ModelAndView("redirect:/agreement/performance");
	}
	
	/**
	 * displays all values of given metric
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/performance-metric-values", method =  RequestMethod.GET )
	public ModelAndView viewPerfomanceMetricValues(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.current.getPerformance() == null || 
				this.current.getPerformance().getMetrics() == null){
			return new ModelAndView("redirect:/agreement/performance");
		}
		ExtendedPerformance ep = new ExtendedPerformance(this.current.getPerformance());
		
		if(ep.getMetricsList().get(index) == null){
			return new ModelAndView("redirect:/agreement/performance");
		}
		
		
		model.addAttribute("values", ep.getMetricsList().get(index).getValues());
		

		return  new ModelAndView("agreement/metricValues") ;
	}
	
	/**
	 * views add threshold form plus list of specified thresholds
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/performance-metric-tresholds", method =  RequestMethod.GET )
	public ModelAndView viewPerfomanceMetricTresholds(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.current.getPerformance() == null || 
				this.current.getPerformance().getMetrics() == null){
			return new ModelAndView("redirect:/agreement/performance");
		}
		ExtendedPerformance ep = new ExtendedPerformance(this.current.getPerformance());
		
		if(ep.getMetricsList().get(index) == null){
			return new ModelAndView("redirect:/agreement/performance");
		}
		
		this.currentMetric = new ExtendedMetric(ep.getMetricsList().get(index));
		this.currentMetricIndex = index;
		
		model.addAttribute("thresholds", this.currentMetric.getThresholdsList());
		

		return  new ModelAndView("agreement/performanceThreshold", "command", new Treshold()) ;
	}
	
	/**
	 * adds 
	 * @param t
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-metric-threshold", method = RequestMethod.POST)
	public ModelAndView actionAddPerformanceMetricThreshold(@ModelAttribute("wsclient")Treshold t, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		if(this.currentMetric == null){
			return new ModelAndView("redirect:/agreement/performance");
		}
		
		this.currentMetric.addThreshold(t);
		
		
		ExtendedPerformance ep = new ExtendedPerformance(this.current.getPerformance());


		ep.getMetricsList().remove(this.currentMetricIndex);
		ep.getMetricsList().add(this.currentMetricIndex, this.currentMetric.getMetric());
		this.current.setPerformance(ep.getPerformance());
		
		return new ModelAndView("redirect:/agreement/performance-metric-tresholds?index="+this.currentMetricIndex);
	}
	
	/**
	 * deletes treshold from metric/performance	
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-performance-metric-threshold", method =  RequestMethod.GET )
	public ModelAndView actionDeletePerformanceMetricThreshold(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentMetric == null){
			return new ModelAndView("redirect:/agreement/performance");
		}
		
		
		this.currentMetric.deleteThreshold(index);
		
		ExtendedPerformance p = new ExtendedPerformance(this.current.getPerformance());
		p.getMetricsList().add(this.currentMetricIndex, this.currentMetric.getMetric());
		
		this.current.setPerformance(p.getPerformance());
		

		return new ModelAndView("redirect:/agreement/performance-metric-tresholds?index="+this.currentMetricIndex);
	}
	
	/**
	 * shows thresholds listeners and new listener form
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/performance-metric-threshold-listeners", method =  RequestMethod.GET )
	public ModelAndView viewPerfomanceMetricTresholdListeners(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentMetric == null){
			return new ModelAndView("redirect:/agreement/performance");
		}

		this.currentThreshold = new ExtendedThreshold(this.currentMetric.getThresholdsList().get(index));
		this.currentThresholdIndex = index;
		
		
		model.addAttribute("listeners", this.currentThreshold.getListenersList());
		

		return  new ModelAndView("agreement/thresholdListeners", "command", new Listener()) ;
	}
	
	/**
	 * adds listener to the threshold
	 * @param l
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-metric-threshold-listener", method = RequestMethod.POST)
	public ModelAndView actionAddPerformanceMetricThresholdListener(@ModelAttribute("wsclient")Listener l, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.currentMetric == null || this.currentThreshold == null){
			return new ModelAndView("redirect:/agreement/performance");
		}
		
		this.currentThreshold.addListener(l);
		
		this.currentMetric.getThresholdsList().remove(this.currentThresholdIndex);
		this.currentMetric.getThresholdsList().add(this.currentThresholdIndex, this.currentThreshold.getThreshold());
		
		ExtendedPerformance ep = new ExtendedPerformance(this.current.getPerformance());
		ep.getMetricsList().remove(this.currentMetricIndex);
		ep.getMetricsList().add(this.currentMetricIndex, this.currentMetric.getMetric());
		
		this.current.setPerformance(ep.getPerformance());
		
		return new ModelAndView("redirect:/agreement/performance-metric-threshold-listeners?index="+this.currentThresholdIndex);
	}
	
	/**
	 * deletes listener from current threshold
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-performance-metric-threshold-listener", method =  RequestMethod.GET )
	public ModelAndView actionDeletePerformanceMetricThresholdListener(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentThreshold == null){
			return new ModelAndView("redirect:/agreement/performance");
		}
		
		this.currentThreshold.deleteListener(index);
		
		this.currentMetric.getThresholdsList().remove(this.currentThresholdIndex);
		this.currentMetric.getThresholdsList().add(this.currentThresholdIndex, this.currentThreshold.getThreshold());
		
		ExtendedPerformance ep = new ExtendedPerformance(this.current.getPerformance());
		ep.getMetricsList().remove(this.currentMetricIndex);
		ep.getMetricsList().add(this.currentMetricIndex, this.currentMetric.getMetric());
		
		this.current.setPerformance(ep.getPerformance());
		
		return new ModelAndView("redirect:/agreement/performance-metric-threshold-listeners?index="+this.currentThresholdIndex);
	}
	
	
	/**
	 * availability view
	 * consists of new availability form
	 * and list of availabilities
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/availability", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewAvailability(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		
		model.addAttribute("availabilities", this.current.getAvailabilityList());
		
		//System.out.println("velikost availability: "+this.current.getA)
		
		Map<String,String> types = new LinkedHashMap<String,String>();
		types.put("csv", "CSV");
		types.put("xml", "XML");
		types.put("json", "JSON");
		
		model.addAttribute("types", types);

		
		return  new ModelAndView("agreement/availability", "command", new Availability() ) ;
	}
	
	
	/**
	 * adds new availability to agreement
	 * @param a
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-availability", method = RequestMethod.POST)
	public ModelAndView actionAddAvailability(@ModelAttribute("wsclient")Availability a, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.current == null ){
			return new ModelAndView("redirect:/");
		}
		
		this.current.addAvailability(a);
		this.metricChangedFlag = true;
		
		
		return new ModelAndView("redirect:/agreement/availability");
	}
	
	/**
	 * shows all values from specified availability's metric
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/availability-metric-values", method =  RequestMethod.GET )
	public ModelAndView viewAvailabilityMetricValues(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.current.getAvailabilityList() == null){
			return new ModelAndView("redirect:/agreement/availability");
		}

		this.currentAvailability = this.current.getAvailabilityList().get(index);
		if(this.currentAvailability == null){
			return new ModelAndView("redirect:/agreement/availability");
		}
		
		model.addAttribute("values", this.currentAvailability.getMetric().getValues());
		

		return  new ModelAndView("agreement/metricValues") ;
	}
	
	/**
	 * removes availability specified by index parameter
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-availability", method =  RequestMethod.GET )
	public ModelAndView deleteAvailabilityAction(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.current.getAvailabilityList() == null){
			return new ModelAndView("redirect:/agreement/availability");
		}

		this.current.getAvailabilityList().remove(index);
	
		return new ModelAndView("redirect:/agreement/availability");
	}
	
	/**
	 * views thresholds of the availability
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/availability-tresholds", method =  RequestMethod.GET )
	public ModelAndView viewAvailabilityTresholds(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.current.getAvailabilityList() == null || this.current.getAvailabilityList().size() < index){
			return new ModelAndView("redirect:/agreement/availability");
		}
		
		this.currentAvailability = this.current.getAvailabilityList().get(index);
		this.currentAvailabilityIndex = index;
		
		if(this.currentAvailability == null){
			return new ModelAndView("redirect:/agreement/availability");
		}
		
		this.currentMetric = new ExtendedMetric(this.currentAvailability.getMetric());
		
		model.addAttribute("thresholds", this.currentMetric.getThresholdsList());
		

		return  new ModelAndView("agreement/availabilityThreshold", "command", new Treshold()) ;
	}
	
	/**
	 * adds new threshold to an availability metric
	 * @param t
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-availability-threshold", method = RequestMethod.POST)
	public ModelAndView actionAddAvailabilityThreshold(@ModelAttribute("wsclient")Treshold t, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		if(this.currentAvailability == null){
			return new ModelAndView("redirect:/agreement/availability");
		}
		
		this.currentMetric.addThreshold(t);
		

		this.currentAvailability.setMetric(this.currentMetric.getMetric());
		
		this.current.deleteAvailability(this.currentAvailabilityIndex);
		this.current.getAvailabilityList().add(this.currentAvailabilityIndex, this.currentAvailability);
		
		return new ModelAndView("redirect:/agreement/availability-tresholds?index="+this.currentMetricIndex);
	}
	
	/**
	 * deletes threshold from an availability
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-availability-threshold", method =  RequestMethod.GET )
	public ModelAndView actionDeleteAvailabilityThreshold(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentMetric == null){
			return new ModelAndView("redirect:/agreement/availability");
		}
		
		ExtendedMetric em = new ExtendedMetric(this.currentAvailability.getMetric());
		
		em.deleteThreshold(index);
		
		this.currentAvailability.setMetric(em.getMetric());
		
		this.current.deleteAvailability(this.currentAvailabilityIndex);
		this.current.getAvailabilityList().add(this.currentAvailabilityIndex, this.currentAvailability);
		
		return new ModelAndView("redirect:/agreement/availability-tresholds?index="+this.currentMetricIndex);
	}
	
	
	/**
	 * Views form for adding a listener to the threshold and list of listeners
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/availability-threshold-listeners", method =  RequestMethod.GET )
	public ModelAndView viewAvailabilityTresholdListeners(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentAvailability == null){
			return new ModelAndView("redirect:/agreement/availability");
		}

		this.currentThreshold = new ExtendedThreshold((this.currentAvailability.getMetric().getTresholds())[index]);
		this.currentThresholdIndex = index;
		
		
		model.addAttribute("listeners", this.currentThreshold.getListenersList());
		

		return  new ModelAndView("agreement/availabilityThresholdListeners", "command", new Listener()) ;
	}
	
	/**
	 * adds listener to the threshold
	 * @param l
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/add-availability-threshold-listener", method = RequestMethod.POST)
	public ModelAndView actionAddAvailabilityThresholdListener(@ModelAttribute("wsclient")Listener l, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.currentAvailability == null || this.currentThreshold == null){
			return new ModelAndView("redirect:/agreement/availability");
		}
		
		this.currentThreshold.addListener(l);
		
		ExtendedMetric em = new ExtendedMetric(this.currentAvailability.getMetric());
		
		em.getThresholdsList().remove(this.currentThresholdIndex);
		em.getThresholdsList().add(this.currentThresholdIndex, this.currentThreshold.getThreshold());
		
		this.currentAvailability.setMetric(em.getMetric());
		
		this.current.deleteAvailability(this.currentAvailabilityIndex);
		this.current.getAvailabilityList().add(this.currentAvailabilityIndex, this.currentAvailability);
		
		return new ModelAndView("redirect:/agreement/availability-threshold-listeners?index="+this.currentThresholdIndex);
	}
	
	
	/**
	 * removes a listener from current threshold
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-availability-threshold-listener", method =  RequestMethod.GET )
	public ModelAndView actionDeleteAvailabilityThresholdListener(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentThreshold == null){
			return new ModelAndView("redirect:/agreement/availability");
		}
		
		this.currentThreshold.deleteListener(index);
		ExtendedMetric em = new ExtendedMetric(this.currentAvailability.getMetric());
		
		em.getThresholdsList().remove(this.currentThresholdIndex);
		em.getThresholdsList().add(this.currentThresholdIndex, this.currentThreshold.getThreshold());
		
		this.currentAvailability.setMetric(em.getMetric());
		
		this.current.deleteAvailability(this.currentAvailabilityIndex);
		this.current.getAvailabilityList().add(this.currentAvailabilityIndex, this.currentAvailability);
		
		return new ModelAndView("redirect:/agreement/availability-threshold-listeners?index="+this.currentMetricIndex);
	}
	
	/**
	 * reports view
	 * consists of new report form
	 * and list of reports
	 * @param extendedAgreement
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/reports", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView viewReports(@ModelAttribute("wsclient")ExtendedAgreement extendedAgreement, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null){
			this.current = new ExtendedAgreement();
		}
		
		
		model.addAttribute("reports", this.current.getReportList());
		
		
		Map<Integer, String> days = new LinkedHashMap<Integer, String>();
		String h = "";
		for(int i = 1; i < 29; i++){
			h = Integer.toString(i);
			days.put(i, h);
		}
		
		model.addAttribute("days", days);
		
		
		Map<String,String> frequency = new LinkedHashMap<String,String>();
		frequency.put("daily", "Daily");
		frequency.put("weekly", "Weekly");
		frequency.put("monthly", "Monthly");
		
		model.addAttribute("frequency", frequency);
		
		Map<Integer, String> hours = new LinkedHashMap<Integer, String>();
		
		for(int i = 0; i < 24; i++){
			
			if(i < 10){
				h = "0"+Integer.toString(i);
			}else{
				h = Integer.toString(i);
			}
			hours.put(i, h);
		}
		model.addAttribute("hours", hours);

		
		return  new ModelAndView("agreement/reports", "command", new Report() ) ;
	}
	
	@RequestMapping(value = "/agreement/add-report", method = RequestMethod.POST)
	public ModelAndView actionAddReport(@ModelAttribute("wsclient")Report r, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.current == null ){
			return new ModelAndView("redirect:/");
		}
		
		this.current.addReport(r);
		
		
		return new ModelAndView("redirect:/agreement/reports");
	}
	
	/**
	 * deletes report from current sla
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-report", method =  RequestMethod.GET )
	public ModelAndView deleteReportAction(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.current.getReportList() == null){
			return new ModelAndView("redirect:/agreement/reports");
		}

		this.current.deleteReport(index);
	
		return new ModelAndView("redirect:/agreement/reports");
	}
	
	/**
	 * views all contacts of report and new contact form
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/report-contacts", method =  RequestMethod.GET )
	public ModelAndView viewReportContacts(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.current.getReportList() == null){
			return new ModelAndView("redirect:/agreement/report");
		}
		
		this.currentReport = new ExtendedReport(this.current.getReportList().get(index));
		this.currentReportIndex = index;
		
		if(this.currentReport == null){
			return new ModelAndView("redirect:/agreement/reports");
		}
		
		
		model.addAttribute("contacts", this.currentReport.getContactList());
		

		return  new ModelAndView("agreement/reportContact", "command", new Contact()) ;
	}
	
	/**
	 * adds contact to current report
	 * @param c
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/report-add-contact", method = RequestMethod.POST)
	public ModelAndView actionAddReportContact(@ModelAttribute("wsclient")Contact c, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.currentReport == null){
			return new ModelAndView("redirect:/agreement/report");
		}
		
		this.currentReport.addContact(c);


		
		this.current.getReportList().remove(this.currentReportIndex);
		this.current.getReportList().add(this.currentReportIndex, this.currentReport.getReport());
		

		
		return new ModelAndView("redirect:/agreement/report-contacts?index="+this.currentReportIndex);
	}
	
	/**
	 * deletes contact specified by index from current contact
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-report-contact", method =  RequestMethod.GET )
	public ModelAndView deleteReportContactAction(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentReport == null){
			return new ModelAndView("redirect:/agreement/reports");
		}

		this.currentReport.deleteContact(index);
	
		this.current.getReportList().remove(this.currentReportIndex);
		this.current.getReportList().add(this.currentReportIndex, this.currentReport.getReport());

		return new ModelAndView("redirect:/agreement/report-contacts?index="+this.currentReportIndex);
	}
	
	/**
	 * views all current metrics of report plus forms for adding new	
	 * performance metrics are show separately from availability metrics
	 * 
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/report-metrics", method =  RequestMethod.GET )
	public ModelAndView viewReportMetrics(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.current.getReportList() == null){
			return new ModelAndView("redirect:/agreement/report");
		}
		
		
		// refresh current report
		if(this.current.getReportList() != null && this.current.getReportList().size() > index){
			this.currentReportIndex = index;
			this.currentReport = new ExtendedReport(current.getReportList().get(this.currentReportIndex));
		}
		
		// get performance metric names and indexes
		Map<Integer, String> perfomanceMetrics = new LinkedHashMap<Integer, String>();
		int key = 0;
		if(this.current != null && this.current.getPerformance() != null  && this.current.getPerformance().getMetrics() != null){
			
			for(Metric m: current.getPerformance().getMetrics()){
				// every single metric may be only once in one report
				if(!(this.currentReport.getMetricList() != null && this.currentReport.getMetricList().contains(m)) ){
					perfomanceMetrics.put(key, m.getName());
				}
				key++;
			}
		}
		

		model.addAttribute("perfomanceMetricsSet", perfomanceMetrics.size() > 0 ? true : false);
		model.addAttribute("perfomanceMetrics", perfomanceMetrics);
		session.setAttribute("metricChangedFlag", this.metricChangedFlag);
		
		
		// get availabilities metric names and indexes
		Map<Integer, String> availabilityMetrics = new LinkedHashMap<Integer, String>();
		key = 0;
		if(this.current != null && this.current.getAvailabilityList() != null){
			for(Availability a: this.current.getAvailabilityList()){
				if(a.getMetric() != null){
					
					// every single metric may be only once in one report 
					if(!(this.currentReport.getMetricList() != null && this.currentReport.getMetricList().contains(a.getMetric())) ){
						availabilityMetrics.put(key, a.getMetric().getName());
					}
					
					key++;
				}
			}
		}
		model.addAttribute("availabilityMetricsSet",  availabilityMetrics.size() > 0 ? true : false);
		model.addAttribute("availabilityMetrics", availabilityMetrics);
		
		
		
		// set list of current report metrics
		model.addAttribute("reportMetrics", this.currentReport.getMetricList());
		

		return  new ModelAndView("agreement/reportMetric", "command", new MetricIndex()) ; // dirty hack
	}
	
	/**
	 * adds performance metric specified by index to the current report
	 * @param mi
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/report-add-perfomance-metric", method = RequestMethod.POST)
	public ModelAndView actionReportAddPerfomanceMetric(@ModelAttribute("wsclient")MetricIndex mi, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.currentReport == null || this.metricChangedFlag){
			return new ModelAndView("redirect:/agreement/report");
		}
		
		if(this.current != null && this.current.getPerformance() != null  
				&& this.current.getPerformance().getMetrics() != null
				&& (this.current.getPerformance().getMetrics())[mi.getIndex()] != null
		){
			Metric[] pm = this.current.getPerformance().getMetrics();
			System.out.println("v Adddu: "+pm[mi.getIndex()].toString());
			
			
			
			this.currentReport.addMetric(pm[mi.getIndex()]);
		}
		

		this.current.getReportList().remove(this.currentReportIndex);
		this.current.getReportList().add(this.currentReportIndex, this.currentReport.getReport());
		

		
		return new ModelAndView("redirect:/agreement/report-metrics?index="+this.currentReportIndex);
	}
	
	/**
	 * adds availability metric to reports metrics
	 * @param mi
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agreement/report-add-availability-metric", method = RequestMethod.POST)
	public ModelAndView actionReportAddAvailabilityMetric(@ModelAttribute("wsclient")MetricIndex mi, ModelMap model)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}
		
		
		if(this.currentReport == null || this.metricChangedFlag){
			return new ModelAndView("redirect:/agreement/report");
		}
		
		if(this.current != null && this.current.getAvailabilityList() != null  
				&& this.current.getAvailabilityList().get(mi.getIndex()) != null
				&& this.current.getAvailabilityList().get(mi.getIndex()).getMetric() != null
		){
			this.currentReport.addMetric(this.current.getAvailabilityList().get(mi.getIndex()).getMetric());
		}
		
		// refresh current report in the current SLA
		this.current.getReportList().remove(this.currentReportIndex);
		this.current.getReportList().add(this.currentReportIndex, this.currentReport.getReport());
		

		
		return new ModelAndView("redirect:/agreement/report-metrics?index="+this.currentReportIndex);
	}
	
	/**
	 * Deletes metric from the current report
	 * @param index
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/agreement/delete-report-metric", method =  RequestMethod.GET )
	public ModelAndView deleteReportMetricAction(@ModelAttribute("wsclient")@RequestParam(value = "index") int index, ModelMap model, HttpSession session)
	{
		if(!this.isAllowed("user")){
			return new ModelAndView("redirect:/");
		}

		if(this.current == null || this.currentReport == null){
			return new ModelAndView("redirect:/agreement/reports");
		}

		this.currentReport.deleteMetric(index);
	
		this.current.getReportList().remove(this.currentReportIndex);
		this.current.getReportList().add(this.currentReportIndex, this.currentReport.getReport());

		return new ModelAndView("redirect:/agreement/report-metrics?index="+this.currentReportIndex);
	}
	
	
	

	
	/**
	 * Checks the role of user
	 * @param requiredRole (string guest/user/administrator)
	 * @return true if user is in required role
	 */
	private boolean isAllowed(String requiredRole){
		// is logged in		
		if(requiredRole == "user"){
			if(this.user == null){
				return false;
			}
		}
		
		// is logged in as administrator?
		if(requiredRole == "administrator"){
			if(this.user == null || !this.user.isAdministrator()){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * finds the index of predecessor agreement
	 * @param a
	 * @return -1 if no predecessor found
	 */
	private int getIndexOfPredecessor(ExtendedAgreement a){
		int index = -1;
		int i = 0;
		if(a.getPredecessor() != null && this.agreements != null){
			for(Agreement agr: this.agreements){
				if(agr.getId() == a.getPredecessor().getId()){
					index = i;
					break;
				}
				i++;
			}
		}
		return index;		
	}
	
}
