package xdrozd07.dt.wsclient.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xdrozd07.dt.domain.AccessTime;
import xdrozd07.dt.domain.Event;
import xdrozd07.dt.domain.ServiceHours;

public class ExtendedServiceHours extends ServiceHours{
	private List<AccessTime> accessTimesList;
	private List<Event> eventsList;
	
	public List<AccessTime> getAccessTimeslist() {
		return accessTimesList;
	}
	public void setAccessTimesList(List<AccessTime> accessTimesList) {
		this.accessTimesList = accessTimesList;
	}
	public List<Event> getEventsList() {
		return eventsList;
	}
	public void setEventsList(List<Event> eventsList) {
		this.eventsList = eventsList;
	}
	
	
	
	
	/**
	 * Creates ExtendatedServiceHours from given ServiceHours
	 * @param sh
	 */
	public ExtendedServiceHours(ServiceHours sh){
		if(sh != null){
			this.setDescription(sh.getDescription());
			this.setId(sh.getId());
			
			// add access times
			if(sh.getAccessTimes() != null){
				this.accessTimesList = new ArrayList<AccessTime>();
				for(AccessTime at: sh.getAccessTimes()){
					this.accessTimesList.add(at);
				}
			}
			
			//add events
			if(sh.getEvents() != null){
				this.eventsList = new ArrayList<Event>();
				for(Event e : sh.getEvents()){
					this.eventsList.add(e);
				}
			}
		}
	}
	
	
	/**
	 * creates service hours from extended
	 * @return
	 */
	public ServiceHours getServiceHours(){
		ServiceHours sh = new ServiceHours();
		
		sh.setDescription(super.getDescription());
		sh.setId(super.getId());
		
		AccessTime[] ats = null;
		if(this.accessTimesList != null){
			ats = new AccessTime[this.accessTimesList.size()];
				
			int i = 0;
			for(AccessTime at: this.accessTimesList){
				ats[i] = at;
				i++;
			}
		}
		
		Event[] events = null;
		if(this.eventsList != null){
			events = new Event[this.eventsList.size()];
			
			int i = 0;
			for(Event e: this.eventsList){
				events[i] = e;
				i++;
			}	
		}
		
		
		sh.setAccessTimes(ats);
		sh.setEvents(events);
		
		return sh;
	}
	
	
	/**
	 * adds event to the list
	 * @param e
	 */
	public void addEvent(Event e){
		if(this.eventsList == null){
			this.eventsList = new ArrayList<Event>();
		}
		this.eventsList.add(e);
	}
	
	/**
	 * delete event on specified index, if exists
	 * @param index
	 */
	public void deleteEvent(int index){
		if(this.eventsList.size() > index){
			this.eventsList.remove(index);
		}
	}
	
	/**
	 * adds Access time to list
	 * @param at
	 */
	public void addAccessTime(AccessTime at){
		if(this.accessTimesList == null){
			this.accessTimesList = new ArrayList<AccessTime>();
		}
		this.accessTimesList.add(at);
	}
	
	/**
	 * delete Access time on specified index, if exists
	 * @param at
	 */
	public void deleteAccessTime(int index){
		if(this.accessTimesList.size() > index){
			this.accessTimesList.remove(index);
		}
	}


}
