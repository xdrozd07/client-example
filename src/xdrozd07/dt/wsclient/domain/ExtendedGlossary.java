package xdrozd07.dt.wsclient.domain;

import java.util.ArrayList;
import java.util.List;

import xdrozd07.dt.domain.glossary.Term;
import xdrozd07.dt.domain.glossary.Glossary;

public class ExtendedGlossary extends Glossary{
	
	private List<Term> termsList;
	
	
	public List<Term> getTermsList() {
		return termsList;
	}


	public void setTermsList(List<Term> termsList) {
		this.termsList = termsList;
	}


	/**
	 * POJO constructor
	 */
	public ExtendedGlossary(){
	}
	
	/**
	 * creates extended glossary from glossary
	 * @param g
	 */
	public ExtendedGlossary(Glossary g){
		super.setDescription(g.getDescription());
		super.setId(g.getId());
		super.setName(g.getName());
		
		this.termsList = null;
		
		if(g.getTerms() != null){
			this.termsList = new ArrayList<Term>();
			for(Term t : g.getTerms()){
				this.termsList.add(t);
			}
		}
	}
	
	/**
	 * makes pure POJO glossary from extended one
	 * @return
	 */
	public Glossary getGlossary(){
		Glossary g = new Glossary();
		
		g.setDescription(super.getDescription());
		g.setId(super.getId());
		g.setName(super.getName());
		
		Term[] terms = null;
		
		if(this.termsList != null){
			terms = new Term[this.termsList.size()];
			
			int i = 0;
			for (Term t: this.termsList){
				terms[i] = t;
				i++;
			}
		}
		
		g.setTerms(terms);
		
		return g;
	}
	
	/**
	 * Adds Term to glossary
	 * @param t
	 */
	public void addTerm(Term t){
		if(this.termsList == null){
			this.termsList = new ArrayList<Term>();
		}
		this.termsList.add(t);
	}
	
	/**
	 * delete term of specified index if exists
	 * @param index
	 */
	public void deleteTerm(int index){
		if(this.termsList != null && this.termsList.size() > index){
			this.termsList.remove(index);
		}
	}
}
