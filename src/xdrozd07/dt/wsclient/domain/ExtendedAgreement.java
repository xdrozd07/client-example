package xdrozd07.dt.wsclient.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import xdrozd07.dt.domain.Agreement;
import xdrozd07.dt.domain.Availability;
import xdrozd07.dt.domain.InvolvedParty;
import xdrozd07.dt.domain.Report;
import xdrozd07.dt.domain.glossary.Glossary;

public class ExtendedAgreement extends xdrozd07.dt.domain.Agreement{

	private String validFromString;
	private String validToString;
	private List<InvolvedParty> involvedPartiesList;
	private List<Glossary> gloassariesList;
	private List<Availability> availabilityList;
	private List<Report> reportList;
	private int predecessorIndex;
	

	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	
	/**
	 * POJO constructor
	 */
	public ExtendedAgreement(){
		
	}
	
	/**
	 * Makes extendedAgreement from its simple version
	 * @param a
	 */
	public ExtendedAgreement(Agreement a){
		
		this.setId(a.getId());
		this.setAuthor(a.getAuthor());
		this.setChangemanagement(a.getChangemanagement());
		this.setName(a.getName());
		this.setCustomerSupport(a.getCustomerSupport());
		this.setPerformance(a.getPerformance());
		this.setType(a.getType());
		
		
		this.setPredecessor(a.getPredecessor());
		this.setSecurityDescription(a.getSecurityDescription());
		this.setServiceDescription(a.getServiceDescription());
		this.setServiceHours(a.getServiceHours());
		this.setSlaDescription(a.getSlaDescription());
		
		this.setValidFromString(this.formatter.format(a.getValidFrom()));		
		this.setValidToString(this.formatter.format(a.getValidTo()));

		// set involved parties
		List<InvolvedParty> ipl = new ArrayList<InvolvedParty>();
		for(InvolvedParty ip: a.getInvolvedParties()){
			ipl.add(ip);
		}
		this.setInvolvedPartiesList(ipl);
		
		// set reports
		List<Report> rl = new ArrayList<Report>();
		for(Report r: a.getReports()){
			rl.add(r);
		}
		this.setReportList(rl);
		
		// set glossaries list
		List<Glossary> gl = new ArrayList<Glossary>();
		for(Glossary g: a.getGlossaries()){
			gl.add(g);
		}
		this.setGloassariesList(gl);
		
		// set availabilities
		List<Availability> al = new ArrayList<Availability>();
		for(Availability av : a.getAvailability()){
			al.add(av);
		}
		this.setAvailabilityList(al);
		
	}
	
	public String getValidFromString() {
		return validFromString;
	}
	public void setValidFromString(String validFromString) {
		this.validFromString = validFromString;
	}
	
	public List<Availability> getAvailabilityList() {
		return availabilityList;
	}
	public void setAvailabilityList(List<Availability> availabilityList) {
		this.availabilityList = availabilityList;
	}
	
	public String getValidToString() {
		return validToString;
	}
	public void setValidToString(String validToString) {
		this.validToString = validToString;
	}
	
	
	public List<InvolvedParty> getInvolvedPartiesList() {
		return involvedPartiesList;
	}
	public void setInvolvedPartiesList(List<InvolvedParty> involvedParties) {
		this.involvedPartiesList = involvedParties;
	}
	
	public List<Glossary> getGloassariesList() {
		return gloassariesList;
	}
	public void setGloassariesList(List<Glossary> gloassariesList) {
		this.gloassariesList = gloassariesList;
	}
	
	public List<Report> getReportList() {
		return reportList;
	}
	public void setReportList(List<Report> reportList) {
		this.reportList = reportList;
	}
	/**
	 * Adds involved party to list
	 * @param party
	 */
	public void addInvolvedParty(InvolvedParty party){
		if(this.involvedPartiesList == null){
			this.involvedPartiesList = new ArrayList<InvolvedParty>();
		}
		this.involvedPartiesList.add(party);
	}
	
	/**
	 * Deletes involved party from list on position specifies by index, if exists
	 * @param index
	 */
	public void deleteInvolvedParty(int index){
		if(this.involvedPartiesList != null && this.involvedPartiesList.size() > index){
			this.involvedPartiesList.remove(index);
		}
	}
	
