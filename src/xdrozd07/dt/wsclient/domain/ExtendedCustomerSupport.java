package xdrozd07.dt.wsclient.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import xdrozd07.dt.domain.AccessTime;
import xdrozd07.dt.domain.Contact;
import xdrozd07.dt.domain.CustomerSupport;

public class ExtendedCustomerSupport extends CustomerSupport{
	

	private int responseHours;
	private int responseDays;
	private List<AccessTime> accessTimeList;
	

	public int getResponseHours() {
		return responseHours;
	}
	public void setResponseHours(int responseHours) {
		this.responseHours = responseHours;
	}
	public int getResponseDays() {
		return responseDays;
	}
	public void setResponseDays(int responseDays) {
		this.responseDays = responseDays;
	}
	public List<AccessTime> getAccessTimesList(){
		return this.accessTimeList;
	}
	public void setAccessTimesList(List<AccessTime> ats){
		this.accessTimeList = ats;
	}
	
	/**
	 * POJO constructor
	 */
	public ExtendedCustomerSupport(){
		
	}
	
	/**
	 * creates extended version from given customer support
	 * @param cs
	 */
	public ExtendedCustomerSupport(CustomerSupport cs){
		if(cs != null){
			
			super.setContact(cs.getContact());
			super.setDescription(cs.getDescription());
			super.setId(cs.getId());
			super.setNote(cs.getNote());
			super.setResponse(cs.getResponse());
			
			if(cs.getResponseTime() != null){
				this.responseDays = cs.getResponseTime().getDate();
				this.responseHours = cs.getResponseTime().getHours();				
			}
			if(cs.getAccessTimes() != null){
				this.accessTimeList = new ArrayList<AccessTime>();
				for(AccessTime at : cs.getAccessTimes()){
					this.accessTimeList.add(at);
				}
			}
		}
		
	}
	
	/**
	 * generates Customer Support from its extended version
	 * @return
	 */
	public CustomerSupport getCustomerSupport(){
		CustomerSupport cs = new CustomerSupport();
		
		cs.setId(super.getId());
		
		cs.setDescription(super.getDescription());
		cs.setNote(super.getNote());
		cs.setResponse(super.getResponse());
		
		if(this.isContactFilled())
			cs.setContact(super.getContact());
		else
			cs.setContact(null);
		
		
		Date responseTime= new Date(0);
		responseTime.setHours(this.responseHours+24*this.responseDays);
		cs.setResponseTime(responseTime);
		
		AccessTime[] accessTimes = null ;
		if(this.accessTimeList != null){
		accessTimes = new AccessTime[this.accessTimeList.size()];
			int i = 0;
			for(AccessTime at : this.accessTimeList){
				accessTimes[i] = at;
				i++;
			}
		}
		
		cs.setAccessTimes(accessTimes);
		
		return cs;	
	}
	
	/**
	 * adds access time to list
	 * @param at
	 */
	public void addAccessTime(AccessTime at){
		if(this.accessTimeList == null){
			this.accessTimeList = new ArrayList<AccessTime>();
		}
		this.accessTimeList.add(at);
	}
	
	/**
	 * removes access time from specified index if exists
	 * @param index
	 */
	public void deleteAccessTime(int index){
		if(this.accessTimeList.size() > index){
			this.accessTimeList.remove(index);
		}
	}
	
	/**
	 * checks if the contact is filled
	 * @return
	 */
	public boolean isContactFilled(){
    	Contact c= this.getContact();
    	if(c == null || 
   			( c.getCountry().compareTo("") == 0 && c.getEmail().compareTo("") == 0 && c.getStreet().compareTo("") == 0  && c.getTelephone().compareTo("") == 0 && c.getTown().compareTo("") == 0 && c.getWeb().compareTo("") == 0 )
    	)
    	{
    		return false;
    	}else{
    		return true;
    	}
    	
    }
}
