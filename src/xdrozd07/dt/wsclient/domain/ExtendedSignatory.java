package xdrozd07.dt.wsclient.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import xdrozd07.dt.domain.Signatory;

public class ExtendedSignatory extends Signatory{
	private String dateString;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	
	/**
	 * Gets pure POJO signature
	 * @return
	 */
	public Signatory getSignatory(){
		Signatory s = new Signatory();
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		s.setId(super.getId());
		s.setName(super.getName());
		
		

		try {
			s.setDate(formatter.parse(this.dateString));
		}catch(ParseException e){
			s.setDate(null);
		}
		
		return s;
	}
}
