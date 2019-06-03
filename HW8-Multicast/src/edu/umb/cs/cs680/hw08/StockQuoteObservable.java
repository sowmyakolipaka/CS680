package edu.umb.cs.cs680.hw08;

import java.util.ArrayList;

public class StockQuoteObservable {

	private ArrayList<StockQuoteObserver> collection;
	private StockEvent event = null; 
	
	public StockQuoteObservable() {
		collection = new  ArrayList<StockQuoteObserver> ();
	}
	public void addObservers(StockQuoteObserver o) {
		
		if (this.collection == null){
			collection = new ArrayList<StockQuoteObserver> ();
		}
		this.collection.add((StockQuoteObserver) o);
	}
	
   public void notifyObservers(StockEvent ev){
		
		for (StockQuoteObserver o: this.collection){
			o.updateStock(this.event = new StockEvent (ev.getTicker(), ev.getQuote()));
		}
		
	}
   
   public StockEvent getLastEvent(){
		return this.event;
	}
	
}