	/**
	 * Adds glossary to the list
	 * @param g
	 */
	public void addGlossary(Glossary g){
		if(this.gloassariesList == null){
			this.gloassariesList = new ArrayList<Glossary>();
		}
		this.gloassariesList.add(g);
	}
	
	/**
	 * deletes glossary on specifies index if exists
	 * @param index
	 */
	public void deleteGlossary(int index){
		if(this.gloassariesList != null && this.gloassariesList.size() > index){
			this.gloassariesList.remove(index);
		}
	}
	
	
	/**
	 * adds availability to the list
	 * @param a
	 */
	public void addAvailability(Availability a){
		if(this.availabilityList == null){
			this.availabilityList = new ArrayList<Availability>();
		}
		this.availabilityList.add(a);
	}
	
	
	/**
	 * removes availability of specified index if exists
	 * @param index
	 */
	public void deleteAvailability(int index){
		if(this.availabilityList.size() > index){
			this.availabilityList.remove(index);
		}
	}
	
	/**
	 * adds the report to the list
	 * @param r
	 */
	public void addReport(Report r){
		if(this.reportList == null){
			this.reportList = new ArrayList<Report>();
		}
		this.reportList.add(r);
	}
	
	/**
	 * removes report specified by index if exists
	 * @param index
	 */
	public void deleteReport(int index){
		if(this.reportList != null && this.reportList.size() > index){
			this.reportList.remove(index);
		}
	}
	
	/**
	 * Generate POJO Agreement class
	 * @return
	 */
	public Agreement getAgreement() throws ParseException{
		Agreement a = new Agreement();
		
		// set fields
		a.setId(super.getId());
		
		a.setType(this.getType());
		
		a.setAuthor(super.getAuthor());
		a.setName(super.getName());
		a.setSecurityDescription(super.getSecurityDescription());
		a.setServiceDescription(super.getServiceDescription());
		a.setSlaDescription(super.getSlaDescription());
		a.setChangemanagement(this.getChangemanagement());
		a.setCustomerSupport(this.getCustomerSupport());
		a.setPerformance(this.getPerformance());
		a.setServiceHours(this.getServiceHours());
		
		// try to set predecessor
		if(this.getPredecessor() != null)
			a.setPredecessor(this.getPredecessor());
		
		// parse dates
		if(this.validFromString != null)
			a.setValidFrom(this.formatter.parse(this.validFromString));
		
		if(this.validToString != null)
			a.setValidTo(this.formatter.parse(this.validToString));
			
		
		//set involved parties
		InvolvedParty[] parties = null;
		if(this.involvedPartiesList != null){
			parties = new InvolvedParty[this.involvedPartiesList.size()];
			int i = 0;
			for(InvolvedParty p : this.involvedPartiesList){
				parties[i] = p;
				i++;
			}
		}
		
		a.setInvolvedParties(parties);
		
		
		// set glossaries
		Glossary[] glossaries = null;
		if(this.gloassariesList != null){
			glossaries =  new Glossary[this.gloassariesList.size()];
			int i = 0;
			for(Glossary g : this.gloassariesList){
				glossaries[i] = g;
				i++;
			}
		}
		a.setGlossaries(glossaries);
		
		// set availabilities
		Availability[] availability= null;
		if(this.availabilityList != null){
			availability = new Availability[this.availabilityList.size()];
			int i = 0;
			for(Availability av: this.availabilityList){
				availability[i] = av;
				i++;
			}
		}
		a.setAvailability(availability);
		
		// set reports
		Report[] reports = null;
		if(this.reportList != null){
			reports = new Report[this.reportList.size()];
			int i = 0;
			for(Report r: this.reportList){
				reports[i] = r;
				i++;
			}
		}
		
		a.setReports(reports);
		return a;
	}

	public int getPredecessorIndex() {
		return predecessorIndex;
	}

	public void setPredecessorIndex(int predecessorIndex) {
		this.predecessorIndex = predecessorIndex;
	}
}
