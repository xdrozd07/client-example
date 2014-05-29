package xdrozd07.dt.wsclient.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import xdrozd07.dt.domain.AccessTime;

public class ExtendedAccessTime extends AccessTime{
	
	private String openString;
	private String closeString;
	
	
	public String getOpenString() {
		return openString;
	}
	public void setOpenString(String openString) {
		this.openString = openString;
	}
	public String getCloseString() {
		return closeString;
	}
	public void setCloseString(String closeString) {
		this.closeString = closeString;
	}
	
	/**
	 * generates access time from this
	 * @return
	 */
	public AccessTime getAccessTime(){
		AccessTime at = new AccessTime();
		
		at.setDay(super.getDay());
		at.setId(super.getId());
		
		DateFormat formatter = new SimpleDateFormat("hh:mm");
		
		try {
			at.setOpen(formatter.parse(this.openString));
		}catch(ParseException e){
			at.setOpen(null);
		}
		try {
			at.setClose(formatter.parse(this.closeString));
		}catch(ParseException e){
			at.setClose(null);
		}
		
		return at;
	}
	

}
