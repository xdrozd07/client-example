package xdrozd07.dt.wsclient.domain;

import java.util.ArrayList;
import java.util.List;

import xdrozd07.dt.domain.Performance;
import xdrozd07.dt.domain.metric.Metric;

public class ExtendedPerformance extends Performance{

	private List<Metric> metricsList;

	public List<Metric> getMetricsList() {
		return metricsList;
	}

	public void setMetricsList(List<Metric> metricsList) {
		this.metricsList = metricsList;
	}
	
	/**
	 * POJO constructor
	 */
	public ExtendedPerformance(){
		
	}
	
	/**
	 * get extended performance from POJO
	 * @param p
	 */
	public ExtendedPerformance(Performance p){
		this.setDescription(p.getDescription());
		this.setId(p.getId());
		this.metricsList = null;
		
		if(p.getMetrics() != null){
			this.metricsList = new ArrayList<Metric>();
			
			for(Metric m : p.getMetrics()){
				this.metricsList.add(m);
			}
			
		}
	}
	
	/**
	 * get POJO metric from extended one
	 * @return
	 */
	public Performance getPerformance(){
		Performance p  = new Performance();
		
		p.setId(this.getId());
		p.setDescription(this.getDescription());
		
		Metric[] metrics = null;
		if(this.metricsList != null){
			int i = 0;
			metrics = new Metric[this.metricsList.size()];
			for(Metric m : this.metricsList){
				metrics[i] = m;
				i++;
			}
		}
		p.setMetrics(metrics);
		
		return p;
	}
	
	
	/**
	 * Adds metric to an array
	 * @param m
	 */
	public void addMetric(Metric m){
		if(this.metricsList == null){
			this.metricsList = new ArrayList<Metric>();
		}
		this.metricsList.add(m);
	}
	
	/**
	 * removes metric on specified index if exists
	 * @param index
	 */
	public void deleteMetrics(int index){
		if(this.metricsList != null && this.metricsList.size() > index){
			this.metricsList.remove(index);
		}
	}
}
