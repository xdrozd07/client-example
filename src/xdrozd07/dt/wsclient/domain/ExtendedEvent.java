package xdrozd07.dt.wsclient.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import xdrozd07.dt.domain.Event;

public class ExtendedEvent extends Event{

	private String openTime;
	private String openDate;
	
	private String closeDate;
	private String closeTime;
	
	
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	
	/**
	 * generates pure POJO Event pro this object
	 * @return
	 */
	public Event getEvent(){
		Event ev = new Event();
		
		ev.setDescription(super.getDescription());
		ev.setId(super.getId());
		ev.setType(super.getType());
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");

		System.out.println(this.openDate+" "+this.openTime);
		System.out.println(this.closeDate+" "+this.closeTime);
		
		try {
			ev.setOpen(formatter.parse(this.openDate+" "+this.openTime));
		}catch(ParseException e){
			ev.setOpen(null);
		}
		try {
			ev.setClose(formatter.parse(this.closeDate+" "+this.closeTime));
		}catch(ParseException e){
			ev.setClose(null);
		}
		
		return ev;
	}
	
}
