package xdrozd07.dt.wsclient.domain;

import xdrozd07.dt.domain.ChangeManagement;
import xdrozd07.dt.domain.Contact;

public class ExtendedChangeManagement extends ChangeManagement {
	
	/**
	 * POJO constructor
	 */
	public ExtendedChangeManagement() {
	}
	
	
	/**
	 * makes extended change management from the simple one
	 * @param chm
	 */
	public ExtendedChangeManagement(ChangeManagement chm) {
		if(chm != null){
			this.setId(chm.getId());
			this.setDescription(chm.getDescription());
			this.setContact(chm.getContact());
		}
	}
	
	/**
	 * returns simple version of change management
	 * @return
	 */
	public ChangeManagement getChangeManagement(){
		ChangeManagement chm = new ChangeManagement();
		
		chm.setId(this.getId());
		chm.setDescription(this.getDescription());
		if(this.isContactFilled()){
			chm.setContact(this.getContact());
		}else{
			chm.setContact(null);
		}
		
		return chm;
		
	}
	
	/**
	 * says if the contact is filled
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
