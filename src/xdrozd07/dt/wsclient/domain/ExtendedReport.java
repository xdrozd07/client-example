package xdrozd07.dt.wsclient.domain;

import java.util.ArrayList;
import java.util.List;

import xdrozd07.dt.domain.Contact;
import xdrozd07.dt.domain.Report;
import xdrozd07.dt.domain.metric.Metric;

public class ExtendedReport extends Report {
	private List<Contact> contactList;
	private List<Metric> metricList;
	
	
	/**
	 * makes extended report from the simple one
	 * @param r
	 */
	public ExtendedReport(Report r){
		if(r != null){
			super.setDay(r.getDay());
			super.setDescription(r.getDescription());
			super.setFrequency(r.getFrequency());
			super.setHour(r.getHour());
			super.setId(r.getId());
			super.setName(r.getName());
			
			
			if(r.getContacts() != null) {
				this.contactList = new ArrayList<Contact>();
				
				for(Contact c : r.getContacts()){
					this.contactList.add(c);
				}
			}
			
			if(r.getMetrics() != null) {
				this.metricList = new ArrayList<Metric>();
				
				for(Metric m : r.getMetrics()){
					this.metricList.add(m);
				}
			}
		}
	}
	
	/**
	 * generates simple report from the extended one
	 * @return
	 */
	public Report getReport(){
		Report r = new Report();
		
		r.setDay(this.getDay());
		r.setDescription(this.getDescription());
		r.setFrequency(this.getFrequency());
		r.setHour(this.getHour());
		r.setId(this.getId());
		r.setName(this.getName());
		
		Metric[] ma = null;
		if(this.metricList != null){
			
			ma = new Metric[this.metricList.size()];
			int i = 0;
			for(Metric m : this.metricList){
				ma[i] = m;
				i++;
			}
		}
		r.setMetrics(ma);
		
		
		Contact[] ca = null;
		if(this.contactList != null){
			
			ca = new Contact[this.contactList.size()];
			int i = 0;
			for(Contact c : this.contactList){
				ca[i] = c;
				i++;
			}
		}
		r.setContacts(ca);
		
		return r;
	}

	/* getters and setters */
	public List<Contact> getContactList() {
		return contactList;
	}
	
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	public List<Metric> getMetricList() {
		return metricList;
	}
	
	public void setMetricList(List<Metric> metricList) {
		this.metricList = metricList;
	}
	
	/**
	 * Adds the contact to a list
	 * @param c
	 */
	public void addContact(Contact c){
		if(this.contactList == null){
			this.contactList = new ArrayList<Contact>();
		}
		this.contactList.add(c);
	}
	
	/**
	 * Removes the contact specified by index if exists
	 * @param index
	 */
	public void deleteContact(int index){
		if(this.contactList != null && this.contactList.size() > index){
			this.contactList.remove(index);
		}
	}
	
	/**
	 * Adds the Metric m to a list of contacts
	 * @param m
	 */
	public void addMetric(Metric m){
		if(this.metricList == null){
			this.metricList = new ArrayList<Metric>();
		}
		this.metricList.add(m);
	}
	
	/**
	 * Removes the Metric, specified by index, from the list if exists
	 * @param index
	 */
	public void deleteMetric(int index){
		if(this.metricList != null && this.metricList.size() > index){
			this.metricList.remove(index);
		}
	}
}
