package xdrozd07.dt.wsclient.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xdrozd07.dt.domain.Contact;
import xdrozd07.dt.domain.InvolvedParty;
import xdrozd07.dt.domain.Signatory;

public class ExtendedInvolvedParty extends InvolvedParty {
	
	private List<Signatory> signatoryList;

	
	
	public ExtendedInvolvedParty(){
		this.signatoryList = null;
	}
	
	/**
	 * generates extended party from party
	 * @param p
	 */
	public ExtendedInvolvedParty(InvolvedParty p){
		super.setContact(p.getContact());
		super.setId(p.getId());
		super.setName(p.getName());
		super.setRole(p.getRole());
		
		if(p.getSignatories() != null){
			this.signatoryList = new ArrayList<Signatory>(Arrays.asList(p.getSignatories()));
		}
			
	}
	
	
	/**
	 * getter
	 * @return
	 */
	public List<Signatory> getSignatoryList() {
		return signatoryList;
	}
	
	/**
	 * setter
	 * @param signatoryList
	 */

	public void setSignatoryList(List<Signatory> signatoryList) {
		this.signatoryList = signatoryList;
	}
	
	
	/**
	 * adds signature to the list
	 * @param s
	 */
	public void addSignature(Signatory s){
		if(this.signatoryList == null){
			this.signatoryList = new ArrayList<Signatory>();
		}
		this.signatoryList.add(s);
	}
	
	/**
	 * Deletes signature on position specified by index if exists
	 * @param index
	 */
	public void deleteSignature(int index){
		if(this.signatoryList != null && this.signatoryList.size() > index){
			this.signatoryList.remove(index);
		}
	}
	
	/**
	 * return POJO involved party
	 * @return
	 */
	public InvolvedParty getInvolvedParty(){
		
		InvolvedParty party = new InvolvedParty();
		
		if(this.isContactFilled()){
			party.setContact(super.getContact());
		}else{
			party.setContact(null);
		}
		party.setId(super.getId());
		party.setName(super.getName());
		party.setRole(super. getRole());
		
		if(this.signatoryList != null){
			Signatory[] signatories = new Signatory[this.signatoryList.size()];
			
			int i = 0;
			for(Signatory s: this.signatoryList){
				signatories[i] = s;
				i++;
			}
			party.setSignatories(signatories);
		}
		
		
		
		
		
		return party;
	}
	
    /**
     * Checks wheather the contact is filled
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
