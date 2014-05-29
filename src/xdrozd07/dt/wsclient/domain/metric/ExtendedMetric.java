package xdrozd07.dt.wsclient.domain.metric;

import java.util.ArrayList;
import java.util.List;

import xdrozd07.dt.domain.metric.Metric;
import xdrozd07.dt.domain.metric.MetricValue;
import xdrozd07.dt.domain.metric.Treshold;

public class ExtendedMetric extends Metric{
	
	private List<MetricValue> metricValuesList;
	private List<Treshold> thresholdsList;
	
	
	public List<MetricValue> getMetricValuesList() {
		return metricValuesList;
	}


	public void setMetricValuesList(List<MetricValue> metricValuesList) {
		this.metricValuesList = metricValuesList;
	}


	public List<Treshold> getThresholdsList() {
		return thresholdsList;
	}


	public void setThresholdsList(List<Treshold> thresholdsList) {
		this.thresholdsList = thresholdsList;
	}

	/**
	 * POJO constructor
	 */
	public ExtendedMetric(){
		
	}
	
	/**
	 * returns extended metric from it's pojo version 
	 * @param m
	 */
	public ExtendedMetric(Metric m){
		this.setId(m.getId());
		this.setInputAddress(m.getInputAddress());
		this.setInputFormat(m.getInputFormat());
		this.setInputType(m.getInputType());
		this.setName(m.getName());
		
		this.setMetricValuesList(null);
		if(m.getValues() != null){
			for(MetricValue mv: m.getValues()){
				this.addMetricValue(mv);
			}
		}
		
		this.thresholdsList = null;
		if(m.getTresholds() != null){
			for(Treshold t : m.getTresholds()){
				this.addThreshold(t);
			}
		}
		
	}
	
	
	/**
	 * adds metric value to the list
	 * @param mv
	 */
	public void addMetricValue(MetricValue mv){
		if(this.metricValuesList == null){
			this.metricValuesList = new ArrayList<MetricValue>();
		}
		this.metricValuesList.add(mv);
	}
	
	/**
	 * removes metric value of specified index, if exists
	 * @param index
	 */
	public void deleteMetricValue(int index){
		if(this.metricValuesList != null && this.metricValuesList.size() > index){
			this.metricValuesList.remove(index);
		}
	}
	
	/**
	 * adds threshold to the list
	 * @param t
	 */
	public void addThreshold(Treshold t){
		if(this.thresholdsList == null){
			this.thresholdsList = new ArrayList<Treshold>();
		}
		
		this.thresholdsList.add(t);
	}
	
	/**
	 * removes threshold of specified index from list, if exists
	 * @param index
	 */
	public void deleteThreshold(int index){
		if(this.thresholdsList != null && this.thresholdsList.size() > index){
			this.thresholdsList.remove(index);
		}
	}
	
	/**
	 * generates POJO Metric from this one
	 * @return
	 */
	public Metric getMetric(){
		Metric m = new Metric();
		
		m.setId(this.getId());
		m.setInputAddress(this.getInputAddress());
		m.setInputFormat(this.getInputFormat());
		m.setInputType(this.getInputType());
		m.setName(this.getName());
		
		m.setValues(null);
		m.setTresholds(null);
		
		if(this.metricValuesList != null){
			MetricValue[] values = new MetricValue[this.metricValuesList.size()];
			
			int i = 0;
			for(MetricValue mv : this.metricValuesList){
				values[i] = mv;
				i++;
			}
			m.setValues(values);
		}
		
		if(this.thresholdsList != null){
			Treshold[] tresholds = new Treshold[this.thresholdsList.size()];
			
			int i = 0;
			for(Treshold t : this.thresholdsList){
				tresholds[i] = t;
				i++;
			}
			
			m.setTresholds(tresholds);
		}
		
		
		return m;
	}
}
