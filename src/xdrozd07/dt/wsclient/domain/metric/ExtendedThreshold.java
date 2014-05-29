package xdrozd07.dt.wsclient.domain.metric;

import java.util.ArrayList;
import java.util.List;

import xdrozd07.dt.domain.metric.Listener;
import xdrozd07.dt.domain.metric.Treshold;

public class ExtendedThreshold extends Treshold{
	
	private List<Listener> listenersList;
	
	public List<Listener> getListenersList() {
		return listenersList;
	}

	public void setListenersList(List<Listener> listenersList) {
		this.listenersList = listenersList;
	}

	public ExtendedThreshold(){
		
	}
	
	/**
	 * new extended threshold from a POJO one
	 * @param t
	 */
	public ExtendedThreshold(Treshold t){
		this.setId(t.getId());
		this.setValue(t.getValue());
		
		if(t.getListeners() != null){
			
			for(Listener l : t.getListeners()){
				this.addListener(l);
			}
			
		}
		
	}
	
	/**
	 * generates POJO threshold
	 * @return
	 */
	public Treshold getThreshold(){
		Treshold t = new Treshold();
		
		t.setId(this.getId());
		t.setValue(this.getValue());
		t.setListeners(null);
		
		if(this.listenersList != null){
			
			
			Listener[] listeners = new Listener[this.listenersList.size()];
			
			int i = 0;
			for(Listener l: this.listenersList){
				listeners[i] = l;
				i++;
			}
			
			t.setListeners(listeners);
		}
		
		return t;
	}
	
	/**
	 * adds listener to a list
	 * @param l listener
	 */
	public void addListener(Listener l){
		if(this.listenersList == null){
			this.listenersList = new ArrayList<Listener>();
		}
		this.listenersList.add(l);
	}
	
	/**
	 * removes listener of specified index if exists
	 * @param index
	 */
	public void deleteListener(int index){
		if(this.listenersList.size() > index){
			this.listenersList.remove(index);
		}
	}

}
